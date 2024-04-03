package Database;

import java.util.List;

public interface CRUDCita {

    public Object insertarCita(Object object);
    public boolean actualizarCita(Object object);
    public  boolean eliminarCita(Object object);
    public List<Object> encontrarCita();

}
