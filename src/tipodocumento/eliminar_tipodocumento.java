/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipodocumento;

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
public class eliminar_tipodocumento {
    public static void main(String[] args) {
        // CONEXION
        conexionbd con = new conexionbd();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        int id_eliminar = 6;

        //INSTRUCCION SQL
        String sql = "DELETE FROM tipodocumento where idTipoDocumento="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_tipodocumento.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM tipodocumento"); // TRAER DATOS DE LA TABLA TIPODOCUMENTO
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA TIPODOCUMENTO
            do {
                System.out.println(rs.getInt("idTipoDocumento")+": "+rs.getString("documento"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_tipodocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

