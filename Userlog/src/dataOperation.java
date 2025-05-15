import java.sql.*;
import java.util.ArrayList;

public class dataOperation {
    private static Connection connection = null;
   private static PreparedStatement statement = null;
    private static final dbHelper helper = new dbHelper();
    private boolean flag=false;
    private ResultSet resultSet=null;
    public boolean dataInsert(String userName,String password,String email) throws SQLException{
        try {
            
            connection = helper.getConnection();
            if (connection == null) {
                throw new SQLException("Connection could not be established!");
            }
            String sql = "insert into users (userName, password, email) values (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.setString(3, email);
            
            statement.executeUpdate();
            flag=true;

        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
            helper.showErrorMessage(exception);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Shutdown error: " + e.getMessage());
            }
        }
        if(flag==true){
            return true;
        }
        else{
            return false;}
    }
   public ArrayList<data> dataarray() throws SQLException {
        Statement statement1;
        ArrayList<data> data=new ArrayList<data>();
        connection=helper.getConnection();
        statement1=connection.createStatement();
        resultSet=statement1.executeQuery("select * from users");
        while (resultSet.next()){
            data.add(new data(resultSet.getString("userName"),
                    resultSet.getString("password"),
                    resultSet.getString("email")));
        }
        return data;
    }
    public void ForgetPassword(String email,String password){
        try {
            
            connection = helper.getConnection();
            if (connection == null) {
                throw new SQLException("Connection could not be established!");
            }
            String sql = "update users.users set password= ? where email=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, email);
            
            statement.executeUpdate();
            

        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
            helper.showErrorMessage(exception);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Shutdown Error: " + e.getMessage());
            }
        }
    }
}
