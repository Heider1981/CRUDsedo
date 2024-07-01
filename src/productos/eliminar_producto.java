/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

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
public class eliminar_producto {
    public static void main(String[] args) {
        // CONEXION
        conexionbd con = new conexionbd();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A AGREGAR
        int id_eliminar = 24;

        //INSTRUCCION SQL
        String sql = "DELETE FROM productos where idProductos="+id_eliminar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_producto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATOS
            rs = st.executeQuery("SELECT * FROM productos"); // TRAER DATOS DE LA TABLA PRODUCTOS
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PRODUCTOS
            do {
                System.out.println(rs.getInt("idProductos")+": "+rs.getString("nombreProducto")+" - "+rs.getString("precioProducto")+" - "+rs.getInt("TiPoproducto_idTiPoproducto"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
