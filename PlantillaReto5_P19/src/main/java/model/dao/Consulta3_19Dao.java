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

public class Consulta3_19Dao {
    public ArrayList<Consulta3VO_19> consulta3DAO() throws SQLException {
        ArrayList<Consulta3VO_19> reque3 = new ArrayList<Consulta3VO_19>();

        Connection conexion = JDBCUtilities.getConnection();

        try{
            String consulta = "SELECT ID_Proyecto, Nombre ||' '|| Primer_Apellido AS nombreapellido FROM Proyecto p JOIN Lider l USING(ID_Lider) WHERE Banco_Vinculado = 'Bancolombia'";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Consulta3VO_19 consulta3vo_19 = new Consulta3VO_19();
                consulta3vo_19.setiD_Proyecto(resultSet.getInt("ID_Proyecto"));
                consulta3vo_19.setNombreapellido(resultSet.getString("nombreapellido"));

                reque3.add(consulta3vo_19);

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

        return reque3;
    }  
}
