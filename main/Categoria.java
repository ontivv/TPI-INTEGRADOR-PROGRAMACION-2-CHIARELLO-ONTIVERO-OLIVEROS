
import java.util.ArrayList;
import java.util.List;

public class Categoria extends Base
{
    private String nombre;
    private String descripcion;
    
    public Categoria (String nombre,String descripcion)
    {
        super();
        setNombre(nombre);
        setDescripcion(descripcion);
        
    }
//setters
    public void setNombre(String nombre) {
        if (nombre!=null && !nombre.isEmpty())
        {
            this.nombre = nombre;
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion!=null && !descripcion.isEmpty())
        {
            this.descripcion = descripcion;
        }
    }
    
    
//getters

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
