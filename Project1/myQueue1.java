import java.lang.*;
import java.util.*;

public class myQueue1<E> implements Queue<E>{
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
		if(Stack1.isEmpty() == true)
		{
        	throw new EmptyStackException();
      	}
      	while(Stack1.isEmpty() == false)
      	{
      		//System.out.println("Stack2.push(Stack1.pop()) = "+Stack1.top());
      		Stack2.push(Stack1.pop());
      	}
      	E result = (E)Stack2.top();
      	while(Stack2.isEmpty() == false)
      	{
      		//System.out.println("Stack1.push(Stack2.pop()) = "+Stack2.top());
      		Stack1.push(Stack2.pop());
      	}
      	//System.out.println("result = "+result);
      	return result;
	};

	public void enqueue(E a){
		System.out.println("Pushing element : "+a);
		Stack1.push(a);
		Q_rear = (Q_rear+1) % Q_size;
	}
	public E dequeue(){
		if(Stack1.isEmpty() == true)
		{
        	throw new EmptyStackException();
      	}
      	while(Stack1.isEmpty() == false)
      	{
      		System.out.println("Stack2.push(Stack1.pop()) = "+Stack1.top());
      		Stack2.push(Stack1.pop());
      	}
      	E result = (E)Stack2.pop();
      	while(Stack2.isEmpty() == false)
      	{
      		System.out.println("Stack1.push(Stack2.pop()) = "+Stack2.top());
      		Stack1.push(Stack2.pop());
      	}
      	System.out.println("result = "+result);
      	Q_front = (Q_front+1) % Q_size;
      	return result;
	}

	public static void main(String[] args) throws Exception{
		myQueue1<Integer> queue = new myQueue1<Integer>();
		for (int i = 1;i<=10;i++)
			queue.enqueue(i);
		for (int i = 1;i<=8;i++)
			queue.dequeue();
      	System.out.println("size = "+queue.size());
      	System.out.println("front = "+queue.front());

	}
}