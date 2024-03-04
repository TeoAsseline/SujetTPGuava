import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LireMonFichier {
    public void lireFichiercorrompu() throws IOException {
        File file = new File("mailCorrompu.txt");
        String content = Files.asCharSource(file, Charsets.UTF_8).read();
        String output = CharMatcher.is('@').replaceFrom(content, "e");
        output = CharMatcher.is('%').replaceFrom(output, "i");
        output = CharMatcher.is('+').replaceFrom(output, "s");
        output = CharMatcher.is('^').replaceFrom(output, "o");
        File fileToSave = new File("MailDecorrompu.txt");
        Files.asCharSink(fileToSave, Charsets.UTF_8).write(output);
    }

    public void lireFichierconversation() throws IOException{
        File file = new File("conversationCorrompu.txt");
        String content = Files.asCharSource(file, Charsets.UTF_8).read();
        Iterable iterable = Splitter.on('\n').omitEmptyStrings().split(content);
        List<String> phrases = iterableToList(iterable);
        List<String> phrasesOrdonne = new ArrayList<>();
        phrasesOrdonne.add(phrases.get(0));
        phrasesOrdonne.add(phrases.get(7));
        phrasesOrdonne.add(phrases.get(4));
        phrasesOrdonne.add(phrases.get(6));
        phrasesOrdonne.add(phrases.get(5));
        phrasesOrdonne.add(phrases.get(1));
        phrasesOrdonne.add(phrases.get(3));
        phrasesOrdonne.add(phrases.get(2));
        String output = joinListToString(phrasesOrdonne);
        File fileToSave = new File("conversationDecorrompu.txt");
        Files.asCharSink(fileToSave, Charsets.UTF_8).write(output);
    }

    private static <T> ArrayList<T> iterableToList(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    private static String joinListToString(List<String> list) {
        return Joiner.on("\n").join(list);
    }

    public static void main(String[] args) throws IOException {
        LireMonFichier lireMonFichier = new LireMonFichier();
        lireMonFichier.lireFichiercorrompu();
        lireMonFichier.lireFichierconversation();
    }
}
