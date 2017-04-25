import java.util.ArrayList;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class BruteForceSearch {
    
    /**
     * Find all sentences/words in the
     * text and return their starting
     * indexes.
     *
     * @param text
     * @param toFind
     * @return array of indexes.
     */
    public int[] findText(String text, String toFind){
        
        
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        String[] textWords = text.split("");
        String[] toFindWords = toFind.split("");
        
    mainLoop:
        for(int i = 0; i < textWords.length; i++){
            
            if(textWords[i].equals(toFindWords[0])){
                
                for(int j = 0; j < toFindWords.length; j++){
                    
                    if(!toFindWords[j].equals(textWords[i+j]))
                        continue mainLoop;
                    
                }
                indexes.add(i);
            }
            
        }
        
        return indexes.stream().mapToInt(i -> i).toArray();
        
    }
    
    /**
     * Find sentences/words in the
     * text and return the string with
     * highlighted positions.
     *
     * The default value for
     * startHighlight is '{' and
     * endHighlight is '}' if
     * null passed.
     *
     * @param text
     * @param toFind
     * @param startHighlight
     * @param endHighlight
     * @return
     */
    public String highlightText(String text, String toFind, String startHighlight, String endHighlight){
        
        if(startHighlight == null)
            startHighlight = "{";
        if(endHighlight == null)
            endHighlight = "}";
        
        int[] indexes = findText(text, toFind);
        StringBuilder builder = new StringBuilder(text);
        int increment = 0;
        
        for(int i = 0; i < indexes.length; i++){
            builder.insert(indexes[i] + increment, startHighlight);
            increment += startHighlight.length();
            builder.insert(indexes[i] + increment + toFind.length(), endHighlight);
            increment += endHighlight.length();
        }
        
        return builder.toString();
        
    }
    
    /**
     * Main method to start executing and
     * Testing the program.
     */
    public static void main(String[] args){
        
        BruteForceSearch search = new BruteForceSearch();
        System.out.println(search.highlightText("He is a dog, he is a cat, he is an elephant", "is a", "<<", ">>"));
        
    }
    
}
