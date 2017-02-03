/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;

/**
 *
 * @author ernesto
 */
public class LectorDeLibros extends Producto implements Serializable {
    String SN;
    String marca;        
    String modelo; 
                  
    String descripcion;
    
    /**
     * El constructor
     * @param SN
     * @param marca
     * @param modelo
     * @param precio
     * @param descripcion
     */
    public LectorDeLibros(String SN,String marca,String modelo,double precio,String descripcion) {
        super(precio);
        this.SN = SN;
        this.marca = marca;
        this.modelo = modelo;
        
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public String getSN() {
        return SN;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param SN
     */
    public void setSN(String SN) {
        this.SN = SN;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    
    public String toString() {
        
        return "LectorDeLibros{" + "SN=" + SN + ", marca=" + marca + ", modelo=" + modelo + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
