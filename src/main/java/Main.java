import java.sql.*;

public class Main {
    public static void main (String args[])  {
        System.out.println("Hello project");
        ConnectBDD connected = new ConnectBDD();
        connected.connect();


    }
}
