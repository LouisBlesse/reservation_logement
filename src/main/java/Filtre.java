public class Filtre {
    public String region;
    public String type;
    public String typeChambre;
    public String dateFin;
    public String dateDebut;
    public int piscine;
    public int salle;
    public int parking;
    public int accesHandicape;
    public int depaneur;
    public int restaurant;

    public Filtre(String region, String type, String typeChambre,String dateFin,String dateDebut, int piscine, int salle, int parking, int accesHandicape, int depaneur, int restaurant) {
        this.region = region;
        this.type = type;
        this.typeChambre = typeChambre;
        this.piscine = piscine;
        this.salle = salle;
        this.parking = parking;
        this.accesHandicape = accesHandicape;
        this.depaneur = depaneur;
        this.restaurant = restaurant;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
    }

    public Filtre() {
    }
}
