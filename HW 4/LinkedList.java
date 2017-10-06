import java.util.NoSuchElementException;
import java.util.*;

/**
 * A class to represent a linked list of nodes.
 * @author Isaac Ng
 */
public class LinkedList<T> implements Iterable<T> {
  
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> front;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    front = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFront() {
    return front;
  }
  
  /**
   * Changes the first node.
   * @param node  the first node of the new linked list
   */
  protected void setFront(LLNode<T> node) {
    this.front = node;
  }
  
  /**
   * Creates an ArrayList with the requisite nodes
   * @return the arraylist created
   */
  public ArrayList<T> toArrayList(){
    LLNode<T> nodeptr = getFront(); //LLNode created
    ArrayList<T> list = new ArrayList<T>(); //ArrayList created
    for (int i = 0; i < length(); i++){
      list.add(i, nodeptr.getElement());
      nodeptr = nodeptr.getNext();
    }
    return list;
  }
  
  /**
   * Tranlates the ArrayList to a string
   * @return the string created
   */
  public String toString(){
    return this.toArrayList().toString();
  }
  
  /**
   * Add an element to the front of the linked list
   * @param T element
   */
  public void addToFront(T element) {
    setFront(new LLNode<T>(element, getFront()));
  }
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;                      // counts number of nodes seen
    LLNode<T> nodeptr = getFront();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Remove and return the element at the front of the list
   * @return the first element of the list
   * @throws NoSuchElementException if there is no such element
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFront().getElement();
      setFront(getFront().getNext());
      return save;
    }
  }
  
  /**
   * Add an element to the very end of the list
   * @param element the element to add to the end of the list
   */
  public void addToEnd(T element) {
    if (isEmpty()) 
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFront();
      // the loop will end with nodeptr looking at the last node in list
      while (nodeptr.getNext() != null)
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /**
   * An inner class to represent the iterator of linkedlist
   * @author Isaac Ng
   */
  public class ThisListIterator implements LLIterator<T>{
    
    //previousnode of the iteration
    private LLNode<T> pnode;
    
    //boolean indicating whether next has been called
    private boolean hasstarted;
    
    /** points to the current node of the iteration */
    private LLNode<T> nodeptr;
    
    /** Create an iterator for the list starting at the inputted node
      * @param front  the first node for the iteration
      */
    public ThisListIterator(LLNode<T> front) {
      nodeptr = front;
      hasstarted = false;
    }
    
    /**
     * Returns true if there are more nodes to run through
     * @return true if there are still more values in the iteration
     */
    public boolean hasNext() {
      return nodeptr != null;
    }
    
    /**
     * adds the element before the node being called by next if next has been called and Linked List is not empty
     * @param the T element
     */
    @Override
    public void addBefore(T element){
      if (isEmpty() ||  hasstarted == false){
        throw new NoSuchElementException();
      }
      else{
        pnode.setNext(new LLNode<T>(element, nodeptr));
      }
    }
    
    /**
     * adds the element after the node being called by next if next has been called and Linked List is not empty
     * @param the T element
     */
    @Override
    public void addAfter(T element){
      if (isEmpty() || hasstarted == false){
        addToFront(element);
      }
      else if (nodeptr == null && hasstarted == true){
        addToEnd(element);
      }
      else{
        nodeptr.insertAfter(element);
      }
    }
    
    /**
     * Returns the next value stored in the linked list
     * @return the next value of the linked list
     */
    public T next() {
      pnode = nodeptr;
      hasstarted = true; 
      T save = nodeptr.getElement();
      nodeptr = nodeptr.getNext();
      return save;
    }
    
    /** Not implemented */
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
  /**
   * Required by the Iterable interface. 
   * @return an LLiterator for the list
   */
  public LLIterator<T> iterator() {
    return new ThisListIterator(getFront());
  } 
}