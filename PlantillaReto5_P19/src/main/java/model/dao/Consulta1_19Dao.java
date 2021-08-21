package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta1_19Dao {
    public ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException {
        ArrayList<Consulta1VO_19> reque1 = new ArrayList<Consulta1VO_19>();
        
        Connection conexion = JDBCUtilities.getConnection();

        try{
            String consulta = "SELECT ID_Proyecto, Fecha_inicio, Constructora, Serial FROM Proyecto p WHERE ID_Proyecto < 15";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Consulta1VO_19 consulta1vo_19 = new Consulta1VO_19();
                consulta1vo_19.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                consulta1vo_19.setFecha_inicio(resultSet.getString("Fecha_inicio"));
                consulta1vo_19.setConstructora(resultSet.getString("Constructora"));
                consulta1vo_19.setSerial(resultSet.getString("Serial"));

                reque1.add(consulta1vo_19);

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e){
            System.err.println("Error consultando: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return reque1;

    }
}
