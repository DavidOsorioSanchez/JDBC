package Model;

import Database.CRUDCita;
import Database.ConfigDB;
import Entity.EntityCita;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelCita implements CRUDCita {


    @Override
    public Object insertarCita(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        EntityCita objModelos = (EntityCita) object;

        try {

            String SQL = "INSERT INTO Cita(date,hour,motive) VALUES(?,?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getDate());
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

        EntityCita objModelos = (EntityCita)object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Cita SET date = ?, hour = ?, motive = ? WHERE id_appointment = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objModelos.getDate());
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
        EntityCita objModelos = (EntityCita) object;


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

        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> encontrarCita() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaCita = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Cita ORDER BY Cita.date ASC;";

            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()) {

                EntityCita objModelos = new EntityCita();

                objModelos.setID_Cita(objResult.getInt("id_appointment"));
                objModelos.setDate(objResult.getString("date"));
                objModelos.setHour(objResult.getInt("hour"));
                objModelos.setMotive(objResult.getString("motive"));

                listaCita.add(objModelos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaCita;
    }

}
