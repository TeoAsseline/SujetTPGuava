import com.google.common.math.IntMath;
import java.math.BigInteger;
import java.util.Scanner;

public class FonctionMath {
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
    public static void main(String[] args) {
        //Test de nos fonctions de calculs
        factoriel();
        //puissance();
    }
}
