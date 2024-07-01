/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipousuarios;

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
public class eliminar_tipousuarios {
    public static void main(String[] args) {
        // CONEXION
        conexionbd con = new conexionbd();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        int id_eliminar = 4;

        //INSTRUCCION SQL
        String sql = "DELETE FROM tipousuario where idTipoUsuario="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_tipousuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM tipousuario"); // TRAER DATOS DE LA TABLA TIPOUSUARIO
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA TIPOUSUARIO
            do {
                System.out.println(rs.getInt("idTipoUsuario")+": "+rs.getString("TipoUsuario")+": "+rs.getInt("RegistroUsuarios_idRegistro"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_tipousuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

