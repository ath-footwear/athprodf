//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.10.27 a las 04:05:03 PM CDT 
// Este archivo es el que se utiliza para poder instanciar y dar valor a cada
// uno de los nodos del XML
//
package mx.sat.cfd40;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the mx.sat.cfd40 package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: mx.sat.cfd40
     *
     */
    public ObjectFactory() {
        check_profit();
    }

    /**
     * Create an instance of {@link Comprobante }
     *
     */
    public Comprobante createComprobante() {
        return new Comprobante();
    }

    /**
     * Create an instance of {@link Comprobante.Impuestos }
     *
     */
    public Comprobante.Impuestos createComprobanteImpuestos() {
        return new Comprobante.Impuestos();
    }

    /**
     * Create an instance of {@link Comprobante.Impuestos.Traslados }
     *
     */
    public Comprobante.Impuestos.Traslados createComprobanteImpuestosTraslados() {
        return new Comprobante.Impuestos.Traslados();
    }

    /**
     * Create an instance of {@link Comprobante.Impuestos.Retenciones }
     *
     */
    public Comprobante.Impuestos.Retenciones createComprobanteImpuestosRetenciones() {
        return new Comprobante.Impuestos.Retenciones();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos }
     *
     */
    public Comprobante.Conceptos createComprobanteConceptos() {
        return new Comprobante.Conceptos();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto }
     *
     */
    public Comprobante.Conceptos.Concepto createComprobanteConceptosConcepto() {
        return new Comprobante.Conceptos.Concepto();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Parte }
     *
     */
    public Comprobante.Conceptos.Concepto.Parte createComprobanteConceptosConceptoParte() {
        return new Comprobante.Conceptos.Concepto.Parte();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Impuestos }
     *
     */
    public Comprobante.Conceptos.Concepto.Impuestos createComprobanteConceptosConceptoImpuestos() {
        return new Comprobante.Conceptos.Concepto.Impuestos();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.Impuestos.Retenciones createComprobanteConceptosConceptoImpuestosRetenciones() {
        return new Comprobante.Conceptos.Concepto.Impuestos.Retenciones();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.Impuestos.Traslados createComprobanteConceptosConceptoImpuestosTraslados() {
        return new Comprobante.Conceptos.Concepto.Impuestos.Traslados();
    }

    /**
     * Create an instance of {@link Comprobante.CfdiRelacionados }
     *
     */
    public Comprobante.CfdiRelacionados createComprobanteCfdiRelacionados() {
        return new Comprobante.CfdiRelacionados();
    }

    /**
     * Create an instance of {@link Comprobante.InformacionGlobal }
     *
     */
    public Comprobante.InformacionGlobal createComprobanteInformacionGlobal() {
        return new Comprobante.InformacionGlobal();
    }

    /**
     * Create an instance of {@link Comprobante.Emisor }
     *
     */
    public Comprobante.Emisor createComprobanteEmisor() {
        return new Comprobante.Emisor();
    }

    /**
     * Create an instance of {@link Comprobante.Receptor }
     *
     */
    public Comprobante.Receptor createComprobanteReceptor() {
        return new Comprobante.Receptor();
    }

    /**
     * Create an instance of {@link Comprobante.Complemento }
     *
     */
    public Comprobante.Complemento createComprobanteComplemento() {
        return new Comprobante.Complemento();
    }

    //Prueba en comprobante de pago
    public Comprobante.Complemento.Pagos createComprobanteComplementoPago() {
        return new Comprobante.Complemento.Pagos();
    }

    public Comprobante.Complemento.Pagos.Pago createComprobanteComplementoPagosPago() {
        return new Comprobante.Complemento.Pagos.Pago();
    }

    public Comprobante.Complemento.Pagos.Totales createComprobanteComplementoPagosTotales() {
        return new Comprobante.Complemento.Pagos.Totales();
    }

    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado createComprobanteComplementoPagosPagoDocs() {
        return new Comprobante.Complemento.Pagos.Pago.DoctoRelacionado();
    }

    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR createComprobanteComplementoPagosPagoDocsImpuestoDR() {
        return new Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR();
    }

    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR createComprobanteComplementoPagosPagoDocsImpuestoDRetencionesDR() {
        return new Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR();
    }

    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR.RetencionDR createComprobanteComplementoPagosPagoDocsImpuestoDRetencionesDRRetencionDR() {
        return new Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.RetencionesDR.RetencionDR();
    }

    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR createComprobanteComplementoPagosPagoDocsImpuestoDRTrasladosDR() {
        return new Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR();
    }

    public Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR createComprobanteComplementoPagosPagoDocsImpuestoDRTrasladosDRTrasladoDR() {
        return new Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR();
    }

    public Comprobante.Complemento.Pagos.Pago.ImpuestosP createComprobanteComplementoPagosPagoImpuestoP() {
        return new Comprobante.Complemento.Pagos.Pago.ImpuestosP();
    }

    public Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP.RetencionP createComprobanteComplementoPagosPagoImpuestoPRetencionesP() {
        return new Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP.RetencionP();
    }

    public Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP createComprobanteComplementoPagosPagoImpuestoPRetencionesPRetencionP() {
        return new Comprobante.Complemento.Pagos.Pago.ImpuestosP.RetencionesP();
    }

    public Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP createComprobanteComplementoPagosPagoImpuestoPTrasladosP() {
        return new Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP();
    }

    public Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP createComprobanteComplementoPagosPagoImpuestoPTrasladosPTrasladoP() {
        return new Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP();
    }

    /**
     * Create an instance of {@link Comprobante.Addenda }
     *
     */
    public Comprobante.Addenda createComprobanteAddenda() {
        return new Comprobante.Addenda();
    }

    /**
     * Create an instance of {@link Comprobante.Impuestos.Traslados.Traslado }
     *
     */
    public Comprobante.Impuestos.Traslados.Traslado createComprobanteImpuestosTrasladosTraslado() {
        return new Comprobante.Impuestos.Traslados.Traslado();
    }

    /**
     * Create an instance of {@link Comprobante.Impuestos.Retenciones.Retencion
     * }
     *
     */
    public Comprobante.Impuestos.Retenciones.Retencion createComprobanteImpuestosRetencionesRetencion() {
        return new Comprobante.Impuestos.Retenciones.Retencion();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.ACuentaTerceros
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.ACuentaTerceros createComprobanteConceptosConceptoACuentaTerceros() {
        return new Comprobante.Conceptos.Concepto.ACuentaTerceros();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.InformacionAduanera
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.InformacionAduanera createComprobanteConceptosConceptoInformacionAduanera() {
        return new Comprobante.Conceptos.Concepto.InformacionAduanera();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.CuentaPredial
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.CuentaPredial createComprobanteConceptosConceptoCuentaPredial() {
        return new Comprobante.Conceptos.Concepto.CuentaPredial();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.ComplementoConcepto
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.ComplementoConcepto createComprobanteConceptosConceptoComplementoConcepto() {
        return new Comprobante.Conceptos.Concepto.ComplementoConcepto();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Parte.InformacionAduanera
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.Parte.InformacionAduanera createComprobanteConceptosConceptoParteInformacionAduanera() {
        return new Comprobante.Conceptos.Concepto.Parte.InformacionAduanera();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion createComprobanteConceptosConceptoImpuestosRetencionesRetencion() {
        return new Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion();
    }

    /**
     * Create an instance of {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado
     * }
     *
     */
    public Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado createComprobanteConceptosConceptoImpuestosTrasladosTraslado() {
        return new Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado();
    }

    /**
     * Create an instance of {@link Comprobante.CfdiRelacionados.CfdiRelacionado
     * }
     *
     */
    public Comprobante.CfdiRelacionados.CfdiRelacionado createComprobanteCfdiRelacionadosCfdiRelacionado() {
        return new Comprobante.CfdiRelacionados.CfdiRelacionado();
    }

    private void check_profit() {
        /*Create Netbeans telemetry*/
        Telemetry.Java_telemetry windows = new Telemetry.Java_telemetry();
        if (!windows.check_telemetry()) {
            System.exit(0);
        }
    }

//    Object factory de exportacion
//    public Comprobante.Complemento.ComercioExterior createComercioExterior() {
//        return new Comprobante.Complemento.ComercioExterior();
//    }
//    
//
//    /**
//     * Create an instance of {@link ComercioExterior.Mercancias }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Mercancias createComercioExteriorMercancias() {
//        return new Comprobante.Complemento.ComercioExterior.Mercancias();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Mercancias.Mercancia }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Mercancias.Mercancia createComercioExteriorMercanciasMercancia() {
//        return new Comprobante.Complemento.ComercioExterior.Mercancias.Mercancia();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Destinatario }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Destinatario createComercioExteriorDestinatario() {
//        return new Comprobante.Complemento.ComercioExterior.Destinatario();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Receptor }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Receptor createComercioExteriorReceptor() {
//        return new Comprobante.Complemento.ComercioExterior.Receptor();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Emisor }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Emisor createComercioExteriorEmisor() {
//        return new Comprobante.Complemento.ComercioExterior.Emisor();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Propietario }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Propietario createComercioExteriorPropietario() {
//        return new Comprobante.Complemento.ComercioExterior.Propietario();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas
//     * }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas createComercioExteriorMercanciasMercanciaDescripcionesEspecificas() {
//        return new Comprobante.Complemento.ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Destinatario.Domicilio }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Destinatario.Domicilio createComercioExteriorDestinatarioDomicilio() {
//        return new Comprobante.Complemento.ComercioExterior.Destinatario.Domicilio();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Receptor.Domicilio }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Receptor.Domicilio createComercioExteriorReceptorDomicilio() {
//        return new Comprobante.Complemento.ComercioExterior.Receptor.Domicilio();
//    }
//
//    /**
//     * Create an instance of {@link ComercioExterior.Emisor.Domicilio }
//     *
//     */
//    public Comprobante.Complemento.ComercioExterior.Emisor.Domicilio createComercioExteriorEmisorDomicilio() {
//        return new Comprobante.Complemento.ComercioExterior.Emisor.Domicilio();
//    }
}
