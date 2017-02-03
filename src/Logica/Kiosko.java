/*
 * 
 */
package Logica;

import Datos.Factura;
import Datos.Cliente;
import Datos.Estudiante;
import Datos.Producto;
import Datos.Profesor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * En esta clase encontraras las estructuras de datos de la aplicación y los metodos de persistencia
 * @author Ernesto
 * Metodos para guardar los objetos. Libros disponibles, Lectores de libros disponibles, los resultados de las busquedas, las ventas realizadas y los usuarios.
 */
public class Kiosko {
    /*Atributos para guardar los objetos. Libros disponibles, 
     Lectores de libros disponibles, los resultados de las busquedas, 
     las ventas realizadas y los usuarios.*/

    private static ArrayList<Producto> productosDisponibles;
    private static ArrayList<Producto> lectoresDisponibles;
    private static ArrayList<Producto> losResultados;
    private static ArrayList<Factura> ventas;
    private static HashMap<String, Cliente> usuariosRegistrados;
    /*Información de la cuenta para enviar correos*/
    private static String correoDeLaTienda;
    private static String contraseñaCorreo;

    private static Estudiante auxEstudiante;
    private static Profesor auxProfesor;

    /**
     *Constructor de la clase: No requiere ningún parametro. 
     */
    public Kiosko() {

        productosDisponibles = new ArrayList();
        losResultados = new ArrayList();
        lectoresDisponibles = new ArrayList();
        ventas = new ArrayList();
        usuariosRegistrados = new HashMap();

        /*Esto es importante, son los atributos que identifican el correo y la contraeña desde la que se enviaran los correos, es modificable, 
        pero está diseñado únicamente para gmail, cambios mayores requieren revisar la clase Secretario*/
        correoDeLaTienda = "abejotest1@gmail.com";
        contraseñaCorreo = "claremort";
    }

    public static ArrayList<Producto> getproductosDisponibles() {
        return productosDisponibles;
    }

    public static HashMap<String, Cliente> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static void setproductosDisponibles(ArrayList<Producto> productosDisponibles) {
        Kiosko.productosDisponibles = productosDisponibles;
    }

    public static void setUsuariosRegistrados(HashMap<String, Cliente> usuariosRegistrados) {
        Kiosko.usuariosRegistrados = usuariosRegistrados;
    }

    public static ArrayList<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public static ArrayList<Producto> getLosResultados() {
        return losResultados;
    }

    public static void setProductosDisponibles(ArrayList<Producto> productosDisponibles) {
        Kiosko.productosDisponibles = productosDisponibles;
    }

    public static void setLosResultados(ArrayList<Producto> losResultados) {
        Kiosko.losResultados = losResultados;
    }

    public static ArrayList<Producto> getLectoresDisponibles() {
        return lectoresDisponibles;
    }

    public static void setLectoresDisponibles(ArrayList<Producto> lectoresDisponibles) {
        Kiosko.lectoresDisponibles = lectoresDisponibles;
    }

    public static ArrayList<Factura> getVentas() {
        return ventas;
    }

    public static String getCorreoDeLaTienda() {
        return correoDeLaTienda;
    }

    public static String getContraseñaCorreo() {
        return contraseñaCorreo;
    }

    public static void setVentas(ArrayList<Factura> ventas) {
        Kiosko.ventas = ventas;
    }

    public static void setCorreoDeLaTienda(String correoDeLaTienda) {
        Kiosko.correoDeLaTienda = correoDeLaTienda;
    }

    public static void setContraseñaCorreo(String contraseñaCorreo) {
        Kiosko.contraseñaCorreo = contraseñaCorreo;
    }

    public Estudiante getAuxEstudiante() {
        return auxEstudiante;
    }

    public Profesor getAuxProfesor() {
        return auxProfesor;
    }

    public static void setAuxEstudiante(Estudiante auxEstudiante) {
        Kiosko.auxEstudiante = auxEstudiante;
    }

    public static void setAuxProfesor(Profesor auxProfesor) {
        Kiosko.auxProfesor = auxProfesor;
    }

    
    

    /**
     *Metodos para la serialización de datos
     */
    
    public static void cargarDatos() {
        try {
            try ( //Lectura de los objetos de tipo vehiculo de plazas
                    FileInputStream istreamCar = new FileInputStream("copiasegClien.dat")) {
                ObjectInputStream oisCar = new ObjectInputStream(istreamCar);
                usuariosRegistrados = (HashMap) oisCar.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    public static void guardarDatos() {
        try {
            //Si hay datos los guardamos...
            if (!usuariosRegistrados.isEmpty()) {
                try ( /**
                         * **** Serialización de los objetos *****
                         */
                        FileOutputStream ostreamCar = new FileOutputStream("copiasegClien.dat")) {
                    ObjectOutputStream oosCar;
                    oosCar = new ObjectOutputStream(ostreamCar);
                    //guardamos los datos
                    oosCar.writeObject(usuariosRegistrados);
                }
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos

    
    public static void cargarDatosLectores() {
        try {
            try ( //Lectura de los objetos de tipo vehiculo de plazas
                    FileInputStream istreamCar = new FileInputStream("copiaLectores.dat")) {
                ObjectInputStream oisCar = new ObjectInputStream(istreamCar);
                lectoresDisponibles = (ArrayList) oisCar.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    public static void guardarDatosLectores() {
        try {
            //Si hay datos los guardamos...
            if (!lectoresDisponibles.isEmpty()) {
                try ( /**
                         * **** Serialización de los objetos *****
                         */
                        FileOutputStream ostreamCar = new FileOutputStream("copiaLectores.dat")) {
                    ObjectOutputStream oosCar;
                    oosCar = new ObjectOutputStream(ostreamCar);
                    //guardamos los datos
                    oosCar.writeObject(lectoresDisponibles);
                }
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
    

    public static void cargarDatosLibros() {
        try {
            try ( //Lectura de los objetos de tipo vehiculo de plazas
                    FileInputStream istreamCar = new FileInputStream("copiaLibros.dat")) {
                ObjectInputStream oisCar = new ObjectInputStream(istreamCar);
                productosDisponibles = (ArrayList) oisCar.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    public static void guardarDatosLibros() {
        try {
            //Si hay datos los guardamos...
            if (!productosDisponibles.isEmpty()) {
                try ( /**
                         * **** Serialización de los objetos *****
                         */
                        FileOutputStream ostreamCar = new FileOutputStream("copiaLibros.dat")) {
                    ObjectOutputStream oosCar;
                    oosCar = new ObjectOutputStream(ostreamCar);
                    //guardamos los datos
                    oosCar.writeObject(productosDisponibles);
                }
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos



    public static void cargarDatosVentas() {
        try {
            try ( //Lectura de los objetos de tipo vehiculo de plazas
                    FileInputStream istreamCar = new FileInputStream("copiaVentas.dat")) {
                ObjectInputStream oisCar = new ObjectInputStream(istreamCar);
                ventas = (ArrayList) oisCar.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    public static void guardarDatosVentas() {
        try {
            //Si hay datos los guardamos...
            if (!ventas.isEmpty()) {
                try ( /**
                         * **** Serialización de los objetos *****
                         */
                        FileOutputStream ostreamCar = new FileOutputStream("copiaVentas.dat")) {
                    ObjectOutputStream oosCar;
                    oosCar = new ObjectOutputStream(ostreamCar);
                    //guardamos los datos
                    oosCar.writeObject(ventas);
                }
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos

}
