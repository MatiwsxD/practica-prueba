package sql;


import getset.variables;
import sql.conexionsql;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class crudsql extends conexionsql {

    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();

    public void insertar(String nombre, String telefono, String mail, String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into empleados(nombre,telefono,mail,cedula) values('" + nombre + "','" + telefono + "','" + mail + "','" + cedula + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public  void mostrar(String idempleado) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from empleados where cedula='" + idempleado + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setIdempleado(rs.getString("cedula"));
                var.setNombre(rs.getString("nombre"));
                var.setApellido(rs.getString("telefono"));
                var.setPuesto(rs.getString("mail"));
            } else {
                var.setIdempleado("");
                var.setNombre("");
                var.setApellido("");
                var.setPuesto("");
                JOptionPane.showMessageDialog(null, "no se encontro registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en programa " + e, "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(String nombre, String telefono, String mail, String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update empleados set nombre='" + nombre + "',telefono='" + telefono + "',mail='" + mail + "' where cedula='" + cedula + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String cedula){
        try {
            Connection conexion=conectar();
            st=conexion.createStatement();
            String sql="delete from empleados where cedula='"+cedula+"'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
