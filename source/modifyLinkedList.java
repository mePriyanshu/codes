
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

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
void modifyLinkedList(Node p)
{
	Stack<Node> s1=new Stack<>();
	Node q=p;
	while(q!=null)
	{
		s1.push(q);
		q=q.next;
	}
	//System.out.print(s1+" ");
	q=p;
	while(q!=s1.peek()&&q.next!=s1.peek())
	{
		q.data=q.data-s1.peek().data;
		//System.out.print(q.data);
		q=q.next;
		s1.pop();
	}
	if(q.next==s1.peek())
	{
		q.data=q.data-q.next.data;
	}
}
public static void main(String aa[])
{
	Test t1=new Test();
	t1.insertEnd(2);
	t1.insertEnd(9);
	t1.insertEnd(8);
	t1.insertEnd(12);
	t1.insertEnd(7);
	t1.insertEnd(10);
	t1.modifyLinkedList(t1.start);
	t1.display(t1.start);
	
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

