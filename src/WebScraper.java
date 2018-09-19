import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"))); //31,955
        System.out.println(wordCount(urlToString("https://www.bls.gov/tus/charts/chart9.txt"))); //78
        System.out.println(wordCount(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"))); // 1021
        System.out.println(oneWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Prince"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
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

    /**
     * calculates how many words there are in the url
     * @param url the url
     * @return the wordcount in integer
     */
    public static int wordCount(String url) {
//        Scanner in = new Scanner(url);
//        int count = 0;
//        while(in.hasNext()) {
//            in.next();
//            count++;
//        }
//        return count;
        return url.split("\\s+").length;
    }

    /**
     * Return how many times word was found in url
     * @param url the link
     * @param word the keyword
     * @return integer
     */
    public static int oneWordCount(String url, String word) {
        String lowCase = url.toLowerCase();
        String keyWord = word.toLowerCase();
        return lowCase.split(keyWord).length - 1;
    }
}
