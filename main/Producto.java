
class Producto extends Base
{
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;
    private Categoria categoria;
    
    public Producto (String nombre,Double precio,String descripcion,int stock,String imagen,Categoria categoria)
    {
        super();
        setNombre(nombre);
        setPrecio(precio);
        setDescripcion(descripcion);
        setStock(stock);
        setImagen(imagen);
        setCategoria(categoria);
        setDisponible(false);
    }
    
    //setters
    public void setNombre(String nombre)
    {
        if(nombre!=null)
        {
            this.nombre=nombre;
        }
    }

    public void setPrecio(Double precio) {
        if (precio!=null && precio >=0)
        {
            this.precio=precio;
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion!=null)
        {
            this.descripcion = descripcion;
        }
    }

    public void setStock(int stock) {
        if (stock>=0)
        {
            this.stock = stock;
        }
    }

    public void setImagen(String imagen) {
        if (imagen!=null && !imagen.isEmpty())
        {
            this.imagen = imagen;
        }
    }

    public void setDisponible(Boolean disponible) {
        if (disponible !=null)
        {
            this.disponible = disponible;
        }
    }
    
    public void setCategoria(Categoria categoria)
    {
        if (categoria!=null)
        {
            this.categoria=categoria;
        }
    }
    
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public String getImagen() {
        return imagen;
    }

    public Boolean getDisponible() {
        return disponible;
    }
    
    
   
    public Categoria getCategoria() {
        return categoria;
    }
    
    
    
    
    
}
