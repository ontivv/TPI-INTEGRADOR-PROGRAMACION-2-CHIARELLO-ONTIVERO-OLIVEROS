package entities;

import exceptions.ValidacionEntradaException;
import java.time.LocalDateTime;

public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido(int cantidad, Producto producto) throws ValidacionEntradaException {
        super();
        setProducto(producto);
        setCantidad(cantidad); // El setter calcula automáticamente el subtotal
    }

    // Constructor para JDBC
    public DetallePedido(Long id, boolean eliminado, LocalDateTime createAt, int cantidad, Double subtotal, Producto producto) throws ValidacionEntradaException {
        this.setId(id);
        this.setEliminado(eliminado);
        this.setCreateAt(createAt);
        this.producto = producto;
        this.subtotal = subtotal;
        setCantidad(cantidad);
    }

    // --- SETTERS CON VALIDACIÓN ---

    public void setCantidad(int cantidad) throws ValidacionEntradaException {
        if (cantidad <= 0) {
            throw new ValidacionEntradaException("Error: La cantidad del producto en el detalle debe ser mayor a 0.");
        }
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public void setProducto(Producto producto) throws ValidacionEntradaException {
        if (producto == null) {
            throw new ValidacionEntradaException("Error: El detalle debe estar asociado a un producto válido.");
        }
        this.producto = producto;
    }

    private void calcularSubtotal() {
        if (this.producto != null) {
            this.subtotal = this.cantidad * this.producto.getPrecio();
        }
    }

    // --- GETTERS ---

    public int getCantidad() { return cantidad; }
    public Double getSubtotal() { return subtotal; }
    public Producto getProducto() { return producto; }

    @Override
    public String toString() {
        return String.format("%s x%d | Subtotal: $%.2f", producto.getNombre(), cantidad, subtotal);
    }
}