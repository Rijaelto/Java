/*
 *Clase basica de la que extienden todos los productos de la tienda online, unicamente es destacable el comparador. 
 */
package Datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;



/**
 *
 * @author Ernesto
 */
public abstract class Producto implements Serializable {
    
    /**
     *
     */
    protected static int IDtotal; /*Numero de productos introducidos*/
    private int ID; /*Identificador del producto*/
    private double precio;
    private GregorianCalendar fechaDeAlta;
    private ArrayList<String> comentarios;
    private ImageIcon fotoProducto;
    
    /**
     * El constructor
     * @param precio
     */
    public Producto(double precio) { /*Contructor, se suma uno a la IDtotal y se toma como ID*/
        
            IDtotal++;
            this.ID = IDtotal;
            this.precio = precio;
            this.fechaDeAlta = (GregorianCalendar) GregorianCalendar.getInstance();
            this.comentarios = new ArrayList();
            this.fotoProducto = null;
        }
    
    /**
     *
     */
    public static Comparator<Producto> COMPARAPRECIO = new Comparator<Producto>(){

        @Override
        public int compare(Producto o1, Producto o2) {
            LectorDeLibros p1 = (LectorDeLibros) o1;
            LectorDeLibros p2 = (LectorDeLibros) o2;
            
            return Double.compare(p1.getPrecio(),p2.getPrecio());
            
        }

    }; 
         
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
    public double getPrecio() {
        return precio;
    }
    
    /**
     *
     * @return
     */
    public String getPrecioString() {
        return Double.toString(precio);
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getFechaDeAlta() {
        return fechaDeAlta;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    /**
     *
     * @param IDtotal
     */
    public static void setIDtotal(int IDtotal) {
        Producto.IDtotal = IDtotal;
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
     * @param fechaDeAlta
     */
    public void setFechaDeAlta(GregorianCalendar fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    /**
     *
     * @param comentarios
     */
    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     *
     * @return
     */
    public ImageIcon getFotoProducto() {
        return fotoProducto;
    }

    /**
     *
     * @param fotoProducto
     */
    public void setFotoProducto(ImageIcon fotoProducto) {
        this.fotoProducto = fotoProducto;
    }
    
    
    @Override
    public String toString() {
        return "Producto{" + "ID=" + ID + ", precio=" + precio + '}';
    }

 



    
    
    
    
}
