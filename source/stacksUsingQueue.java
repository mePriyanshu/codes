
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test{
	
	Queue<Integer> q1=new LinkedList<>();
	Queue<Integer> q2=new LinkedList<>();
	void push(int item)
	{
		q1.add(item);
	}
	
	int pop()
	{
		int i=0;
		int n=q1.size();
		while(i!=n-1)
		{
			q2.add(q1.poll());
			i++;
		}
		int lastElement=q1.poll();
		Queue<Integer> temp=q1;
		q1=q2;
		q2=temp;
		return lastElement;
	}
	void display()
	{
		Iterator i=q1.iterator();
		while(i.hasNext())
		{
			System.out.print(i.next()+" ");
		}
		System.out.println();
	}
	
	void pushOneQueue(int item)
	{
		int n=q1.size();
		q1.add(item);
		int i=0;
		while(i!=n)
		{
			q1.add(q1.poll());
			i++;
		}
	}
	public static void main(String aa[])
	{
		
		Test t1=new Test();
		t1.pushOneQueue(10);
		t1.pushOneQueue(20);
		t1.pushOneQueue(30);
		t1.pushOneQueue(40);
		t1.pushOneQueue(50);
		t1.display();
		//System.out.println(t1.pop());
		//System.out.println(t1.pop());
		//t1.display();
		
		
	}
}