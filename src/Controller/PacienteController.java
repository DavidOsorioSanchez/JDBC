package Controller;

import Entity.EntityPaciente;
import Model.ModelPaciente;
import Util.Util;

import javax.swing.*;
import java.util.List;

public class PacienteController {
    //    insertar
    public static void insert(){
        String name = JOptionPane.showInputDialog(null,"ingresa el nombre del paciente");
        String lastName = JOptionPane.showInputDialog(null,"ingresa el apellido del paciente");
        String dateBorn = JOptionPane.showInputDialog(null,"ingresa la fecha de nacimiento del paciente");
        String documentPassword = JOptionPane.showInputDialog(null,"ingresa el documento del paciente");
        instaceModel().insertarPaciente(new EntityPaciente(name, lastName, dateBorn,documentPassword));
    }

    public static ModelPaciente instaceModel(){
        return new ModelPaciente();
    }

//    getAll

    public static  void listar(){

        String list = listar(instaceModel().encontrarPaciente());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de pacientes";

        for (Object obj : listado){
            EntityPaciente objModelos = (EntityPaciente) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static void borrar(){
        Object[] options = Util.listArray(instaceModel().encontrarPaciente());

        EntityPaciente objSelected = (EntityPaciente) JOptionPane.showInputDialog(null, "selecciona un paciente","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarPaciente(objSelected);
    }

    public static void update(){
        Object[] options = Util.listArray(instaceModel().encontrarPaciente());
        EntityPaciente objSelected = (EntityPaciente) JOptionPane.showInputDialog(null, "selecciona el paciente que quieres para actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        objSelected.setNamePatient(JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre del paciente:", objSelected.getNamePatient()));
        objSelected.setLastNamePatient(JOptionPane.showInputDialog(null, "Ingresa el nuevo apellido: ",objSelected.getLastNamePatient()));
        objSelected.setDateBorn(JOptionPane.showInputDialog(null, "Ingresa la fecha de nacimiento: ",objSelected.getDateBorn()));
        objSelected.setDocumentPassword(JOptionPane.showInputDialog(null, "Ingresa el nuevo documento del paciente: ",objSelected.getDocumentPassword()));

        instaceModel().actualizarPaciente(objSelected);
    }
}
