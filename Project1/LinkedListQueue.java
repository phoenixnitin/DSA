import java.lang.*;
import java.util.*;

public class LinkedListQueue<E> implements Queue<E>{
	LinkedList<E> ll = new LinkedList<E>();
	private int Q_size=100000;
	public int size(){
		return ll.size();
	};

	public boolean isEmpty(){
		return (ll.size() == 0);
	};

	public E front() throws EmptyQueueException{
		if(ll.size() == 0)
    	{
    		throw new EmptyQueueException();
    	}
		return (E)ll.getFirst();	
	};

	public void enqueue (E element) throws FullQueueException{
		if(ll.size() == Q_size-1)
		{
			throw new FullQueueException();
		}
		ll.add(element);
	};

	public E dequeue() throws EmptyQueueException{
		if(ll.size() == 0)
    	{
    		throw new EmptyStackException();
    	}
    	E result = (E)ll.getFirst();
    	ll.remove(result);
    	
    	return result;
	};

	public static void main (String[] args) throws Exception
 	{
	    LinkedListQueue<String> arr = new LinkedListQueue<String>();
	    //System.out.println(arr.front());
	    //arr.dequeue();
	    arr.enqueue ("First");
	    arr.enqueue("Second");
	    arr.dequeue();
	    arr.enqueue("Third");
	    arr.enqueue("Fourth");
	     
	    String str = arr.dequeue();
	    boolean bool=arr.isEmpty();
	    System.out.println(bool);
	    System.out.println("String \""+str+"\" size = "+ arr.size()+"  "+arr.dequeue());
  	}
};