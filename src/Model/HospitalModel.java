package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Modelos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class HospitalModel implements CRUD {


    @Override
    public Object insertarCita(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        Modelos objModelos = (Modelos) object;

        try {

            String sql = "INSERT INTO Cita(date,hour,motive) VALUES(?,?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

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
        return false;
    }

    @Override
    public boolean eliminarCita(Object object) {
        return false;
    }

    @Override
    public List<Object> encontrarCita() {
        return null;
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
