import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Salaire {

    private String nom;
    private double salaire;
    private String prenom;
    private final String identification;
    private double prime;
    private int anciennete;

    public Salaire(String nom,String prenom,int anciennete,double salaire) {
        this.nom=nom;
        this.prenom=prenom;
        this.anciennete=anciennete;
        this.salaire=salaire*0.7;
        this.identification=nom+prenom+new Random().nextInt(1000);
        this.prime=0;
    }

    public void setPrime(double prime) {
        checkNotNull(prime,"La prime ne peut pas etre nulle");
        this.prime = prime*100/this.anciennete;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setSalaire(double salaire) {
        checkNotNull(salaire,"Le salaire ne peut pas etre nul");
        checkArgument(salaire<=0,"Le salaire doit etre positif");
        checkArgument(salaire>=10000,"Le salaire ne doit pas dépasser 10000€");
        this.salaire = salaire*0.7;
    }
    public void setAnciennete(int anciennete) {
        checkNotNull(anciennete,"L'ancienneté ne peut pas etre nulle");
        this.anciennete = anciennete;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public double getSalaire() {
        return salaire;
    }
    public String getIdentification() {
        return identification;
    }
    public double getPrime() {
        return prime;
    }
    public int getAnciennete() {
        return anciennete;
    }
}
