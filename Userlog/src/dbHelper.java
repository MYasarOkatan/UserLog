import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbHelper {
    private final  String username="";//Enter your MySQL database username here.
    private final String password="";//Enter your MySQL database password here.
    private final String dburl="";//Enter your MySQL database url here.

    public Connection getConnection() throws SQLException{
      
        return DriverManager.getConnection(dburl,username,password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error:"+exception.getMessage());
        System.out.println("Error code:"+exception.getErrorCode());
    }
}
