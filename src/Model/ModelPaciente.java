package Model;

import Database.CRUDPaciente;
import Database.ConfigDB;
import Entity.EntityPaciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelPaciente implements CRUDPaciente {
    @Override
    public Object insertarPaciente(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityPaciente objModelos = (EntityPaciente) object;

        try {

            String SQL = "INSERT INTO Paciente(name,lastName,bornDate,documentPassword) VALUES(?,?,?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getNamePatient());
            objPrepare.setString(2, objModelos.getLastNamePatient());
            objPrepare.setString(3, objModelos.getDateBorn());
            objPrepare.setString(4, objModelos.getDocumentPassword());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Paciente(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "El Paciente a sido creada sin problemas. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public boolean actualizarPaciente(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityPaciente objModelos = (EntityPaciente)object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Paciente SET name=?, lastName = ?, bornDate = ?, documentPassword = ? WHERE id_patient = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objModelos.getNamePatient());
            objPrepare.setString(2,objModelos.getLastNamePatient());
            objPrepare.setString(3,objModelos.getDateBorn());
            objPrepare.setString(4,objModelos.getDocumentPassword());
            objPrepare.setInt(4,objModelos.getID_Paciente());


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
    public boolean eliminarPaciente(Object object) {
        EntityPaciente objModelos = (EntityPaciente) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Paciente WHERE  id_patient = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Paciente());

            int totalAfectado = objPrepare.executeUpdate();

            if (totalAfectado>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Se a eliminado efectivamente. (^_^)");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ಥ_ಥ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> encontrarPaciente() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaPaciente = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Paciente ORDER BY Paciente.id_patient ASC;";

            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()) {

                EntityPaciente objModelos = new EntityPaciente();

                objModelos.setID_Paciente(objResult.getInt("id_patient"));
                objModelos.setNamePatient(objResult.getString("name"));
                objModelos.setLastNamePatient(objResult.getString("lastName"));
                objModelos.setDateBorn(objResult.getString("bornDate"));
                objModelos.setDocumentPassword(objResult.getString("documentPassword"));

                listaPaciente.add(objModelos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaPaciente;
    }
}
