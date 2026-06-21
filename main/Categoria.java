import java.time.LocalDateTime;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        super();
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    //  Constructor para JDBC (recuperar de MySQL)
    public Categoria(Long id, boolean eliminado, LocalDateTime createAt, String nombre, String descripcion) {
        // Asignamos los valores de la clase padre
        this.setId(id);
        this.setEliminado(eliminado);
        this.setCreateAt(createAt);
        // Asignamos los valores propios
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    //setters
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isEmpty()) {
            this.descripcion = descripcion;
        }
    }

    //getters
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    //toString
    @Override
    public String toString() {
        return "Categoría [ID=" + getId() + "] " + nombre + " - " + descripcion;
    }
}