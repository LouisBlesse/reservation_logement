import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ConnectBDD connected;
    static Client user;

    public static void main (String args[])  {
        connected = new ConnectBDD();
        connected.connect();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Que voulez vous faire ?\n 1: Se connecter \n 2: Se creer un compte");
        int choix = myObj.nextInt();

        if(choix == 1){
            user = SystemeGestionReservationsImpl.connectClient();
        }
        else{
            SystemeGestionReservationsImpl.createClient();
            user = SystemeGestionReservationsImpl.connectClient();
        }
        while (choix != 4){
            System.out.println("Bonjour "+ user.nom +" que voulez vous faire ?\n 1: Chercher un hébergement\n 2: Voir les réservations ");
            if(user.admin == 1){
                System.out.println(" 3: Ajouter un hébergement");
            }
            choix = myObj.nextInt();

            if(choix == 3 && user.admin == 1){
                SystemeGestionReservationsImpl.createHebergement();
            }
            else if (choix == 1){
                ArrayList<Hebergement> hebergements = (ArrayList<Hebergement>) SystemeGestionReservationsImpl.seachHebergement();
                for (Hebergement hebergement: hebergements) {
                    System.out.println("Voulez vous réserver cet hébergement ?\n"+hebergement.toString()+"\n1: oui \n2: non");
                    choix = myObj.nextInt();
                    if (choix == 1){
                        System.out.println("WIP");
                        SystemeGestionReservationsImpl.createReservation(user, hebergement);
                    }
                }
            }
            else if (choix == 2){
                ArrayList<Reservation> reservations = SystemeGestionReservationsImpl.seachReservation(user);
                for (Reservation reservation: reservations) {
                    System.out.println("Voulez vous annuler cette réservation ?\n"+reservation.toString()+"\n1: oui \n2: non");
                    choix = myObj.nextInt();
                    if (choix == 1){
                        System.out.println("WIP");
                    }
                }
            } else {
                break;
            }
        }

    }
}
