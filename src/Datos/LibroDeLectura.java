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
public class LibroDeLectura extends PublicacionDigital implements Serializable {
    private String nivel;
    private String genero;
    private String resumen;

    /**
     * El constructor
     * @param ISBN
     * @param titulo
     * @param autor
     * @param editorial
     * @param fechaPublicacion
     * @param precio
     * @param precioConsulta
     * @param nivel
     * @param genero
     * @param resumen
     */
    public LibroDeLectura(long ISBN, String titulo, String autor, String editorial, 
            GregorianCalendar fechaPublicacion, double precio, double precioConsulta, 
            String nivel, String genero, String resumen) {
        super(ISBN, titulo, autor, editorial, fechaPublicacion, precio, precioConsulta);
        this.nivel = nivel;
        this.genero = genero;
        this.resumen = resumen;
    }

    /**
     *
     * @return
     */
    public String getNivel() {
        return nivel;
    }

    /**
     *
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @return
     */
    public String getResumen() {
        return resumen;
    }

    /**
     *
     * @param nivel
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     *
     * @param resumen
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String toString() {
        return "LibroDeLectura{" + "ISBN=" + this.getISBN() + ", titulo=" + this.getTitulo() + ", autor=" + this.getAutor() + ", editorial=" + this.getEditorial() 
                + ", fechaPublicacion=" + this.getFechaPublicacionString() + ", precio=" + this.getPrecio() + " Euros , precioConsulta=" + this.getPrecioConsulta() +" Euros , ID" + this.getID() 
                + "nivel=" + nivel + ", genero=" + genero + ", resumen=" + resumen + '}';
    }
    
    
    
    
}
