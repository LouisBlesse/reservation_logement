import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectBDD {
    public Connection connection;

    public void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:reservationData.sqlite");
            String sqlCommand = "SELECT * FROM Client";
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) +" "+ rs.getString(2));
            }
        }
        catch (Exception e){
            System.out.println("fail to connect" + e);
        }
    }
}
