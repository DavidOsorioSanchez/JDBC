package Database;

import java.util.List;

public interface CRUDEspecializacion {

    public Object insertarEspecialidad(Object object);
    public boolean actualizarEspecialidad(Object object);
    public  boolean eliminarEspecialidad(Object object);
    public List<Object> encontrarEspecialidad();

}
