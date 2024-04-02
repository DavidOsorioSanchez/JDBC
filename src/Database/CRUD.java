package Database;

import java.util.List;

public interface CRUD {

    public Object insertarCita(Object object);
    public boolean actualizarCita(Object object);
    public  boolean eliminarCita(Object object);
    public List<Object> encontrarCita();

    public Object insertarMedico(Object object);
    public boolean actualizarMedico(Object object);
    public  boolean eliminarMedico(Object object);
    public List<Object> encontrarMedico();

    public Object insertarPaciente(Object object);
    public boolean actualizarPaciente(Object object);
    public  boolean eliminarPaciente(Object object);
    public List<Object> encontrarPaciente();


    public Object insertarEspecialidad(Object object);
    public boolean actualizarEspecialidad(Object object);
    public  boolean eliminarEspecialidad(Object object);
    public List<Object> encontrarEspecialidad();






}
