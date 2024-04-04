package Controller;

import Entity.EntityCita;
import Model.ModelCita;
import Util.Util;

import javax.swing.*;
import java.util.List;

public class CitaController {
    //    insertar
    public static void insert(){
        String date = JOptionPane.showInputDialog(null,"ingresa el dia de la Cita");
        int hour = Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa la hora de la Cita"));
        String motive = JOptionPane.showInputDialog(null,"ingresa el motivo de la Cita");
        instaceModel().insertarCita(new EntityCita(date, hour, motive));
    }

    public static ModelCita instaceModel(){
        return new ModelCita();
    }

//    getAll

    public static  void listar(){

        String list = listar(instaceModel().encontrarCita());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de citas";

        for (Object obj : listado){
            EntityCita objModelos = (EntityCita) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static void borrar(){
        Object[] options = Util.listArray(instaceModel().encontrarCita());

        EntityCita objSelected = (EntityCita) JOptionPane.showInputDialog(null, "selecciona una cita","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarCita(objSelected);
    }

    public static void update(){
        Object[] options = Util.listArray(instaceModel().encontrarCita());
        EntityCita objSelected = (EntityCita) JOptionPane.showInputDialog(null, "selecciona una cita para actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        objSelected.setDate(JOptionPane.showInputDialog(null, "Ingresa el nuevo dia de la cita: ", objSelected.getDate()));
        objSelected.setHour(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la nueva hora de la Cita: ",objSelected.getHour())));
        objSelected.setMotive(JOptionPane.showInputDialog(null, "Ingresa la nueva motivacion de la Cita: ",objSelected.getMotive()));
        instaceModel().actualizarCita(objSelected);
    }
}

