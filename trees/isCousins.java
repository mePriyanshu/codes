import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test{
class Node
{
	int data;
	Node left,right;
	Node(int data)
	{
		this.data=data;
		left=null;right=null;
	}
}
Node root=null;
boolean isCousins(Node p,int x,int y)
{
	if(p==null)
		return false;
	if(p.data==x||p.data==y)
		return false;
	Queue<Node> q1=new LinkedList<>();
	q1.add(p);q1.add(null);
	boolean flag1=false,flag2=false;
	Node parent1=null,parent2=null;
	while(!q1.isEmpty())
	{
		Node curr=q1.poll();
		if(curr==null)
		{
			if(flag1==true&&flag2==false)
				return false;
			if(flag1==false&&flag2==true)
				return false;
			if(!q1.isEmpty())q1.add(null);
		}else
		{
			if(curr.left!=null)
			{
				if(curr.left.data==x)
					parent1=curr;
				if(curr.left.data==y)
					parent2=curr;
				q1.add(curr.left);
			}
			if(curr.right!=null)
			{
				if(curr.right.data==x)
					parent1=curr;
				if(curr.right.data==y)
					parent2=curr;
				q1.add(curr.right);
			}
			if(curr.data==x)
				flag1=true;
			if(curr.data==y)
				flag2=true;
		}
	}
	return (parent1.data!=parent2.data);
}

public static void main(String aa[])
{
	Test t1=new Test();
	t1.root=t1.new Node(5);
	t1.root.left=t1.new Node(1);
	t1.root.right=t1.new Node(6);
	t1.root.left.left=t1.new Node(3);
	//t1.root.left.right=t1.new Node(8);
	t1.root.right.left=t1.new Node(7);
	t1.root.right.right=t1.new Node(4);
	System.out.print(t1.isCousins(t1.root, 2, 3));
//	System.out.print(t1.isCousins(t1.root, 20, 30));
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

//10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6