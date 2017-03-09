import java.lang.*;
import java.util.*;

public class myQueue1<E> extends ArrayStack{
	ArrayStack Stack1 = new ArrayStack();
	ArrayStack Stack2 = new ArrayStack();
	public <K>int enqueue(K a){
		System.out.println("Pushing element : "+a);
		Stack1.push(a);
		return 0;
	}
	public <K>K dequeue(){
		if(Stack1.isEmpty() == true)
		{
        	throw new EmptyStackException();
      	}
      	while(Stack1.isEmpty() == false)
      	{
      		System.out.println("Stack2.push(Stack1.pop()) = "+Stack1.top());
      		Stack2.push(Stack1.pop());
      	}
      	K result = (K)Stack2.pop();
      	while(Stack2.isEmpty() == false)
      	{
      		System.out.println("Stack1.push(Stack2.pop()) = "+Stack2.top());
      		Stack1.push(Stack2.pop());
      	}
      	System.out.println("result = "+result);
      	return result;
	}

	public static void main(String[] args) throws Exception{
		myQueue1<Integer> queue = new myQueue1<Integer>();
		for (int i = 1;i<=10;i++)
			queue.enqueue(i);
		for (int i = 1;i<=10;i++)
			queue.dequeue();
	}
}