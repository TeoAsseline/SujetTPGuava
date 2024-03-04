import java.util.Random;

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

    public void setPrime(Double prime) {
        this.prime = prime*100/this.anciennete;
    }
    public void setSalaire(Double salaire) {
        this.salaire = salaire*0.7;
    }
    public void setAnciennete(Integer anciennete) {
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
    public double getPrime() {
        return prime;
    }
    public int getAnciennete() {
        return anciennete;
    }
}