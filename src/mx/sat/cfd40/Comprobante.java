//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.10.27 a las 04:05:03 PM CDT 
//
package mx.sat.cfd40;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Clase Java para anonymous complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InformacionGlobal" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Periodicidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Periodicidad" />
 *                 &lt;attribute name="Meses" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Meses" />
 *                 &lt;attribute name="A�o" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *                       &lt;minInclusive value="2021"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CfdiRelacionados" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CfdiRelacionado" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="UUID" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;length value="36"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="TipoRelacion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoRelacion" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Emisor">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
 *                 &lt;attribute name="Nombre" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[^|]{1,300}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RegimenFiscal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
 *                 &lt;attribute name="FacAtrAdquirente">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;length value="10"/>
 *                       &lt;pattern value="[0-9]{10}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Receptor">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
 *                 &lt;attribute name="Nombre" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[^|]{1,300}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="DomicilioFiscalReceptor" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;length value="5"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[0-9]{5}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="ResidenciaFiscal" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
 *                 &lt;attribute name="NumRegIdTrib">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="40"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RegimenFiscalReceptor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
 *                 &lt;attribute name="UsoCFDI" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_UsoCFDI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Conceptos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Concepto" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Impuestos" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Traslados" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Traslado" maxOccurs="unbounded">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;attribute name="Base" use="required">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;fractionDigits value="6"/>
 *                                                               &lt;minInclusive value="0.000001"/>
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                                         &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                                         &lt;attribute name="TasaOCuota">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;fractionDigits value="6"/>
 *                                                               &lt;minInclusive value="0.000000"/>
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Retenciones" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Retencion" maxOccurs="unbounded">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;attribute name="Base" use="required">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;fractionDigits value="6"/>
 *                                                               &lt;minInclusive value="0.000001"/>
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                                         &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                                         &lt;attribute name="TasaOCuota" use="required">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                               &lt;minInclusive value="0.000000"/>
 *                                                               &lt;fractionDigits value="6"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ACuentaTerceros" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="RfcACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
 *                                     &lt;attribute name="NombreACuentaTerceros" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="300"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,300}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="RegimenFiscalACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
 *                                     &lt;attribute name="DomicilioFiscalACuentaTerceros" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;length value="5"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[0-9]{5}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="NumeroPedimento" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;length value="21"/>
 *                                           &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CuentaPredial" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Numero" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="150"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[0-9a-zA-Z]{1,150}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ComplementoConcepto" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;any maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Parte" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="NumeroPedimento" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;length value="21"/>
 *                                                     &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
 *                                     &lt;attribute name="NoIdentificacion">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="100"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,100}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Cantidad" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                           &lt;fractionDigits value="6"/>
 *                                           &lt;minInclusive value="0.000001"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Unidad">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="20"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,20}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Descripcion" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="1000"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,1000}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                     &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
 *                           &lt;attribute name="NoIdentificacion">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="100"/>
 *                                 &lt;pattern value="[^|]{1,100}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Cantidad" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                 &lt;fractionDigits value="6"/>
 *                                 &lt;minInclusive value="0.000001"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ClaveUnidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveUnidad" />
 *                           &lt;attribute name="Unidad">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="20"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,20}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Descripcion" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="1000"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,1000}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ValorUnitario" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="ObjetoImp" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ObjetoImp" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Impuestos" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Retenciones" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Retencion" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Traslados" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Traslado" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Base" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                     &lt;attribute name="TasaOCuota">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;minInclusive value="0.000000"/>
 *                                           &lt;fractionDigits value="6"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                 &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Complemento" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Addenda" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" use="required" fixed="4.0">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Serie">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="25"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[^|]{1,25}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Folio">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="40"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[^|]{1,40}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Fecha" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_FechaH" />
 *       &lt;attribute name="Sello" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="FormaPago" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_FormaPago" />
 *       &lt;attribute name="NoCertificado" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;length value="20"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[0-9]{20}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Certificado" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CondicionesDePago">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="1000"/>
 *             &lt;pattern value="[^|]{1,1000}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SubTotal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *       &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *       &lt;attribute name="Moneda" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
 *       &lt;attribute name="TipoCambio">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;fractionDigits value="6"/>
 *             &lt;minInclusive value="0.000001"/>
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Total" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *       &lt;attribute name="TipoDeComprobante" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoDeComprobante" />
 *       &lt;attribute name="Exportacion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Exportacion" />
 *       &lt;attribute name="MetodoPago" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_MetodoPago" />
 *       &lt;attribute name="LugarExpedicion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_CodigoPostal" />
 *       &lt;attribute name="Confirmacion">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;length value="5"/>
 *             &lt;pattern value="[0-9a-zA-Z]{5}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "informacionGlobal",
    "cfdiRelacionados",
    "emisor",
    "receptor",
    "conceptos",
    "impuestos",
    "complemento",
    "addenda"
})
@XmlRootElement(name = "Comprobante")
public class Comprobante {

    @XmlElement(name = "InformacionGlobal")
    protected Comprobante.InformacionGlobal informacionGlobal;
    @XmlElement(name = "CfdiRelacionados")
    protected List<Comprobante.CfdiRelacionados> cfdiRelacionados;
    @XmlElement(name = "Emisor", required = true)
    protected Comprobante.Emisor emisor;
    @XmlElement(name = "Receptor", required = true)
    protected Comprobante.Receptor receptor;
    @XmlElement(name = "Conceptos", required = true)
    protected Comprobante.Conceptos conceptos;
    @XmlElement(name = "Impuestos")
    protected Comprobante.Impuestos impuestos;
    @XmlElement(name = "Complemento")
    protected Comprobante.Complemento complemento;
    @XmlElement(name = "Addenda")
    protected Comprobante.Addenda addenda;
    @XmlAttribute(name = "Version", required = true)
    protected String version;
    @XmlAttribute(name = "Serie")
    protected String serie;
    @XmlAttribute(name = "Folio")
    protected String folio;
    @XmlAttribute(name = "Fecha", required = true)
    protected XMLGregorianCalendar fecha;
    @XmlAttribute(name = "Sello", required = true)
    protected String sello;
    @XmlAttribute(name = "FormaPago")
    protected String formaPago;
    @XmlAttribute(name = "NoCertificado", required = true)
    protected String noCertificado;
    @XmlAttribute(name = "Certificado", required = true)
    protected String certificado;
    @XmlAttribute(name = "CondicionesDePago")
    protected String condicionesDePago;
    @XmlAttribute(name = "SubTotal", required = true)
    protected BigDecimal subTotal;
    @XmlAttribute(name = "Descuento")
    protected BigDecimal descuento;
    @XmlAttribute(name = "Moneda", required = true)
    protected CMoneda moneda;
    @XmlAttribute(name = "TipoCambio")
    protected BigDecimal tipoCambio;
    @XmlAttribute(name = "Total", required = true)
    protected BigDecimal total;
    @XmlAttribute(name = "TipoDeComprobante", required = true)
    protected CTipoDeComprobante tipoDeComprobante;
    @XmlAttribute(name = "Exportacion", required = true)
    protected String exportacion;
    @XmlAttribute(name = "MetodoPago")
    protected CMetodoPago metodoPago;
    @XmlAttribute(name = "LugarExpedicion", required = true)
    protected String lugarExpedicion;
    @XmlAttribute(name = "Confirmacion")
    protected String confirmacion;

    /**
     * Obtiene el valor de la propiedad informacionGlobal.
     *
     * @return possible object is {@link Comprobante.InformacionGlobal }
     *
     */
    public Comprobante.InformacionGlobal getInformacionGlobal() {
        return informacionGlobal;
    }

    /**
     * Define el valor de la propiedad informacionGlobal.
     *
     * @param value allowed object is {@link Comprobante.InformacionGlobal }
     *
     */
    public void setInformacionGlobal(Comprobante.InformacionGlobal value) {
        this.informacionGlobal = value;
    }

    /**
     * Gets the value of the cfdiRelacionados property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the cfdiRelacionados property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCfdiRelacionados().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comprobante.CfdiRelacionados }
     *
     *
     */
    public List<Comprobante.CfdiRelacionados> getCfdiRelacionados() {
        if (cfdiRelacionados == null) {
            cfdiRelacionados = new ArrayList<Comprobante.CfdiRelacionados>();
        }
        return this.cfdiRelacionados;
    }

    /**
     * Obtiene el valor de la propiedad emisor.
     *
     * @return possible object is {@link Comprobante.Emisor }
     *
     */
    public Comprobante.Emisor getEmisor() {
        return emisor;
    }

    /**
     * Define el valor de la propiedad emisor.
     *
     * @param value allowed object is {@link Comprobante.Emisor }
     *
     */
    public void setEmisor(Comprobante.Emisor value) {
        this.emisor = value;
    }

    /**
     * Obtiene el valor de la propiedad receptor.
     *
     * @return possible object is {@link Comprobante.Receptor }
     *
     */
    public Comprobante.Receptor getReceptor() {
        return receptor;
    }

    /**
     * Define el valor de la propiedad receptor.
     *
     * @param value allowed object is {@link Comprobante.Receptor }
     *
     */
    public void setReceptor(Comprobante.Receptor value) {
        this.receptor = value;
    }

    /**
     * Obtiene el valor de la propiedad conceptos.
     *
     * @return possible object is {@link Comprobante.Conceptos }
     *
     */
    public Comprobante.Conceptos getConceptos() {
        return conceptos;
    }

    /**
     * Define el valor de la propiedad conceptos.
     *
     * @param value allowed object is {@link Comprobante.Conceptos }
     *
     */
    public void setConceptos(Comprobante.Conceptos value) {
        this.conceptos = value;
    }

    /**
     * Obtiene el valor de la propiedad impuestos.
     *
     * @return possible object is {@link Comprobante.Impuestos }
     *
     */
    public Comprobante.Impuestos getImpuestos() {
        return impuestos;
    }

    /**
     * Define el valor de la propiedad impuestos.
     *
     * @param value allowed object is {@link Comprobante.Impuestos }
     *
     */
    public void setImpuestos(Comprobante.Impuestos value) {
        this.impuestos = value;
    }

    /**
     * Obtiene el valor de la propiedad complemento.
     *
     * @return possible object is {@link Comprobante.Complemento }
     *
     */
    public Comprobante.Complemento getComplemento() {
        return complemento;
    }

    /**
     * Define el valor de la propiedad complemento.
     *
     * @param value allowed object is {@link Comprobante.Complemento }
     *
     */
    public void setComplemento(Comprobante.Complemento value) {
        this.complemento = value;
    }

    /**
     * Obtiene el valor de la propiedad addenda.
     *
     * @return possible object is {@link Comprobante.Addenda }
     *
     */
    public Comprobante.Addenda getAddenda() {
        return addenda;
    }

    /**
     * Define el valor de la propiedad addenda.
     *
     * @param value allowed object is {@link Comprobante.Addenda }
     *
     */
    public void setAddenda(Comprobante.Addenda value) {
        this.addenda = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     *
     * @return possible object is {@link String }
     *
     */
    public String getVersion() {
        if (version == null) {
            return "4.0";
        } else {
            return version;
        }
    }

    /**
     * Define el valor de la propiedad version.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad serie.
     *
     * @return possible object is {@link String }
     *
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Define el valor de la propiedad serie.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Obtiene el valor de la propiedad folio.
     *
     * @return possible object is {@link String }
     *
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Define el valor de la propiedad folio.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setFolio(String value) {
        this.folio = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     *
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad sello.
     *
     * @return possible object is {@link String }
     *
     */
    public String getSello() {
        return sello;
    }

    /**
     * Define el valor de la propiedad sello.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setSello(String value) {
        this.sello = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPago.
     *
     * @return possible object is {@link String }
     *
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Define el valor de la propiedad formaPago.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad noCertificado.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNoCertificado() {
        return noCertificado;
    }

    /**
     * Define el valor de la propiedad noCertificado.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNoCertificado(String value) {
        this.noCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad certificado.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     * Define el valor de la propiedad certificado.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCertificado(String value) {
        this.certificado = value;
    }

    /**
     * Obtiene el valor de la propiedad condicionesDePago.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    /**
     * Define el valor de la propiedad condicionesDePago.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCondicionesDePago(String value) {
        this.condicionesDePago = value;
    }

    /**
     * Obtiene el valor de la propiedad subTotal.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Define el valor de la propiedad subTotal.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setSubTotal(BigDecimal value) {
        this.subTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad descuento.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setDescuento(BigDecimal value) {
        this.descuento = value;
    }

    /**
     * Obtiene el valor de la propiedad moneda.
     *
     * @return possible object is {@link CMoneda }
     *
     */
    public CMoneda getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     *
     * @param value allowed object is {@link CMoneda }
     *
     */
    public void setMoneda(CMoneda value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCambio.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    /**
     * Define el valor de la propiedad tipoCambio.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setTipoCambio(BigDecimal value) {
        this.tipoCambio = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDeComprobante.
     *
     * @return possible object is {@link CTipoDeComprobante }
     *
     */
    public CTipoDeComprobante getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    /**
     * Define el valor de la propiedad tipoDeComprobante.
     *
     * @param value allowed object is {@link CTipoDeComprobante }
     *
     */
    public void setTipoDeComprobante(CTipoDeComprobante value) {
        this.tipoDeComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad exportacion.
     *
     * @return possible object is {@link String }
     *
     */
    public String getExportacion() {
        return exportacion;
    }

    /**
     * Define el valor de la propiedad exportacion.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setExportacion(String value) {
        this.exportacion = value;
    }

    /**
     * Obtiene el valor de la propiedad metodoPago.
     *
     * @return possible object is {@link CMetodoPago }
     *
     */
    public CMetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Define el valor de la propiedad metodoPago.
     *
     * @param value allowed object is {@link CMetodoPago }
     *
     */
    public void setMetodoPago(CMetodoPago value) {
        this.metodoPago = value;
    }

    /**
     * Obtiene el valor de la propiedad lugarExpedicion.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    /**
     * Define el valor de la propiedad lugarExpedicion.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setLugarExpedicion(String value) {
        this.lugarExpedicion = value;
    }

    /**
     * Obtiene el valor de la propiedad confirmacion.
     *
     * @return possible object is {@link String }
     *
     */
    public String getConfirmacion() {
        return confirmacion;
    }

    /**
     * Define el valor de la propiedad confirmacion.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setConfirmacion(String value) {
        this.confirmacion = value;
    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Addenda {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the any property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         *
         *
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CfdiRelacionado" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="UUID" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;length value="36"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="TipoRelacion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoRelacion" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cfdiRelacionado"
    })
    public static class CfdiRelacionados {

        @XmlElement(name = "CfdiRelacionado", required = true)
        protected List<Comprobante.CfdiRelacionados.CfdiRelacionado> cfdiRelacionado;
        @XmlAttribute(name = "TipoRelacion", required = true)
        protected String tipoRelacion;

        /**
         * Gets the value of the cfdiRelacionado property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the cfdiRelacionado property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCfdiRelacionado().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Comprobante.CfdiRelacionados.CfdiRelacionado }
         *
         *
         */
        public List<Comprobante.CfdiRelacionados.CfdiRelacionado> getCfdiRelacionado() {
            if (cfdiRelacionado == null) {
                cfdiRelacionado = new ArrayList<Comprobante.CfdiRelacionados.CfdiRelacionado>();
            }
            return this.cfdiRelacionado;
        }

        /**
         * Obtiene el valor de la propiedad tipoRelacion.
         *
         * @return possible object is {@link String }
         *
         */
        public String getTipoRelacion() {
            return tipoRelacion;
        }

        /**
         * Define el valor de la propiedad tipoRelacion.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setTipoRelacion(String value) {
            this.tipoRelacion = value;
        }

        /**
         * <p>
         * Clase Java para anonymous complex type.
         *
         * <p>
         * El siguiente fragmento de esquema especifica el contenido que se
         * espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="UUID" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;length value="36"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class CfdiRelacionado {

            @XmlAttribute(name = "UUID", required = true)
            protected String uuid;

            /**
             * Obtiene el valor de la propiedad uuid.
             *
             * @return possible object is {@link String }
             *
             */
            public String getUUID() {
                return uuid;
            }

            /**
             * Define el valor de la propiedad uuid.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setUUID(String value) {
                this.uuid = value;
            }

        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any",
        "pagos"
    })
    public static class Complemento {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         *
         */
//        @XmlElement(name = "Pagos", required = true)
        @XmlElement(name = "Pagos", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
        protected Comprobante.Complemento.Pagos pagos;

        /**
         * Gets the value of the any property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the any property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         *
         *
         * @param value
         */
        public void setPagos(Comprobante.Complemento.Pagos value) {
            this.pagos = value;
        }

        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "totales",
            "pago"
        })
        public static class Pagos {

            @XmlElement(name = "Totales", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
            protected Comprobante.Complemento.Pagos.Totales totales;
            @XmlElement(name = "Pago", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
            protected List<Comprobante.Complemento.Pagos.Pago> pago;
            @XmlAttribute(name = "Version", required = true)
            protected String version;

            public void setVersion(String value) {
                this.version = value;
            }

            public String getVersion() {
                if (version == null) {
                    return "2.0";
                } else {
                    return version;
                }
            }

            public Pagos.Totales getTotales() {
                return totales;
            }

            public void setTotales(Comprobante.Complemento.Pagos.Totales value) {
                this.totales = value;
            }

            public List<Comprobante.Complemento.Pagos.Pago> getPago() {
                if (pago == null) {
                    pago = new ArrayList<Comprobante.Complemento.Pagos.Pago>();
                }
                return this.pago;
            }

            public Pagos() {

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Totales {

                @XmlAttribute(name = "TotalRetencionesIVA")
                protected BigDecimal totalRetencionesIVA;
                @XmlAttribute(name = "TotalRetencionesISR")
                protected BigDecimal totalRetencionesISR;
                @XmlAttribute(name = "TotalRetencionesIEPS")
                protected BigDecimal totalRetencionesIEPS;
                @XmlAttribute(name = "TotalTrasladosBaseIVA16")
                protected BigDecimal totalTrasladosBaseIVA16;
                @XmlAttribute(name = "TotalTrasladosImpuestoIVA16")
                protected BigDecimal totalTrasladosImpuestoIVA16;
                @XmlAttribute(name = "TotalTrasladosBaseIVA8")
                protected BigDecimal totalTrasladosBaseIVA8;
                @XmlAttribute(name = "TotalTrasladosImpuestoIVA8")
                protected BigDecimal totalTrasladosImpuestoIVA8;
                @XmlAttribute(name = "TotalTrasladosBaseIVA0")
                protected BigDecimal totalTrasladosBaseIVA0;
                @XmlAttribute(name = "TotalTrasladosImpuestoIVA0")
                protected BigDecimal totalTrasladosImpuestoIVA0;
                @XmlAttribute(name = "TotalTrasladosBaseIVAExento")
                protected BigDecimal totalTrasladosBaseIVAExento;
                @XmlAttribute(name = "MontoTotalPagos", required = true)
                protected BigDecimal montoTotalPagos;

                public BigDecimal getTotalRetencionesIVA() {
                    return totalRetencionesIVA;
                }

                public void setTotalRetencionesIVA(BigDecimal value) {
                    this.totalRetencionesIVA = value;
                }

                public BigDecimal getTotalRetencionesISR() {
                    return totalRetencionesISR;
                }

                public void setTotalRetencionesISR(BigDecimal value) {
                    this.totalRetencionesISR = value;
                }

                public BigDecimal getTotalRetencionesIEPS() {
                    return totalRetencionesIEPS;
                }

                public void setTotalRetencionesIEPS(BigDecimal value) {
                    this.totalRetencionesIEPS = value;
                }

                public BigDecimal getTotalTrasladosBaseIVA16() {
                    return totalTrasladosBaseIVA16;
                }

                public void setTotalTrasladosBaseIVA16(BigDecimal value) {
                    this.totalTrasladosBaseIVA16 = value;
                }

                public BigDecimal getTotalTrasladosImpuestoIVA16() {
                    return totalTrasladosImpuestoIVA16;
                }

                public void setTotalTrasladosImpuestoIVA16(BigDecimal value) {
                    this.totalTrasladosImpuestoIVA16 = value;
                }

                public BigDecimal getTotalTrasladosBaseIVA8() {
                    return totalTrasladosBaseIVA8;
                }

                public void setTotalTrasladosBaseIVA8(BigDecimal value) {
                    this.totalTrasladosBaseIVA8 = value;
                }

                public BigDecimal getTotalTrasladosImpuestoIVA8() {
                    return totalTrasladosImpuestoIVA8;
                }

                public void setTotalTrasladosImpuestoIVA8(BigDecimal value) {
                    this.totalTrasladosImpuestoIVA8 = value;
                }

                public BigDecimal getTotalTrasladosBaseIVA0() {
                    return totalTrasladosBaseIVA0;
                }

                public void setTotalTrasladosBaseIVA0(BigDecimal value) {
                    this.totalTrasladosBaseIVA0 = value;
                }

                public BigDecimal getTotalTrasladosImpuestoIVA0() {
                    return totalTrasladosImpuestoIVA0;
                }

                public void setTotalTrasladosImpuestoIVA0(BigDecimal value) {
                    this.totalTrasladosImpuestoIVA0 = value;
                }

                public BigDecimal getTotalTrasladosBaseIVAExento() {
                    return totalTrasladosBaseIVAExento;
                }

                public void setTotalTrasladosBaseIVAExento(BigDecimal value) {
                    this.totalTrasladosBaseIVAExento = value;
                }

                public BigDecimal getMontoTotalPagos() {
                    return montoTotalPagos;
                }

                public void setMontoTotalPagos(BigDecimal value) {
                    this.montoTotalPagos = value;
                }

                public Totales() {
                }
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "doctoRelacionado",
                "impuestosP"
            })
            public static class Pago {

                @XmlElement(name = "DoctoRelacionado", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                protected List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado> doctoRelacionado;
                @XmlElement(name = "ImpuestosP", namespace= "http://www.sat.gob.mx/Pagos20")
                protected Comprobante.Complemento.Pagos.Pago.ImpuestosP impuestosP;
                @XmlAttribute(name = "FechaPago", required = true)
                protected XMLGregorianCalendar fechaPago;
                @XmlAttribute(name = "FormaDePagoP", required = true)
                protected String formaDePagoP;
                @XmlAttribute(name = "MonedaP", required = true)
                protected CMoneda monedaP;
                @XmlAttribute(name = "TipoCambioP")
                protected BigDecimal tipoCambioP;
                @XmlAttribute(name = "Monto", required = true)
                protected BigDecimal monto;
                @XmlAttribute(name = "NumOperacion")
                protected String numOperacion;
                @XmlAttribute(name = "RfcEmisorCtaOrd")
                protected String rfcEmisorCtaOrd;
                @XmlAttribute(name = "NomBancoOrdExt")
                protected String nomBancoOrdExt;
                @XmlAttribute(name = "CtaOrdenante")
                protected String ctaOrdenante;
                @XmlAttribute(name = "RfcEmisorCtaBen")
                protected String rfcEmisorCtaBen;
                @XmlAttribute(name = "CtaBeneficiario")
                protected String ctaBeneficiario;
                @XmlAttribute(name = "TipoCadPago")
                protected String tipoCadPago;
                @XmlAttribute(name = "CertPago")
                protected byte[] certPago;
                @XmlAttribute(name = "CadPago")
                protected String cadPago;
                @XmlAttribute(name = "SelloPago")
                protected byte[] selloPago;

                public List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado> getDoctoRelacionado() {
                    if (doctoRelacionado == null) {
                        doctoRelacionado = new ArrayList<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado>();
                    }
                    return this.doctoRelacionado;
                }

                public Comprobante.Complemento.Pagos.Pago.ImpuestosP getImpuestosP() {
                    return impuestosP;
                }

                public void setImpuestosP(Comprobante.Complemento.Pagos.Pago.ImpuestosP value) {
                    this.impuestosP = value;
                }

                public XMLGregorianCalendar getFechaPago() {
                    return fechaPago;
                }

                public void setFechaPago(XMLGregorianCalendar value) {
                    this.fechaPago = value;
                }

                public String getFormaDePagoP() {
                    return formaDePagoP;
                }

                public void setFormaDePagoP(String value) {
                    this.formaDePagoP = value;
                }

                public CMoneda getMonedaP() {
                    return monedaP;
                }

                public void setMonedaP(CMoneda value) {
                    this.monedaP = value;
                }

                public BigDecimal getTipoCambioP() {
                    return tipoCambioP;
                }

                public void setTipoCambioP(BigDecimal value) {
                    this.tipoCambioP = value;
                }

                public BigDecimal getMonto() {
                    return monto;
                }

                public void setMonto(BigDecimal value) {
                    this.monto = value;
                }

                public String getNumOperacion() {
                    return numOperacion;
                }

                public void setNumOperacion(String value) {
                    this.numOperacion = value;
                }

                public String getRfcEmisorCtaOrd() {
                    return rfcEmisorCtaOrd;
                }

                public void setRfcEmisorCtaOrd(String value) {
                    this.rfcEmisorCtaOrd = value;
                }

                public String getNomBancoOrdExt() {
                    return nomBancoOrdExt;
                }

                public void setNomBancoOrdExt(String value) {
                    this.nomBancoOrdExt = value;
                }

                public String getCtaOrdenante() {
                    return ctaOrdenante;
                }

                public void setCtaOrdenante(String value) {
                    this.ctaOrdenante = value;
                }

                public String getRfcEmisorCtaBen() {
                    return rfcEmisorCtaBen;
                }

                public void setRfcEmisorCtaBen(String value) {
                    this.rfcEmisorCtaBen = value;
                }

                public String getCtaBeneficiario() {
                    return ctaBeneficiario;
                }

                public void setCtaBeneficiario(String value) {
                    this.ctaBeneficiario = value;
                }

                public String getTipoCadPago() {
                    return tipoCadPago;
                }

                public void setTipoCadPago(String value) {
                    this.tipoCadPago = value;
                }

                public byte[] getCertPago() {
                    return certPago;
                }

                public void setCertPago(byte[] value) {
                    this.certPago = value;
                }

                public String getCadPago() {
                    return cadPago;
                }

                public void setCadPago(String value) {
                    this.cadPago = value;
                }

                public byte[] getSelloPago() {
                    return selloPago;
                }

                public void setSelloPago(byte[] value) {
                    this.selloPago = value;
                }

                public Pago() {
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "impuestosDR"
                })
                public static class DoctoRelacionado {

                    @XmlElement(name = "ImpuestosDR", namespace= "http://www.sat.gob.mx/Pagos20")
                    protected Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR impuestosDR;
                    @XmlAttribute(name = "IdDocumento", required = true)
                    protected String idDocumento;
                    @XmlAttribute(name = "Serie")
                    protected String serie;
                    @XmlAttribute(name = "Folio")
                    protected String folio;
                    @XmlAttribute(name = "MonedaDR", required = true)
                    protected CMoneda monedaDR;
                    @XmlAttribute(name = "EquivalenciaDR")
                    protected BigDecimal equivalenciaDR;
                    @XmlAttribute(name = "NumParcialidad", required = true)
                    protected BigInteger numParcialidad;
                    @XmlAttribute(name = "ImpSaldoAnt", required = true)
                    protected BigDecimal impSaldoAnt;
                    @XmlAttribute(name = "ImpPagado", required = true)
                    protected BigDecimal impPagado;
                    @XmlAttribute(name = "ImpSaldoInsoluto", required = true)
                    protected BigDecimal impSaldoInsoluto;
                    @XmlAttribute(name = "ObjetoImpDR", required = true)
                    protected String objetoImpDR;

                    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR getImpuestosDR() {
                        return impuestosDR;
                    }

                    public void setImpuestosDR(Pagos.Pago.DoctoRelacionado.ImpuestosDR value) {
                        this.impuestosDR = value;
                    }

                    public String getIdDocumento() {
                        return idDocumento;
                    }

                    public void setIdDocumento(String value) {
                        this.idDocumento = value;
                    }

                    public String getSerie() {
                        return serie;
                    }

                    public void setSerie(String value) {
                        this.serie = value;
                    }

                    public String getFolio() {
                        return folio;
                    }

                    public void setFolio(String value) {
                        this.folio = value;
                    }

                    public CMoneda getMonedaDR() {
                        return monedaDR;
                    }

                    public void setMonedaDR(CMoneda value) {
                        this.monedaDR = value;
                    }

                    public BigDecimal getEquivalenciaDR() {
                        return equivalenciaDR;
                    }

                    public void setEquivalenciaDR(BigDecimal value) {
                        this.equivalenciaDR = value;
                    }

                    public BigInteger getNumParcialidad() {
                        return numParcialidad;
                    }

                    public void setNumParcialidad(BigInteger value) {
                        this.numParcialidad = value;
                    }

                    public BigDecimal getImpSaldoAnt() {
                        return impSaldoAnt;
                    }

                    public void setImpSaldoAnt(BigDecimal value) {
                        this.impSaldoAnt = value;
                    }

                    public BigDecimal getImpPagado() {
                        return impPagado;
                    }

                    public void setImpPagado(BigDecimal value) {
                        this.impPagado = value;
                    }

                    public BigDecimal getImpSaldoInsoluto() {
                        return impSaldoInsoluto;
                    }

                    public void setImpSaldoInsoluto(BigDecimal value) {
                        this.impSaldoInsoluto = value;
                    }

                    public String getObjetoImpDR() {
                        return objetoImpDR;
                    }

                    public void setObjetoImpDR(String value) {
                        this.objetoImpDR = value;
                    }

                    public DoctoRelacionado() {
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "retencionesDR",
                        "trasladosDR"
                    })
                    public static class ImpuestosDR {

                        @XmlElement(name = "RetencionesDR", namespace= "http://www.sat.gob.mx/Pagos20")
                        protected Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR retencionesDR;
                        @XmlElement(name = "TrasladosDR", namespace= "http://www.sat.gob.mx/Pagos20")
                        protected Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR trasladosDR;

                        public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR getRetencionesDR() {
                            return retencionesDR;
                        }

                        public void setRetencionesDR(Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR value) {
                            this.retencionesDR = value;
                        }

                        public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR getTrasladosDR() {
                            return trasladosDR;
                        }

                        public void setTrasladosDR(Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR value) {
                            this.trasladosDR = value;
                        }

                        public ImpuestosDR() {
                        }

                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "retencionDR"
                        })
                        public static class RetencionesDR {

                            @XmlElement(name = "RetencionDR", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                            protected List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR.RetencionDR> retencionDR;

                            public List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR.RetencionDR> getRetencionDR() {
                                if (retencionDR == null) {
                                    retencionDR = new ArrayList<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR.RetencionDR>();
                                }
                                return this.retencionDR;
                            }

                            public RetencionesDR() {
                            }

                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "")
                            public static class RetencionDR {

                                @XmlAttribute(name = "BaseDR", required = true)
                                protected BigDecimal baseDR;
                                @XmlAttribute(name = "ImpuestoDR", required = true)
                                protected String impuestoDR;
                                @XmlAttribute(name = "TipoFactorDR", required = true)
                                protected CTipoFactor tipoFactorDR;
                                @XmlAttribute(name = "TasaOCuotaDR", required = true)
                                protected BigDecimal tasaOCuotaDR;
                                @XmlAttribute(name = "ImporteDR", required = true)
                                protected BigDecimal importeDR;

                                public BigDecimal getBaseDR() {
                                    return baseDR;
                                }

                                public void setBaseDR(BigDecimal value) {
                                    this.baseDR = value;
                                }

                                public String getImpuestoDR() {
                                    return impuestoDR;
                                }

                                public void setImpuestoDR(String value) {
                                    this.impuestoDR = value;
                                }

                                public CTipoFactor getTipoFactorDR() {
                                    return tipoFactorDR;
                                }

                                public void setTipoFactorDR(CTipoFactor value) {
                                    this.tipoFactorDR = value;
                                }

                                public BigDecimal getTasaOCuotaDR() {
                                    return tasaOCuotaDR;
                                }

                                public void setTasaOCuotaDR(BigDecimal value) {
                                    this.tasaOCuotaDR = value;
                                }

                                public BigDecimal getImporteDR() {
                                    return importeDR;
                                }

                                public void setImporteDR(BigDecimal value) {
                                    this.importeDR = value;
                                }

                                public RetencionDR() {
                                }
                            }
                        }

                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "trasladoDR"
                        })
                        public static class TrasladosDR {

                            @XmlElement(name = "TrasladoDR", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                            protected List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR> trasladoDR;

                            public List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR> getTrasladoDR() {
                                if (trasladoDR == null) {
                                    trasladoDR = new ArrayList<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR>();
                                }
                                return this.trasladoDR;
                            }

                            public TrasladosDR() {
                            }

                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "")
                            public static class TrasladoDR {

                                @XmlAttribute(name = "BaseDR", required = true)
                                protected BigDecimal baseDR;
                                @XmlAttribute(name = "ImpuestoDR", required = true)
                                protected String impuestoDR;
                                @XmlAttribute(name = "TipoFactorDR", required = true)
                                protected CTipoFactor tipoFactorDR;
                                @XmlAttribute(name = "TasaOCuotaDR")
                                protected BigDecimal tasaOCuotaDR;
                                @XmlAttribute(name = "ImporteDR")
                                protected BigDecimal importeDR;

                                public BigDecimal getBaseDR() {
                                    return baseDR;
                                }

                                public void setBaseDR(BigDecimal value) {
                                    this.baseDR = value;
                                }

                                public String getImpuestoDR() {
                                    return impuestoDR;
                                }

                                public void setImpuestoDR(String value) {
                                    this.impuestoDR = value;
                                }

                                public CTipoFactor getTipoFactorDR() {
                                    return tipoFactorDR;
                                }

                                public void setTipoFactorDR(CTipoFactor value) {
                                    this.tipoFactorDR = value;
                                }

                                public BigDecimal getTasaOCuotaDR() {
                                    return tasaOCuotaDR;
                                }

                                public void setTasaOCuotaDR(BigDecimal value) {
                                    this.tasaOCuotaDR = value;
                                }

                                public BigDecimal getImporteDR() {
                                    return importeDR;
                                }

                                public void setImporteDR(BigDecimal value) {
                                    this.importeDR = value;
                                }

                                public TrasladoDR() {
                                }
                            }
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "retencionesP",
                    "trasladosP"
                })
                public static class ImpuestosP {

                    @XmlElement(name = "RetencionesP", namespace= "http://www.sat.gob.mx/Pagos20")
                    protected Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP retencionesP;
                    @XmlElement(name = "TrasladosP", namespace= "http://www.sat.gob.mx/Pagos20")
                    protected Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP trasladosP;

                    public Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP getRetencionesP() {
                        return retencionesP;
                    }

                    public void setRetencionesP(Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP value) {
                        this.retencionesP = value;
                    }

                    public Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP getTrasladosP() {
                        return trasladosP;
                    }

                    public void setTrasladosP(Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP value) {
                        this.trasladosP = value;
                    }

                    public ImpuestosP() {
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "retencionP"
                    })
                    public static class RetencionesP {

                        @XmlElement(name = "RetencionP", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                        protected List<Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP.RetencionP> retencionP;

                        public List<Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP.RetencionP> getRetencionP() {
                            if (retencionP == null) {
                                retencionP = new ArrayList<Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP.RetencionP>();
                            }
                            return this.retencionP;
                        }

                        public RetencionesP() {
                        }

                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "")
                        public static class RetencionP {

                            @XmlAttribute(name = "ImpuestoP", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                            protected String impuestoP;
                            @XmlAttribute(name = "ImporteP", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                            protected BigDecimal importeP;

                            public String getImpuestoP() {
                                return impuestoP;
                            }

                            public void setImpuestoP(String value) {
                                this.impuestoP = value;
                            }

                            public BigDecimal getImporteP() {
                                return importeP;
                            }

                            public void setImporteP(BigDecimal value) {
                                this.importeP = value;
                            }

                            public RetencionP() {
                            }
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "trasladoP"
                    })
                    public static class TrasladosP {

                        @XmlElement(name = "TrasladoP", required = true, namespace= "http://www.sat.gob.mx/Pagos20")
                        protected List<Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP> trasladoP;

                        public List<Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP> getTrasladoP() {
                            if (trasladoP == null) {
                                trasladoP = new ArrayList<Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP>();
                            }
                            return this.trasladoP;
                        }

                        public TrasladosP() {
                        }

                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "")
                        public static class TrasladoP {

                            @XmlAttribute(name = "BaseP", required = true)
                            protected BigDecimal baseP;
                            @XmlAttribute(name = "ImpuestoP", required = true)
                            protected String impuestoP;
                            @XmlAttribute(name = "TipoFactorP", required = true)
                            protected CTipoFactor tipoFactorP;
                            @XmlAttribute(name = "TasaOCuotaP")
                            protected BigDecimal tasaOCuotaP;
                            @XmlAttribute(name = "ImporteP")
                            protected BigDecimal importeP;

                            public BigDecimal getBaseP() {
                                return baseP;
                            }

                            public void setBaseP(BigDecimal value) {
                                this.baseP = value;
                            }

                            public String getImpuestoP() {
                                return impuestoP;
                            }

                            public void setImpuestoP(String value) {
                                this.impuestoP = value;
                            }

                            public CTipoFactor getTipoFactorP() {
                                return tipoFactorP;
                            }

                            public void setTipoFactorP(CTipoFactor value) {
                                this.tipoFactorP = value;
                            }

                            public BigDecimal getTasaOCuotaP() {
                                return tasaOCuotaP;
                            }

                            public void setTasaOCuotaP(BigDecimal value) {
                                this.tasaOCuotaP = value;
                            }

                            public BigDecimal getImporteP() {
                                return importeP;
                            }

                            public void setImporteP(BigDecimal value) {
                                this.importeP = value;
                            }

                            public TrasladoP() {
                            }
                        }
                    }
                }
            }

        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Concepto" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Impuestos" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Traslados" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Traslado" maxOccurs="unbounded">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;attribute name="Base" use="required">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;fractionDigits value="6"/>
     *                                                     &lt;minInclusive value="0.000001"/>
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                                               &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                                               &lt;attribute name="TasaOCuota">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;fractionDigits value="6"/>
     *                                                     &lt;minInclusive value="0.000000"/>
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Retenciones" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Retencion" maxOccurs="unbounded">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;attribute name="Base" use="required">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;fractionDigits value="6"/>
     *                                                     &lt;minInclusive value="0.000001"/>
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                                               &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                                               &lt;attribute name="TasaOCuota" use="required">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                     &lt;minInclusive value="0.000000"/>
     *                                                     &lt;fractionDigits value="6"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ACuentaTerceros" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="RfcACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
     *                           &lt;attribute name="NombreACuentaTerceros" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="300"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,300}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="RegimenFiscalACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
     *                           &lt;attribute name="DomicilioFiscalACuentaTerceros" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;length value="5"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[0-9]{5}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="NumeroPedimento" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;length value="21"/>
     *                                 &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CuentaPredial" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Numero" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="150"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[0-9a-zA-Z]{1,150}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ComplementoConcepto" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;any maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Parte" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="NumeroPedimento" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;length value="21"/>
     *                                           &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
     *                           &lt;attribute name="NoIdentificacion">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="100"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,100}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Cantidad" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                 &lt;fractionDigits value="6"/>
     *                                 &lt;minInclusive value="0.000001"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Unidad">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="20"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,20}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Descripcion" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="1000"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,1000}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                           &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
     *                 &lt;attribute name="NoIdentificacion">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="100"/>
     *                       &lt;pattern value="[^|]{1,100}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Cantidad" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                       &lt;fractionDigits value="6"/>
     *                       &lt;minInclusive value="0.000001"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ClaveUnidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveUnidad" />
     *                 &lt;attribute name="Unidad">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="20"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,20}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Descripcion" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="1000"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,1000}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ValorUnitario" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="ObjetoImp" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ObjetoImp" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "concepto"
    })
    public static class Conceptos {

        @XmlElement(name = "Concepto", required = true)
        protected List<Comprobante.Conceptos.Concepto> concepto;

        /**
         * Gets the value of the concepto property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the concepto property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConcepto().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Comprobante.Conceptos.Concepto }
         *
         *
         */
        public List<Comprobante.Conceptos.Concepto> getConcepto() {
            if (concepto == null) {
                concepto = new ArrayList<Comprobante.Conceptos.Concepto>();
            }
            return this.concepto;
        }

        /**
         * <p>
         * Clase Java para anonymous complex type.
         *
         * <p>
         * El siguiente fragmento de esquema especifica el contenido que se
         * espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Impuestos" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Traslados" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Traslado" maxOccurs="unbounded">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;attribute name="Base" use="required">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;fractionDigits value="6"/>
         *                                           &lt;minInclusive value="0.000001"/>
         *                                           &lt;whiteSpace value="collapse"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                                     &lt;attribute name="TasaOCuota">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;fractionDigits value="6"/>
         *                                           &lt;minInclusive value="0.000000"/>
         *                                           &lt;whiteSpace value="collapse"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Retenciones" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Retencion" maxOccurs="unbounded">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;attribute name="Base" use="required">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;fractionDigits value="6"/>
         *                                           &lt;minInclusive value="0.000001"/>
         *                                           &lt;whiteSpace value="collapse"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                                     &lt;attribute name="TasaOCuota" use="required">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;whiteSpace value="collapse"/>
         *                                           &lt;minInclusive value="0.000000"/>
         *                                           &lt;fractionDigits value="6"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ACuentaTerceros" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="RfcACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
         *                 &lt;attribute name="NombreACuentaTerceros" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="300"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,300}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="RegimenFiscalACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
         *                 &lt;attribute name="DomicilioFiscalACuentaTerceros" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;length value="5"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[0-9]{5}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="NumeroPedimento" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;length value="21"/>
         *                       &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CuentaPredial" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Numero" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="150"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[0-9a-zA-Z]{1,150}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ComplementoConcepto" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;any maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Parte" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="NumeroPedimento" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;length value="21"/>
         *                                 &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
         *                 &lt;attribute name="NoIdentificacion">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="100"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,100}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Cantidad" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                       &lt;fractionDigits value="6"/>
         *                       &lt;minInclusive value="0.000001"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Unidad">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="20"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,20}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Descripcion" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="1000"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,1000}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                 &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
         *       &lt;attribute name="NoIdentificacion">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="100"/>
         *             &lt;pattern value="[^|]{1,100}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Cantidad" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *             &lt;fractionDigits value="6"/>
         *             &lt;minInclusive value="0.000001"/>
         *             &lt;whiteSpace value="collapse"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ClaveUnidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveUnidad" />
         *       &lt;attribute name="Unidad">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="20"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,20}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Descripcion" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="1000"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,1000}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ValorUnitario" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="ObjetoImp" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ObjetoImp" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "impuestos",
            "aCuentaTerceros",
            "informacionAduanera",
            "cuentaPredial",
            "complementoConcepto",
            "parte"
        })
        public static class Concepto {

            @XmlElement(name = "Impuestos")
            protected Comprobante.Conceptos.Concepto.Impuestos impuestos;
            @XmlElement(name = "ACuentaTerceros")
            protected Comprobante.Conceptos.Concepto.ACuentaTerceros aCuentaTerceros;
            @XmlElement(name = "InformacionAduanera")
            protected List<Comprobante.Conceptos.Concepto.InformacionAduanera> informacionAduanera;
            @XmlElement(name = "CuentaPredial")
            protected List<Comprobante.Conceptos.Concepto.CuentaPredial> cuentaPredial;
            @XmlElement(name = "ComplementoConcepto")
            protected Comprobante.Conceptos.Concepto.ComplementoConcepto complementoConcepto;
            @XmlElement(name = "Parte")
            protected List<Comprobante.Conceptos.Concepto.Parte> parte;
            @XmlAttribute(name = "ClaveProdServ", required = true)
            protected String claveProdServ;
            @XmlAttribute(name = "NoIdentificacion")
            protected String noIdentificacion;
            @XmlAttribute(name = "Cantidad", required = true)
            protected BigDecimal cantidad;
            @XmlAttribute(name = "ClaveUnidad", required = true)
            protected String claveUnidad;
            @XmlAttribute(name = "Unidad")
            protected String unidad;
            @XmlAttribute(name = "Descripcion", required = true)
            protected String descripcion;
            @XmlAttribute(name = "ValorUnitario", required = true)
            protected BigDecimal valorUnitario;
            @XmlAttribute(name = "Importe", required = true)
            protected BigDecimal importe;
            @XmlAttribute(name = "Descuento")
            protected BigDecimal descuento;
            @XmlAttribute(name = "ObjetoImp", required = true)
            protected String objetoImp;

            /**
             * Obtiene el valor de la propiedad impuestos.
             *
             * @return possible object is
             *     {@link Comprobante.Conceptos.Concepto.Impuestos }
             *
             */
            public Comprobante.Conceptos.Concepto.Impuestos getImpuestos() {
                return impuestos;
            }

            /**
             * Define el valor de la propiedad impuestos.
             *
             * @param value allowed object is
             *     {@link Comprobante.Conceptos.Concepto.Impuestos }
             *
             */
            public void setImpuestos(Comprobante.Conceptos.Concepto.Impuestos value) {
                this.impuestos = value;
            }

            /**
             * Obtiene el valor de la propiedad aCuentaTerceros.
             *
             * @return possible object is
             *     {@link Comprobante.Conceptos.Concepto.ACuentaTerceros }
             *
             */
            public Comprobante.Conceptos.Concepto.ACuentaTerceros getACuentaTerceros() {
                return aCuentaTerceros;
            }

            /**
             * Define el valor de la propiedad aCuentaTerceros.
             *
             * @param value allowed object is
             *     {@link Comprobante.Conceptos.Concepto.ACuentaTerceros }
             *
             */
            public void setACuentaTerceros(Comprobante.Conceptos.Concepto.ACuentaTerceros value) {
                this.aCuentaTerceros = value;
            }

            /**
             * Gets the value of the informacionAduanera property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the informacionAduanera
             * property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInformacionAduanera().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Conceptos.Concepto.InformacionAduanera }
             *
             *
             */
            public List<Comprobante.Conceptos.Concepto.InformacionAduanera> getInformacionAduanera() {
                if (informacionAduanera == null) {
                    informacionAduanera = new ArrayList<Comprobante.Conceptos.Concepto.InformacionAduanera>();
                }
                return this.informacionAduanera;
            }

            /**
             * Gets the value of the cuentaPredial property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the cuentaPredial property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCuentaPredial().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Conceptos.Concepto.CuentaPredial }
             *
             *
             */
            public List<Comprobante.Conceptos.Concepto.CuentaPredial> getCuentaPredial() {
                if (cuentaPredial == null) {
                    cuentaPredial = new ArrayList<Comprobante.Conceptos.Concepto.CuentaPredial>();
                }
                return this.cuentaPredial;
            }

            /**
             * Obtiene el valor de la propiedad complementoConcepto.
             *
             * @return possible object is
             *     {@link Comprobante.Conceptos.Concepto.ComplementoConcepto }
             *
             */
            public Comprobante.Conceptos.Concepto.ComplementoConcepto getComplementoConcepto() {
                return complementoConcepto;
            }

            /**
             * Define el valor de la propiedad complementoConcepto.
             *
             * @param value allowed object is
             *     {@link Comprobante.Conceptos.Concepto.ComplementoConcepto }
             *
             */
            public void setComplementoConcepto(Comprobante.Conceptos.Concepto.ComplementoConcepto value) {
                this.complementoConcepto = value;
            }

            /**
             * Gets the value of the parte property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the parte property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getParte().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Conceptos.Concepto.Parte }
             *
             *
             */
            public List<Comprobante.Conceptos.Concepto.Parte> getParte() {
                if (parte == null) {
                    parte = new ArrayList<Comprobante.Conceptos.Concepto.Parte>();
                }
                return this.parte;
            }

            /**
             * Obtiene el valor de la propiedad claveProdServ.
             *
             * @return possible object is {@link String }
             *
             */
            public String getClaveProdServ() {
                return claveProdServ;
            }

            /**
             * Define el valor de la propiedad claveProdServ.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setClaveProdServ(String value) {
                this.claveProdServ = value;
            }

            /**
             * Obtiene el valor de la propiedad noIdentificacion.
             *
             * @return possible object is {@link String }
             *
             */
            public String getNoIdentificacion() {
                return noIdentificacion;
            }

            /**
             * Define el valor de la propiedad noIdentificacion.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setNoIdentificacion(String value) {
                this.noIdentificacion = value;
            }

            /**
             * Obtiene el valor de la propiedad cantidad.
             *
             * @return possible object is {@link BigDecimal }
             *
             */
            public BigDecimal getCantidad() {
                return cantidad;
            }

            /**
             * Define el valor de la propiedad cantidad.
             *
             * @param value allowed object is {@link BigDecimal }
             *
             */
            public void setCantidad(BigDecimal value) {
                this.cantidad = value;
            }

            /**
             * Obtiene el valor de la propiedad claveUnidad.
             *
             * @return possible object is {@link String }
             *
             */
            public String getClaveUnidad() {
                return claveUnidad;
            }

            /**
             * Define el valor de la propiedad claveUnidad.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setClaveUnidad(String value) {
                this.claveUnidad = value;
            }

            /**
             * Obtiene el valor de la propiedad unidad.
             *
             * @return possible object is {@link String }
             *
             */
            public String getUnidad() {
                return unidad;
            }

            /**
             * Define el valor de la propiedad unidad.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setUnidad(String value) {
                this.unidad = value;
            }

            /**
             * Obtiene el valor de la propiedad descripcion.
             *
             * @return possible object is {@link String }
             *
             */
            public String getDescripcion() {
                return descripcion;
            }

            /**
             * Define el valor de la propiedad descripcion.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setDescripcion(String value) {
                this.descripcion = value;
            }

            /**
             * Obtiene el valor de la propiedad valorUnitario.
             *
             * @return possible object is {@link BigDecimal }
             *
             */
            public BigDecimal getValorUnitario() {
                return valorUnitario;
            }

            /**
             * Define el valor de la propiedad valorUnitario.
             *
             * @param value allowed object is {@link BigDecimal }
             *
             */
            public void setValorUnitario(BigDecimal value) {
                this.valorUnitario = value;
            }

            /**
             * Obtiene el valor de la propiedad importe.
             *
             * @return possible object is {@link BigDecimal }
             *
             */
            public BigDecimal getImporte() {
                return importe;
            }

            /**
             * Define el valor de la propiedad importe.
             *
             * @param value allowed object is {@link BigDecimal }
             *
             */
            public void setImporte(BigDecimal value) {
                this.importe = value;
            }

            /**
             * Obtiene el valor de la propiedad descuento.
             *
             * @return possible object is {@link BigDecimal }
             *
             */
            public BigDecimal getDescuento() {
                return descuento;
            }

            /**
             * Define el valor de la propiedad descuento.
             *
             * @param value allowed object is {@link BigDecimal }
             *
             */
            public void setDescuento(BigDecimal value) {
                this.descuento = value;
            }

            /**
             * Obtiene el valor de la propiedad objetoImp.
             *
             * @return possible object is {@link String }
             *
             */
            public String getObjetoImp() {
                return objetoImp;
            }

            /**
             * Define el valor de la propiedad objetoImp.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setObjetoImp(String value) {
                this.objetoImp = value;
            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="RfcACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
             *       &lt;attribute name="NombreACuentaTerceros" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="300"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,300}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="RegimenFiscalACuentaTerceros" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
             *       &lt;attribute name="DomicilioFiscalACuentaTerceros" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;length value="5"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[0-9]{5}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ACuentaTerceros {

                @XmlAttribute(name = "RfcACuentaTerceros", required = true)
                protected String rfcACuentaTerceros;
                @XmlAttribute(name = "NombreACuentaTerceros", required = true)
                protected String nombreACuentaTerceros;
                @XmlAttribute(name = "RegimenFiscalACuentaTerceros", required = true)
                protected String regimenFiscalACuentaTerceros;
                @XmlAttribute(name = "DomicilioFiscalACuentaTerceros", required = true)
                protected String domicilioFiscalACuentaTerceros;

                /**
                 * Obtiene el valor de la propiedad rfcACuentaTerceros.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getRfcACuentaTerceros() {
                    return rfcACuentaTerceros;
                }

                /**
                 * Define el valor de la propiedad rfcACuentaTerceros.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setRfcACuentaTerceros(String value) {
                    this.rfcACuentaTerceros = value;
                }

                /**
                 * Obtiene el valor de la propiedad nombreACuentaTerceros.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getNombreACuentaTerceros() {
                    return nombreACuentaTerceros;
                }

                /**
                 * Define el valor de la propiedad nombreACuentaTerceros.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setNombreACuentaTerceros(String value) {
                    this.nombreACuentaTerceros = value;
                }

                /**
                 * Obtiene el valor de la propiedad
                 * regimenFiscalACuentaTerceros.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getRegimenFiscalACuentaTerceros() {
                    return regimenFiscalACuentaTerceros;
                }

                /**
                 * Define el valor de la propiedad regimenFiscalACuentaTerceros.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setRegimenFiscalACuentaTerceros(String value) {
                    this.regimenFiscalACuentaTerceros = value;
                }

                /**
                 * Obtiene el valor de la propiedad
                 * domicilioFiscalACuentaTerceros.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getDomicilioFiscalACuentaTerceros() {
                    return domicilioFiscalACuentaTerceros;
                }

                /**
                 * Define el valor de la propiedad
                 * domicilioFiscalACuentaTerceros.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setDomicilioFiscalACuentaTerceros(String value) {
                    this.domicilioFiscalACuentaTerceros = value;
                }

            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;any maxOccurs="unbounded"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "any"
            })
            public static class ComplementoConcepto {

                @XmlAnyElement(lax = true)
                protected List<Object> any;

                /**
                 * Gets the value of the any property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object. This is
                 * why there is not a <CODE>set</CODE> method for the any
                 * property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAny().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Object }
                 *
                 *
                 */
                public List<Object> getAny() {
                    if (any == null) {
                        any = new ArrayList<Object>();
                    }
                    return this.any;
                }

            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Numero" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="150"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[0-9a-zA-Z]{1,150}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class CuentaPredial {

                @XmlAttribute(name = "Numero", required = true)
                protected String numero;

                /**
                 * Obtiene el valor de la propiedad numero.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getNumero() {
                    return numero;
                }

                /**
                 * Define el valor de la propiedad numero.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setNumero(String value) {
                    this.numero = value;
                }

            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Traslados" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Traslado" maxOccurs="unbounded">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;attribute name="Base" use="required">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;fractionDigits value="6"/>
             *                                 &lt;minInclusive value="0.000001"/>
             *                                 &lt;whiteSpace value="collapse"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *                           &lt;attribute name="TasaOCuota">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;fractionDigits value="6"/>
             *                                 &lt;minInclusive value="0.000000"/>
             *                                 &lt;whiteSpace value="collapse"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Retenciones" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Retencion" maxOccurs="unbounded">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;attribute name="Base" use="required">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;fractionDigits value="6"/>
             *                                 &lt;minInclusive value="0.000001"/>
             *                                 &lt;whiteSpace value="collapse"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *                           &lt;attribute name="TasaOCuota" use="required">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;whiteSpace value="collapse"/>
             *                                 &lt;minInclusive value="0.000000"/>
             *                                 &lt;fractionDigits value="6"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "traslados",
                "retenciones"
            })
            public static class Impuestos {

                @XmlElement(name = "Traslados")
                protected Comprobante.Conceptos.Concepto.Impuestos.Traslados traslados;
                @XmlElement(name = "Retenciones")
                protected Comprobante.Conceptos.Concepto.Impuestos.Retenciones retenciones;

                /**
                 * Obtiene el valor de la propiedad traslados.
                 *
                 * @return possible object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados }
                 *
                 */
                public Comprobante.Conceptos.Concepto.Impuestos.Traslados getTraslados() {
                    return traslados;
                }

                /**
                 * Define el valor de la propiedad traslados.
                 *
                 * @param value allowed object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados }
                 *
                 */
                public void setTraslados(Comprobante.Conceptos.Concepto.Impuestos.Traslados value) {
                    this.traslados = value;
                }

                /**
                 * Obtiene el valor de la propiedad retenciones.
                 *
                 * @return possible object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones }
                 *
                 */
                public Comprobante.Conceptos.Concepto.Impuestos.Retenciones getRetenciones() {
                    return retenciones;
                }

                /**
                 * Define el valor de la propiedad retenciones.
                 *
                 * @param value allowed object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones }
                 *
                 */
                public void setRetenciones(Comprobante.Conceptos.Concepto.Impuestos.Retenciones value) {
                    this.retenciones = value;
                }

                /**
                 * <p>
                 * Clase Java para anonymous complex type.
                 *
                 * <p>
                 * El siguiente fragmento de esquema especifica el contenido que
                 * se espera que haya en esta clase.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Retencion" maxOccurs="unbounded">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;attribute name="Base" use="required">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;fractionDigits value="6"/>
                 *                       &lt;minInclusive value="0.000001"/>
                 *                       &lt;whiteSpace value="collapse"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                 *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                 *                 &lt;attribute name="TasaOCuota" use="required">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;whiteSpace value="collapse"/>
                 *                       &lt;minInclusive value="0.000000"/>
                 *                       &lt;fractionDigits value="6"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "retencion"
                })
                public static class Retenciones {

                    @XmlElement(name = "Retencion", required = true)
                    protected List<Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion> retencion;

                    /**
                     * Gets the value of the retencion property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live
                     * list, not a snapshot. Therefore any modification you make
                     * to the returned list will be present inside the JAXB
                     * object. This is why there is not a <CODE>set</CODE>
                     * method for the retencion property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getRetencion().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion }
                     *
                     *
                     */
                    public List<Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion> getRetencion() {
                        if (retencion == null) {
                            retencion = new ArrayList<Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion>();
                        }
                        return this.retencion;
                    }

                    /**
                     * <p>
                     * Clase Java para anonymous complex type.
                     *
                     * <p>
                     * El siguiente fragmento de esquema especifica el contenido
                     * que se espera que haya en esta clase.
                     *
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;attribute name="Base" use="required">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;fractionDigits value="6"/>
                     *             &lt;minInclusive value="0.000001"/>
                     *             &lt;whiteSpace value="collapse"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                     *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                     *       &lt;attribute name="TasaOCuota" use="required">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;whiteSpace value="collapse"/>
                     *             &lt;minInclusive value="0.000000"/>
                     *             &lt;fractionDigits value="6"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class Retencion {

                        @XmlAttribute(name = "Base", required = true)
                        protected BigDecimal base;
                        @XmlAttribute(name = "Impuesto", required = true)
                        protected String impuesto;
                        @XmlAttribute(name = "TipoFactor", required = true)
                        protected CTipoFactor tipoFactor;
                        @XmlAttribute(name = "TasaOCuota", required = true)
                        protected BigDecimal tasaOCuota;
                        @XmlAttribute(name = "Importe", required = true)
                        protected BigDecimal importe;

                        /**
                         * Obtiene el valor de la propiedad base.
                         *
                         * @return possible object is {@link BigDecimal }
                         *
                         */
                        public BigDecimal getBase() {
                            return base;
                        }

                        /**
                         * Define el valor de la propiedad base.
                         *
                         * @param value allowed object is {@link BigDecimal }
                         *
                         */
                        public void setBase(BigDecimal value) {
                            this.base = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad impuesto.
                         *
                         * @return possible object is {@link String }
                         *
                         */
                        public String getImpuesto() {
                            return impuesto;
                        }

                        /**
                         * Define el valor de la propiedad impuesto.
                         *
                         * @param value allowed object is {@link String }
                         *
                         */
                        public void setImpuesto(String value) {
                            this.impuesto = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tipoFactor.
                         *
                         * @return possible object is {@link CTipoFactor }
                         *
                         */
                        public CTipoFactor getTipoFactor() {
                            return tipoFactor;
                        }

                        /**
                         * Define el valor de la propiedad tipoFactor.
                         *
                         * @param value allowed object is {@link CTipoFactor }
                         *
                         */
                        public void setTipoFactor(CTipoFactor value) {
                            this.tipoFactor = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tasaOCuota.
                         *
                         * @return possible object is {@link BigDecimal }
                         *
                         */
                        public BigDecimal getTasaOCuota() {
                            return tasaOCuota;
                        }

                        /**
                         * Define el valor de la propiedad tasaOCuota.
                         *
                         * @param value allowed object is {@link BigDecimal }
                         *
                         */
                        public void setTasaOCuota(BigDecimal value) {
                            this.tasaOCuota = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad importe.
                         *
                         * @return possible object is {@link BigDecimal }
                         *
                         */
                        public BigDecimal getImporte() {
                            return importe;
                        }

                        /**
                         * Define el valor de la propiedad importe.
                         *
                         * @param value allowed object is {@link BigDecimal }
                         *
                         */
                        public void setImporte(BigDecimal value) {
                            this.importe = value;
                        }

                    }

                }

                /**
                 * <p>
                 * Clase Java para anonymous complex type.
                 *
                 * <p>
                 * El siguiente fragmento de esquema especifica el contenido que
                 * se espera que haya en esta clase.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Traslado" maxOccurs="unbounded">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;attribute name="Base" use="required">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;fractionDigits value="6"/>
                 *                       &lt;minInclusive value="0.000001"/>
                 *                       &lt;whiteSpace value="collapse"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                 *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                 *                 &lt;attribute name="TasaOCuota">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;fractionDigits value="6"/>
                 *                       &lt;minInclusive value="0.000000"/>
                 *                       &lt;whiteSpace value="collapse"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "traslado"
                })
                public static class Traslados {

                    @XmlElement(name = "Traslado", required = true)
                    protected List<Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado> traslado;

                    /**
                     * Gets the value of the traslado property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live
                     * list, not a snapshot. Therefore any modification you make
                     * to the returned list will be present inside the JAXB
                     * object. This is why there is not a <CODE>set</CODE>
                     * method for the traslado property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getTraslado().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado }
                     *
                     *
                     */
                    public List<Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado> getTraslado() {
                        if (traslado == null) {
                            traslado = new ArrayList<Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado>();
                        }
                        return this.traslado;
                    }

                    /**
                     * <p>
                     * Clase Java para anonymous complex type.
                     *
                     * <p>
                     * El siguiente fragmento de esquema especifica el contenido
                     * que se espera que haya en esta clase.
                     *
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;attribute name="Base" use="required">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;fractionDigits value="6"/>
                     *             &lt;minInclusive value="0.000001"/>
                     *             &lt;whiteSpace value="collapse"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                     *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                     *       &lt;attribute name="TasaOCuota">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;fractionDigits value="6"/>
                     *             &lt;minInclusive value="0.000000"/>
                     *             &lt;whiteSpace value="collapse"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class Traslado {

                        @XmlAttribute(name = "Base", required = true)
                        protected BigDecimal base;
                        @XmlAttribute(name = "Impuesto", required = true)
                        protected String impuesto;
                        @XmlAttribute(name = "TipoFactor", required = true)
                        protected CTipoFactor tipoFactor;
                        @XmlAttribute(name = "TasaOCuota")
                        protected BigDecimal tasaOCuota;
                        @XmlAttribute(name = "Importe")
                        protected BigDecimal importe;

                        /**
                         * Obtiene el valor de la propiedad base.
                         *
                         * @return possible object is {@link BigDecimal }
                         *
                         */
                        public BigDecimal getBase() {
                            return base;
                        }

                        /**
                         * Define el valor de la propiedad base.
                         *
                         * @param value allowed object is {@link BigDecimal }
                         *
                         */
                        public void setBase(BigDecimal value) {
                            this.base = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad impuesto.
                         *
                         * @return possible object is {@link String }
                         *
                         */
                        public String getImpuesto() {
                            return impuesto;
                        }

                        /**
                         * Define el valor de la propiedad impuesto.
                         *
                         * @param value allowed object is {@link String }
                         *
                         */
                        public void setImpuesto(String value) {
                            this.impuesto = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tipoFactor.
                         *
                         * @return possible object is {@link CTipoFactor }
                         *
                         */
                        public CTipoFactor getTipoFactor() {
                            return tipoFactor;
                        }

                        /**
                         * Define el valor de la propiedad tipoFactor.
                         *
                         * @param value allowed object is {@link CTipoFactor }
                         *
                         */
                        public void setTipoFactor(CTipoFactor value) {
                            this.tipoFactor = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tasaOCuota.
                         *
                         * @return possible object is {@link BigDecimal }
                         *
                         */
                        public BigDecimal getTasaOCuota() {
                            return tasaOCuota;
                        }

                        /**
                         * Define el valor de la propiedad tasaOCuota.
                         *
                         * @param value allowed object is {@link BigDecimal }
                         *
                         */
                        public void setTasaOCuota(BigDecimal value) {
                            this.tasaOCuota = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad importe.
                         *
                         * @return possible object is {@link BigDecimal }
                         *
                         */
                        public BigDecimal getImporte() {
                            return importe;
                        }

                        /**
                         * Define el valor de la propiedad importe.
                         *
                         * @param value allowed object is {@link BigDecimal }
                         *
                         */
                        public void setImporte(BigDecimal value) {
                            this.importe = value;
                        }

                    }

                }

            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="NumeroPedimento" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;length value="21"/>
             *             &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class InformacionAduanera {

                @XmlAttribute(name = "NumeroPedimento", required = true)
                protected String numeroPedimento;

                /**
                 * Obtiene el valor de la propiedad numeroPedimento.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getNumeroPedimento() {
                    return numeroPedimento;
                }

                /**
                 * Define el valor de la propiedad numeroPedimento.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setNumeroPedimento(String value) {
                    this.numeroPedimento = value;
                }

            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="NumeroPedimento" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;length value="21"/>
             *                       &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
             *       &lt;attribute name="NoIdentificacion">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="100"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,100}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Cantidad" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *             &lt;fractionDigits value="6"/>
             *             &lt;minInclusive value="0.000001"/>
             *             &lt;whiteSpace value="collapse"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Unidad">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="20"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,20}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Descripcion" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="1000"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,1000}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *       &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "informacionAduanera"
            })
            public static class Parte {

                @XmlElement(name = "InformacionAduanera")
                protected List<Comprobante.Conceptos.Concepto.Parte.InformacionAduanera> informacionAduanera;
                @XmlAttribute(name = "ClaveProdServ", required = true)
                protected String claveProdServ;
                @XmlAttribute(name = "NoIdentificacion")
                protected String noIdentificacion;
                @XmlAttribute(name = "Cantidad", required = true)
                protected BigDecimal cantidad;
                @XmlAttribute(name = "Unidad")
                protected String unidad;
                @XmlAttribute(name = "Descripcion", required = true)
                protected String descripcion;
                @XmlAttribute(name = "ValorUnitario")
                protected BigDecimal valorUnitario;
                @XmlAttribute(name = "Importe")
                protected BigDecimal importe;

                /**
                 * Gets the value of the informacionAduanera property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object. This is
                 * why there is not a <CODE>set</CODE> method for the
                 * informacionAduanera property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInformacionAduanera().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Comprobante.Conceptos.Concepto.Parte.InformacionAduanera }
                 *
                 *
                 */
                public List<Comprobante.Conceptos.Concepto.Parte.InformacionAduanera> getInformacionAduanera() {
                    if (informacionAduanera == null) {
                        informacionAduanera = new ArrayList<Comprobante.Conceptos.Concepto.Parte.InformacionAduanera>();
                    }
                    return this.informacionAduanera;
                }

                /**
                 * Obtiene el valor de la propiedad claveProdServ.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getClaveProdServ() {
                    return claveProdServ;
                }

                /**
                 * Define el valor de la propiedad claveProdServ.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setClaveProdServ(String value) {
                    this.claveProdServ = value;
                }

                /**
                 * Obtiene el valor de la propiedad noIdentificacion.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getNoIdentificacion() {
                    return noIdentificacion;
                }

                /**
                 * Define el valor de la propiedad noIdentificacion.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setNoIdentificacion(String value) {
                    this.noIdentificacion = value;
                }

                /**
                 * Obtiene el valor de la propiedad cantidad.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getCantidad() {
                    return cantidad;
                }

                /**
                 * Define el valor de la propiedad cantidad.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setCantidad(BigDecimal value) {
                    this.cantidad = value;
                }

                /**
                 * Obtiene el valor de la propiedad unidad.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getUnidad() {
                    return unidad;
                }

                /**
                 * Define el valor de la propiedad unidad.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setUnidad(String value) {
                    this.unidad = value;
                }

                /**
                 * Obtiene el valor de la propiedad descripcion.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getDescripcion() {
                    return descripcion;
                }

                /**
                 * Define el valor de la propiedad descripcion.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setDescripcion(String value) {
                    this.descripcion = value;
                }

                /**
                 * Obtiene el valor de la propiedad valorUnitario.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getValorUnitario() {
                    return valorUnitario;
                }

                /**
                 * Define el valor de la propiedad valorUnitario.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setValorUnitario(BigDecimal value) {
                    this.valorUnitario = value;
                }

                /**
                 * Obtiene el valor de la propiedad importe.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Define el valor de la propiedad importe.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }

                /**
                 * <p>
                 * Clase Java para anonymous complex type.
                 *
                 * <p>
                 * El siguiente fragmento de esquema especifica el contenido que
                 * se espera que haya en esta clase.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="NumeroPedimento" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;length value="21"/>
                 *             &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class InformacionAduanera {

                    @XmlAttribute(name = "NumeroPedimento", required = true)
                    protected String numeroPedimento;

                    /**
                     * Obtiene el valor de la propiedad numeroPedimento.
                     *
                     * @return possible object is {@link String }
                     *
                     */
                    public String getNumeroPedimento() {
                        return numeroPedimento;
                    }

                    /**
                     * Define el valor de la propiedad numeroPedimento.
                     *
                     * @param value allowed object is {@link String }
                     *
                     */
                    public void setNumeroPedimento(String value) {
                        this.numeroPedimento = value;
                    }

                }

            }

        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
     *       &lt;attribute name="Nombre" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="300"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[^|]{1,300}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="RegimenFiscal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
     *       &lt;attribute name="FacAtrAdquirente">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;length value="10"/>
     *             &lt;pattern value="[0-9]{10}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Emisor {

        @XmlAttribute(name = "Rfc", required = true)
        protected String rfc;
        @XmlAttribute(name = "Nombre", required = true)
        protected String nombre;
        @XmlAttribute(name = "RegimenFiscal", required = true)
        protected String regimenFiscal;
        @XmlAttribute(name = "FacAtrAdquirente")
        protected String facAtrAdquirente;

        /**
         * Obtiene el valor de la propiedad rfc.
         *
         * @return possible object is {@link String }
         *
         */
        public String getRfc() {
            return rfc;
        }

        /**
         * Define el valor de la propiedad rfc.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setRfc(String value) {
            this.rfc = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         *
         * @return possible object is {@link String }
         *
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad regimenFiscal.
         *
         * @return possible object is {@link String }
         *
         */
        public String getRegimenFiscal() {
            return regimenFiscal;
        }

        /**
         * Define el valor de la propiedad regimenFiscal.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setRegimenFiscal(String value) {
            this.regimenFiscal = value;
        }

        /**
         * Obtiene el valor de la propiedad facAtrAdquirente.
         *
         * @return possible object is {@link String }
         *
         */
        public String getFacAtrAdquirente() {
            return facAtrAdquirente;
        }

        /**
         * Define el valor de la propiedad facAtrAdquirente.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setFacAtrAdquirente(String value) {
            this.facAtrAdquirente = value;
        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Retenciones" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Retencion" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Traslados" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Traslado" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Base" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                           &lt;attribute name="TasaOCuota">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;minInclusive value="0.000000"/>
     *                                 &lt;fractionDigits value="6"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *       &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "retenciones",
        "traslados"
    })
    public static class Impuestos {

        @XmlElement(name = "Retenciones")
        protected Comprobante.Impuestos.Retenciones retenciones;
        @XmlElement(name = "Traslados")
        protected Comprobante.Impuestos.Traslados traslados;
        @XmlAttribute(name = "TotalImpuestosRetenidos")
        protected BigDecimal totalImpuestosRetenidos;
        @XmlAttribute(name = "TotalImpuestosTrasladados")
        protected BigDecimal totalImpuestosTrasladados;

        /**
         * Obtiene el valor de la propiedad retenciones.
         *
         * @return possible object is {@link Comprobante.Impuestos.Retenciones }
         *
         */
        public Comprobante.Impuestos.Retenciones getRetenciones() {
            return retenciones;
        }

        /**
         * Define el valor de la propiedad retenciones.
         *
         * @param value allowed object is
         *     {@link Comprobante.Impuestos.Retenciones }
         *
         */
        public void setRetenciones(Comprobante.Impuestos.Retenciones value) {
            this.retenciones = value;
        }

        /**
         * Obtiene el valor de la propiedad traslados.
         *
         * @return possible object is {@link Comprobante.Impuestos.Traslados }
         *
         */
        public Comprobante.Impuestos.Traslados getTraslados() {
            return traslados;
        }

        /**
         * Define el valor de la propiedad traslados.
         *
         * @param value allowed object is
         *     {@link Comprobante.Impuestos.Traslados }
         *
         */
        public void setTraslados(Comprobante.Impuestos.Traslados value) {
            this.traslados = value;
        }

        /**
         * Obtiene el valor de la propiedad totalImpuestosRetenidos.
         *
         * @return possible object is {@link BigDecimal }
         *
         */
        public BigDecimal getTotalImpuestosRetenidos() {
            return totalImpuestosRetenidos;
        }

        /**
         * Define el valor de la propiedad totalImpuestosRetenidos.
         *
         * @param value allowed object is {@link BigDecimal }
         *
         */
        public void setTotalImpuestosRetenidos(BigDecimal value) {
            this.totalImpuestosRetenidos = value;
        }

        /**
         * Obtiene el valor de la propiedad totalImpuestosTrasladados.
         *
         * @return possible object is {@link BigDecimal }
         *
         */
        public BigDecimal getTotalImpuestosTrasladados() {
            return totalImpuestosTrasladados;
        }

        /**
         * Define el valor de la propiedad totalImpuestosTrasladados.
         *
         * @param value allowed object is {@link BigDecimal }
         *
         */
        public void setTotalImpuestosTrasladados(BigDecimal value) {
            this.totalImpuestosTrasladados = value;
        }

        /**
         * <p>
         * Clase Java para anonymous complex type.
         *
         * <p>
         * El siguiente fragmento de esquema especifica el contenido que se
         * espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Retencion" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "retencion"
        })
        public static class Retenciones {

            @XmlElement(name = "Retencion", required = true)
            protected List<Comprobante.Impuestos.Retenciones.Retencion> retencion;

            /**
             * Gets the value of the retencion property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the retencion property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRetencion().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Impuestos.Retenciones.Retencion }
             *
             *
             */
            public List<Comprobante.Impuestos.Retenciones.Retencion> getRetencion() {
                if (retencion == null) {
                    retencion = new ArrayList<Comprobante.Impuestos.Retenciones.Retencion>();
                }
                return this.retencion;
            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Retencion {

                @XmlAttribute(name = "Impuesto", required = true)
                protected String impuesto;
                @XmlAttribute(name = "Importe", required = true)
                protected BigDecimal importe;

                /**
                 * Obtiene el valor de la propiedad impuesto.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getImpuesto() {
                    return impuesto;
                }

                /**
                 * Define el valor de la propiedad impuesto.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setImpuesto(String value) {
                    this.impuesto = value;
                }

                /**
                 * Obtiene el valor de la propiedad importe.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Define el valor de la propiedad importe.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }

            }

        }

        /**
         * <p>
         * Clase Java para anonymous complex type.
         *
         * <p>
         * El siguiente fragmento de esquema especifica el contenido que se
         * espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Traslado" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Base" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                 &lt;attribute name="TasaOCuota">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;minInclusive value="0.000000"/>
         *                       &lt;fractionDigits value="6"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "traslado"
        })
        public static class Traslados {

            @XmlElement(name = "Traslado", required = true)
            protected List<Comprobante.Impuestos.Traslados.Traslado> traslado;

            /**
             * Gets the value of the traslado property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the traslado property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTraslado().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Impuestos.Traslados.Traslado }
             *
             *
             */
            public List<Comprobante.Impuestos.Traslados.Traslado> getTraslado() {
                if (traslado == null) {
                    traslado = new ArrayList<Comprobante.Impuestos.Traslados.Traslado>();
                }
                return this.traslado;
            }

            /**
             * <p>
             * Clase Java para anonymous complex type.
             *
             * <p>
             * El siguiente fragmento de esquema especifica el contenido que se
             * espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Base" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *       &lt;attribute name="TasaOCuota">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;minInclusive value="0.000000"/>
             *             &lt;fractionDigits value="6"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Traslado {

                @XmlAttribute(name = "Base", required = true)
                protected BigDecimal base;
                @XmlAttribute(name = "Impuesto", required = true)
                protected String impuesto;
                @XmlAttribute(name = "TipoFactor", required = true)
                protected CTipoFactor tipoFactor;
                @XmlAttribute(name = "TasaOCuota")
                protected BigDecimal tasaOCuota;
                @XmlAttribute(name = "Importe")
                protected BigDecimal importe;

                /**
                 * Obtiene el valor de la propiedad base.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getBase() {
                    return base;
                }

                /**
                 * Define el valor de la propiedad base.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setBase(BigDecimal value) {
                    this.base = value;
                }

                /**
                 * Obtiene el valor de la propiedad impuesto.
                 *
                 * @return possible object is {@link String }
                 *
                 */
                public String getImpuesto() {
                    return impuesto;
                }

                /**
                 * Define el valor de la propiedad impuesto.
                 *
                 * @param value allowed object is {@link String }
                 *
                 */
                public void setImpuesto(String value) {
                    this.impuesto = value;
                }

                /**
                 * Obtiene el valor de la propiedad tipoFactor.
                 *
                 * @return possible object is {@link CTipoFactor }
                 *
                 */
                public CTipoFactor getTipoFactor() {
                    return tipoFactor;
                }

                /**
                 * Define el valor de la propiedad tipoFactor.
                 *
                 * @param value allowed object is {@link CTipoFactor }
                 *
                 */
                public void setTipoFactor(CTipoFactor value) {
                    this.tipoFactor = value;
                }

                /**
                 * Obtiene el valor de la propiedad tasaOCuota.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getTasaOCuota() {
                    return tasaOCuota;
                }

                /**
                 * Define el valor de la propiedad tasaOCuota.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setTasaOCuota(BigDecimal value) {
                    this.tasaOCuota = value;
                }

                /**
                 * Obtiene el valor de la propiedad importe.
                 *
                 * @return possible object is {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Define el valor de la propiedad importe.
                 *
                 * @param value allowed object is {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }

            }

        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Periodicidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Periodicidad" />
     *       &lt;attribute name="Meses" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Meses" />
     *       &lt;attribute name="A�o" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
     *             &lt;minInclusive value="2021"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class InformacionGlobal {

        @XmlAttribute(name = "Periodicidad", required = true)
        protected String periodicidad;
        @XmlAttribute(name = "Meses", required = true)
        protected String meses;
        @XmlAttribute(name = "A\u00f1o", required = true)
        protected short año;

        /**
         * Obtiene el valor de la propiedad periodicidad.
         *
         * @return possible object is {@link String }
         *
         */
        public String getPeriodicidad() {
            return periodicidad;
        }

        /**
         * Define el valor de la propiedad periodicidad.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setPeriodicidad(String value) {
            this.periodicidad = value;
        }

        /**
         * Obtiene el valor de la propiedad meses.
         *
         * @return possible object is {@link String }
         *
         */
        public String getMeses() {
            return meses;
        }

        /**
         * Define el valor de la propiedad meses.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setMeses(String value) {
            this.meses = value;
        }

        /**
         * Obtiene el valor de la propiedad a�o.
         *
         * @return
         */
        public short getAño() {
            return año;
        }

        /**
         * Define el valor de la propiedad a�o.
         *
         */
        public void setAño(short value) {
            this.año = value;
        }

    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
     *       &lt;attribute name="Nombre" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="300"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[^|]{1,300}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="DomicilioFiscalReceptor" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;length value="5"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[0-9]{5}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="ResidenciaFiscal" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
     *       &lt;attribute name="NumRegIdTrib">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="40"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="RegimenFiscalReceptor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
     *       &lt;attribute name="UsoCFDI" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_UsoCFDI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Receptor {

        @XmlAttribute(name = "Rfc", required = true)
        protected String rfc;
        @XmlAttribute(name = "Nombre", required = true)
        protected String nombre;
        @XmlAttribute(name = "DomicilioFiscalReceptor", required = true)
        protected String domicilioFiscalReceptor;
        @XmlAttribute(name = "ResidenciaFiscal")
        protected CPais residenciaFiscal;
        @XmlAttribute(name = "NumRegIdTrib")
        protected String numRegIdTrib;
        @XmlAttribute(name = "RegimenFiscalReceptor", required = true)
        protected String regimenFiscalReceptor;
        @XmlAttribute(name = "UsoCFDI", required = true)
        protected CUsoCFDI usoCFDI;

        /**
         * Obtiene el valor de la propiedad rfc.
         *
         * @return possible object is {@link String }
         *
         */
        public String getRfc() {
            return rfc;
        }

        /**
         * Define el valor de la propiedad rfc.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setRfc(String value) {
            this.rfc = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         *
         * @return possible object is {@link String }
         *
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad domicilioFiscalReceptor.
         *
         * @return possible object is {@link String }
         *
         */
        public String getDomicilioFiscalReceptor() {
            return domicilioFiscalReceptor;
        }

        /**
         * Define el valor de la propiedad domicilioFiscalReceptor.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setDomicilioFiscalReceptor(String value) {
            this.domicilioFiscalReceptor = value;
        }

        /**
         * Obtiene el valor de la propiedad residenciaFiscal.
         *
         * @return possible object is {@link CPais }
         *
         */
        public CPais getResidenciaFiscal() {
            return residenciaFiscal;
        }

        /**
         * Define el valor de la propiedad residenciaFiscal.
         *
         * @param value allowed object is {@link CPais }
         *
         */
        public void setResidenciaFiscal(CPais value) {
            this.residenciaFiscal = value;
        }

        /**
         * Obtiene el valor de la propiedad numRegIdTrib.
         *
         * @return possible object is {@link String }
         *
         */
        public String getNumRegIdTrib() {
            return numRegIdTrib;
        }

        /**
         * Define el valor de la propiedad numRegIdTrib.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setNumRegIdTrib(String value) {
            this.numRegIdTrib = value;
        }

        /**
         * Obtiene el valor de la propiedad regimenFiscalReceptor.
         *
         * @return possible object is {@link String }
         *
         */
        public String getRegimenFiscalReceptor() {
            return regimenFiscalReceptor;
        }

        /**
         * Define el valor de la propiedad regimenFiscalReceptor.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setRegimenFiscalReceptor(String value) {
            this.regimenFiscalReceptor = value;
        }

        /**
         * Obtiene el valor de la propiedad usoCFDI.
         *
         * @return possible object is {@link CUsoCFDI }
         *
         */
        public CUsoCFDI getUsoCFDI() {
            return usoCFDI;
        }

        /**
         * Define el valor de la propiedad usoCFDI.
         *
         * @param value allowed object is {@link CUsoCFDI }
         *
         */
        public void setUsoCFDI(CUsoCFDI value) {
            this.usoCFDI = value;
        }

    }

}
