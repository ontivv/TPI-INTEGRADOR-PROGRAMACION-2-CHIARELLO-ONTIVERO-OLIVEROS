
import java.time.LocalDateTime;

public abstract class Base 
{
    private Long id;
    private boolean eliminado;
    private LocalDateTime createAt;
    private static Long ref = 0L;
    
    public Base()
    {
        ref++;
        this.id=ref;
        eliminado=false;
        this.createAt=LocalDateTime.now();
    }

    // Setters
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    public boolean isEliminado() {
        return eliminado;
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public static Long getRef() {
        return ref;
    }

    public abstract String toString(); 
}
