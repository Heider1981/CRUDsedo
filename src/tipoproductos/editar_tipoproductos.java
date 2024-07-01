/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoproductos;

import conexion.conexionbd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heider mauricio Bedoya
 * Ficha - 2721519
 */
public class editar_tipoproductos {
    public static void main(String[] args) {
        // CONEXION
        conexionbd con = new conexionbd();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_editar = 6;
        String TipoProducto = "Cocteles";

        // INSTRUCCION SQL
        String sql = "UPDATE tipoproducto set TipoProducto='" + TipoProducto +"' where idTipoProducto="+id_editar;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_tipoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM tipoproducto"); // TRAER DATOS DE LA TABLA TIPOPRODUCTO
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA TIPOPRODUCTO
            do {
                System.out.println(rs.getInt("idTipoProducto")+": "+rs.getString("TipoProducto"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_tipoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


