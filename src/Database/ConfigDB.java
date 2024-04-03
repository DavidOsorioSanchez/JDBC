package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable que va a contener el estado de la conexión
    static Connection objConnection = null;

    //Metodo para abrir la conexión entre Java y la base de datos

    public static Connection openConnection(){
        try {
            //Class forname permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales de la base de datos
            String url = "jdbc:mysql://bohmph3aqkihryblfjws-mysql.services.clever-cloud.com:3306/bohmph3aqkihryblfjws";
            String user = "uaoew5g6embpdagy";
            String password = "0wNyHIUA7Da8Qe6o73j8";

            //Establecemos la conexión
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecté perfectamente!!!!");

        }catch (ClassNotFoundException e){
            System.out.println("Error >> Driver no Instalado");
        }catch (SQLException e){
            System.out.println("Error >> No se pudo establecer una conexión con la BD"+e.getMessage());
        }

        return objConnection;

    }


    public static void closeConnection(){
        try {
            //Si hay una conexión activa, la cerramos
            if (objConnection != null) objConnection.close();

        }catch (SQLException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }


}
