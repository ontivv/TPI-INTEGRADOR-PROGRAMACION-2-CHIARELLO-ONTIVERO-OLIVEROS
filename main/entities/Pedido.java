package entities;

import enums.Estado;
import enums.FormaPago;
import exceptions.StockInvalidoException;
import exceptions.ValidacionEntradaException;
import interfaces.Calculable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;
    private List<DetallePedido> detalles;

    public Pedido(FormaPago formaPago, Usuario usuario) throws ValidacionEntradaException {
        super();
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE; // Todo pedido nuevo arranca Pendiente
        this.total = 0.0;
        this.detalles = new ArrayList<>();
        setUsuario(usuario);
        setFormaPago(formaPago);
    }

    // Constructor para JDBC
    public Pedido(Long id, boolean eliminado, LocalDateTime createAt, LocalDate fecha, Estado estado, Double total, FormaPago formaPago, Usuario usuario) throws ValidacionEntradaException {
        this.setId(id);
        this.setEliminado(eliminado);
        this.setCreateAt(createAt);
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.detalles = new ArrayList<>();
        setUsuario(usuario);
        setFormaPago(formaPago);
    }

    @Override
    public void calcularTotal() {
        double suma = 0.0;
        for (DetallePedido detalle : detalles) {
            if (!detalle.isEliminado()) {
                suma += detalle.getSubtotal();
            }
        }
        this.total = suma;
    }

    public void addDetallePedido(int cantidad, Double precio, Producto producto) throws StockInvalidoException, ValidacionEntradaException {
        if (producto.getStock() < cantidad) {
            throw new StockInvalidoException("Error: Stock insuficiente para el producto " + producto.getNombre() + ". Stock disponible: " + producto.getStock());
        }

        DetallePedido nuevoDetalle = new DetallePedido(cantidad, producto);
        this.detalles.add(nuevoDetalle);

        calcularTotal();
    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detalle = findeDetallePedidoByProducto(producto);
        if (detalle != null) {
            this.detalles.remove(detalle);
            calcularTotal();
        }
    }

    // --- SETTERS CON VALIDACIÓN ---

    public void setUsuario(Usuario usuario) throws ValidacionEntradaException {
        if (usuario == null || usuario.isEliminado()) {
            throw new ValidacionEntradaException("Error: Un pedido debe tener un usuario asociado no eliminado.");
        }
        this.usuario = usuario;
    }

    public void setFormaPago(FormaPago formaPago) throws ValidacionEntradaException {
        if (formaPago == null) {
            throw new ValidacionEntradaException("Error: La forma de pago es obligatoria.");
        }
        this.formaPago = formaPago;
    }

    public void setEstado(Estado estado) throws ValidacionEntradaException {
        if (formaPago == null) {
            throw new ValidacionEntradaException("Error: El estado es obligatorio.");
        }
        this.formaPago = formaPago;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        if (detalles != null) {
            this.detalles = detalles;
            calcularTotal();
        }
    }

    // --- GETTERS ---

    public LocalDate getFecha() { return fecha; }
    public Estado getEstado() { return estado; }
    public Double getTotal() { return total; }
    public FormaPago getFormaPago() { return formaPago; }
    public Usuario getUsuario() { return usuario; }
    public List<DetallePedido> getDetalles() { return detalles; }

    @Override
    public String toString() {
        return String.format("Pedido [ID=%d] | Fecha: %s | Cliente: %s %s | Estado: %s | Total: $%.2f",
                getId(), fecha, usuario.getNombre(), usuario.getApellido(), estado, total);
    }
}