/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 
 * @author Ernesto
 */
public class LibroDeTexto extends PublicacionDigital implements Serializable {
    
    private String nivel;
    private String materia;
    private int curso;

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
     * @param materia
     * @param curso
     */
    public LibroDeTexto(long ISBN, String titulo, String autor, String editorial, 
            GregorianCalendar fechaPublicacion, double precio, double precioConsulta, 
            String nivel, String materia, int curso) {
        super(ISBN, titulo, autor, editorial, fechaPublicacion, precio, precioConsulta);
        this.nivel = nivel;
        this.materia = materia;
        this.curso = curso;           
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
    public String getMateria() {
        return materia;
    }

    /**
     *
     * @return
     */
    public int getCurso() {
        return curso;
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
     * @param materia
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "LibroDeTexto{" + "ISBN=" + this.getISBN() + ", titulo=" + this.getTitulo() + ", autor=" + this.getAutor() + ", editorial=" + this.getEditorial() 
                + ", fechaPublicacion=" + this.getFechaPublicacionString() + ", precio=" + this.getPrecio() + " Euros , precioConsulta=" + this.getPrecioConsulta() +" Euros , ID" + this.getID() 
                + "nivel=" + nivel + ", materia=" + materia + ", curso=" + curso + '}';
    }


    
    
    
}
