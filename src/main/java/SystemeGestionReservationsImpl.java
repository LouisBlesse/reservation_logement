import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemeGestionReservationsImpl implements SystemeGestionReservations{
    static Filtre newFiltre;
    public static void createClient(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Comment vous appelez vous ?");
        String nom = myObj.nextLine();

        System.out.println("Quel est votre adresse ?");
        String adresse = myObj.nextLine();

        System.out.println("Quel est votre adresse mail ?");
        String courriel = myObj.nextLine();

        System.out.println("Quel est votre numéro de téléphone ?");
        String tel = myObj.nextLine();

        System.out.println("Choisissez un mot de passe?");
        String mdp = myObj.nextLine();

        System.out.println("êtes vous administrateur (les administrateur peuvent ajouter et enlever des hébergements \n 1: oui \n 2: non");
        int admin = myObj.nextInt();

        Client newClient = new Client(nom,adresse,courriel,tel,admin,mdp);

        Main.connected.newClient(newClient);
    };

    public static Client connectClient(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Quel est votre nom de compte ?");
        String nom = myObj.nextLine();

        System.out.println("Quel est votre mot de passe ?");
        String mdp = myObj.nextLine();

        Client user = Main.connected.connectClient(nom, mdp);
        return user;
    }

    public static void createHebergement(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Quel est le nom de l'hébergement?");
        String nom = myObj.nextLine();

        System.out.println("Dans quelle région est l'hébérgement ?");
        String region = myObj.nextLine();

        System.out.println("Quel est le type de l'hébergement ? \n1: Hôtel\n2: Motel\n3: Couette\n4: Café");
        String type;
        int choix = myObj.nextInt();
        if (choix == 1){
            type = "Hôtel";
        } else if (choix == 2) {
            type = "Motel";
        } else if (choix == 3) {
            type = "Couette";
        }else {
            type = "Café";
        }

        System.out.println("Combien y'a t'il de chambres simples ?");
        int nombreChambres = myObj.nextInt();

        System.out.println("Combien y'a t'il de chambres doubles ?");
        int nombreChambresDoubles = myObj.nextInt();

        System.out.println("Combien y'a t'il de chambres suites ?");
        int nombreChambresSuites = myObj.nextInt();

        System.out.println("Y'a t'il une piscine \n 1: oui \n 2: non");
        int piscine = myObj.nextInt();

        System.out.println("Y'a t'il une salle de sport \n 1: oui \n 2: non");
        int salle = myObj.nextInt();

        System.out.println("Y'a t'il un parking \n 1: oui \n 2: non");
        int parking = myObj.nextInt();

        System.out.println("Y'a t'il un accès handicapé \n 1: oui \n 2: non");
        int accesHandicape = myObj.nextInt();

        System.out.println("Y'a t'il un dépaneur \n 1: oui \n 2: non");
        int depaneur = myObj.nextInt();

        System.out.println("Y'a t'il un restaurant \n 1: oui \n 2: non");
        int restaurant = myObj.nextInt();

        Hebergement newHebergement = new Hebergement(nom,type,region,nombreChambres,nombreChambresDoubles,nombreChambresSuites,
                piscine,salle,parking,accesHandicape,depaneur,restaurant);

        Main.connected.newHebergement(newHebergement);

    }

    public static ArrayList<Hebergement> seachHebergement(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Dans quelle région voulez vous partir ?");
        String region = myObj.nextLine();

        System.out.println("Quand va commencer votre voyage ? (YYYY-MM-DD)");
        String dateDebut = myObj.nextLine();

        System.out.println("Quand va finir votre voyage ? (YYYY-MM-DD)");
        String dateFin = myObj.nextLine();

        System.out.println("Quel est le type de l'hébergement ? \n1: Hôtel\n2: Motel\n3: Couette\n4: Café");
        String type;
        int choix = myObj.nextInt();
        if (choix == 1){
            type = "Hôtel";
        } else if (choix == 2) {
            type = "Motel";
        } else if (choix == 3) {
            type = "Couette";
        }else {
            type = "Café";
        }

        System.out.println("Quel type de chambre voulez vous réserver ? \n1: Simple\n2: Double\n3: Suite");
        String typeChambre;
        choix = myObj.nextInt();
        if (choix == 1){
            typeChambre = "nombreChambres";
        } else if (choix == 2) {
            typeChambre = "nombreChambresDoubles";
        } else{
            typeChambre = "nombreChambresSuites";
        }

        System.out.println("Voulez vous une piscine \n 1: oui \n 2: non");
        int piscine = myObj.nextInt();

        System.out.println("Voulez vous une salle de sport \n 1: oui \n 2: non");
        int salle = myObj.nextInt();

        System.out.println("Voulez vous un parking \n 1: oui \n 2: non");
        int parking = myObj.nextInt();

        System.out.println("Voulez vous un accès handicapé \n 1: oui \n 2: non");
        int accesHandicape = myObj.nextInt();

        System.out.println("Voulez vous un dépaneur \n 1: oui \n 2: non");
        int depaneur = myObj.nextInt();

        System.out.println("Voulez vous un restaurant \n 1: oui \n 2: non");
        int restaurant = myObj.nextInt();

        newFiltre = new Filtre(region,type,typeChambre,dateFin,dateDebut,piscine,salle,parking,accesHandicape,depaneur,restaurant);

        ArrayList<Hebergement> hebergements = (ArrayList<Hebergement>) Main.connected.seachHebergement(newFiltre);
        return hebergements;
    }

    public static void createReservation(Client user, Hebergement hebergement){
        Main.connected.createReservation(user, hebergement, newFiltre);
    }

    public static ArrayList<Reservation> seachReservation(Client user){
        ArrayList<Reservation> reservations = Main.connected.seachReservation(user);
        return reservations;
    }
}
