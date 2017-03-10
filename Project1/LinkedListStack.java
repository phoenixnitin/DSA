import java.lang.*;
import java.util.*;

public class LinkedListStack<E> implements Stack<E>{
	LinkedList<E> linkedlist = new LinkedList<E>();

	public int size(){
		return linkedlist.size();
	};
    
    public boolean isEmpty(){
    	return (linkedlist.size() == 0);
    };

    public E top() throws EmptyStackException{
    	if(linkedlist.size() == 0)
    	{
    		throw new EmptyStackException();
    	}
    	
		return (E)linkedlist.getLast();				

    };

    public void push (E element){
    	linkedlist.add(element);
    };
    
    public E pop() throws EmptyStackException{
    	if(linkedlist.size() == 0)
    	{
    		throw new EmptyStackException();
    	}
    	E result = (E)linkedlist.getLast();
    	linkedlist.remove(result);
    	
    	return result;
    };

    public static void main (String[] args) throws Exception
 	  {
      LinkedListStack<String> array = new LinkedListStack<String>();
      //System.out.println(array.top());
      //array.pop();
      array.push ("First");
      array.push("Second");
      array.pop();
      array.push("Third");
      array.push("Fourth");
      
      String str = array.pop();
      boolean bool=array.isEmpty();
      System.out.println(bool);
      System.out.println("String \""+str+"\" size = "+ array.size()+"  "+array.pop());
  	}
};