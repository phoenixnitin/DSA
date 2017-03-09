import java.lang.*;
import java.util.*;

public class ArrayStack<E> implements Stack<E> {
    private int max_size = 100000;
    private int top = -1;
    private E[] Arr = (E[])new Object[max_size];

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
      return Arr[top];
    };

    public void push (E element){
    	Arr[++top] = element;
    };

    public E pop() throws EmptyStackException{
      if(top < 0)
      {
        throw new EmptyStackException();
      }
    	E result = Arr[top];
    	Arr[top--] = null;
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
      
    	String str = arr.pop();
    	boolean bool=arr.isEmpty();
      str = arr.top();
      System.out.println(bool);
      System.out.println("String \""+str+"\" size = "+ arr.size());
  	}

}