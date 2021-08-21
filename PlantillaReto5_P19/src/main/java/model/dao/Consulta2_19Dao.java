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

public class Consulta2_19Dao {
    public ArrayList<Consulta2VO_19> consulta2DAO() throws SQLException {
        ArrayList<Consulta2VO_19> reque2 = new ArrayList<Consulta2VO_19>();

        Connection conexion = JDBCUtilities.getConnection();

        try{
            String consulta = "SELECT ID_Proyecto, Area_Max FROM Proyecto p JOIN Tipo t USING(ID_Tipo) WHERE Numero_Habitaciones = 2";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Consulta2VO_19 consulta2vo_19 = new Consulta2VO_19();
                consulta2vo_19.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                consulta2vo_19.setArea_Max(resultSet.getInt("Area_Max"));

                reque2.add(consulta2vo_19);

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

        return reque2;
    }  
}
