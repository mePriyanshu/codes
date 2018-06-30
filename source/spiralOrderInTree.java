
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//spiral order in binary tree
class Test{
	
	
static class Node
{
	int data;
	Node left,right;
	Node(int a)
	{
		data=a;
		left=null;
		right=null;
	}
}	
Node root=null;
static void printPreOrder(Node p)
{
	if(p!=null)
	{
		System.out.print(p.data+" ");									
																						
		printPreOrder(p.left);
		printPreOrder(p.right);
	}
	//System.out.println();
}
static void printStack(Stack<Integer> s1)
{
	Iterator i1=s1.iterator();
	while(i1.hasNext())
		System.out.print((int)i1.next()+" ");
}

static void reverseStack(Stack<Integer> s1)
{
	while(!s1.isEmpty())
		System.out.print(s1.pop()+" ");
}
static void printSpiralOrder(Node p)
{
	if(p==null)return;
	Queue<Node> q1=new LinkedList<>();
	q1.add(p);
	q1.add(null);
	Stack<Integer> a1=new Stack<>();
	System.out.print(p.data+" ");
	a1.clear();
	
	boolean bl=true;
	while(!q1.isEmpty())
	{
		Node curr=q1.poll();
		
		
		if(curr==null)
		{
			if(bl)
				printStack(a1);
			else
				reverseStack(a1);
			bl=!bl;
			a1.clear();
			//System.out.println();
			if(!q1.isEmpty())
				q1.add(null);
			
		}else
		{
			if(curr.left!=null)
			{
				q1.add(curr.left);
				a1.add(curr.left.data);
			}
			if(curr.right!=null)
			{
				q1.add(curr.right);
				a1.add(curr.right.data);
			}
			
		}
		}
	
	
}
	public static void main(String aa[])
	{
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(7);
		root.left.right=new Node(6);
		root.right.left=new Node(5);
		root.right.right=new Node(4);
		//printPreOrder(root);
		printSpiralOrder(root);
		
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