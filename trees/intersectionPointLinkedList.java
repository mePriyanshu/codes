import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//intersection point in linked list
class Test{
	 class Node
	{
		int data;
		Node next;
		Node(int item)
		{
			data=item;
			next=null;
		}
	}
Node start=null;

int nodeCount(Node p)
{
	if(p==null)
		return 0;
	return 1+nodeCount(p.next);
}

int intersectionPoint(Node p,Node q)						//intersection point by counting nodes
{
	if(p==null||q==null)
		return 0;
	int countP=nodeCount(p);
	int countQ=nodeCount(q);
	
	if(countP<countQ)
	{
		Node temp=p;
		p=q;
		q=temp;
	}
	while(countP!=countQ)
	{
		p=p.next;
		countP--;
	}
	while(p!=null&&q!=null)
	{
		if(p.data==q.data)
			return p.data;
		p=p.next;
		q=q.next;
	}
	return -1;
}

void insertEnd(int item)
{
	Node p=new Node(item);
	if(start==null)
	{
		start=p;
	}else
	{
		Node q=start;
		while(q.next!=null)
			q=q.next;
		q.next=p;
	}
		
}

void display(Node p)
{
	if(p==null)
		System.out.print("Linked list empty");
	while(p!=null)
	{
		System.out.print(p.data+" ");
		p=p.next;
	}
	System.out.println();
}


public static void main(String aa[])
{
	Test t1=new Test();
	t1.insertEnd(3);
	t1.insertEnd(6);
	t1.insertEnd(9);
	t1.insertEnd(15);
	t1.insertEnd(30);
	t1.display(t1.start);
	Test t2=new Test();
	t2.insertEnd(10);
	t2.insertEnd(15);
	t2.insertEnd(30);
	t2.display(t2.start);
	System.out.println(t1.intersectionPoint(t1.start, t2.start));

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
