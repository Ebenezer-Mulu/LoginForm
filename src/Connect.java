import java.sql.Connection;
import java.sql.DriverManager;
public class Connect {
      
public Connection connection;

public Connection getconnection(){
      
    String dbName = "Form";
    String user = "root" ;
    String password = "metegese.4122";
     String url = "jdbc:mysql://localhost:3306/"+dbName;

    try {
        connection = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      System.out.println(e);
    }
    return connection;
}

}
