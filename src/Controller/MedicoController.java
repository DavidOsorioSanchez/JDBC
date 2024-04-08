package Controller;

import Entity.EntityEspecializacion;
import Entity.EntityMedico;
import Model.ModelMedico;
import Util.Util;

import javax.swing.*;
import java.util.List;

public class MedicoController {
    //    insertar
    public static void insert(){
        String name = JOptionPane.showInputDialog(null,"ingresa el nombre del medico");
        String lastName = JOptionPane.showInputDialog(null,"ingresa los apellidos del medico");

        Object[] opcionesEspecial = Util.listArray(EspecialidadController.instaceModel().encontrarEspecialidad());

        EntityEspecializacion objEspecialidad = (EntityEspecializacion) JOptionPane.showInputDialog(null, "selecciona tu especialidad", "no titulo", JOptionPane.QUESTION_MESSAGE, null, opcionesEspecial, opcionesEspecial[0]);

        instaceModel().insertarMedico(new EntityMedico(name, lastName,objEspecialidad.getID_Especialidad(), objEspecialidad));
    }

    public static ModelMedico instaceModel(){
        return new ModelMedico();
    }

//    getAll

    public static  void listar(){

        String list = listar(instaceModel().encontrarMedico());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de medicos";

        for (Object obj : listado){
            EntityMedico objModelos = (EntityMedico) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static void borrar(){
        Object[] options = Util.listArray(instaceModel().encontrarMedico());

        EntityMedico objSelected = (EntityMedico) JOptionPane.showInputDialog(null, "selecciona un medico","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarMedico(objSelected);
    }

    public static void update(){
        Object[] options = Util.listArray(instaceModel().encontrarMedico());
        EntityMedico objSelected = (EntityMedico) JOptionPane.showInputDialog(null, "selecciona el medico que quieres para actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        String name = JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre del medico:", objSelected.getNameMedic());
        String lastName = JOptionPane.showInputDialog(null, "Ingresa el nuevo apellido: ",objSelected.getLastNameMedic());

        Object[] otionEspecial = Util.listArray(EspecialidadController.instaceModel().encontrarEspecialidad());
        EntityEspecializacion objEspecial= (EntityEspecializacion) JOptionPane.showInputDialog(null, "selecciona una especialidad","",JOptionPane.QUESTION_MESSAGE, null,otionEspecial,otionEspecial[0]);


        instaceModel().actualizarMedico(new EntityMedico(name,lastName,objEspecial.getID_Especialidad(),objEspecial));
    }
}
