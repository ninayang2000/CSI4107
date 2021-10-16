import java.util.*;


public class InvertedIndex {



    // inverted index will be a hshmap

    // private Map<String, documentTfTuple> invertedIndex = new Hashmap<>();

    private Map<String, Posting> invertedIndex = new HashMap<String, Posting>();

    // public void addToIndex(String indexTerm, documentTfTuple tuple) {
    //     // if index term is not yet in hashmap
    //     if(!invertedIndex.containsKey(indexTerm)) {
    //         // add the term in the hashmap
    //         List<documentTfTuple> array = new ArrayList<documentTfTuple>();
    //         array.add(tuple);
    //         invertedIndex.put(indexTerm, array);
    //     }
    //     // if term already in hash map -- only add the tuple
    //     invertedIndex.get(indexTerm).add(tuple);
    // }


  public Map<String, Posting> getMap(){
    return invertedIndex;
  }

    public void addToIndex(String indexTerm, documentTfTuple tuple) {
        // if index term is not yet in hashmap
        if(!invertedIndex.containsKey(indexTerm)) {
            // add the term in the hashmap
            List<documentTfTuple> array = new ArrayList<documentTfTuple>();
            array.add(tuple);
            int df = array.size();
            Posting posting = new Posting(df,array);
            invertedIndex.put(indexTerm, posting);
        } else {
            invertedIndex.get(indexTerm).getPostingList().add(tuple);
            int df = invertedIndex.get(indexTerm).getPostingList().size();
            invertedIndex.get(indexTerm).setDocf(df);
        }
        // if term already in hash map -- only add the tuple

    }

    public void printIndex() {
        // System.out.println(invertedIndex.entrySet());

        for (String index: invertedIndex.keySet()) {
            System.out.print(index + " [DF: " + invertedIndex.get(index).getDocf() + "] -> ");
            for (documentTfTuple tup: invertedIndex.get(index).getPostingList()) {
              // if (!(tup.getTermFrequency() == 0)) {
              //     tup.printTuple();
              //
              // }
              tup.printTuple();
            }

            System.out.println();

        }

    }







}
