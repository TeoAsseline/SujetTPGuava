import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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

    public String getNom() {
        return nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getMail() {
        return mail;
    }
    public List<Salaire> getSalaires() {
        return salaires;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void addSalaires(List<Salaire> salaire) {
        this.salaires.addAll(salaire);
    }

    public void addSalaire(Salaire salaire) {
        this.salaires.add(salaire);
    }

    public List<Salaire> RangerSalairesOrdreDecroissant() {
        List<Salaire> salairescopy = newArrayList(this.salaires);
        Ordering<Salaire> ordering = Ordering
                .natural()
                .onResultOf(new Function<Salaire, Comparable>() {
                    @Override
                    public Comparable apply(Salaire salaire) {
                        return salaire.getSalaire();
                    }
                }).reverse();
        salairescopy.sort(ordering);
        return salairescopy;
    }

    public List<Salaire> RecupererSalaireSuperieur1500() {
        List<Salaire> salairesSup1500 = Lists.newArrayList(
                Collections2.filter(this.salaires, salaire -> salaire.getSalaire() > 1500));
        return salairesSup1500;
    }

    public Multimap<String,Double> RecupererSalaireParEmploye() {
        Multimap<String,Double> salairesParEmploye = com.google.common.collect.ArrayListMultimap.create();
        for (Salaire salaire : salaires) {
            salairesParEmploye.put(salaire.getNom()+" "+salaire.getPrenom(), salaire.getSalaire());
        }
        return salairesParEmploye;
    }
}
