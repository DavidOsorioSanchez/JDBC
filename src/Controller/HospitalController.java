package Controller;

import Model.HospitalModel;
import Entity.Modelos;

import javax.swing.*;
import java.util.List;

public class HospitalController {

    HospitalController objModel;

    public HospitalController() {
        this.objModel = new HospitalController();
    }

    public String listar(List<Object> listado){
        String lista = "Listado de citas";

        for (Object obj : listado){
            Modelos objModelos = (Modelos) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public void proyectar(){
        String lista = this.listar(this.objModel.encontrarCita());
        JOptionPane.showMessageDialog(null,lista);
    }



}
