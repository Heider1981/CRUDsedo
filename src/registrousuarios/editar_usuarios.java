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
public class editar_usuarios {
    public static void main(String[] args) {
        // CONEXION
        conexionbd con = new conexionbd();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_editar = 13;
        String new_usuNombres = "Hair";
        String new_usuApellidos = "Delta";
        int new_usuNumeroDocumento = 22575654;
        String new_usuDireccion = "carrera 43 # 18-36";
        int new_usuNumeroTelefono = 312543626;
        String new_usuEmail = "jeda@gmail.com";
        int new_TipoDocumento_idTipoDocumento = 1;

        // INSTRUCCION SQL
        String sql = "UPDATE registrousuarios set usuNombres='"+new_usuNombres+"', usuApellidos='"+new_usuApellidos+"', usuNumeroDocumento='"+new_usuNumeroDocumento+"', usuDireccion='"+new_usuDireccion+"', usuNumeroTelefono='"+new_usuNumeroTelefono+"', usuEmail='"+new_usuEmail+"', TipoDocumento_idTipoDocumento='"+new_TipoDocumento_idTipoDocumento+"' where idRegistro="+id_editar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREGAR DATOS
            rs = st.executeQuery("SELECT * FROM registrousuarios"); // TRAER DATOS DE LA TABLA REGISTROUSUARIOS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA REGISTROUSUARIOS
            do {
                System.out.println(rs.getInt("idRegistro")+": "+rs.getString("usuNombres")+" - "+rs.getString("usuApellidos")+" - "+rs.getInt("usuNumeroDocumento")+" - "+rs.getString("usuDireccion")+" - "+rs.getInt("usuNumeroTelefono")+" - "+rs.getString("usuEmail")+" - "+rs.getInt("TipoDocumento_idTipoDocumento"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
