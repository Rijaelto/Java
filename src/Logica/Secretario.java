package Logica;

import Datos.Factura;
import Datos.Cliente;
import Datos.TarjetaCredito;
import Datos.Diccionario;
import Datos.LectorDeLibros;
import Datos.LibroDeLectura;
import Datos.LibroDeTexto;
import Datos.Producto;
import Datos.PublicacionDigital;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Esta clase se encarga de gestionar los usuarios del Kiosko y de todo lo
 * relacionado con verificar y comprobar los datos. Se utiliza el patron
 * Singleton.
 *
 * @author ernesto
 */
public class Secretario {

    private static Secretario instance;

    private Secretario() {

    }

    /**
     *
     * @return Nos devuelve la instancia del Secretario
     */
    public static Secretario getInstance() {
        if (instance == null) {
            instance = new Secretario();
        }
        return instance;
    }

    /**
     * Metodo para registrar un usuario en el hashmap del kiosko
     *
     * @param nick
     * @param usuario
     * @param usuariosRegistrados
     * @throws KioskoException
     */
    public void registraUsuario(String nick, Cliente usuario, HashMap<String, Cliente> usuariosRegistrados)
            throws KioskoException {

        if (usuariosRegistrados.containsKey(nick)) {/*Se comprueba el usuario y se controla el error*/

            throw new KioskoException(KioskoException.USUARIO_EXISTENTE);
        } else {
            usuariosRegistrados.put(nick, usuario);
        }
    }

    /**
     * Metodo para borrar un usuario del hashmap del kiosko
     *
     * @param nick
     * @param usuario
     * @param usuariosRegistrados
     * @throws KioskoException
     */
    public void borraUsuario(String nick, HashMap<String, Cliente> usuariosRegistrados)
            throws KioskoException {

        if (usuariosRegistrados.containsKey(nick)) {/*Se comprueba antes de borrar y se controla el error*/

            usuariosRegistrados.remove(nick);

        } else {
            throw new KioskoException(KioskoException.USUARIO_INEXISTENTE);
        }
    }

    /**
     * Comprueba la existencia de un usuario
     *
     * @param nick
     * @param laLista
     * @return
     */
    public boolean existeUsuario(String nick, HashMap<String, Cliente> laLista) {

        boolean existe = true;

        try {

            boolean dentro;
            dentro = laLista.containsKey(nick);
            if (dentro != true) {
                throw new KioskoException(KioskoException.USUARIO_INEXISTENTE);

            } else {
                existe = true;
            }
        } catch (NullPointerException o) {
            System.out.println("\nPuntero nulo\n");

        } catch (Exception e) {

            System.out.println("Excepción: " + e.toString());
        }

        return existe;

    }

    /**
     * Este metodo nos indica si un DNI es correcto o incorrecto
     *
     * @param dni
     * @return
     */
    public boolean compruebaDni(String dni) {
        boolean correcto = true;
        char letraDni;
        char letraCalculada;/*Variables para la comprobación*/

        int dniNum;
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
            'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int pos;

        if (dni.length() != 9) {/*Comprobación de la longitud de la cadena*/

            correcto = false;

        } else {
            dni = dni.toUpperCase();/*Letra a mayuscula*/

            letraDni = dni.charAt(8);/*Separamos la letra*/

            dniNum = Integer.parseInt(dni.substring(0, 8));/*Separamos los numeros*/

            pos = dniNum % 23;/*Operación para obtener la letra*/

            letraCalculada = letras[pos];/*Comprobación de la letra*/

            if (letraDni != letraCalculada) {
                correcto = false;
            }

        }

        return correcto;
    }

    /**
     * Este metodo nos indica si un telefono es correcto
     *
     * @param tlf
     * @return
     */
    public boolean compruebaTelefono(long tlf) {
        boolean correcto;

        if (tlf > 900000000 && tlf < 1000000000 || tlf > 600000000 && tlf < 800000000) {//si cumple los requisitos lo almacenamos y la variable correcto cierra el bucle

            correcto = true;
        } else {
            correcto = false;
        }

        return correcto;
    }

    /**
     * Este metodo lo usamos para separar una cadena por los espacios, muy útil
     * para la busqueda
     *
     * @param comando
     * @return
     */
    public ArrayList<String> separaLaCadena(String comando) {
        ArrayList<String> tokens;

        /*Partimos la cadena por los espacios*/
        String[] auxTokens = comando.split(" ");
        /*transformamos el array en un arraylist mediante los metodos de la clase*/
        tokens = new ArrayList(Arrays.asList(auxTokens));
        return tokens;
    }

    /**
     * Este metodo es para quitar espacios al final y al principio y poner la
     * inicial de cada palabra en mayuscula
     *
     * @param comando
     * @return
     */
    public String preparaTextoNombre(String comando) {
        /*Quitamos los espacios al principio y al final*/
        comando = comando.trim();
        char[] comandoCorrecto = comando.toCharArray();
        comandoCorrecto[0] = Character.toUpperCase(comandoCorrecto[0]);
        /*Recorremos el nuevo Array para poner las iniciales en mayuscula*/
        for (int i = 0; i < comando.length() - 2; i++) {/*De esta manera evitamos posibles excepciones*/

            if (comandoCorrecto[i] == ' ' || comandoCorrecto[i] == '.' || comandoCorrecto[i] == ',') {
                comandoCorrecto[i + 1] = Character.toUpperCase(comandoCorrecto[i + 1]);
            }
        }

        return new String(comandoCorrecto);
    }

    /**
     * Se añade una tarjeta de credito
     *
     * @param cliente
     * @param tarjeta
     * @throws KioskoException
     */
    public void addTarjeta(Cliente cliente, TarjetaCredito tarjeta) /*http://ricardogeek.com/como-validar-tarjetas-de-credito/*/
            throws KioskoException {

        if (cliente.getTarjetero().contains(tarjeta)) {/*Se comprueba el producto y se controla el error*/

            throw new KioskoException(KioskoException.TARJETA_EXISTENTE);
        } else {

            cliente.getTarjetero().add(tarjeta);
        }

    }

    /**
     * Se elimina una tarjeta de credito
     *
     * @param tarjeta
     * @param cliente
     * @throws KioskoException
     */
    public void removeTarjeta(TarjetaCredito tarjeta, Cliente cliente)
            throws KioskoException {

        if (cliente.getTarjetero().contains(tarjeta)) {/*Se comprueba el producto y se controla el error*/

            cliente.getTarjetero().remove(tarjeta);

        } else {
            throw new KioskoException(KioskoException.TARJETA_INEXISTENTE);

        }

    }

    /**
     * Realiza una compra, este metodo realiza los pasos uno por uno
     *
     * @param cliente
     * @param pos
     * @param producto
     * @param precioFinal
     */
    public void gestionaLaCompra(Cliente cliente, int pos, Producto producto, Double precioFinal) throws KioskoException {
        String nombreArchivo;

        if (cliente.getCompras().contains(producto)) {
            throw new KioskoException(KioskoException.COMPRA_YAREALIZADA);
        } else {

            Factura compraRealizada = new Factura(cliente.getTarjeta(pos), cliente, (GregorianCalendar) GregorianCalendar.getInstance(), producto, precioFinal);/*objeto factura*/

            Kiosko.getVentas().add(compraRealizada);/*Lo guardamos para el futuro*/

            cliente.addCompra(producto);/*Añadimos el producto a la lista del cliente*/

            nombreArchivo = facturaEnTexto(compraRealizada);/*Sacamos la factura en texto*/

            envioCorreoAutomatico(cliente.getEmail(), compraRealizada, nombreArchivo);
        }
    }

    public void gestionaLaConsulta(Cliente cliente, int pos, PublicacionDigital producto, Double precioFinal, int meses) throws KioskoException {
        String nombreArchivo;
        int mes = 30;

        if (cliente.getCompras().contains(producto)) {
            GregorianCalendar fechaActual = (GregorianCalendar) GregorianCalendar.getInstance();
            GregorianCalendar fechaInicioConsulta = producto.getFechaInicioConsulta();
            GregorianCalendar fechaFinalizacionConsulta = (GregorianCalendar) GregorianCalendar.getInstance();
            int mesesDeConsulta = meses * mes;
            fechaFinalizacionConsulta.add(Calendar.DATE, mesesDeConsulta);

            if (fechaActual.before(fechaFinalizacionConsulta)) {
                
                producto.setPrecio(producto.getPrecioConsulta()*meses);
                producto.setFechaInicioConsulta((GregorianCalendar) GregorianCalendar.getInstance());
                producto.setMesesConsulta(meses);
                Factura consultaRealizada = new Factura(cliente.getTarjeta(pos), cliente, (GregorianCalendar) GregorianCalendar.getInstance(), producto, precioFinal*meses);/*objeto factura*/
                cliente.addCompra(producto);/*Añadimos el producto a la lista del cliente*/

                nombreArchivo = facturaEnTexto(consultaRealizada);/*Sacamos la factura en texto*/

                envioCorreoAutomatico(cliente.getEmail(), consultaRealizada, nombreArchivo);
                Kiosko.getVentas().add(consultaRealizada);
            } else {
                throw new KioskoException(KioskoException.COMPRA_YAREALIZADA);
            }

        } else {

            
            producto.setPrecio(producto.getPrecioConsulta()*meses);
            producto.setFechaInicioConsulta((GregorianCalendar) GregorianCalendar.getInstance());
            producto.setMesesConsulta(meses);
            Factura consultaRealizada = new Factura(cliente.getTarjeta(pos), cliente, (GregorianCalendar) GregorianCalendar.getInstance(), producto, precioFinal*meses);/*objeto factura*/

            Kiosko.getVentas().add(consultaRealizada);/*Lo guardamos para el futuro*/
            cliente.addCompra(producto);/*Añadimos el producto a la lista del cliente*/

            nombreArchivo = facturaEnTexto(consultaRealizada);/*Sacamos la factura en texto*/

            envioCorreoAutomatico(cliente.getEmail(), consultaRealizada, nombreArchivo);

        }
    }

    /**
     * este metodo es útil para poner chivatos en el codigo
     *
     * @param txt
     */
    public void escribe(String txt) {

        System.out.println(txt);

    }

    /**
     * Metodo para enviar un email automatico con cada compra Los datos están
     * predefinidos para gmail, el correo y la contraseña deben establecerse en
     * la clase Kiosko
     *
     * @param destinatario
     * @param factura
     * @param nombreArchivo
     */
    public void envioCorreoAutomatico(String destinatario, Factura factura, String nombreArchivo) {
        String cad1, cad2;
        cad1 = "Librería online " + factura.getFechaString();
        cad2 = "Gracias por utilizar nuestra plataforma, que también es tuya, esperamos que disfrutes de tu compra. Recuerda que el ID de tu compra es: " + factura.getID();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Kiosko.getCorreoDeLaTienda(), Kiosko.getContraseñaCorreo());
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Kiosko.getCorreoDeLaTienda()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(cad1);

            BodyPart cuerpoMensaje = new MimeBodyPart();
            cuerpoMensaje.setText(cad2);

            Multipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(cuerpoMensaje);

            cuerpoMensaje = new MimeBodyPart();

            DataSource fuente = new FileDataSource(nombreArchivo);
            cuerpoMensaje.setDataHandler(new DataHandler(fuente));
            cuerpoMensaje.setFileName(nombreArchivo);
            multiparte.addBodyPart(cuerpoMensaje);

            message.setContent(multiparte);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para enviar un email sencillo
     *
     * @param destinatario
     * @param asunto
     * @param cuerpo
     */
    public void SendMail(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Kiosko.getCorreoDeLaTienda(), Kiosko.getContraseñaCorreo());
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Kiosko.getCorreoDeLaTienda()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Proceso pra generar el archivo factura, devuelve una cadena con el nombre
     * del archivo
     *
     * @param factura
     * @return
     */
    public static String facturaEnTexto(Factura factura) {

        /*Declaramos las cadenas que utilizaremos en la factura*/
        String cad1, cad2, cad3, cad4, cad5, cad6, cad7, cad8, cad9, cad10, cad11, cad12,cad13;
        cad1 = "Factura Libreria Online ";
        cad2 = "ID ";
        cad3 = Integer.toString(factura.getID());
        cad4 = "PN ";
        cad5 = Integer.toString(((factura.getProducto()).getID()));
        cad6 = cad1 + cad2 + cad3 + cad4 + cad5 + ".txt";

        cad7 = "GRACIAS POR COMPRAR EN LA LIBRERIA ONLINE";
        cad8 = "SU COMPRA FUE REALIZADA CON EXITO EL:";
        cad9 = "USTED ADQUIRIO:";
        cad10 = " ";
        cad11 = "Precio antes del descuento: ";
        cad12 = "Precio despues del descuento: ";
        cad13= " ";

        /*Primero utilizamos el kioskero para saber que tipo de producto tiene la factura*/
        Kioskero igor = Kioskero.getInstance();
        /*Producto auxiliar para realizar comparaciones*/
        Producto auxProducto;
        /*Auxiliares para el tipo de producto concreto */
        LibroDeTexto auxLibroDeTexto;
        LibroDeLectura auxLibroDeLectura;
        Diccionario auxDiccionario;/**/

        LectorDeLibros auxLectorDeLibros;
        /*variable para guardar el valor retornado por el metodo determinaElProducto*/
        int tipoDeProducto;
        /*Obtenemos el producto de la factura*/
        auxProducto = factura.getProducto();
        /*Llamada al metodo que nos indica a que clase concreta pertenece el producto*/
        tipoDeProducto = igor.determinaElProducto(auxProducto);

        /*Este switch nos permite obtener la informacion necesaria para escribir la factura*/
        switch (tipoDeProducto) {
            case 1: /*En este caso sabemos que es un LibroDeTexto*/

                auxLibroDeTexto = igor.modeladoLibroDeTexto(auxProducto);/*Modelamos el producto en un LibroDeTexto*/

                cad10 = auxLibroDeTexto.toString();
                cad13 = Double.toString(auxLibroDeTexto.getPrecio()) + " o " + Double.toString(auxLibroDeTexto.getPrecioConsulta())+ " (por mes de consulta)";
                break;
            case 2:/*En este caso sabemos que es un LibroDeLectura*/

                auxLibroDeLectura = igor.modeladoLibroDeLectura(auxProducto);/*Modelamos el producto en un LibroDeLectura*/

                cad10 = auxLibroDeLectura.toString();
                cad13 = Double.toString(auxLibroDeLectura.getPrecio()) + " o " + Double.toString(auxLibroDeLectura.getPrecioConsulta())+ " (por mes de consulta)";
                break;
            case 3:/*En este caso sabemos que es un Diccionario*/

                auxDiccionario = igor.modeladoDiccionario(auxProducto);/*Modelamos el producto en un Diccionario*/

                cad10 = auxDiccionario.toString();
                cad13 = Double.toString(auxDiccionario.getPrecio()) + " o " + Double.toString(auxDiccionario.getPrecioConsulta()) + " (por mes de consulta)";
                break;
            case 4:/*En este caso sabemos que es un LectorDeLibros*/

                auxLectorDeLibros = igor.modeladoLectorDeLibros(auxProducto);
                cad10 = auxLectorDeLibros.toString();
                cad13 = Double.toString(auxLectorDeLibros.getPrecio());
                break;
        }

        /*Escribimos el archivo*/
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cad6));
            bw.write(cad7);
            bw.newLine();
            bw.newLine();
            bw.newLine();
            bw.write(cad8);
            bw.newLine();
            bw.write(factura.getFechaString());
            bw.newLine();
            bw.newLine();
            bw.write(cad9);
            bw.write(cad10);
            bw.newLine();
            bw.newLine();
            bw.newLine();
            bw.write(cad11);
            bw.write(cad13);
            bw.write(" Euros");
            bw.newLine();
            bw.newLine();
            bw.write(cad12);
            bw.write(Double.toString(factura.getPrecioFinal()));
            bw.write(" Euros");
            bw.newLine();
            bw.flush();

            //Cerramos el stream
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.toString());
        }
        return cad6;
    }

}
