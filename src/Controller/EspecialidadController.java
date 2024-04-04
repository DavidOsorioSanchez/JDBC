package Controller;

import Entity.EntityEspecializacion;
import Model.ModelEspecializacion;
import Util.Util;

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

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de citas";

        for (Object obj : listado){
            EntityEspecializacion objModelos = (EntityEspecializacion) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static void borrar(){
        Object[] options = Util.listArray(instaceModel().encontrarEspecialidad());

        EntityEspecializacion objSelected = (EntityEspecializacion) JOptionPane.showInputDialog(null, "selecciona una especialidad","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarEspecialidad(objSelected);
    }

    public static void update(){
        Object[] options = Util.listArray(instaceModel().encontrarEspecialidad());
        EntityEspecializacion objSelected = (EntityEspecializacion) JOptionPane.showInputDialog(null, "selecciona una especialidad para actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        objSelected.setNameEspeciality(JOptionPane.showInputDialog(null, "Ingrresa el nuevo numero:", objSelected.getNameEspeciality()));
        objSelected.setDescription(JOptionPane.showInputDialog(null, "Ingresa la nueva descripcion: ",objSelected.getDescription()));

        instaceModel().actualizarEspecialidad(objSelected);
    }
}
