package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.*;
import model.vo.*;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {    
    private final Consulta1_19Dao consulta1_19dao;
    private final Consulta2_19Dao consulta2_19dao;
    private final Consulta3_19Dao consulta3_19dao;

    public ControladorRequerimientosReto4(){
        this.consulta1_19dao = new Consulta1_19Dao();
        this.consulta2_19dao = new Consulta2_19Dao();
        this.consulta3_19dao = new Consulta3_19Dao();
    }

        public ArrayList<Consulta1VO_19> consultarConsulta1() throws SQLException{
            return this.consulta1_19dao.consulta1DAO();
        }

        public ArrayList<Consulta2VO_19> consultarConsulta2() throws SQLException{
            return this.consulta2_19dao.consulta2DAO();
        }

        public ArrayList<Consulta3VO_19> consultarConsulta3() throws SQLException{
            return this.consulta3_19dao.consulta3DAO();
        }

    
}
