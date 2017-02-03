/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author ernesto
 */
public class Diccionario extends PublicacionDigital implements Serializable {
    
    private String idioma;
    private ArrayList<String> cursosRecomendados;

    /**
     * El constructor
     * @param ISBN
     * @param titulo
     * @param autor
     * @param editorial
     * @param fechaPublicacion
     * @param precio
     * @param precioConsulta
     * @param idioma
     * @param cursoRecomendado
     */
    public Diccionario(long ISBN, String titulo, String autor, String editorial, 
            GregorianCalendar fechaPublicacion, double precio, double precioConsulta, 
            String idioma,String cursoRecomendado) {
        super(ISBN, titulo, autor, editorial, fechaPublicacion, precio, precioConsulta);
        this.idioma = idioma;
        this.cursosRecomendados = new ArrayList();
        cursosRecomendados.add(cursoRecomendado);
    }

    /**
     *
     * @return
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getCursosRecomendados() {
        return cursosRecomendados;
    }

    /**
     *
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     *
     * @param cursosRecomendados
     */
    public void setCursosRecomendados(ArrayList<String> cursosRecomendados) {
        this.cursosRecomendados = cursosRecomendados;
    }

    @Override
    public String toString() {
        return "Diccionario{" + "ISBN=" + this.getISBN() + ", titulo=" + this.getTitulo() + ", autor=" + this.getAutor() + ", editorial=" + this.getEditorial() 
                + ", fechaPublicacion=" + this.getFechaPublicacionString() + ", precio=" + this.getPrecio() + " Euros , precioConsulta=" + this.getPrecioConsulta() +" Euros , ID" + this.getID() 
                + "idioma=" + idioma + ", cursosRecomendados=" + cursosRecomendados + '}';
    }

    
    

}
