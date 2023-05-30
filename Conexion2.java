package Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion2 {

    private Connection connection;

    public Conexion2(){
        try{
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:proyectousuarios.db");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
