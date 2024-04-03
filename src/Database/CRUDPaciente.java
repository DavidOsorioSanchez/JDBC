package Database;

import java.util.List;

public interface CRUDPaciente {

    public Object insertarPaciente(Object object);
    public boolean actualizarPaciente(Object object);
    public  boolean eliminarPaciente(Object object);
    public List<Object> encontrarPaciente();

}
