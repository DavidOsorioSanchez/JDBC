package Model;

import Database.CRUDMedico;
import Database.ConfigDB;
import Entity.EntityEspecializacion;
import Entity.EntityMedico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelMedico implements CRUDMedico {

    @Override
    public Object insertarMedico(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityMedico objModelos = (EntityMedico) object;

        try {

            String SQL = "INSERT INTO Medico(name,lastName,id_Especialidad) VALUES (?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getNameMedic());
            objPrepare.setString(2, objModelos.getLastNameMedic());
            objPrepare.setInt(3,objModelos.getFk_ID_Especialidad());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Medico(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "El medico a sido creada sin problemas. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public boolean actualizarMedico(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityMedico objModelos = (EntityMedico)object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Medico SET name = ?, lastName = ?, id_Especialidad = ? ; ";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);


            objPrepare.setString(1,objModelos.getNameMedic());
            objPrepare.setString(2,objModelos.getLastNameMedic());
            objPrepare.setInt(3,objModelos.getFk_ID_Especialidad());


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
    public boolean eliminarMedico(Object object) {
        EntityMedico objModelos = (EntityMedico) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Medico WHERE  id_doctor = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Medico());

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
    public List<Object> encontrarMedico() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaMedico = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Medico INNER JOIN Especialidad ON Especialidad.id_Especialidad = Medico.id_doctor;";


            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()) {

                EntityMedico objModelos = new EntityMedico();
                EntityEspecializacion objEspecial = new EntityEspecializacion();

                objModelos.setID_Medico(objResult.getInt("Medico.id_doctor"));
                objModelos.setNameMedic(objResult.getString("Medico.name"));
                objModelos.setLastNameMedic(objResult.getString("Medico.lastName"));
                objModelos.setFk_ID_Especialidad(objResult.getInt("Medico.id_Especialidad"));

                objEspecial.setID_Especialidad(objResult.getInt("Especialidad.id_Especialidad"));
                objEspecial.setNameEspeciality(objResult.getString("Especialidad.name"));
                objEspecial.setDescription(objResult.getString("Especialidad.description"));

                objModelos.setEspecial(objEspecial);

                listaMedico.add(objModelos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaMedico;
    }
}
