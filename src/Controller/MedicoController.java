package Controller;

import Entity.EntityMedico;
import Model.ModelMedico;
import Util.Util;

import javax.swing.*;
import java.util.List;

public class MedicoController {
    //    insertar
    public static void insert(){
        String name = JOptionPane.showInputDialog(null,"ingresa el nombre del medico");
        String lastName = JOptionPane.showInputDialog(null,"ingresa la descripcion del medico");
        instaceModel().insertarMedico(new EntityMedico(name, lastName));
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
        objSelected.setNameMedic(JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre del medico:", objSelected.getNameMedic()));
        objSelected.setLastNameMedic(JOptionPane.showInputDialog(null, "Ingresa el nuevo apellido: ",objSelected.getLastNameMedic()));

        instaceModel().actualizarMedico(objSelected);
    }
}
