import java.lang.*;
import java.util.*;

public class myQueue2<E> extends ArrayStack{
	ArrayStack Stack1 = new ArrayStack();
	ArrayStack Stack2 = new ArrayStack();
	public <K>void enqueue(K a){
		System.out.println("Pushing element : "+a);
		Stack1.push(a);
	}
	
	public <K>K dequeue(){
		if (Stack1.isEmpty()==true && Stack2.isEmpty()==true){
			throw new EmptyStackException();
		}
		if (Stack2.isEmpty() == true){
			while(Stack1.isEmpty() == false){
      			System.out.println("Stack2.push(Stack1.pop()) = "+Stack1.top());
				Stack2.push(Stack1.pop());
			}
		}
		return ((K)Stack2.pop());
	}
	public static void main(String[] args) throws Exception{
		myQueue2<Integer> queue = new myQueue2<Integer>();
		for (int i = 1;i<=10;i++)
			queue.enqueue(i);
		for (int i = 1;i<=10;i++)
			System.out.println("Dequeue = "+queue.dequeue());
	}
}