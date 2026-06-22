package entities;

import enums.Rol;
import exceptions.ValidacionEntradaException;
import java.time.LocalDateTime;

public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;


    public Usuario(String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) throws ValidacionEntradaException {
        super();
        setNombre(nombre);
        setApellido(apellido);
        setMail(mail);
        setCelular(celular);
        setContraseña(contraseña);
        setRol(rol);
    }

    //  CONSTRUCTOR PARA JDBC
    public Usuario(Long id, boolean eliminado, LocalDateTime createAt, String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) throws ValidacionEntradaException {
        this.setId(id);
        this.setEliminado(eliminado);
        this.setCreateAt(createAt);

        setNombre(nombre);
        setApellido(apellido);
        setMail(mail);
        setCelular(celular);
        setContraseña(contraseña);
        setRol(rol);
    }

    // --- SETTERS ---
    public void setNombre(String nombre) throws ValidacionEntradaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: El nombre es obligatorio.");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) throws ValidacionEntradaException{
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: El apellido es obligatorio.");
        }
        this.apellido = apellido;
    }

    public void setMail(String mail) throws ValidacionEntradaException {
        if (mail == null || mail.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: El correo electrónico es obligatorio.");
        }
        this.mail = mail;
    }

    public void setCelular(String celular) throws ValidacionEntradaException {
        if (celular == null || celular.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: El celular electrónico es obligatorio.");
        }
        this.celular = celular;
    }

    public void setContraseña(String contraseña) throws ValidacionEntradaException {
        if (contraseña == null || contraseña.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: La contraseña no puede estar vacía.");
        }
        this.contraseña = contraseña;
    }

    public void setRol(Rol rol) {
        if (rol != null) {
            this.rol = rol;
        }
    }

    // --- GETTERS ---
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public String getCelular() {
        return celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    //ToString
    @Override
    public String toString() {
        return "entities.Usuario [ID=" + getId() + "] " + nombre + " " + apellido + " | Correo: " + mail + " | enums.Rol: " + rol;
    }

}