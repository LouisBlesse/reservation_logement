import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConnectBDD {
    public static Connection connection;

    public void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:reservationData.sqlite");
            String sqlCommand = "SELECT * FROM Client";
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            ResultSet rs = statement.executeQuery();
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
                //System.out.println(rs.getString(1) + " " + rs.getString(2));
                user = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("fail to connect : " + e);
        }
        return user;
    }

    public void newHebergement(Hebergement hebergement){
        String uniqueID = UUID.randomUUID().toString();
        String query = "INSERT INTO Hebergement VALUES ('"+uniqueID+"', '"  + hebergement.nom +"', '"+ hebergement.type+"', '"+ hebergement.region+"', "
                + hebergement.nombreChambres+", "+ hebergement.nombreChambresDouble+", "+ hebergement.nombreChambresSuites+", "+
                hebergement.piscine+", "+hebergement.salle+", "+hebergement.parking+", "+hebergement.accesHandicape+", "+ hebergement.depaneur+", "+ hebergement.restaurant+");" ;
        System.out.println(query);
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            int rs = statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println("fail to insert Hebergement : " + e);
        }
    }

    public static List<Hebergement> seachHebergement(Filtre filtre){
        String query = "SELECT * FROM hebergement WHERE (region ='"+filtre.region+"' AND type ='"
                +filtre.type+"' AND "+filtre.typeChambre +">= 1 AND piscine ="+filtre.piscine+
                " AND salle = "+filtre.salle+" AND accesHandicape = "+filtre.accesHandicape+
                " AND depaneur = "+filtre.depaneur+" AND restaurant = "+filtre.restaurant+")";

        System.out.println(query);
        ArrayList<Hebergement> hebergements= new ArrayList<Hebergement>();;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                //System.out.println(rs.getString(1) + " " + rs.getString(2));
                Hebergement tmp = new Hebergement(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)),
                        Integer.parseInt(rs.getString(6)),  Integer.parseInt(rs.getString(7)),
                        Integer.parseInt(rs.getString(8)), Integer.parseInt(rs.getString(9)),
                        Integer.parseInt(rs.getString(10)), Integer.parseInt(rs.getString(11)),
                        Integer.parseInt(rs.getString(12)), Integer.parseInt(rs.getString(13)));
                Boolean check = Main.connected.checkReservation(tmp, filtre);
                System.out.println(check);
                if (check){
                    hebergements.add(tmp);
                }

            }
        } catch (Exception e) {
            System.out.println("fail to connect : " + e);
        }
        return hebergements;
    }

    public static boolean checkReservation(Hebergement hebergement, Filtre filtre){
        int nbr=0;
        String query = "SELECT * FROM reservations WHERE (idHebergement ='"+hebergement.id+"' AND typeChambre ='"
                +filtre.typeChambre+"' AND dateDebut NOT BETWEEN "+filtre.dateDebut+
                " AND "+filtre.dateFin+" AND dateFin NOT BETWEEN "+filtre.dateDebut+
                " AND "+filtre.dateFin+")";
        System.out.println(query);
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                nbr++;
            }
            System.out.println(nbr);
            if (filtre.typeChambre=="nombreChambres"){
                if(hebergement.nombreChambres>nbr){
                    return true;
                }
            } else if (filtre.typeChambre=="nombreChambresDoubles") {
                if(hebergement.nombreChambresDouble>nbr){
                    return true;
                }
            }else if (filtre.typeChambre=="nombreChambresSuites"){
                if(hebergement.nombreChambresSuites>nbr){
                    return true;
                }
            }

        }
        catch (Exception e){
            System.out.println("fail to connect : " + e);
        }
        return false;
    }

    public void createReservation(Client user, Hebergement hebergement, Filtre newFiltre){
        String uniqueID = UUID.randomUUID().toString();
        String query = "INSERT INTO reservations VALUES ('" + uniqueID +"', '"+ user.id+"', '"+ hebergement.id+"', '"+ newFiltre.dateDebut+"', '"+ newFiltre.dateFin+"', '"+ newFiltre.typeChambre+"');" ;
        System.out.println(query);
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            int rs = statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println("fail to insert reservation : " + e);
        }
    };

    public static ArrayList<Reservation> seachReservation (Client user){
        String query = "SELECT * FROM reservations WHERE (idClient ='"+user.id+"')";
        System.out.println(query);
        ArrayList<Reservation> reservations= new ArrayList<Reservation>();;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                //System.out.println(rs.getString(1) + " " + rs.getString(2));
                Reservation tmp = new Reservation(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
                reservations.add(tmp);
            }
        } catch (Exception e) {
            System.out.println("fail to connect : " + e);
        }
        return reservations;
    }

    public static void deleteReservation (Reservation reservation){
        String query = "DELETE FROM reservations WHERE (id ='"+reservation.id+"')";
        System.out.println(query);
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            int rs = statement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("fail to connect : " + e);
        }
    }
}
