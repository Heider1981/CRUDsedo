/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class conexionbd {
        Connection con;
        
    public conexionbd(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sedo_cra","root","16461219bcG@");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("La Conexion no Fue Exitosa");
        }
    }
    
    public Connection getConection(){
        return con;
    }
}