
import java.util.*;
public class My_Stack
{
  
  void sortStack(Stack<Integer> s)
  {
	 
	  if(!s.isEmpty())
	  {
		  int temp=s.pop();
		  sortStack(s);
		  sortInsert(s,temp);
	  }
  }
  
  void sortInsert(Stack<Integer>s,int item)
  {
	  if(s.isEmpty()||item>s.peek())
	  {
		  s.push(item);
	  }
	  else
	  {
		  int temp=s.pop();
		  sortInsert(s,item);
		  s.push(temp);
	  }
  }
	public static void main(String aa[])
	{
	Stack<Integer> s=new Stack<Integer>();
	s.push(10);
	s.push(2);
	s.push(30);
	s.push(40);
	s.push(50);
	My_Stack m1=new My_Stack();
	m1.sortStack(s);
	System.out.println(s);
	

	}
}