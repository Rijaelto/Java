/*
Esta clase, como la clase Estudiante, no agrega ningún metodo ni atributo nuevo con respecto a la clase Cliente, 
no obstante, es útil que este separada para poder añadir cambios en el futuro con facilidad. 
Importante tener en cuenta que implementa la interfaz MetodosUsuario y por lo tanto reescribe los metodos.
 */
package Datos;

import Logica.Kioskero;
import Logica.KioskoException;
import Logica.Secretario;
import java.io.Serializable;


/**
 *
 * @author ernesto
 */
public class Profesor extends Cliente implements MetodosUsuario, Serializable {

    /**
     * El constructor
     * @param nombre
     * @param apellidos
     * @param NIF
     * @param nick
     * @param email
     * @param password
     * @param telefono
     */
    public Profesor(String nombre, String apellidos, String NIF, String nick, String email, String password, long telefono) {
        super(nombre, apellidos, NIF, nick, email, password, telefono);
    }

    @Override
    public void comprar(Producto producto,int tarjeta) 
            throws KioskoException{
        Producto auxProducto = producto;
        int tipoDeProducto;
        double descuento;
        double precioFinal = auxProducto.getPrecio();
        Kioskero igor;
        igor = Kioskero.getInstance();        
        tipoDeProducto=igor.determinaElProducto(producto);
        
        
        switch(tipoDeProducto){
            
            case 1: /*Libro de texto*/
                descuento = ((auxProducto.getPrecio())*0.2);
                precioFinal = ((auxProducto.getPrecio())-descuento);
                break;
            case 2: /*Libro de lectura*/
                
                precioFinal = auxProducto.getPrecio();
                break;
            case 3: /*Diccionario*/
                
                precioFinal = auxProducto.getPrecio();
                break;
               
        }
        Secretario alfred;
        alfred = Secretario.getInstance();
        
        
        alfred.gestionaLaCompra(this,tarjeta,producto,precioFinal);
        
        
    }
 
    @Override
    public void añadirComentario(Producto producto, String comentario) {
        Kioskero igor;
        igor = Kioskero.getInstance();  
        igor.añadirComentario(producto, nick, comentario);
        
        
    }

    @Override
    public void consultaOnline(Producto producto, int tarjeta,int meses) throws KioskoException {
         PublicacionDigital auxProducto = (PublicacionDigital) producto;
        int tipoDeProducto;
        double descuento;
        double precioFinal = auxProducto.getPrecioConsulta();
        Kioskero igor;
        igor = Kioskero.getInstance();        
        tipoDeProducto=igor.determinaElProducto(producto);
        
        
        switch(tipoDeProducto){
            
             case 1: /*Libro de texto*/
                descuento = ((auxProducto.getPrecioConsulta())*0.2);
                precioFinal = ((auxProducto.getPrecioConsulta())-descuento);
                break;
            case 2: /*Libro de lectura*/
                
                precioFinal = auxProducto.getPrecioConsulta();
                break;
            case 3: /*Diccionario*/
                
                precioFinal = auxProducto.getPrecioConsulta();
                break;
               
        }
        Secretario alfred;
        alfred = Secretario.getInstance();
        
        
        alfred.gestionaLaConsulta(this,tarjeta,auxProducto,precioFinal,meses);
    }
    
    
    
}
