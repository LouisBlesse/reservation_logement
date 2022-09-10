import java.sql.*;
import java.util.UUID;

public class ConnectBDD {
    public static Connection connection;

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

    public void newClient(Client client){
        String uniqueID = UUID.randomUUID().toString();
        String query = "INSERT INTO Client (nom, adresse, courriel, tel, admin, mdp, id) VALUES ('" + client.nom +"', '"+ client.adresse+"', '"+ client.courriel+"', '"+ client.tel+"', "+ client.admin+", '"+ client.mdp+"', '"+ uniqueID+"');" ;
        System.out.println(query);
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            int rs = statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println("fail to insert Client : " + e);
        }
    }

    public static Client connectClient(String nom, String mdp) {
        String sqlCommand = "SELECT * FROM Client WHERE (nom ='" + nom + "' AND mdp ='" + mdp + "') LIMIT 1;";
        System.out.println(sqlCommand);
        Client user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            ResultSet rs = statement.executeQuery();

            if (rs.next() == false) {
                System.out.println("Utilisateur inconnu");
            } else {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
                user = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("fail to connect : " + e);
        }

        return user;
    }
}
