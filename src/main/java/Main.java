import java.sql.*;
import java.util.Scanner;

public class Main {
    static ConnectBDD connected;
    static Client user;
    public static void main (String args[])  {
        System.out.println("Hello project");
        connected = new ConnectBDD();
        connected.connect();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Que voulez vous faire ?\n 1: Se connecter \n 2: Se creer un compte");
        int choix = myObj.nextInt();

        if(choix == 1){
            user = connectClient();
        }
        else{
            createClient();
            user = connectClient();
        }

        System.out.println("Bonjour "+ user.nom);
    }

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

        connected.newClient(newClient);

    };

    public static Client connectClient(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Quel est votre nom de compte ?");
        String nom = myObj.nextLine();

        System.out.println("Quel est votre mot de passe ?");
        String mdp = myObj.nextLine();

        Client user = connected.connectClient(nom, mdp);
        return user;
    }
}
