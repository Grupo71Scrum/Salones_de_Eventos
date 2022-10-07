
package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String bd = "heroku_e186d911456268c";
    static String port = "3306";
    static String login = "bf98aa231e9b1b";
    static String password = "a911f37a";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://bf98aa231e9b1b:a911f37a@us-cdbr-east-06.cleardb.net/heroku_e186d911456268c";
            connection = DriverManager.getConnection(url,this.login,this.password);
            System.out.println("conecxión establecida");
        } catch (Exception ex) {
            System.out.println("error en la conexión");
        }
    }
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
    
}
