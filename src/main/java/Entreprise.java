import java.util.ArrayList;
import java.util.List;

public class Entreprise {
    private String nom;
    private String adresse;
    private String telephone;
    private String mail;
    private List<Salaire> salaires;

    public Entreprise(String nom, String adresse, String telephone, String mail) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.salaires = new ArrayList<Salaire>();
    }

    public List<Salaire> getSalaires() {
        return salaires;
    }
    public void addSalaires(List<Salaire> salaire) {
        this.salaires.addAll(salaire);
    }
    public void addSalaire(Salaire salaire) {
        this.salaires.add(salaire);
    }
}