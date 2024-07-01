/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrousuarios;

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
public class eliminar_usuarios {
    public static void main(String[] args) {
        // CONEXION
        conexionbd con = new conexionbd();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        int id_eliminar = 13;

        //INSTRUCCION SQL
        String sql = "DELETE FROM registrousuarios where idRegistro="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM registrousuarios"); // TRAER DATOS DE LA TABLA REGISTROUSUARIOS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA REGISTROUSUARIOS
            do {
                System.out.println(rs.getInt("idRegistro")+": "+rs.getString("usuNombres")+" - "+rs.getString("usuApellidos")+" - "+rs.getInt("usuNumeroDocumento")+" - "+rs.getString("usuDireccion")+" - "+rs.getInt("usuNumeroTelefono")+" - "+rs.getString("usuEmail")+" - "+rs.getInt("TipoDocumento_idTipoDocumento"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
