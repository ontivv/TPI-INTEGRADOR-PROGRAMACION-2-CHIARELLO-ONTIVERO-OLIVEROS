import java.time.LocalDateTime;

public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;
    private Categoria categoria;

    public Producto(String nombre, Double precio, String descripcion, int stock, String imagen, Categoria categoria) {
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
    public Producto(Long id, boolean eliminado, LocalDateTime createAt, String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible, Categoria categoria) {
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
    public void setNombre(String nombre) {
        if(nombre != null && !nombre.isEmpty()) this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        if (precio != null && precio >= 0) this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null) this.descripcion = descripcion;
    }

    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
    }

    public void setImagen(String imagen) {
        if (imagen != null && !imagen.isEmpty()) this.imagen = imagen;
    }

    public void setDisponible(Boolean disponible) {
        if (disponible != null) this.disponible = disponible;
    }

    public void setCategoria(Categoria categoria) {
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
        return String.format("Producto [ID=%d] %s | Precio: $%.2f | Stock: %d | Categoría: %s",
                getId(), nombre, precio, stock, categoria.getNombre());
    }
}