package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Modelos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalModel implements CRUD {


    @Override
    public Object insertarCita(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        Modelos objModelos = (Modelos) object;

        try {

            String SQL = "INSERT INTO Cita(date,hour,motive) VALUES(?,?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objModelos.getDate());
            objPrepare.setInt(2, objModelos.getHour());
            objPrepare.setString(3, objModelos.getMotive());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Cita(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "La cita a sido creada sin problemas. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public boolean actualizarCita(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        Modelos objModelos = (Modelos)object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Cita SET date = ?, hour = ?, motive = ? WHERE id_appointment = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1,objModelos.getDate());
            objPrepare.setInt(2,objModelos.getHour());
            objPrepare.setString(3,objModelos.getMotive());
            objPrepare.setInt(4,objModelos.getID_Cita());


            int lineasAfectadas  = objPrepare.executeUpdate();
            if (lineasAfectadas > 0){
                isUpdated= true;
                JOptionPane.showMessageDialog(null,"la actualizacion fue exitosa. ^_^");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(T-T) Error: " + e.getMessage());
        }finally {

            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean eliminarCita(Object object) {
        Modelos objModelos = (Modelos) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Cita WHERE  id_appointment = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Cita());

            int totalAfectado = objPrepare.executeUpdate();

            if (totalAfectado>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Se a eliminado efectivamente. (^_^)");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ಥ_ಥ Error: " + e.getMessage());
        }

        //8. Cerrar la conexión
        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> encontrarCita() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaCita = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Cita ORDER BY Cita.id_appointment ASC;";

            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()) {

                Modelos objModelos = new Modelos();

                objModelos.setID_Cita(objResult.getInt("id"));
                objModelos.setDate(objResult.getInt("date"));
                objModelos.setHour(objResult.getInt("hour"));
                objModelos.setMotive(objResult.getString("motive"));

                listaCita.add(objModelos);
            }
            JOptionPane.showMessageDialog(null,"Busqueda sin problema. ♥‿♥");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaCita;
    }

    @Override
    public Object insertarMedico(Object object) {
        return null;
    }

    @Override
    public boolean actualizarMedico(Object object) {
        return false;
    }

    @Override
    public boolean eliminarMedico(Object object) {
        return false;
    }

    @Override
    public List<Object> encontrarMedico() {
        return null;
    }

    @Override
    public Object insertarPaciente(Object object) {
        return null;
    }

    @Override
    public boolean actualizarPaciente(Object object) {
        return false;
    }

    @Override
    public boolean eliminarPaciente(Object object) {
        return false;
    }

    @Override
    public List<Object> encontrarPaciente() {
        return null;
    }

    @Override
    public Object insertarEspecialidad(Object object) {
        return null;
    }

    @Override
    public boolean actualizarEspecialidad(Object object) {
        return false;
    }

    @Override
    public boolean eliminarEspecialidad(Object object) {
        return false;
    }

    @Override
    public List<Object> encontrarEspecialidad() {
        return null;
    }
}
