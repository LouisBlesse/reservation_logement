public class Hebergement {
    public String id;
    public String nom;
    public String type;
    public String region;
    public int nombreChambres;
    public int nombreChambresDouble;
    public int nombreChambresSuites;
    public int piscine;
    public int salle;
    public int parking;
    public int accesHandicape;
    public int depaneur;
    public int restaurant;

    public Hebergement(String nom, String type, String region, int nombreChambres, int nombreChambresDouble, int nombreChambresSuites, int piscine, int salle, int parking, int accesHandicape, int depaneur, int restaurant) {
        this.nom = nom;
        this.type = type;
        this.region = region;
        this.nombreChambres = nombreChambres;
        this.nombreChambresDouble = nombreChambresDouble;
        this.nombreChambresSuites = nombreChambresSuites;
        this.piscine = piscine;
        this.salle = salle;
        this.parking = parking;
        this.accesHandicape = accesHandicape;
        this.depaneur = depaneur;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Hebergement{" +
                "nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", nombreChambres=" + nombreChambres +
                ", nombreChambresDouble=" + nombreChambresDouble +
                ", nombreChambresSuites=" + nombreChambresSuites +
                ", piscine=" + piscine +
                ", salle=" + salle +
                ", parking=" + parking +
                ", accesHandicape=" + accesHandicape +
                ", depaneur=" + depaneur +
                ", restaurant=" + restaurant +
                '}';
    }

    public Hebergement(String id, String nom, String type, String region, int nombreChambres, int nombreChambresDouble, int nombreChambresSuites, int piscine, int salle, int parking, int accesHandicape, int depaneur, int restaurant) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.region = region;
        this.nombreChambres = nombreChambres;
        this.nombreChambresDouble = nombreChambresDouble;
        this.nombreChambresSuites = nombreChambresSuites;
        this.piscine = piscine;
        this.salle = salle;
        this.parking = parking;
        this.accesHandicape = accesHandicape;
        this.depaneur = depaneur;
        this.restaurant = restaurant;
    }

    public Hebergement() {
        this.nom = "nom";
    }
}
