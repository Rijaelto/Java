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
 * @author Ernesto
 */
public abstract class PublicacionDigital extends Producto implements Serializable{
    
    private long ISBN; //http://recursostic.educacion.es/descartes/web/materiales_didacticos/digitocontrol/DigitoControl.htm
    private String titulo;
    private String autor;
    private String editorial;
    private GregorianCalendar fechaPublicacion;
    private GregorianCalendar fechaInicioConsulta;
    private int mesesConsulta;
    private double precioConsulta;

    /**
     * El constructor
     * @param ISBN
     * @param titulo
     * @param autor
     * @param editorial
     * @param fechaPublicacion
     * @param precio
     * @param precioConsulta
     */
    public PublicacionDigital(long ISBN, String titulo, String autor, String editorial, 
            GregorianCalendar fechaPublicacion, double precio, double precioConsulta) {
        super(precio);
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        
        this.precioConsulta = precioConsulta;
    }

    public GregorianCalendar getFechaInicioConsulta() {
        return fechaInicioConsulta;
    }

    public int getMesesConsulta() {
        return mesesConsulta;
    }

    public void setFechaInicioConsulta(GregorianCalendar fechaInicioConsulta) {
        this.fechaInicioConsulta = fechaInicioConsulta;
    }

    public void setMesesConsulta(int mesesConsulta) {
        this.mesesConsulta = mesesConsulta;
    }

    
    
    
    /**
     *
     * @return
     */
    public long getISBN() {
        return ISBN;
    }
    
    /**
     *
     * @return
     */
    public String getISBNString(){
        return String.valueOf(ISBN);
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @return
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    /**
     *
     * @return
     */
    public String getFechaPublicacionString() {
        return fechaPublicacion.getTime().toString();
    }

    /**
     *
     * @return
     */
    public double getPrecioConsulta() {
        return precioConsulta;       
    }
    
    /**
     *
     * @return
     */
    public String getPrecioConsultaString() {
        return Double.toString(precioConsulta);
    }

    /**
     *
     * @param ISBN
     */
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }
    
    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     *
     * @param fechaPublicacion
     */
    public void setFechaPublicacion(GregorianCalendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     *
     * @param precioConsulta
     */
    public void setPrecioConsulta(double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    @Override
    public String toString() {
        return "PublicacionDigital{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", fechaPublicacion=" + this.getFechaPublicacionString() + ", precio=" + this.getPrecio() + ", precioConsulta=" + precioConsulta +", ID" + this.getID() + '}';
    }
    
    
    
    
}
