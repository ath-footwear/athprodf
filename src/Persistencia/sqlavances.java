/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Avance;
import Modelo.Colsdepartamentos;
import Modelo.Davance;
import Modelo.metadep;
import Modelo.pantalla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class sqlavances {

    public boolean nuevoavancept(Connection a, Avance av) {
        try {
            PreparedStatement st;
            a.setAutoCommit(false);
            int lote = av.getLote();
            int pares = av.getPares();
            String fecha = av.getFecha();
            String punto = av.getPunto();
            String sql = "insert into lotespt(lotes,fecha,punto,pares,estatus) values(?,?,?,?,'1')";
//            String sql = "insert into lotespt(lotes,fecha,punto,pares,estatus) values(" + lote + ",'" + fecha + "','" + punto + "'," + pares + ",'1')";
//            System.out.println(sql);
            st = a.prepareStatement(sql);
            st.setInt(1, lote);
            st.setString(2, fecha);
            st.setString(3, punto);
            st.setInt(4, pares);
            st.executeUpdate();
            a.commit();

            return true;
        } catch (SQLException ex) {
            try {
                a.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    /**
     * Vacia la bd de avances de sqlite
     *
     * @param a
     */
    public void Vaciabd(Connection a) {
        try {
            PreparedStatement st;
            a.setAutoCommit(false);
            String sql = "delete from Avancespt";
//            System.out.println(sql);
            st = a.prepareStatement(sql);
            st.executeUpdate();
            a.commit();
        } catch (SQLException ex) {
            try {
                a.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Desarrollo para poder realizar el reporte con lo dinamico de los puntos
     *
     * @param av conexion a avances
     * @param lite conexion a sqlite
     * @param rcpt
     * @param cob
     * @param f1 fecha iniciañ
     * @param f2 fecha fianl
     * @return
     */
    public boolean setRowsav(Connection av, Connection lite, String rcpt, String cob, String f1, String f2) {
        try {
            ResultSet rs, rs1, rs2;
            PreparedStatement st, st1, st2, s;
            lite.setAutoCommit(false);
            String sql = "select lotes,p.pedido, nombre40,corridacpt,cor.PuntoInicial, cor.PuntoFinal,p.npares,sum(pares) as in_par\n"
                    + "from lotespt l \n"
                    + "join programa p on l.lotes=p.lote\n"
                    + "join " + rcpt + ".dbo.pedidos ped on ped.pedido=p.pedido\n"
                    + "join " + cob + ".dbo.Clientes c on ped.NumCliente=c.NumCliente\n"
                    + "join " + rcpt + ".dbo.corridas cor on p.corridacpt=cor.Corrida\n"
                    + "where l.fecha between '" + f1 + "' and '" + f2 + "' and years=year(l.fecha)\n"
                    + "group by lotes,p.pedido, nombre40,corridacpt,cor.PuntoInicial, cor.PuntoFinal,p.npares";
//            System.out.println(sql);
            st = av.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                int lote = rs.getInt("lotes");
                int parin = rs.getInt("in_par");
                int npar = rs.getInt("npares");
                int pi = rs.getInt("puntoinicial") * 10;
                int pf = (rs.getInt("puntofinal") * 10) + 5;
                String pedido = rs.getString("pedido");
                String cliente = rs.getString("nombre40");
                sql = "select distinct convert(date,fecha) as fecha, lotes\n"
                        + "from lotespt\n"
                        + "where lotes=" + lote + " and fecha between '" + f1 + "' and '" + f2 + "'";
////                System.out.println(sql);
                st1 = av.prepareStatement(sql);
                rs1 = st1.executeQuery();
                while (rs1.next()) {
                    ArrayList<Avance> arrav = new ArrayList<>();
                    String fecha = rs1.getString("fecha");
                    sql = "select distinct sum(pares) as pares,punto\n"
                            + "from lotespt\n"
                            + "where lotes=" + lote + " and convert(date,fecha)='" + fecha + "'\n"
                            + "group by punto\n"
                            + "order by punto";
////                    System.out.println(sql);
                    st2 = av.prepareStatement(sql);
                    rs2 = st2.executeQuery();

                    while (rs2.next()) {
                        Avance a = new Avance();
                        a.setPunto(rs2.getString("punto"));
                        a.setPares(rs2.getInt("pares"));
                        arrav.add(a);
                    }
                    int iarr = 0;
                    int p = pi;
                    int aux = 1;
                    String sqlpar = "";
                    boolean band = true;
//                    bucle solo para crear un string con la consulta para insercion
                    for (int i = 0; i <= 11; i++) {
                        if (band) {
                            if (arrav.get(iarr).getPunto().equals(pi + "")) {
                                sqlpar = "'" + arrav.get(iarr).getPares() + "','" + pi + "'";
                                iarr++;
                            } else {
                                sqlpar = "'0','" + pi + "'";
                            }
                            p += 5;
                            band = false;
                        } else {
                            if (iarr < arrav.size()) {
                                if (arrav.get(iarr).getPunto().equals(p + "")) {
                                    sqlpar += ",'" + arrav.get(iarr).getPares() + "','" + p + "'";
                                    iarr++;
                                } else {
                                    if (p <= pf) {
                                        sqlpar += ",'0','" + p + "'";
                                    } else {
                                        sqlpar += ",'',''";
                                    }

                                }
                            } else {
                                if (p <= pf) {
                                    sqlpar += ",'0','" + p + "'";
                                } else {
                                    sqlpar += ",'',''";
                                }

                            }
                            p += 5;
                        }
                        aux++;
                    }
                    sql = "insert into Avancespt(lote,fecha,pedido,cliente,parinicial,parcap,c1,p1,c2,p2,c3,p3,c4,p4,c5,p5,c6,p6,c7,p7,c8,p8,c9,p9,c10,p10,c11,p11,c12,p12)"
                            + " values(" + lote + ",'" + fecha + "','" + pedido + "','" + cliente + "'," + parin + "," + npar + "," + sqlpar + ")";
////                    System.out.println(sql);
                    s = lite.prepareStatement(sql);
                    s.executeUpdate();
                    lite.commit();
////                    System.out.println(sqlpar);
                    arrav.clear();
                }
            }
            return true;
        } catch (SQLException ex) {
            try {
                lite.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<metadep> getallavance(Connection c) {
        ArrayList<metadep> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select  * from metaxdep order by nombre";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                metadep m = new metadep();
                m.setNombre(rs.getString("Nombre"));
                m.setCantxhr(rs.getInt("cantxhr"));
                m.setCantxdia(rs.getInt("cantxdia"));
                arr.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Cambios en col, de ahora en adelante se utilizara para mandar la
     * multiplicacion de hrs x los pares
     *
     * @param c
     * @param prs
     * @param col
     * @param nombre
     * @return
     */
    public boolean updateprshr(Connection c, int prs, String col, String nombre) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update metaxdep set cantxhr=?, cantxdia=? where nombre=?";
//            System.out.println("actualiza prs avance " + sql);
            st = c.prepareStatement(sql);
            st.setInt(1,prs);
            st.setInt(2, Integer.parseInt(col));
            st.setString(3, nombre);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<pantalla> getpantalals(Connection c) {
        ArrayList<pantalla> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from pantallas";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                pantalla p = new pantalla();
                p.setPantalla(rs.getInt("pantalla"));
                p.setNombre(rs.getString("nombre"));
                p.setCorte(rs.getString("corte"));
                p.setPrecorte(rs.getString("precorte"));
                p.setPespunte(rs.getString("pespunte"));
                p.setDeshebrado(rs.getString("deshebrado"));
                p.setOjillado(rs.getString("ojillado"));
                p.setInspeccion(rs.getString("inspeccion"));
                p.setPreacabado(rs.getString("preacabado"));
                p.setMontado(rs.getString("montado"));
                p.setMontado2(rs.getString("montado2"));
                p.setMontado3(rs.getString("montado3"));
                p.setMontado4(rs.getString("montado4"));
                p.setPt(rs.getString("pt"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int getmaxpantalla(Connection c) {
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select max(pantalla) as pantalla from pantallas";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("pantalla");
            }
            resp++;
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public boolean nuevaspantallas(Connection c, pantalla p) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            int pant = p.getPantalla();
            String n = p.getNombre();
            String cor = p.getCorte();
            String prec = p.getPrecorte();
            String pes = p.getPespunte();
            String des = p.getDeshebrado();
            String oji = p.getOjillado();
            String prea = p.getPreacabado();
            String ins = p.getInspeccion();
            String m = p.getMontado();
            String pt = p.getPt();
            String m2 = p.getMontado2();
            String m3 = p.getMontado3();
            String sql = "insert into pantallas "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            st = c.prepareStatement(sql);
            st.setInt(1, pant);
            st.setString(2, n);
            st.setString(3, cor);
            st.setString(4, prec);
            st.setString(5, pes);
            st.setString(6, des);
            st.setString(7, oji);
            st.setString(8, prea);
            st.setString(9, ins);
            st.setString(10, m);
            st.setString(11, pt);
            st.setString(12, m2);
            st.setString(13, "0");
            st.setString(14, "0");
            st.setString(15, "0");
            st.setString(16, m3);
            
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<Colsdepartamentos> getColsdepartamentos(Connection c){
        ArrayList<Colsdepartamentos> arr= new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from colsdepartamentos";
            st=c.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                Colsdepartamentos col= new Colsdepartamentos();
                col.setDepartamento(rs.getString("departamento"));
                col.setNombre(rs.getString("nombre"));
                col.setNfecha(rs.getString("nfecha"));
                col.setNmaq(rs.getString("nmaq"));
                arr.add(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    /**
     * Se obtiene los registros de el contexto de los campos de la bd y en base
     * a esos registros se asignaran valores a cada uno de los departamentos
     * encontrados, inicialmente se tenia pensado usar 2 metodos independientes
     * pero al final se desicion solo en uno.
     *
     * @param c
     * @param f1
     * @param f2
     * @return
     */
    public ArrayList<Colsdepartamentos> getColsdepas(Connection c, String f1, String f2) {
        ArrayList<Colsdepartamentos> arr = new ArrayList<>();
        ArrayList<Colsdepartamentos> arrf = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from colsdepartamentos";
//            System.out.println("colddepas " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Colsdepartamentos cd = new Colsdepartamentos();
                cd.setNombredep(rs.getString("nombre"));
                cd.setDepartamento(rs.getString("departamento"));
                cd.setNfecha(rs.getString("nfecha"));
                cd.setNmaq(rs.getString("nmaq"));
                arr.add(cd);
            }
            for (Colsdepartamentos arr1 : arr) {
                String nfecha = arr1.getNfecha();
                String nmaq = arr1.getNmaq();
                String depa = arr1.getNombredep();
                sql = "select datepart(dw,convert(date," + nfecha + ")) as dia,\n"
                        + "ndia=case when datepart(dw,convert(date," + nfecha + "))=1 then 'Lunes' else case when datepart(dw,convert(date," + nfecha + "))=2 then 'Martes' \n"
                        + "else case when datepart(dw,convert(date," + nfecha + "))=3 then 'Miercoles' else case when datepart(dw,convert(date," + nfecha + "))=4 then 'Jueves' \n"
                        + "else case when datepart(dw,convert(date," + nfecha + "))=5 then 'Viernes' else '' end end end end end,\n"
                        + "pares=case when datepart(dw,convert(date," + nfecha + "))=1 then sum(npares) else case when datepart(dw,convert(date," + nfecha + "))=2 then sum(npares) \n"
                        + "else case when datepart(dw,convert(date," + nfecha + "))=3 then sum(npares) else case when datepart(dw,convert(date," + nfecha + "))=4 then sum(npares) \n"
                        + "else case when datepart(dw,convert(date," + nfecha + "))=5 then sum(npares) else 0 end end end end end\n"
                        + "from programa p\n"
                        + "join avance a on p.id_prog=a.id_prog\n"
                        + "where convert(date," + nfecha + ") between '" + f1 + "' and '" + f2 + "' and " + nmaq + "='PL'\n"
                        + "group by convert(date," + nfecha + ")\n"
                        + "order by datepart(dw,convert(date," + nfecha + "))";
////                System.out.println("Avances sem " + sql);
                st = c.prepareStatement(sql);
                rs = st.executeQuery();
                while (rs.next()) {
                    Colsdepartamentos cd = new Colsdepartamentos();
                    cd.setDia(rs.getInt("dia"));
                    cd.setNdia(rs.getString("ndia"));
                    cd.setPares(rs.getInt("pares"));
                    cd.setNombre(depa);
                    arrf.add(cd);
                }
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrf;
    }

    public boolean insertaregsinavansemana(Connection c, ArrayList<Colsdepartamentos> arr) {
        PreparedStatement st;
        try {
            c.setAutoCommit(false);
            for (Colsdepartamentos arr1 : arr) {
                String sql = "insert into Avances_semanal(nombre,dia,ndia,pares) "
                        + "values(?,?,?,?)";
////                System.out.println("insert avance sem " + sql);
                st = c.prepareStatement(sql);
                st.setString(1, arr1.getNombre());
                st.setInt(2, arr1.getDia() );
                st.setString(3, arr1.getNdia());
                st.setInt(4, arr1.getPares());
                st.executeUpdate();
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

//    public boolean deleterowsAvansem(Connection c) {
//        try {
//            PreparedStatement st;
//            c.setAutoCommit(false);
//            String sql = "delete from Avances_semanal";
//            st = c.prepareStatement(sql);
//            st.executeUpdate();
//            c.commit();
//            return true;
//        } catch (SQLException ex) {
//            try {
//                c.rollback();
//                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex1) {
//                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            return false;
//        }
//    }

    public ArrayList<Colsdepartamentos> getarrayavancemes(Connection c, String f1, String f2, String nfecha, String nmaq, String dep, int depa) {
        ArrayList<Colsdepartamentos> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select convert(date," + nfecha + ") as fecha,datepart(dw,convert(date," + nfecha + ")) as dia,\n"
                    + "pares=case when " + dep + "!=0  then sum(npares) else 0 end\n"
                    + "from programa p\n"
                    + "join avance a on p.id_prog=a.id_prog\n"
                    + "where convert(date," + nfecha + ") between '" + f1 + "' and '" + f2 + "' and " + nmaq + "='PL' and "+dep+"="+depa+"\n"
                    + "group by convert(date," + nfecha + ")," + dep + "\n"
                    + "order by convert(date," + nfecha + ")";
//            System.out.println("avancexdepa " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Colsdepartamentos cd = new Colsdepartamentos();
                cd.setNombre(dep);
                cd.setDia(rs.getInt("dia"));
                cd.setFecha(rs.getString("fecha"));
                cd.setPares(rs.getInt("pares"));
                arr.add(cd);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean insertarregsMes(Connection c, ArrayList<Davance> arr) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            String sql;
            for (Davance arr1 : arr) {
                String f = arr1.getFecha();
                int cor = arr1.getCor();
                int pre = arr1.getPrecor();
                int pes = arr1.getPes();
                int des = arr1.getDes();
                int oji = arr1.getOji();
                int ins = arr1.getInsp();
                int prea = arr1.getPrea();
                int mont = arr1.getMont();
                int pt = arr1.getPt();
                sql = "insert into Avances_mensual(fecha,corte,precor,pes,des,oji,ins,prea,mont,pt) "
//                        + "values('" + f + "'," + cor + "," + pre + "," + pes + "," + des + "," + oji + "," + ins + "," + prea + "," + mont + "," + pt + ")";
                        + "values(?,?,?,?,?,?,?,?,?,?)";
//                System.out.println("Avanmensual " + sql);
                st = c.prepareStatement(sql);
                st.setString(1, f);
                st.setInt(2, cor);
                st.setInt(3, pre);
                st.setInt(4, pes);
                st.setInt(5, des);
                st.setInt(6, oji);
                st.setInt(7, ins);
                st.setInt(8, prea);
                st.setInt(9, mont);
                st.setInt(10, pt);
                st.executeUpdate();
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deleteregsMes(Connection c, String col) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            String sql;
            sql = "delete from "+col;
//            System.out.println("Avantabla " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public Davance getregsDia(Connection c, String f2, String nmaq, String nfecha, String dep) {
        Davance da = new Davance();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select sum(npares) as total,\n"
                    + "(select sum(npares)\n"
                    + "from programa p\n"
                    + "join avance a on p.id_prog=a.id_prog\n"
                    + "where convert(date," + nfecha + ") between '" + f2 + "' and '" + f2 + "' and " + nmaq + "='PL' and " + dep + "!=0\n"
                    + "and (a.lote<=30000 or a.lote >=35900) ) as reportado,\n"
                    + "(select ISNULL(sum(npares),0)\n"
                    + "from programa p\n"
                    + "join avance a on p.id_prog=a.id_prog\n"
                    + "where convert(date," + nfecha + ") between '" + f2 + "' and '" + f2 + "' and " + nmaq + "='PL' and " + dep + "!=0\n"
                    + "and (a.lote>=30000 and a.lote <=35900) ) as muestras,\n"
                    + "(select sum(npares) from programa p\n"
                    + "join avance a on p.id_prog=a.id_prog\n"
                    + "where convert(date," + nfecha + ") between convert(date,dateadd(day,-DATEPART(dw,'" + f2 + "'),'" + f2 + "')) \n"
                    + "and '" + f2 + "' and " + nmaq + "='PL' and " + dep + "!=0) as acumulado,\n"
                    + "(select (sum(npares)/DATEPART(dw,'" + f2 + "'))*5 from programa p\n"
                    + "join avance a on p.id_prog=a.id_prog \n"
                    + "where convert(date," + nfecha + ") between '" + f2 + "' and '" + f2 + "' and " + nmaq + "='PL' and " + dep + "!=0) as proyeccion\n"
                    + "from programa p\n"
                    + "join avance a on p.id_prog=a.id_prog\n"
                    + "where convert(date," + nfecha + ") between '" + f2 + "' and '" + f2 + "' and " + nmaq + "='PL' and " + dep + "!=0";
////            System.out.println("avances dia "+sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                da.setDepa(dep);
                da.setReportado(rs.getInt("reportado"));
                da.setMuestras(rs.getInt("muestras"));
                da.setTotal(rs.getInt("total"));
//                da.setAcumulado(rs.getInt("acumulado")-da.getTotal());
                da.setAcumulado(rs.getInt("acumulado"));
                da.setProyeccion(rs.getInt("proyeccion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return da;
    }

    public boolean insertarregsDia(Connection c, ArrayList<Davance> arr) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            String sql;
            for (Davance arr1 : arr) {
                String n = arr1.getDepa();
                int repor = arr1.getReportado();
                int mues = arr1.getMuestras();
                int t = arr1.getTotal();
                int acum = arr1.getAcumulado();
                int proy = arr1.getProyeccion();
                sql = "insert into Avances_Diario(nombre,reportado,muestras,Total,Acumulado,Proyeccion) "
                        + "values(?,?,?,?,?,?)";
////                System.out.println("Avadiario " + sql);
                st = c.prepareStatement(sql);
                st.setString(1, n);
                st.setInt(2, repor);
                st.setInt(3, mues);
                st.setInt(4, t);
                st.setInt(5, acum);
                st.setInt(6, proy);
                st.executeUpdate();
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
    
    

}
