import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        //inputs user variables
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a url: ");
        String website = userInput.nextLine();
        System.out.println("Input a search term: ");
        String searchTerm = userInput.nextLine();
        userInput.close();

        //tests webcrawler
        String tester = urlToString(website);
        System.out.println(tester);
        System.out.println("Found " + wordCount(tester, searchTerm) + " times");
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    private static String urlToString(final String url) {
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

    /**
     *
     * @param contents string of which to parse through
     * @param searchTerm term searched for
     * @return the number of times the searchTerm was found
     */
    private static int wordCount(final String contents, final String searchTerm) {
        int wordLength = searchTerm.length();
        int countedTimes = 0;
        for (int index = 1; index < (contents.length() - wordLength); index++) {
            if (contents.substring(index, index + wordLength).equalsIgnoreCase(searchTerm)) {
                countedTimes++;
            }
        }
        return countedTimes;
    }

}
