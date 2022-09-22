import java.time.LocalDate;

public class Reservation {
    public String id;
    public String idClient;
    public String idHebergement;
    public String dateFin;
    public String dateDebut;
    public String typeChambre;

    public Reservation(String id, String idClient, String idHebergement, String dateFin, String dateDebut, String typeChambre) {
        this.id = id;
        this.idClient = idClient;
        this.idHebergement = idHebergement;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
        this.typeChambre = typeChambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", idClient='" + idClient + '\'' +
                ", idHebergement='" + idHebergement + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", dateDebut='" + dateDebut + '\'' +
                ", typeChambre='" + typeChambre + '\'' +
                '}';
    }
}
