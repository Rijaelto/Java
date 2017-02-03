
package Logica;

import Datos.Diccionario;
import Datos.LectorDeLibros;
import Datos.LibroDeLectura;
import Datos.LibroDeTexto;
import Datos.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Esta clase es la encargada de realizar todo lo relacionado con los libros 
 disponibles, son especialmente importantes sus metodos de busqueda y de gestión 
 de los libros disponibles. Utiliza el patron Singleton.
 * @author ernesto
 */
public class Kioskero {

    private static Kioskero instance;

    private Kioskero() {

    }

    /**
     *
     * @return: Nos devuelve la instancia del kioskero
     */
    public static Kioskero getInstance() {
        if (instance == null) {
            instance = new Kioskero();
        }
        return instance;
    }

    

    /**
     * Metodo para registrar un producto del arraylist del kiosko
     * @param producto
     * @param laLista
     * @throws KioskoException
     */
    
    public void registrarProducto(Producto producto, ArrayList<Producto> laLista)
            throws KioskoException {

        if (laLista.contains(producto)) {/*Se comprueba el producto y se controla el error*/

            throw new KioskoException(KioskoException.PRODUCTO_EXISTENTE);
        } else {

            laLista.add(producto);
        }
    }

    

    /**
     * Metodo para borrar un producto del arraylist del kiosko
     * @param producto
     * @param laLista
     * @throws KioskoException
     */
    
    public void borrarProducto(Producto producto, ArrayList<Producto> laLista)
            throws KioskoException {

        if (laLista.contains(producto)) {/*Se comprueba antes de borrar y se controla el error*/

            laLista.remove(producto);

        } else {
            throw new KioskoException(KioskoException.PRODUCTO_INEXISTENTE);
        }
    }

   

    /**
     * Metodo para añadir un comentario
     * @param producto
     * @param nombre
     * @param comentario
     */
    
    public void añadirComentario(Producto producto, String nombre, String comentario) {

        producto.getComentarios().add(nombre + ": " + comentario);

    }

    

    /**
     * Este metodo nos permite saber que clase en concreto es el producto, es lo mismo que usar istanceof, pero ayuda a entender el codigo de la busqueda
     * @param producto
     * @return
     */
    
    public int determinaElProducto(Producto producto) {
        int tipoDeProducto = 0; /*Devolveremos un 0 si el producto no es de ningún tipo conocido*/

        if (producto instanceof LibroDeTexto) {
            tipoDeProducto = 1; /*Si el producto es un libro de texto */

        }
        if (producto instanceof LibroDeLectura) {
            tipoDeProducto = 2; /*Si el producto es un libro de Lectura */

        }
        if (producto instanceof Diccionario) {
            tipoDeProducto = 3; /*Si el producto es un diccionario */

        }
        if (producto instanceof LectorDeLibros) {
            tipoDeProducto = 4; /*Si el producto es un lector*/

        }
        return tipoDeProducto;

    }

    
    /**
     * Metodo para modelar el productos en clases concretas que extienden de ella
     * @param producto
     * @return lectordelibros
     */
    
    public LectorDeLibros modeladoLectorDeLibros(Producto producto) {
        LectorDeLibros productoAux;
        productoAux = (LectorDeLibros) producto;

        return productoAux;
    }

    /**
     * Metodo para modelar el productos en clases concretas que extienden de ella
     * @param producto
     * @return LibroDeTexto
     */
    public LibroDeTexto modeladoLibroDeTexto(Producto producto) {
        LibroDeTexto productoAux;
        productoAux = (LibroDeTexto) producto;

        return productoAux;
    }

    /**
     * Metodo para modelar el productos en clases concretas que extienden de ella
     * @param producto
     * @return LibroDeLectura
     */
    public LibroDeLectura modeladoLibroDeLectura(Producto producto) {
        LibroDeLectura productoAux;
        productoAux = (LibroDeLectura) producto;

        return productoAux;
    }

    /**
     * Metodo para modelar el productos en clases concretas que extienden de ella
     * @param producto
     * @return Diccionario
     */
    public Diccionario modeladoDiccionario(Producto producto) {
        Diccionario productoAux;
        productoAux = (Diccionario) producto;

        return productoAux;
    }

    

    /**
     * Para limpiar los resultados
     * @param laLista
     */
    
    public void limpiarLista(ArrayList<Producto> laLista) {
        laLista.clear();
    }

    

    /**
     * Metodo para realizar una busqueda, necesita una cadena con la que comprar, la lista de productos y la lista de resultados
     * @param comando
     * @param laLista
     * @param losResultados
     * @throws KioskoException
     */
    
    public void busqueda(String comando, ArrayList<Producto> laLista, ArrayList<Producto> losResultados) throws KioskoException {
        Producto auxProducto;/*Producto auxiliar para realizar comparaciones*/

        LibroDeTexto auxLibroDeTexto;/*Auxiliares para el tipo de producto concreto */

        LibroDeLectura auxLibroDeLectura;
        Diccionario auxDiccionario;/**/

        int tipoDeProducto;/*variable para guardar el valor retornado por el metodo determinaElProducto*/

        Iterator<Producto> iter = laLista.iterator();/*Iterador para recorrer la lista*/

        if (laLista.isEmpty()) {
            throw new KioskoException(KioskoException.SIN_PRODUCTOS);
        } else {

            while (iter.hasNext()) {/*Bucle hasta acabar la lista*/

                auxProducto = iter.next();
                tipoDeProducto = determinaElProducto(auxProducto);/*Llamada al metodo que nos indica a que clase concreta pertenece el producto*/

                switch (tipoDeProducto) {

                    case 1: /*En este caso sabemos que es un LibroDeTexto*/

                        auxLibroDeTexto = modeladoLibroDeTexto(auxProducto);/*Modelamos el producto en un LibroDeTexto*/
                        /*Realizamos las comparaciones necesarias*/

                        if ((auxLibroDeTexto.getAutor().contains(comando))
                                || (auxLibroDeTexto.getTitulo().contains(comando))
                                || (String.valueOf(auxLibroDeTexto.getISBN()).contains(comando))
                                || (auxLibroDeTexto.getMateria().contains(comando))
                                || (auxLibroDeTexto.getNivel().contains(comando))) {
                            try {
                                registrarProducto(auxLibroDeTexto, losResultados);/*Añadimos el libro a los resultados mediante este metodo, así evitamos duplicados*/

                            } catch (KioskoException e) {
                                /*Capturamos la excepcion pero no hacemos nada porque en la busqueda se va a producir seguro*/
                            }

                        }
                        break;
                    case 2:/*En este caso sabemos que es un LibroDeLectura*/

                        auxLibroDeLectura = modeladoLibroDeLectura(auxProducto);/*Modelamos el producto en un LibroDeLectura*/
                        /*Realizamos las comparaciones necesarias*/

                        if ((auxLibroDeLectura.getAutor().contains(comando))
                                || (auxLibroDeLectura.getTitulo().contains(comando))
                                || (String.valueOf(auxLibroDeLectura.getISBN()).contains(comando))) {
                            try {

                                registrarProducto(auxLibroDeLectura, losResultados);

                            } catch (KioskoException e) {
                            }

                        }
                        break;
                    case 3:/*En este caso sabemos que es un Diccionario*/

                        auxDiccionario = modeladoDiccionario(auxProducto);/*Modelamos el producto en un Diccionario*/
                        /*Realizamos las comparaciones necesarias*/

                        if ((auxDiccionario.getAutor().contains(comando))
                                || (auxDiccionario.getTitulo().contains(comando))
                                || (String.valueOf(auxDiccionario.getISBN()).contains(comando))
                                || (auxDiccionario.getIdioma().contains(comando))) {
                            try {
                                registrarProducto(auxDiccionario, losResultados);
                            } catch (KioskoException e) {
                            }

                        }
                        break;
                    default:
                        break;
                }

            }
        }
    }

    

    /**
     * Busqueda simple, varias veces
     * @param comandos
     * @param laLista
     * @param losResultados
     * @throws KioskoException
     */
    
    public void busquedaAvanzada(ArrayList<String> comandos, ArrayList<Producto> laLista, ArrayList<Producto> losResultados) throws KioskoException {

        for (int i = 0; i < comandos.size(); i++) {
            busqueda(comandos.get(i), laLista, losResultados);

        }

    }

    

    /**
     * Busqueda de lector
     * @param comando
     * @param laLista
     * @param losResultados
     * @throws KioskoException
     */
    
    public void buscaLector(String comando, ArrayList<Producto> laLista, ArrayList<Producto> losResultados) throws KioskoException {
        Producto auxProducto;/*Producto auxiliar para realizar comparaciones*/

        LectorDeLibros auxLectorDeLibros;/*Auxiliares para el tipo de producto concreto */


        Iterator<Producto> iter = laLista.iterator();/*Iterador para recorrer la lista*/

        if (laLista.isEmpty()) {
            throw new KioskoException(KioskoException.SIN_PRODUCTOS);
        } else {

            while (iter.hasNext()) {/*Bucle hasta acabar la lista*/

                auxProducto = iter.next();

                auxLectorDeLibros = (LectorDeLibros) auxProducto;/*Modelamos el producto en un Lector de Libros*/
                /*Realizamos las comparaciones necesarias*/

                if ((auxLectorDeLibros.getMarca().contains(comando))
                        || (auxLectorDeLibros.getModelo().contains(comando))
                        || (auxLectorDeLibros.getSN().contains(comando))) {
                    try {
                        registrarProducto(auxLectorDeLibros, losResultados);/*Añadimos el llector a los resultados mediante este metodo, así evitamos duplicados*/

                    } catch (KioskoException e) {
                        /*Capturamos la excepcion pero no hacemos nada porque en la busqueda se va a producir seguro*/
                    }

                }
            }
        }

    }

    /**
     * Ordena los lectores por una marca concreta
     * @param laLista
     */
    public void ordenaLectoresPorMarca(ArrayList<Producto> laLista) {
        //Comparador para ordenar las personas por su nombre
        Comparator LectoresMarcaComp = new Comparator() {

            public int compare(Object o1, Object o2) {
                LectorDeLibros p1 = (LectorDeLibros) o1;
                LectorDeLibros p2 = (LectorDeLibros) o2;
                return p1.getMarca().compareTo(p2.getMarca());
            }
        };
        //Ordenamos el array
        Collections.sort(laLista, LectoresMarcaComp);

    }

    /**
     * Ordena los producto deacuerdo a su precio
     * @param laLista
     */
    public void ordenaProductosPorPrecio(ArrayList<Producto> laLista) {
        Collections.sort(laLista, Producto.COMPARAPRECIO);
    }

    /**
     * busca los lectores por debajo de un determinado precio
     * @param laLista
     * @param losResultados
     * @param PrecioMax
     * @throws KioskoException
     */
    public void buscaLectoresPrecio(ArrayList<Producto> laLista, ArrayList<Producto> losResultados, double PrecioMax) throws KioskoException {

        Producto auxProducto;/*Producto auxiliar para realizar comparaciones*/
        /*Auxiliares para el tipo de producto concreto */

        Iterator<Producto> iter = laLista.iterator();/*Iterador para recorrer la lista*/

        if (laLista.isEmpty()) {
            throw new KioskoException(KioskoException.SIN_PRODUCTOS);
        } else {

            while (iter.hasNext()) {
                auxProducto = iter.next();

                if (auxProducto.getPrecio() < PrecioMax) {
                    registrarProducto(auxProducto, losResultados);
                } else {

                }

            }
        }

    }

}
