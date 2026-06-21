import java.time.LocalDateTime;

public abstract class Base {
    private Long id;
    private boolean eliminado;
    private LocalDateTime createAt;

    public Base() {
        this.eliminado = false;
        this.createAt = LocalDateTime.now();
    }

    // --- SETTERS ---

    public void setId(Long id) {
        this.id = id;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    // --- GETTERS ---

    public Long getId() {
        return id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public abstract String toString();
}