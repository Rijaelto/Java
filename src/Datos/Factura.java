/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * 
 * @author ernesto
 */
public class Factura implements Serializable{
    
    private static int IDtotal; /*Numero de facturas emitidas*/
    private int ID; /*Identificador de la factura*/
    private TarjetaCredito tarjeta; 
    private Cliente cliente;
    private GregorianCalendar fecha;
    private Producto producto;
    private Double precioFinal;

    /**
     * El constructor
     * @param tarjeta
     * @param cliente
     * @param fecha
     * @param producto
     * @param precioFinal
     */
    public Factura(TarjetaCredito tarjeta, Cliente cliente, GregorianCalendar fecha, Producto producto, Double precioFinal) {
        
        IDtotal++;
        this.ID = IDtotal;
        this.tarjeta = tarjeta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.producto = producto;
        this.precioFinal = precioFinal;
    }

    /**
     *
     * @return
     */
    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     *
     * @param tarjeta
     */
    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public static int getIDtotal() {
        return IDtotal;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     *
     * @param IDtotal
     */
    public static void setIDtotal(int IDtotal) {
        Factura.IDtotal = IDtotal;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    /**
     *
     * @return
     */
    public String getFechaString() {
        return fecha.getTime().toString();
    }

    /**
     *
     * @return
     */
    public Double getPrecioFinal() {
        return precioFinal;
    }

    /**
     *
     * @param precioFinal
     */
    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
    
}
