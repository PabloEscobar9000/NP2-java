
package factory;
import java.sql.Connection; //conexão SQL para JAVA
import java.sql.DriverManager; //driver de conexão SQL para JAVA
import java.sql.SQLException;

import java.sql.Connection;


public class TestaConexao {

    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
