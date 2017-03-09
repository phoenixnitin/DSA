import java.lang.*;
import java.util.*;

public class ArrayStack<E> implements Stack<E> {
    private int max_size = 100;
    private int top = -1;
    private ArrayList<E> Arr = new ArrayList<E>();

    public int size(){
      return top;
    };

  	public boolean isEmpty(){
  		return (top<0);
  	};

  	public E top() throws EmptyStackException{
  		if(top < 0)
        {
          throw new EmptyStackException();
        }
      return Arr.get(top);
    };

    public void push (E element){
    	Arr.add(++top,element);
    };

    public E pop() throws EmptyStackException{
      if(top < 0)
      {
        throw new EmptyStackException();
      }
    	E result = Arr.get(top);
    	Arr.remove(top--);
    	return result;
    };

    public static void main (String[] args) throws Exception
 	  {
      ArrayStack<String> arr = new ArrayStack<String> ();
      arr.push ("First");
      arr.push("Second");
      arr.pop();
      arr.push("Third");
      arr.push("Fourth");
      arr.push("Fifth");
    	String str = arr.pop();
    	boolean bool=arr.isEmpty();
      str = arr.top();
      System.out.println(bool);
      System.out.println("String \""+str+"\" size = "+ arr.size());
  	}

}