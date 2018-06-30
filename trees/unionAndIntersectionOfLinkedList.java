
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
Test unionLinkedList(Node p,Node q)
{
	HashSet<Integer> h1=new HashSet<>();
	if(p==null||q==null)return null;
	
	while(p!=null)
	{
		h1.add(p.data);
		p=p.next;
	}
	
	while(q!=null)
	{
		if(!h1.contains(q.data))
		{
			h1.add(q.data);
		}
		q=q.next;
	}
	//System.out.println(h1);
	Test t3=new Test();
	Iterator i=h1.iterator();
	while(i.hasNext())
		t3.insertEnd((int)i.next());
	return t3;
}

Test intersectionLinkedList(Node p,Node q)
{
	if(q==null)
		return null;
	if(p==null)return null;
	HashMap<Integer,Boolean> h1=new HashMap<>();
	while(p!=null)
	{
		h1.put(p.data,true);
		p=p.next;
	}
	Test t1=new Test();
	while(q!=null)
	{
		if(h1.containsKey(q.data))
		{
			if(h1.get(q.data)==true)
				t1.insertEnd(q.data);
		}
		q=q.next;
	}
	return t1;
}	
public static void main(String aa[])
{
	Test t1=new Test();
	t1.insertEnd(10);
	t1.insertEnd(15);
	t1.insertEnd(4);
	t1.insertEnd(20);
	t1.display(t1.start);	
	Test t2=new Test();
	t2.insertEnd(8);
	t2.insertEnd(4);
	t2.insertEnd(2);
	t2.insertEnd(10);
	t2.display(t2.start);
	
	Test t3=t1.unionLinkedList(t1.start, t2.start);
	System.out.print("Union Of A Linked List:");
	t3.display(t3.start);
	System.out.print("Intersection Of A Linked List:");
	Test t4=t1.intersectionLinkedList(t1.start, t2.start);
	t4.display(t4.start);
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

