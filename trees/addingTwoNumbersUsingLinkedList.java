import java.security.Timestamp;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
//adding two numbers using linked list
class Test{
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
		next=null;
	}
}
Node start=null;

void insertEnd(int data)
{
	Node p=new Node(data);
	if(start==null)
		start=p;
	else
	{
		Node q=start;
		while(q.next!=null)
			q=q.next;
		q.next=p;
	}
	
}

void display(Node p)
{
	
	if(p==null){
		System.out.println("Linked List Empty");
		return;
	}
	while(p!=null){
		System.out.print(p.data+" ");
		p=p.next;
	}
	System.out.println();
}


Node reverse(Node p)
{
	Node curr=p,next=null,prev=null;
	while(curr!=null)
	{
		next=curr.next;
		curr.next=prev;
		prev=curr;
		curr=next;
	}
	p=prev;
	return p;
}

Test  addTwoNumbers(Node p,Node q,Test t3)
{
	if(p==null)return null;
	if(q==null)return null;
	int sum=0;
	while(p!=null||q!=null)
	{
	  sum+=((p!=null)?p.data:0)+((q!=null)?q.data:0);
	  if(p!=null)
		  p=p.next;
	  if(q!=null)
		  q=q.next;
	  if(sum>9)
	  {
		  t3.insertEnd(sum%10);
		  sum/=10;
	  }else{
		  t3.insertEnd(sum);
		  sum=0;
		  }
	}
	if(sum>0)
		t3.insertEnd(sum);
		
	return t3;
	
}
public static void main(String aa[])
{
	Test t1=new Test();
	t1.insertEnd(9);
	t1.insertEnd(9);
	t1.insertEnd(9);
	
	t1.start=t1.reverse(t1.start);
	//t1.display(t1.start);
	
	Test t2=new Test();
	t2.insertEnd(9);
	t2.insertEnd(9);
	t2.insertEnd(9);
	t2.start=t2.reverse(t2.start);
	
	Test t3=new Test();
	t3=t3.addTwoNumbers(t1.start,t2.start,t3);
	t3.start=t3.reverse(t3.start);
	t3.display(t3.start);
	
}
    
	
}

class Scan
	{
	   // BufferedReader br;
	    StringTokenizer st;
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String scanString() throws IOException
	    {
	        while(st==null||!st.hasMoreTokens())
	        {
	            st=new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }
	    int scanInt() throws IOException
	    {
	        return parseInt(scanString());
	    }
	    
	    
	}


	
	//901601001507006
	//y7G3Tz
	
	//adhar 350294648107
	//income-073161017748