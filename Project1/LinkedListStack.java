import java.lang.*;
import java.util.*;

public class LinkedListStack<E> implements Stack<E>{
	LinkedList<E> ll = new LinkedList<E>();

	public int size(){
		return ll.size();
	};
    
    public boolean isEmpty(){
    	return (ll.size() == 0);
    };

    public E top() throws EmptyStackException{
    	if(ll.size() == 0)
    	{
    		throw new EmptyStackException();
    	}
    	
		return (E)ll.getLast();				

    };

    public void push (E element){
    	ll.add(element);
    };
    
    public E pop() throws EmptyStackException{
    	if(ll.size() == 0)
    	{
    		throw new EmptyStackException();
    	}
    	E result = (E)ll.getLast();
    	ll.remove(result);
    	
    	return result;
    };

    public static void main (String[] args) throws Exception
 	  {
      LinkedListStack<String> arr = new LinkedListStack<String>();
      //System.out.println(arr.top());
      //arr.pop();
      arr.push ("First");
      arr.push("Second");
      arr.pop();
      arr.push("Third");
      arr.push("Fourth");
      
      String str = arr.pop();
      boolean bool=arr.isEmpty();
      System.out.println(bool);
      System.out.println("String \""+str+"\" size = "+ arr.size()+"  "+arr.pop());
  	}
};