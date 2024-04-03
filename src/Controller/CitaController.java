package Controller;

import Model.ModelCita;
import Entity.EntityCita;

import javax.swing.*;
import java.util.List;

public class CitaController {

    ModelCita objModel;

    public CitaController() {
        this.objModel = new ModelCita();
    }

    public String listar(List<Object> listado){
        String lista = "Listado de citas";

        for (Object obj : listado){
            EntityCita objModelos = (EntityCita) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

 public void proyectar(){
     String lista = this.listar(this.objModel.encontrarCita());
     JOptionPane.showMessageDialog(null,lista);
   }



}
