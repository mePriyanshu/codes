import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//reverse the linked list using one pointer
class Test
{
	class Node
	{
		int data;
		Node next;
		
		Node(int a)
		{
			data=a;
			next=null;
		}
	}
Node start=null;

void display(Node p)
{
	Node q=p;
	while(q!=null)
	{
		System.out.print(q.data+" ");
		q=q.next;
	}
	System.out.println();
}

	Node reverse(Node p,Node prev)
	{
		if(p.next==null)			//move to the end of list
		{
			start=p;
			p.next=prev;
			return null;
		}
		
		Node next1=p.next;
		p.next=prev;
		reverse(next1,p);
		return start;
	}
	
public static void main(String aa[])
{
	Test t1=new Test();
	t1.start=t1.new Node(10);
	t1.start.next=t1.new Node(20);
	t1.start.next.next=t1.new Node(30);
	t1.start.next.next.next=t1.new Node(40);
	t1.start.next.next.next.next=t1.new Node(50);
	t1.display(t1.start);
	t1.start=t1.reverse(t1.start,null);
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
