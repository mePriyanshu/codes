import java.io.*;
import java.util.*;
public class My_Stack
{
  Stack<Integer> s1=new Stack<Integer>();
  public  Stack<Integer> Rev(Stack<Integer> s)
  {
	  if(s.isEmpty())
		  return null;
	  s1.push(s.peek());
	  s.pop();
	  Rev(s);
	  return s1;
	  
  }
	public static void main(String aa[])
	{
	Stack<Integer> s=new Stack<Integer>();
	s.push(10);
	s.push(20);
	s.push(30);
	s.push(40);
	s.push(50);
	My_Stack m1=new My_Stack();
	System.out.println(s);
	System.out.println(m1.Rev(s));

	}
}