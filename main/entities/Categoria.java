package entities;

import exceptions.ValidacionEntradaException;
import java.time.LocalDateTime;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) throws ValidacionEntradaException {
        super();
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    //  Constructor para JDBC (recuperar de MySQL)
    public Categoria(Long id, boolean eliminado, LocalDateTime createAt, String nombre, String descripcion) throws ValidacionEntradaException {
        this.setId(id);
        this.setEliminado(eliminado);
        this.setCreateAt(createAt);

        setNombre(nombre);
        setDescripcion(descripcion);
    }

    //setters
    public void setNombre(String nombre) throws ValidacionEntradaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: El nombre de la categoría no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) throws ValidacionEntradaException {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: La descripción de la categoría no puede estar vacía.");
        }
        this.descripcion = descripcion;
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