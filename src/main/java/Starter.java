import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        System.out.println(numWords(urlToString("https://www.bls.gov/tus/charts/chart9.txt")));
        System.out.println(wordCount(urlToString("https://www.bls.gov/tus/charts/chart9.txt"), "all"));
        System.out.println(wordCount(urlToString("https://www.bls.gov/tus/charts/chart9.txt"), "minutes"));
    }

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int numWords(String url) {
        int words = 1;
        for (int i = 0; i < url.length(); i++)
        {
            if (url.charAt(i) == ' ')
            {
                words++;
            }
        }
        return words;
    }

    public static int wordCountCase(String url, String key) {
        int count = url.split(key).length - 1;
        return count;
    }

    public static int wordCount(String url, String key) {
        int count = url.toLowerCase().split(key).length - 1;
        return count;
    }
}
