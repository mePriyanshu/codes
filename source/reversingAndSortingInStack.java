
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//reverse a stack
class Test{
	Stack<Integer> s1=new Stack();
	void add(int item)
	{
		s1.push(item);
	}
	void reverseStack()
	{
		if(s1.size()>0)
		{
			int temp=s1.pop();
			reverseStack();
			insertAtBottom(temp);
		}
	}
	void display()
	{
		System.out.print(s1);
		System.out.println();
	}
	void insertAtBottom(int item)
	{
		if(s1.isEmpty())
			s1.push(item);
		else
		{
			int temp=s1.pop();
		//	if(temp>item){
			insertAtBottom(item);
			s1.push(temp);}
			//else
			//{
			//	insertAtBottom(temp);
				//s1.push(item);
			//}
		//}
	}
	public static void main(String aa[])
	{
		Test t1=new Test();
		t1.add(10);
		t1.add(20);
		t1.add(3);
		t1.add(35);
		t1.add(50);
		t1.display();
		t1.reverseStack();
		t1.display();
	}
}