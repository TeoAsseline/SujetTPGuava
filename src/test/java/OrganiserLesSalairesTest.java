import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OrganiserLesSalairesTest {

    public Entreprise entreprise;
    private Salaire salaire1;
    private Salaire salaire2;
    private Salaire salaire3;

    @BeforeEach
    //remplir creer 3 salaires et les saisir dans une entreprise
    void setUp() {
        // Création des salaires
        this.salaire1 = new Salaire("Doe", "John", 3, 1450);
        this.salaire2 = new Salaire("Doe", "Jane", 12, 2110);
        this.salaire3 = new Salaire("Doe", "Jim", 17, 3540);
        // Création de l'entreprise et ajout des salaires
        this.entreprise = new Entreprise("Doe's company","1 rue de la paix","01 02 03 04 05","doe@gmail.com");
        this.entreprise.addSalaires(Lists.newArrayList(salaire1, salaire2, salaire3));
    }

    @AfterEach
    //vider les salaires
    void tearDown() {
        this.entreprise.getSalaires().clear();
    }

    @Test
    public void salairetropgrand() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> {
            this.entreprise.getSalaires().getFirst().setSalaire(10001);
        });
    }

    @Test
    public void salairevide() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> {
            this.entreprise.getSalaires().getFirst().setSalaire(0);
        });
    }

    @Test
    public void salairecorrect() throws Exception{
        double salaire = 1450*0.7;
        assertEquals(salaire, this.entreprise.getSalaires().getFirst().getSalaire());
    }

    @Test
    public void salairesRangeParMontant() throws Exception{
        assertEquals(Arrays.asList(salaire3, salaire2, salaire1) , this.entreprise.RangerSalairesOrdreDecroissant());
    }

    @Test
    public void salairesAvecNom(){
        Multimap<String,Double> lessalaires = ArrayListMultimap.create();
        lessalaires.put("Doe John", 1450.0*0.7);
        lessalaires.put("Doe Jane",2110.0*0.7);
        lessalaires.put("Doe Jim", 3540.0*0.7);
        assertEquals(lessalaires, this.entreprise.RecupererSalaireParEmploye());
    }

    @Test
    public void salairesSuperieur1500(){
        assertEquals(Arrays.asList(
                salaire3), this.entreprise.RecupererSalaireSuperieur1500());
    }

}