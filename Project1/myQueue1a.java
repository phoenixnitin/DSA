import java.lang.*;
import java.util.*;

class EmptyQueueException extends Exception{
	EmptyQueueException(){
		System.out.println("Queue is Empty");
	}
}

class FullQueueException extends Exception{
	FullQueueException(){
		System.out.println("Queue is Full");
	}
}

public class myQueue1a<E> extends ArrayStack<E> implements Queue<E>{
	private int Q_front = 0;
	private int Q_rear = 0;
	private int Q_size = 20;
	private E[] Arr = (E[])new Object[Q_size];

	public int size(){
		//System.out.println("Queue size 1 " + ((Q_size - Q_front + Q_rear) % Q_size));

		return ((Q_size - Q_front + Q_rear) % Q_size);
	};

	public boolean isEmpty(){
		return (Q_front == Q_rear);
	};
	
	public E front() throws EmptyQueueException{
		if( Q_front == Q_rear)
		{
			throw new EmptyQueueException();
		}
		return (Arr[Q_front]);
	};
	
	public void enqueue (E element) throws FullQueueException{
		
		//System.out.println("Queue size 4" + Arr.size());

		if( ((Q_size - Q_front + Q_rear) % Q_size) == (Q_size-1))
		{
			//System.out.println("Queue size 3" + Arr.size());
			throw new FullQueueException();
		}
		Arr[Q_rear] = element;
		System.out.println("enqueue = "+ Arr[Q_rear]);

		Q_rear = (Q_rear+1) % Q_size;
	};
	
	public E dequeue() throws EmptyQueueException{
		if( Q_front == Q_rear)
		{
			throw new EmptyQueueException();
		}
		E result = Arr[Q_front];
		Arr[Q_front] = null;
		Q_front = (Q_front+1) % Q_size;
		return result;
	};

	public static void main(String[] args) throws Exception{
		myQueue1a<String> queue = new myQueue1a<String>();
		for (int i = 1;i<=10;i++)
			queue.enqueue("check "+ i);
		for (int i = 1;i<=5;i++)
			System.out.println("Dequeue = "+queue.dequeue());
		for (int i = 11;i<=20;i++)
			queue.enqueue("check "+ i);
		for (int i = 1;i<=10;i++)
			System.out.println("Dequeue = "+queue.dequeue());
	}
}