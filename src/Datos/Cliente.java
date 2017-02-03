/*
 * Clase abstracta que sirve de base a los diferentes clientes, solo atributos y metodos get y set
 */
package Datos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ernesto
 */
public abstract class Cliente implements Serializable {

    /**
     *
     */
    protected String nombre;

    /**
     *
     */
    protected String apellidos;
    
    /**
     *
     */
    protected String NIF;

    /**
     *
     */
    protected String nick;

    /**
     *
     */
    protected String email;

    /**
     *
     */
    protected String password;

    /**
     *
     */
    protected long telefono;

    /**
     *
     */
    protected ArrayList<TarjetaCredito> tarjetero; /*No solicitamos una tarjeta de credito en el contructor al añadir un usuario*/

    /**
     *
     */
    protected ArrayList<Producto> compras;

    /**
     *
     */
    protected ArrayList<Producto> librosConsulta;
    
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
    public Cliente(String nombre, String apellidos, String NIF, String nick, String email, String password, long telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        
        this.NIF = NIF;
        this.nick = nick;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.tarjetero = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @return
     */
    public String getNIF() {
        return NIF;
    }

    /**
     *
     * @return
     */
    public String getNick() {
        return nick;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public long getTelefono() {
        return telefono;
    }
    
    /**
     *
     * @return
     */
    public String getTelefonoString() {
        return String.valueOf(telefono);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<TarjetaCredito> getTarjetero() {
        return tarjetero;
    }

    /**
     *
     * @param pos
     * @return
     */
    public TarjetaCredito getTarjeta(int pos) {
        TarjetaCredito auxTarjetaCredito = this.getTarjetero().get(pos);

        return auxTarjetaCredito;

    }

    /**
     *
     * @return
     */
    public ArrayList<Producto> getCompras() {
        return compras;
    }

    /**
     *
     * @return
     */
    public ArrayList<Producto> getLibrosConsulta() {
        return librosConsulta;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @param NIF
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     *
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @param tarjetero
     */
    public void setTarjetero(ArrayList<TarjetaCredito> tarjetero) {
        this.tarjetero = tarjetero;
    }

    /**
     *
     * @param compras
     */
    public void setCompras(ArrayList<Producto> compras) {
        this.compras = compras;
    }
    
    /**
     *
     * @param compra
     */
    public void addCompra(Producto compra){
        compras.add(compra);
    }

    /**
     *
     * @param librosConsulta
     */
    public void setLibrosConsulta(ArrayList<Producto> librosConsulta) {
        this.librosConsulta = librosConsulta;
    }

 
    
}
