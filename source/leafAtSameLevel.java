
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//leaf at same level
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

static boolean leavesAtSameLevel(Node p)
{
	if(p==null)return false;
	Queue<Node> q1=new LinkedList<>();
	q1.add(p);
	q1.add(null);
int currentLevel=0;
   
	int leafLevel=0;
	while(!q1.isEmpty())
	{
		Node curr=q1.poll();
		
		
		if(curr==null)
		{
			
			if(!q1.isEmpty())
				q1.add(null);
			currentLevel++;
			
		}else
		{
			if(curr.left==null&&curr.right==null&&leafLevel==0)
				leafLevel=currentLevel;
			else if(curr.left==null&&curr.right==null&&leafLevel!=currentLevel)
				return false;
			if(curr.left!=null)
			{
				q1.add(curr.left);
				
			}
			if(curr.right!=null)
			{
				q1.add(curr.right);
				
			}
			
		}
		
		}
	return true;

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
		System.out.print(leavesAtSameLevel(root));
		
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