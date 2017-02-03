/*
 * Representa una tarjeta de credito, están asociadas a un usuario, pero pueden usarse por separado, abriendo la puerta a las compras anonimas. 
 */
package Datos;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author ernesto
 */
public class TarjetaCredito implements Serializable{
    private String nombre;
    private int ccv;
    private long numero;
    private GregorianCalendar fechaCaducidad;
    
    /**
     * El constructor
     * @param nombre
     * @param ccv
     * @param numero
     * @param fechaCaducidad
     */
    public TarjetaCredito(String nombre, int ccv, long numero, GregorianCalendar fechaCaducidad) {
        this.nombre = nombre;
        this.ccv = ccv;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }
      
    /**
     *
     * @return
     */
    public int getCcv() {
        return ccv;
    }

    /**
     *
     * @return
     */
    public String getCcvString() {
        return Integer.toString(ccv);
    }
    
    /**
     *
     * @return
     */
    public long getNumero() {
        return numero;
    }
    
    /**
     *
     * @return
     */
    public String getNumeroString() {
        return String.valueOf(numero);
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    /**
     *
     * @return
     */
    public String getFechaCaducidadString() {
        return fechaCaducidad.getTime().toString();
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *
     * @param ccv
     */
    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     *
     * @param fechaCaducidad
     */
    public void setFechaCaducidad(GregorianCalendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "ccv=" + ccv + ", numero=" + numero + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
           
        
        
}
