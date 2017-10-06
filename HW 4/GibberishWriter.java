import java.util.*;
import java.lang.String;
import java.io.*;

/**
 * This class represents GibberishWriter which outputs Gibberish based on word input
 * @author Isaac Ng
 */
public class GibberishWriter /*implements Iterator<ContextData>*/{
  
  //ArrayList that takes ContextData
  private ArrayList<ContextData> cdArray;
  
  //the size of the Context
  private int contextSize;
  
  /**
   * Creates GibberishWriter with contextSize and ArrayList of ContextData
   * @param contextSize the size of the context
   * @param cdArray the Arraylist of ContextData
   */
  public GibberishWriter(int contextSize, ArrayList<ContextData> cdArray){
    this.contextSize = contextSize;
    this.cdArray = cdArray;
  }
  
  /**
   * gets the contextsize
   * @return the contextsize
   */
  public int getContextSize(){
    return contextSize;
  }
  
  /**
   * gives you the data at the inputted index
   * @param index, the place where the data is at
   * @return returns context data at the given index
   */
  public ContextData getContextData(int index){
    return cdArray.get(index);
  }
  
  /**
   * Creates new contextdata using context and linkedlist
   * @param context the context to be added
   * @param LinkedList the linkedlist to be added
   * @return ContextData modified with the linkedlist and context
   */
  public static ContextData addContextData(Context context, LinkedList<ContextData> linked){
    LLIterator<ContextData> iter = linked.iterator(); //the iterator to step through
    GibberishWriter gibbyshark = new GibberishWriter(1, new ArrayList<ContextData>()); //the gibberish writer
    ContextData data = gibbyshark.new ContextData(context); //contextdata that created out of context
    while (iter.hasNext()){ //identifies whether context is in contextdata and returns appropriate value while list can be iterated thorugh
      ContextData next = iter.next();
      if ((next.getContext()).compareTo(context) == 0)
        return next;
      else if (context.compareTo(next.getContext()) < 0){
        iter.addBefore(next);
        return next;
      }
      else{
        iter.addAfter(next);
        return next;
      }
    }
    linked.addToFront(data);
    return data;
  }
  
  /**
   * Loads data file and adds it to linkedlist
   * @param Filename the name of the file to be loaded in
   */
  public void addDataFile(String fileName) throws FileNotFoundException{
    LinkedList<ContextData> linked = new LinkedList<ContextData>(); //created linkedlist
    
    //converts linked list to array list
    for (int i = cdArray.size() - 1; i >= 0; i--){
      linked.addToFront(this.getContextData(i));
    }
    
    Scanner sc = new Scanner(new File(fileName)); //scanner created
    String[] sarray = new String[this.getContextSize()]; //string array created to add to context
    sc.useDelimiter(" "); 
    for (int i = 0; i < this.getContextSize(); i++){
      sarray[i] = sc.next();
    }
    
    Context c = new Context(sarray); //creates context
    for (int j = 0; j < sarray.length; j++){
      ContextData cdata = addContextData(c, linked);
      cdata.addFollowingWord(sarray[j]);
      for (int k = 0; k < c.length() && k > 0; k++){ //shifting context
        if (k == c.length() - 1){
          sarray[k] = sarray[j];
        }
        else{
          sarray[k] = sarray[k-1];
        }
        c = new Context(sarray);
      }
    }
    sc.close();
    this.cdArray = linked.toArrayList();
  }
  
  /**
   * returns true if arraylist has contextdata values
   * @return boolean whether the cdarray has context data in it
   */
  public boolean hasNext(){
    return cdArray.iterator().hasNext();
  }
  
  /**
   * use binary searcht to get contextdata, then returns random word and shifts context
   *
  public String next(){ 
    if (!hasNext()){
      Context lcontext = cdArray.iterator().next();
    }
    else{
      Context ccontext = Collections.binarySearch(cdArray, lcontext);
      String word = lcontext.getFollowingWord(random.nextInt(numOccurences) + 1);
      return word;
    }
    return null;
  }
  */
  
  
  /**
   * This inner class creates contextdata
   * @author Isaac Ng
   */
  class ContextData implements Comparable<Context>{
    
    // the context
    private Context data;
    //variable for how often word occurs
    private int occur;
    //Linked list of worddata
    private LinkedList<WordData> store;
    
    /**
     * Creates ContextData with context
     * @param context the context to be set to the contextdata
     */
    public ContextData(Context context){
      this.data = context;
      this.occur = 0;
      this.store = new LinkedList<WordData>();
    }
    
    /**
     * Gets the stored context
     * @return the context stored
     */
    public Context getContext(){
      return data;
    }
    
    /**
     * Gets the number of occurences
     * @return the number of occurences
     */
    public int numOccurrences(){
      return occur;
    }
    
    /**
     * returns number based on one context compared to another
     * @param Context the context to be compared
     * @return the number
     */
    public int compareTo(Context other){
      int compare = this.compareTo(other);
      return compare;
    }
    
    
    /**
     * adds the word that is inputed
     * @param word to be added
     */
    public void addFollowingWord(String word){ 
      boolean found = false; //boolean indicating whether found or not
      WordData container = new WordData(word); //mkaing the word data
      LLIterator<WordData> iter = store.iterator(); //iterator to step through
      if (store.isEmpty()){ //empty case
        store.addToFront(container);  
      }
      while (iter.hasNext() && !found){ //if next and not found
        WordData w = iter.next();
        if (word.compareTo(w.getWord()) == 0){ //is found
          w.incrementCount();
          found = true;
        }
        else if (word.compareTo(w.getWord()) < 0){ //if not found and added to iter
          iter.addBefore(container);
          found = true;
        }
        else if (found == false && !iter.hasNext()) //addding to after
          iter.addAfter(container);
      }
    }
    
    /**
     * Gets the following word at the index
     * @param the int the index at where the word is
     * @return the word that is there
     */
    public String getFollowingWord(int place){
      if (place < 1 || place > store.length()){
        throw new IndexOutOfBoundsException();
      }
      ArrayList<WordData> array = store.toArrayList();
      return array.get(place).getWord();
    }
  }
  
  /**
   * This inner class creates a context
   * @author Isaac Ng
   */
  class Context implements Comparable<Context>{
    
    //the context made of a string array
    private String[] context;
    
    /**
     * Creates context with a string array
     * @param sarray used to create the context
     */
    public Context(String[] sarray){
      context = new String[sarray.length];
      for (int i = 0; i < sarray.length; i++){
        context[i] = sarray[i];
      }
    }
    
    /**
     * returns the context's length
     * @return the context's length
     */
    public int length(){
      return context.length;
    }
    
    /**
     * Creates string version of context
     * @return the context converted to string
     */
    public String toString(){
      StringBuilder s = new StringBuilder(); //Stringbuilder used to build the string
      for (int i = 0; i < context.length; i++){ //steps thorugh and creates string
        if (i == context.length - 1){
          s.append(context[i]);
        }
        else{
          s.append(context[i] + " ");
        }
      }
      return s.toString();
    }
    
    /**
     * gets the word at teh desired index
     * @param i the index where the word is at
     * @return the word at int i
     */
    public String getWord(int i){
      return context[i];
    }
    
    /**
     * Returns a boolean based on comparison of the contexts
     * @param o object to be compared to the context
     * @return the boolean that says whether equal or not
     */
    @Override
    public boolean equals(Object o){
      if (o instanceof Context){
        Context c = (Context)o;
        int marker = 0; //signifies whether it is end
        if (this.length() == c.length()){
          for (int i = 0; i < this.length(); i++){
            if (this.getWord(i) == c.getWord(i))
              marker = marker + 1; //increments as you go word by word
          }
          if (marker == this.length()) //if it reaches the end and everything is same, returns true
            return true;
        }
        else{
          return false;
        }
        return false;
      }
      else{
        return false;
      }
    }
    
    /**
     * compares contexts and returns int based on they're equality
     * @param context the context to be compared
     * @return int -1, 1, 0 if the contexts are compared to each other
     */
    public int compareTo(Context other){
      int i = 0;
      int compare = 0;
      while (i < context.length){
        compare = this.getWord(i).toLowerCase().compareTo(other.getWord(i).toLowerCase());
        if (compare == 0){
          if (i == this.length() || i == other.length())
            return compare;
          i = i + 1;
        }
        else{
          return compare;
        }
      }
      return compare;
    }
  }
  
  /**
   * This class represents the data about a word
   * @author Isaac Ng
   */
  class WordData{
    
    //the word stored
    private String word;
    //the count of how many times it appears
    private int count;
    
    /**
     * Creates WordData based on word 
     * @param word, the word to be stored
     */
    public WordData(String word){
      this.word = word;
      this.count = 1;
    }
    
    /**
     * increments the count
     */
    public void incrementCount(){
      count = count + 1;
    }
    
    /**
     * Gets the word stored
     * @return the stored word
     */
    public String getWord(){
      return word;
    }
    
    /**
     * gets the count 
     * @return the count stored
     */
    public int getCount(){
      return count; 
    }
  }
}


