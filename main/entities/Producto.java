package entities;

import java.time.LocalDateTime;
import exceptions.StockInvalidoException;
import exceptions.ValidacionEntradaException;

public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;
    private Categoria categoria;

    public Producto(String nombre, Double precio, String descripcion, int stock, String imagen, Categoria categoria) throws StockInvalidoException, ValidacionEntradaException {
        super();
        setNombre(nombre);
        setPrecio(precio);
        setDescripcion(descripcion);
        setStock(stock);
        setImagen(imagen);
        setCategoria(categoria);
        setDisponible(stock > 0);
    }

    // Constructor para JDBC (recuperar de MySQL)
    public Producto(Long id, boolean eliminado, LocalDateTime createAt, String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible, Categoria categoria) throws StockInvalidoException, ValidacionEntradaException {
        this.setId(id);
        this.setEliminado(eliminado);
        this.setCreateAt(createAt);

        setNombre(nombre);
        setPrecio(precio);
        setDescripcion(descripcion);
        setStock(stock);
        setImagen(imagen);
        setDisponible(disponible);
        setCategoria(categoria);
    }

    //setters
    private void setNombre(String nombre) throws ValidacionEntradaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: El nombre del producto es obligatorio.");
        }
        this.nombre = nombre;
    }

    private void setPrecio(Double precio) throws ValidacionEntradaException {
        if (precio == null || precio < 0) {
            throw new ValidacionEntradaException("Error: El precio no puede ser menor a 0.");
        }
        this.precio = precio;
    }

    private void setDescripcion(String descripcion) throws ValidacionEntradaException {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: La descripcion del producto es obligatoria.");
        }
        this.descripcion = descripcion;
    }

    private void setStock(int stock) throws StockInvalidoException {
        if (stock < 0) {
            throw new StockInvalidoException("Error: El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    private void setImagen(String imagen) throws ValidacionEntradaException {
        if (imagen == null || imagen.trim().isEmpty()) {
            throw new ValidacionEntradaException("Error: La imagen del producto es obligatoria.");
        }
        this.imagen = imagen;
    }

    private void setDisponible(Boolean disponible) {
        if (disponible != null) this.disponible = disponible;
    }

    private void setCategoria(Categoria categoria) {
        if (categoria != null) this.categoria = categoria;
    }

    //getters
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
    public String getDescripcion() { return descripcion; }
    public int getStock() { return stock; }
    public String getImagen() { return imagen; }
    public Boolean getDisponible() { return disponible; }
    public Categoria getCategoria() { return categoria; }

    //ToString
    @Override
    public String toString() {
        return String.format("entities.Producto [ID=%d] %s | Precio: $%.2f | Stock: %d | Categoría: %s",
                getId(), nombre, precio, stock, categoria.getNombre());
    }
}