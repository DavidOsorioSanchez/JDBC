package Controller;

import Entity.EntityEspecializacion;
import Model.ModelEspecializacion;

import javax.swing.*;
import java.util.List;

public class EspecialidadController {

//    insertar
    public static void insert(){
        String name = JOptionPane.showInputDialog(null,"ingresa el nombre de la especializacion");
        String description = JOptionPane.showInputDialog(null,"ingresa la descripcion de la especializacion");
        instaceModel().insertarEspecialidad(new EntityEspecializacion(name, description));
    }

    public static ModelEspecializacion instaceModel(){
        return new ModelEspecializacion();
    }

//    getAll

    public static  void listar(){
        String list = listar(instaceModel().encontrarEspecialidad());
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de citas";

        for (Object obj : listado){
            EntityEspecializacion objModelos = (EntityEspecializacion) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }
}
