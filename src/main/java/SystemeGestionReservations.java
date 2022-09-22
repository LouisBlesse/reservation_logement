import java.util.ArrayList;
import java.util.List;

public interface SystemeGestionReservations {
    public static void createClient() {};

    public static Client connectClient() {
        return new Client();
    };

    public static void createHebergement() {};

    public static List<Hebergement> seachHebergement(){
        return (new ArrayList<Hebergement>());
    };

    public static void createReservation (){};
}
