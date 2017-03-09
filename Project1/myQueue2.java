import java.lang.*;
import java.util.*;

public class myQueue2<E> implements Queue<E>{
	ArrayStack Stack1 = new ArrayStack();
	ArrayStack Stack2 = new ArrayStack();
	private int Q_front = 0;
	private int Q_rear = 0;
	private int Q_size = 100000;

	public int size(){
		return ((Q_size - Q_front + Q_rear) % Q_size);
	};

	public boolean isEmpty(){
		return (Q_front == Q_rear);
	};

	public E front() throws EmptyQueueException{
		if (Stack1.isEmpty()==true && Stack2.isEmpty()==true)
		{
        	throw new EmptyStackException();
      	}
      	if (Stack2.isEmpty() == true){
			while(Stack1.isEmpty() == false){
      			System.out.println("Stack2.push(Stack1.pop()) = "+Stack1.top());
				Stack2.push(Stack1.pop());
			}
		}
		return (E)Stack2.top();
	};

	public void enqueue(E a){
		System.out.println("Pushing element : "+a);
		Stack1.push(a);
		Q_rear = (Q_rear+1) % Q_size;
	}
	
	public E dequeue(){
		if (Stack1.isEmpty()==true && Stack2.isEmpty()==true){
			throw new EmptyStackException();
		}
		if (Stack2.isEmpty() == true){
			while(Stack1.isEmpty() == false){
      			System.out.println("Stack2.push(Stack1.pop()) = "+Stack1.top());
				Stack2.push(Stack1.pop());
			}
		}
      	Q_front = (Q_front+1) % Q_size;
		return ((E)Stack2.pop());
	}
	public static void main(String[] args) throws Exception{
		myQueue2<Integer> queue = new myQueue2<Integer>();
		for (int i = 1;i<=10;i++)
			queue.enqueue(i);
		for (int i = 1;i<=5;i++)
			System.out.println("Dequeue = "+queue.dequeue());
		for (int i = 11;i<=20;i++)
			queue.enqueue(i);
		for (int i = 1;i<=10;i++)
			System.out.println("Dequeue = "+queue.dequeue());
		System.out.println("size = "+queue.size());
		System.out.println("front = "+queue.front());
	}
}