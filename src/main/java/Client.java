public class Client {
    public String nom;
    public String adresse;
    public String courriel;
    public String tel;
    public int admin;
    public String mdp;
    public String id;

    public Client(String nom, String adresse, String courriel, String tel, int admin, String mdp) {
        this.nom = nom;
        this.adresse = adresse;
        this.courriel = courriel;
        this.tel = tel;
        this.admin = admin;
        this.mdp = mdp;
    }

    public Client(String nom, String adresse, String courriel, String tel, int admin, String mdp, String id) {
        this.nom = nom;
        this.adresse = adresse;
        this.courriel = courriel;
        this.tel = tel;
        this.admin = admin;
        this.mdp = mdp;
        this.id = id;
    }

    public Client() {
        this.nom = "nom";
    }
}
