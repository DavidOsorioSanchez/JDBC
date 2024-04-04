package Model;

import Database.CRUDEspecializacion;
import Database.ConfigDB;
import Entity.EntityEspecializacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelEspecializacion implements CRUDEspecializacion {

    @Override
    public Object insertarEspecialidad(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityEspecializacion objModelos = (EntityEspecializacion) object;

        try {

            String SQL = "INSERT INTO Especialidad(name,description) VALUES(?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getNameEspeciality());
            objPrepare.setString(2, objModelos.getDescription());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Especialidad(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "La Especialidad a sido creada sin problemas. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public boolean actualizarEspecialidad(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityEspecializacion objModelos = (EntityEspecializacion) object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Especialidad SET name = ?, description = ? WHERE id_Especialidad = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objModelos.getNameEspeciality());
            objPrepare.setString(2,objModelos.getDescription());
            objPrepare.setInt(3,objModelos.getID_Especialidad());


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
    public boolean eliminarEspecialidad(Object object) {
        EntityEspecializacion objModelos = (EntityEspecializacion) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Especialidad WHERE  id_Especialidad = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Especialidad());

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
    public List<Object> encontrarEspecialidad() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaEspecialidad = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Especialidad ORDER BY Especialidad.id_Especialidad ASC;";

            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()) {

                EntityEspecializacion objModelos = new EntityEspecializacion();

                objModelos.setID_Especialidad(objResult.getInt("id_Especialidad"));
                objModelos.setNameEspeciality(objResult.getString("name"));
                objModelos.setDescription(objResult.getString("description"));

                listaEspecialidad.add(objModelos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaEspecialidad;
    }

}
