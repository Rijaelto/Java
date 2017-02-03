/*
 
 */
package Datos;

import Logica.KioskoException;


/**
 * Interfaz con los metodos que deben implementar las clases que representen a usuarios de la aplicación
 * @author ernesto
 */
public interface MetodosUsuario {
    
    

    /**
     * Este metodo sirve para comprar, necesita una tarjeta de credito y un producto
     * @param producto
     * @param tarjeta
     * @throws KioskoException
     */
    
    void comprar(Producto producto,int tarjeta)throws KioskoException;
    
    

    /**
     * añade un comentario a un producto
     * @param producto
     * @param comentario
     */
    
    void añadirComentario(Producto producto, String comentario);
    

    /**
     * Permite el acceso a un libro online
     * @param producto
     * @throws KioskoException
     */
    
    void consultaOnline(Producto producto,int tarjeta, int meses)throws KioskoException;
}
