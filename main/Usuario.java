import java.time.LocalDateTime;

public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;


    public Usuario(String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        super();
        setNombre(nombre);
        setApellido(apellido);
        setMail(mail);
        setCelular(celular);
        setContraseña(contraseña);
        setRol(rol);
    }

    //  NUEVO - CONSTRUCTOR PARA JDBC
    public Usuario(Long id, boolean eliminado, LocalDateTime createAt, String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        // Acá no llamamos a super() vacío para no generar un ID nuevo accidentalmente
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
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.isEmpty()) {
            this.apellido = apellido;
        }
    }

    public void setMail(String mail) {
        if (mail != null && !mail.isEmpty()) {
            this.mail = mail;
        }
    }

    public void setCelular(String celular) {
        if (celular != null && !celular.isEmpty()) {
            this.celular = celular;
        }
    }

    public void setContraseña(String contraseña) {
        if (contraseña != null && !contraseña.isEmpty()) {
            this.contraseña = contraseña;
        }
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
        return "Usuario [ID=" + getId() + "] " + nombre + " " + apellido + " | Correo: " + mail + " | Rol: " + rol;
    }

}