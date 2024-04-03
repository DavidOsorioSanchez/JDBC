package Database;

import java.util.List;

public interface CRUDMedico {

    public Object insertarMedico(Object object);
    public boolean actualizarMedico(Object object);
    public  boolean eliminarMedico(Object object);
    public List<Object> encontrarMedico();


}
