/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Estudiante;
import Datos.TarjetaCredito;
import Datos.Diccionario;
import Datos.LectorDeLibros;
import Datos.LibroDeLectura;
import Datos.LibroDeTexto;
import Datos.Producto;
import Datos.Profesor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 *
 * @author Ernesto
 */
public class LibreriaErnesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws KioskoException {
        // TODO code application logic here

        Kiosko tienda = new Kiosko();
        Secretario alfred = Secretario.getInstance();
        Kioskero igor = Kioskero.getInstance();

        Kiosko.cargarDatos();
        Kiosko.cargarDatosLectores();
        Kiosko.cargarDatosLibros();
        Kiosko.cargarDatosVentas();

        
        /*
        Estudiante Luis = new Estudiante("Luis", "Apellidos", "09052182A", "luis", "ern.domenech@gmail.com", "pass", 618880934);
        TarjetaCredito tarjetaLuis = new TarjetaCredito("Luis Martin Domenech", 980, 567889, (GregorianCalendar) GregorianCalendar.getInstance());

        Estudiante Ernesto = new Estudiante("Ernesto", "Apellidos", "09052182A", "ernesto", "ern.domenech@gmail.com", "pass", 618880934);
        TarjetaCredito tarjetaErnesto = new TarjetaCredito("Ernesto Martin Domenech", 980, 567889, (GregorianCalendar) GregorianCalendar.getInstance());

        Estudiante Juan = new Estudiante("Juan", "Apellidos", "09052182A", "juan", "ern.domenech@gmail.com", "pass", 618880934);
        TarjetaCredito tarjetaJuan = new TarjetaCredito("Juan Martin Domenech", 980, 567889, (GregorianCalendar) GregorianCalendar.getInstance());

        Estudiante Manuel = new Estudiante("Manuel", "Apellidos", "09052182A", "manuel", "ern.domenech@gmail.com", "pass", 618880934);
        TarjetaCredito tarjetaManuel = new TarjetaCredito("Manuel Martin Domenech", 980, 567889, (GregorianCalendar) GregorianCalendar.getInstance());

        Profesor Emilio = new Profesor("Emilio", "Apellidos", "09052182A", "emilio", "ern.domenech@gmail.com", "pass", 618880934);
        TarjetaCredito tarjetaEmilio = new TarjetaCredito("Emilio Martin Domenech", 980, 567889, (GregorianCalendar) GregorianCalendar.getInstance());

        Profesor Pedro = new Profesor("Pedro", "Apellidos", "09052182A", "pedro", "ern.domenech@gmail.com", "pass", 618880934);
        TarjetaCredito tarjetaPedro = new TarjetaCredito("Pedro Martin Domenech", 980, 567889, (GregorianCalendar) GregorianCalendar.getInstance());

        alfred.registraUsuario("luis", Luis, Kiosko.getUsuariosRegistrados());
        alfred.addTarjeta(Luis, tarjetaLuis);
        alfred.registraUsuario("ernesto", Ernesto, Kiosko.getUsuariosRegistrados());
        alfred.addTarjeta(Ernesto, tarjetaErnesto);

        alfred.registraUsuario("juan", Juan, Kiosko.getUsuariosRegistrados());
        alfred.addTarjeta(Juan, tarjetaJuan);

        alfred.registraUsuario("manuel", Manuel, Kiosko.getUsuariosRegistrados());
        alfred.addTarjeta(Manuel, tarjetaManuel);

        alfred.registraUsuario("emilio", Emilio, Kiosko.getUsuariosRegistrados());
        alfred.addTarjeta(Emilio, tarjetaEmilio);

        alfred.registraUsuario("pedro", Pedro, Kiosko.getUsuariosRegistrados());
        alfred.addTarjeta(Pedro, tarjetaPedro);

        LectorDeLibros amazon = new LectorDeLibros("09044582", "Amazon", "El primero", 80.50, "El más antiguo");
        LectorDeLibros amazon1 = new LectorDeLibros("09045231", "Amazon", "El segundo de Amazon", 99.40, "Con pantalla");
        LectorDeLibros amazon2 = new LectorDeLibros("09045831", "Amazon", "El tercero de Amazon", 75.50, "Puedes pasar de pagina al pestañear");
        LectorDeLibros amazon3 = new LectorDeLibros("79045739", "Microsoft", "El de Microsoft", 99.95, "Su luz y su software restringen tu libertad");
        LectorDeLibros amazon4 = new LectorDeLibros("09045131", "Amazon", "El más caro", 105.50, "El más caro, hace lo mismo que los demás");
        LectorDeLibros amazon5 = new LectorDeLibros("09043582", "Microsoft", "El de Microsoft", 80.50, "La pantalla es más pequeña");
        LectorDeLibros amazon6 = new LectorDeLibros("09041231", "Sony", "Muy bien acabado", 99.40, "Con un nuevo formato privativo que nadie más usara nunca");
        LectorDeLibros amazon7 = new LectorDeLibros("09545831", "Sony", "Otro de sony", 75.50, "Viene sin tarjeta, pero puedes comprar una");
        LectorDeLibros amazon8 = new LectorDeLibros("79045739", "Microsoft", "El de Microsoft2", 99.95, "Su luz y su software restringen tu libertad");
        LectorDeLibros amazon9 = new LectorDeLibros("09243161", "Sony", "El último", 105.50, "Tan caro como El más caro");

        igor.registrarProducto(amazon, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon1, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon2, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon3, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon4, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon5, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon6, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon7, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon8, Kiosko.getLectoresDisponibles());
        igor.registrarProducto(amazon9, Kiosko.getLectoresDisponibles());

        LibroDeTexto mates = new LibroDeTexto(111111111, "Mates 1", "Elautor Mates", "laEditorial Mates", (GregorianCalendar) GregorianCalendar.getInstance(), 23.52, 4, "primaria", "matematicas", 1);
        LibroDeTexto mates2 = new LibroDeTexto(111111112, "Mates 2", "Elautor Mates", "laEditorial Mates", (GregorianCalendar) GregorianCalendar.getInstance(), 34.95, 4, "secundaria", "matematicas", 2);
        LibroDeTexto mates3 = new LibroDeTexto(111111113, "Mates 3", "Elautor Mates", "laEditorial Mates", (GregorianCalendar) GregorianCalendar.getInstance(), 31.20, 4, "bachillerato", "matematicas", 3);

        LibroDeTexto sociales = new LibroDeTexto(111111111, "Sociales 1", "Elautor Sociales", "laEditorial Sociales", (GregorianCalendar) GregorianCalendar.getInstance(), 23.52, 4, "primaria", "sociales", 1);
        LibroDeTexto sociales2 = new LibroDeTexto(111111112, "Sociales 2", "Elautor Sociales", "laEditorial Sociales", (GregorianCalendar) GregorianCalendar.getInstance(), 34.95, 4, "secundaria", "sociales", 2);
        LibroDeTexto sociales3 = new LibroDeTexto(111111113, "Sociales 3", "Elautor Sociales", "laEditorial Sociales", (GregorianCalendar) GregorianCalendar.getInstance(), 31.20, 4, "bachillerato", "sociales", 3);

        LibroDeTexto filo = new LibroDeTexto(111111114, "Filosofia 1", "Elautor Filosofia", "laEditorial Filosofia", (GregorianCalendar) GregorianCalendar.getInstance(), 23.52, 4, "primaria", "Filosofia", 1);
        LibroDeTexto filo2 = new LibroDeTexto(111111115, "Filosofia 2", "Elautor Filosofia", "laEditorial Filosofia", (GregorianCalendar) GregorianCalendar.getInstance(), 34.95, 4, "secundaria", "Filosofia", 2);
        LibroDeTexto filo3 = new LibroDeTexto(111111116, "Filosofia 3", "Elautor Filosofia", "laEditorial Filosofia", (GregorianCalendar) GregorianCalendar.getInstance(), 31.20, 4, "bachillerato", "Filosofia", 3);

        Diccionario español = new Diccionario(111111117, "Español-Ingles", "ElautorDiccionario", "laEditorialDiccionario", (GregorianCalendar) GregorianCalendar.getInstance(), 35, 2, "Español", "1º ESO");
        Diccionario español2 = new Diccionario(111111118, "Español-Ingles", "ElautorDiccionario2", "laEditorialDiccionario2", (GregorianCalendar) GregorianCalendar.getInstance(), 23, 2, "Español", "2º ESO");
        Diccionario español3 = new Diccionario(111111110, "Español-Frances", "ElautorDiccionario3", "laEditorialDiccionario3", (GregorianCalendar) GregorianCalendar.getInstance(), 13, 2, "Español", "3º ESO");
        Diccionario español4 = new Diccionario(111111110, "Español-Aleman", "ElautorDiccionario4", "laEditorialDiccionario4", (GregorianCalendar) GregorianCalendar.getInstance(), 35, 2, "Español", "1º ESO");
        Diccionario español5 = new Diccionario(111111120, "Español-Sueco", "ElautorDiccionario5", "laEditorialDiccionario5", (GregorianCalendar) GregorianCalendar.getInstance(), 23, 2, "Español", "2º ESO");
        Diccionario español6 = new Diccionario(111111130, "Español-Ruso", "ElautorDiccionario6", "laEditorialDiccionario6", (GregorianCalendar) GregorianCalendar.getInstance(), 13, 2, "Español", "3º ESO");
        Diccionario español7 = new Diccionario(111111140, "Español-Lengua Común", "ElautorDiccionario7", "laEditorialDiccionario7", (GregorianCalendar) GregorianCalendar.getInstance(), 35, 2, "Español", "1º ESO");
        Diccionario español8 = new Diccionario(111111150, "Español-Klingon", "ElautorDiccionario8", "laEditorialDiccionario8", (GregorianCalendar) GregorianCalendar.getInstance(), 35, 2, "Español", "1º ESO");

        LibroDeLectura LibroDeLectura2 = new LibroDeLectura(111111119, "Las dos torres", "Tolkien", "laEditorialLibroDeLectura2",
                (GregorianCalendar) GregorianCalendar.getInstance(), 6, 2, "Secundaria", "Fantasia", "Los amigos de Frodo se van por otro lado, el sigue el camino");
        LibroDeLectura LibroDeLectura1 = new LibroDeLectura(111111121, "La comunidad del anillo", "Tolkien", "laEditorialLibroDeLectura1",
                (GregorianCalendar) GregorianCalendar.getInstance(), 6, 2, "Secundaria", "Fantasia", "Gandalf le dice a Frodo que vaya a tirar el anillo");
        LibroDeLectura LibroDeLectura3 = new LibroDeLectura(111111122, "El retorno del rey", "Tolkien", "laEditorialLibroDeLectura3",
                (GregorianCalendar) GregorianCalendar.getInstance(), 6, 2, "Secundaria", "Fantasia", "Tercera parte, se acaba");

        LibroDeLectura LibroDeLectura4 = new LibroDeLectura(111111123, "Fundacion", "Asimov", "Editor",
                (GregorianCalendar) GregorianCalendar.getInstance(), 3, 2, "Secundaria", "Ciencia-Ficcion", "La aventura comienza");
        LibroDeLectura LibroDeLectura5 = new LibroDeLectura(111111124, "Fundación e Imperio", "Asimov", "Editor",
                (GregorianCalendar) GregorianCalendar.getInstance(), 3, 2, "Secundaria", "Ciencia-Ficcion", "La aventura sigue");
        LibroDeLectura LibroDeLectura6 = new LibroDeLectura(111111125, "Segunda Fundacion", "Asimov", "Editor",
                (GregorianCalendar) GregorianCalendar.getInstance(), 3, 2, "Secundaria", "Ciencia-Ficcion", "No es el último libro de la saga");

        igor.registrarProducto(mates, Kiosko.getproductosDisponibles());
        igor.registrarProducto(mates2, Kiosko.getproductosDisponibles());
        igor.registrarProducto(mates3, Kiosko.getproductosDisponibles());

        igor.registrarProducto(sociales, Kiosko.getproductosDisponibles());
        igor.registrarProducto(sociales2, Kiosko.getproductosDisponibles());
        igor.registrarProducto(sociales3, Kiosko.getproductosDisponibles());
        igor.registrarProducto(filo, Kiosko.getproductosDisponibles());
        igor.registrarProducto(filo2, Kiosko.getproductosDisponibles());
        igor.registrarProducto(filo3, Kiosko.getproductosDisponibles());

        igor.registrarProducto(español, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español2, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español3, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español4, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español5, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español6, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español7, Kiosko.getproductosDisponibles());
        igor.registrarProducto(español8, Kiosko.getproductosDisponibles());

        igor.registrarProducto(LibroDeLectura1, Kiosko.getproductosDisponibles());
        igor.registrarProducto(LibroDeLectura2, Kiosko.getproductosDisponibles());
        igor.registrarProducto(LibroDeLectura3, Kiosko.getproductosDisponibles());
        igor.registrarProducto(LibroDeLectura4, Kiosko.getproductosDisponibles());
        igor.registrarProducto(LibroDeLectura5, Kiosko.getproductosDisponibles());
        igor.registrarProducto(LibroDeLectura6, Kiosko.getproductosDisponibles());
        
        Pedro.consultaOnline(mates, 0, 6);
        Luis.consultaOnline(mates, 0, 6);
        Ernesto.consultaOnline(mates, 0, 6);
        Juan.consultaOnline(mates, 0, 6);
        Manuel.consultaOnline(mates, 0, 6);
        Emilio.consultaOnline(mates, 0, 6);
        
        Pedro.consultaOnline(mates2, 0, 1);
        Luis.consultaOnline(mates2, 0, 12);
        Ernesto.consultaOnline(mates2, 0, 5);
        Juan.consultaOnline(mates2, 0, 1);
        Manuel.consultaOnline(mates2, 0, 2);
        Emilio.consultaOnline(mates2, 0, 3);
        
        Pedro.consultaOnline(español4, 0, 6);
        Luis.consultaOnline(español4, 0, 6);
        Ernesto.consultaOnline(español4, 0, 6);
        Juan.consultaOnline(español2, 0, 6);
        Manuel.consultaOnline(español4, 0, 6);
        Emilio.consultaOnline(español2, 0, 6);
         
        Pedro.consultaOnline(sociales2, 0, 6);
        Luis.consultaOnline(sociales2, 0, 6);
        Ernesto.consultaOnline(sociales2, 0, 6);
        Juan.consultaOnline(sociales2, 0, 6);
        Manuel.consultaOnline(sociales2, 0, 6);
        Emilio.consultaOnline(sociales2, 0, 6);
          
        Pedro.consultaOnline(sociales2, 0, 6);
        Luis.consultaOnline(sociales, 0, 6);
        Ernesto.consultaOnline(sociales3, 0, 5);
        Juan.consultaOnline(sociales3, 0, 1);
        Manuel.consultaOnline(sociales3, 0, 2);
        Emilio.consultaOnline(sociales3, 0, 4);
        
        Pedro.comprar(filo, 0); 
        Luis.comprar(filo, 0); 
        Ernesto.comprar(filo, 0); 
        Juan.comprar(filo, 0); 
        Manuel.comprar(filo, 0); 
        Emilio.comprar(filo, 0); 
        
         Pedro.comprar(LibroDeLectura1, 0); 
        Luis.comprar(LibroDeLectura1, 0); 
        Ernesto.comprar(LibroDeLectura1, 0); 
        Juan.comprar(LibroDeLectura1, 0); 
        Manuel.comprar(LibroDeLectura1, 0); 
        Emilio.comprar(LibroDeLectura1, 0); 
        
         Pedro.comprar(LibroDeLectura2, 0); 
        Luis.comprar(LibroDeLectura2, 0); 
        Ernesto.comprar(LibroDeLectura2, 0); 
        Juan.comprar(LibroDeLectura2, 0); 
        Manuel.comprar(LibroDeLectura2, 0); 
        Emilio.comprar(LibroDeLectura2, 0);
        
         Pedro.comprar(LibroDeLectura5, 0); 
        Luis.comprar(LibroDeLectura5, 0); 
        Ernesto.comprar(LibroDeLectura5, 0); 
        Juan.comprar(LibroDeLectura5, 0); 
        Manuel.comprar(LibroDeLectura5, 0); 
        Emilio.comprar(LibroDeLectura5, 0); 
        
        
        */
    
        Kiosko.guardarDatos();
        Kiosko.guardarDatosLectores();
        Kiosko.guardarDatosLibros();
        Kiosko.guardarDatosVentas();

    }
}
