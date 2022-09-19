public class Filtre {
    public String region;
    public String dateDebut;
    public String dateFin;
    public String type;
    public String typeChambre;
    public int piscine;
    public int salle;
    public int parking;
    public int accesHandicape;
    public int depaneur;
    public int restaurant;

    public Filtre(String region, String dateDebut, String dateFin, String type, String typeChambre, int piscine, int salle, int parking, int accesHandicape, int depaneur, int restaurant) {
        this.region = region;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.typeChambre = typeChambre;
        this.piscine = piscine;
        this.salle = salle;
        this.parking = parking;
        this.accesHandicape = accesHandicape;
        this.depaneur = depaneur;
        this.restaurant = restaurant;
    }
}
