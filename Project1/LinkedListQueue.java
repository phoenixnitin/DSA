import java.lang.*;
import java.util.*;

public class LinkedListQueue<E> implements Queue<E>{
	LinkedList<E> linkedlist = new LinkedList<E>();
	private int Q_size=100000;
	public int size(){
		return linkedlist.size();
	};

	public boolean isEmpty(){
		return (linkedlist.size() == 0);
	};

	public E front() throws EmptyQueueException{
		if(linkedlist.size() == 0)
    	{
    		throw new EmptyQueueException();
    	}
		return (E)linkedlist.getFirst();	
	};

	public void enqueue (E element) throws FullQueueException{
		if(linkedlist.size() == Q_size-1)
		{
			throw new FullQueueException();
		}
		linkedlist.add(element);
	};

	public E dequeue() throws EmptyQueueException{
		if(linkedlist.size() == 0)
    	{
    		throw new EmptyStackException();
    	}
    	E result = (E)linkedlist.getFirst();
    	linkedlist.remove(result);
    	
    	return result;
	};

	public static void main (String[] args) throws Exception
 	{
	    LinkedListQueue<String> array = new LinkedListQueue<String>();
	    //System.out.println(array.front());
	    //array.dequeue();
	    array.enqueue ("First");
	    array.enqueue("Second");
	    array.dequeue();
	    array.enqueue("Third");
	    array.enqueue("Fourth");
	     
	    String str = array.dequeue();
	    boolean bool=array.isEmpty();
	    System.out.println(bool);
	    System.out.println("String \""+str+"\" size = "+ array.size()+"  "+array.dequeue());
  	}
};