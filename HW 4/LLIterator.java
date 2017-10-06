import java.util.*; 
/**
 * an interface LinkedList
 * @author Isaac Ng
 */

public interface LLIterator<E> extends Iterator<E>{
  //method stub addAfter
  void addAfter(E element);
  //method stub addBefore
  void addBefore(E element);
}
