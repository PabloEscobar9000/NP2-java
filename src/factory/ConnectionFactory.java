package factory;

import java.sql.Connection; //conexão SQL para JAVA
import java.sql.DriverManager; //driver de conexão SQL para JAVA
import java.sql.SQLException; //classe p tratamento de exceções

public class ConnectionFactory {
    public Connection getConnection(){
        try{
                return DriverManager.getConnection("jdbc:mysql://localhost/academia","root","102794");
            }
        catch(SQLException excecao){
                throw new RuntimeException(excecao);
        }
    }
}
