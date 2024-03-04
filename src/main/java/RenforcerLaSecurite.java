import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.math.IntMath;
import java.math.BigInteger;

public class RenforcerLaSecurite {
    private static final Map<String, String> userPasswords = new HashMap<>();
    public static void factoriel() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Entrez un nombre entier positif : ");
            int userInput = scanner.nextInt();
            if (userInput < 0) {
                System.out.println("Veuillez entrer un nombre entier positif.");
            } else {
                int factorial = IntMath.factorial(userInput);
                System.out.println("Le factoriel de " + userInput + " est : " + factorial);
            }
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite. Assurez-vous d'entrer un nombre entier.");
        } finally {
            scanner.close();
        }
    }
    public static void puissance() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Entrez un nombre entier positif : ");
            int base = scanner.nextInt();
            System.out.print("Entrez la puissance (un nombre entier positif) : ");
            int exponent = scanner.nextInt();
            if (base < 0 || exponent < 0) {
                System.out.println("Veuillez entrer des nombres entiers positifs.");
            } else {
                BigInteger result = BigInteger.valueOf(base).pow(exponent);
                System.out.println(base + " élevé à la puissance " + exponent + " est : " + result);
            }
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite. Assurez-vous d'entrer des nombres entiers.");
        } finally {
            scanner.close();
        }
    }
    public static void connexion(){
        Scanner scanner = new Scanner(System.in);
        // Simulation de l'inscription d'un utilisateur
        System.out.print("Entrez un nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.print("Entrez un mot de passe : ");
        String password = scanner.nextLine();
        // Génération aléatoire d'un "salt" pour chaque utilisateur (pour des raisons de sécurité)
        String salt = Long.toString(System.nanoTime());
        // Hachage du mot de passe et stockage dans la structure de données
        String hashedPassword = hashPassword(password, salt);
        userPasswords.put(username, hashedPassword);
        // Simulation de la connexion d'un utilisateur
        System.out.print("Entrez le nom d'utilisateur pour la connexion : ");
        String loginUsername = scanner.nextLine();
        System.out.print("Entrez le mot de passe pour la connexion : ");
        String loginPassword = scanner.nextLine();
        // Vérification du mot de passe lors de la connexion
        String storedHashedPassword = userPasswords.get(loginUsername);
        String loginAttemptHash = hashPassword(loginPassword, salt);
        if (loginAttemptHash.equals(storedHashedPassword)) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Échec de la connexion. Vérifiez vos informations.");
        }
        scanner.close();
    }
    public static void main(String[] args) {
        //Test de nos fonctions de calculs
        factoriel();
        //puissance();
        //Test de notre fonction de connexion
        //connexion();
    }
    public static String hashPassword(String password, String salt) {
        // Utilisez la fonction de hachage SHA-256 de Guava avec le sel
        HashCode hashCode = Hashing.sha256().hashString(password + salt, StandardCharsets.UTF_8);
        return hashCode.toString();
    }
}