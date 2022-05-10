package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexionsql {
    Connection conn=null;
    private String url = "jdbc:postgresql://ec2-54-172-175-251.compute-1.amazonaws.com:5432/dfkcq62frda735?sslmode=require";
    private String usuario = "pktkcbpkkwuogv";
    private String clave = "bc911b71f80cd373e2608f0a34bbf574cbf15990ba52fc98aadf72eada72671e";

    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

}


