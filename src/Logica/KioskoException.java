/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 * Las diferentes excepciones que se pueden producir al usar el programa
 * @author Ernesto
 */
public class KioskoException extends Exception {
    
    /**
     *
     */
    public static String USUARIO_EXISTENTE = "El usuario ha sido registrado con anterioridad.";
    
    /**
     *
     */
    public static String USUARIO_INEXISTENTE = "El usuario no existe.";
    
    /**
     *
     */
    public static String PRODUCTO_EXISTENTE = "El producto ha sido registrado con anterioridad.";
    
    /**
     *
     */
    public static String PRODUCTO_INEXISTENTE = "El producto que pretende eliminar no existe.";
    
    /**
     *
     */
    public static String SIN_PRODUCTOS = "Parece que aún no tenemos ningún producto disponible.";
    
    /**
     *
     */
    public static String BUSQUEDA_SIN_RESULTADO = "No encontramos el producto que busca.";
    
    /**
     *
     */
    public static String TARJETA_EXISTENTE = "No encontramos el producto que busca.";
    
    /**
     *
     */
    public static String TARJETA_INEXISTENTE = "No encontramos el producto que busca.";
    
    /**
     *
     */
    public static String TARJETERO_VACIO = "No hay ninguna tarjeta de credito para procesar la compra.";
    
    public static String COMPRA_YAREALIZADA = "Este libro ya ha sido comprado con anterioridad.";
    
    /**
     *
     */
    public KioskoException() {
      super("Se ha producido un error.");
    }
    
    /**
     *
     * @param error
     */
    public KioskoException(String error) {
        super(error);
    }
    
}
