import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PreProcessor {

    public static void main(String args[]) throws IOException {

        List<String> words = new ArrayList<>();
        ArrayList<String> stopWords = getStopWords();

        try {
            
            File input = new File("Trec_microblog11.txt");
            // File input = new File("Trec_microblog11.txt");

            System.out.println("Opened successfully");
            Scanner scanner = new Scanner(input);
        
            while (scanner.hasNext()) {
                // change word to lower case
                String word = scanner.next().toLowerCase();

                // remove special characters and numbers
                word = word.replaceAll("[^a-zA-Z]","");
                
                // store in array
                if (word.length() > 0) {
                    words.add(word);
                }
            }

            // remove all the stop words 
            words.removeAll(stopWords);
            // for (String word: words) {
            //     System.out.println(word);
            // }

            // close scanner 
            scanner.close();
        }   catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;

        }
    }

    
    private static ArrayList<String> getStopWords() throws IOException{
        // extract stop words from stopwords.txt and store in array
        ArrayList<String> stopWords = new ArrayList<String>();

        // open file and store words in array 
        try {
            File input = new File("StopWords.txt");
            Scanner scanner = new Scanner(input);
        
            while (scanner.hasNext()) {
                String word = scanner.next();
                stopWords.add(word);
            }

            // close scanner 
            scanner.close();
        }   catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        return stopWords;

        
    }  


}