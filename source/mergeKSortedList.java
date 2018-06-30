import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;

class Test {
 
	class Node
	{
		int value;
		Node next;
		Node(int value)
		{
			this.value=value;
			next=null;
		}
		public String toString()
		{
			return value+" ";
		}
	}
	Node start=null;
	void insert(int item)
	{
		Node p=new Node(item);
		if(start==null)
			start=p;
		else
		{
			Node q=start;
			while(q.next!=null)
			{
				q=q.next;
			}
			q.next=p;
		}
	}
	
	void display(Node p)
	{
		while(p!=null)
		{
			System.out.print(p.value+" ");
			p=p.next;
		}
		System.out.println();
	}
 

	 Node mergekSortedList(ArrayList<Node> l1)
	{
		 if(l1==null||l1.size()==0)
			 return null;
		PriorityQueue<Node> p1=new PriorityQueue<>(l1.size(),new Comparator<Node>(){
			public int compare(Node p,Node q)
			{
				if(p.value>q.value)
					return 1;
				else if(p.value==q.value)
					return 0;
				return -1;
			}
		});
		
		for(Node p:l1)
		{
			Node q=p;
			while(q!=null)
			{
				p1.add(q);
				q=q.next;
			}
		}
		Node ans=new Node(0);
		Node sec=ans;
		while(!p1.isEmpty())
		{
			sec.next=new Node(p1.poll().value);
			sec=sec.next;
		}
		return ans.next;
		
	}
		public static void main(String aa[]){
			
			Test t1=new Test();
			t1.insert(10);
			t1.insert(20);
			t1.insert(30);
			t1.insert(40);
			t1.display(t1.start);
			
			Test t2=new Test();
			t2.insert(50);
			t2.insert(60);
			t2.insert(70);
			t2.insert(80);
			t2.display(t2.start);
			
			Test t3=new Test();
			t3.insert(110);
			t3.insert(100);
			t3.insert(90);
			t3.insert(120);
			t3.display(t3.start);
			
			ArrayList<Node> ans=new ArrayList<>();
			ans.add(t1.start);
			ans.add(t2.start);
			ans.add(t3.start);
			//System.out.println(ans);
			
			Node res=t1.mergekSortedList(ans);
			t1.display(res);
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
