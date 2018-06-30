import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//binary trees
class Test {
	Scan s=new Scan();
	class Node								//representation of a binary tree
	{
		int item;
		Node left;
		Node right;
		
		Node(int a)
		{
			item=a;
			left=null;
			right=null;
		}
	}
	Node root=null;
	
	Node binaryInsert() throws IOException
	{
		int item;
		//System.out.println("Enter the item");
		item=s.scanInt();
		if(item==-1) return null;
		Node p=new Node(item);
		//System.out.println("Enter the left Child");
		p.left=binaryInsert();
		//System.out.println("Enter the right Child");
		p.right=binaryInsert();
		return p;		
	}
	int findMax(Node p)
	{
		int max=Integer.MIN_VALUE;
		Queue<Node> q1=new LinkedList<>();
		q1.add(p);
		while(!q1.isEmpty())
		{
			Node curr=q1.peek();
			if(max<curr.item)
				max=curr.item;
			if(curr.left!=null) q1.add(curr.left);
			if(curr.right!=null) q1.add(curr.right);
			q1.poll();	
		}
		return max;
		
	}
	void levelOrder(Node p)
	{
		if(p==null) return;
		Queue<Node> q1=new LinkedList<>();
		q1.add(p);
		
		while(!q1.isEmpty())
		{
			Node curr=q1.peek();
			System.out.print(curr.item+" ");
			if(curr.left!=null) q1.add(curr.left);
			if(curr.right!=null) q1.add(curr.right);
			q1.poll();
		}
		System.out.println();
	}
	boolean searchElement(Node p,int x)			//iteration
	{
		if(p==null)
			return false;
		Queue<Node> q1=new LinkedList<>();
		q1.add(p);
		while(!q1.isEmpty())
		{
			Node curr=q1.poll();
			if(curr.item==x)
				return true;
			if(curr.left!=null) q1.add(p.left);
			if(curr.right!=null) q1.add(p.right);
			
		}
		return false;
	}
	boolean searchElementRecursion(Node p,int x)
	{
		if(p==null)
			return false;
		if(p.item==x)
			return true;
		else
			return searchElementRecursion(p.left,x)||searchElementRecursion(p.right,x);
	}
	int heightBinary(Node p)
	{
		if(p==null) return -1;
		int left=heightBinary(p.left);
		int right=heightBinary(p.right);
		if(left>right)
			return left+1;
		else
			return right+1;
	}
	int noOfNonLeafNodes(Node p)
	{
		if(p==null) return 0;
		int count=0;
		Queue<Node> q1=new LinkedList<>();
		q1.add(p);
		while(!q1.isEmpty())
		{
			Node curr=q1.poll();
			if(curr.left!=null&&curr.right!=null)
				count++;
			if(curr.left!=null)
				q1.add(curr.left);
			if(curr.right!=null)
				q1.add(curr.right);
		}
		q1.clear();
		return count;
	}
	void sumAtLevel(Node p)
	{
		if(p==null)
			return;
		int sum=0,max=Integer.MIN_VALUE;
		Queue<Node> q1=new LinkedList<>();
		q1.add(p);
		q1.add(null);
		while(!q1.isEmpty())
		{
			Node curr=q1.poll();
			if(curr==null)
			{
				//System.out.println(sum);
				//sum=0;
				if(max<sum)
					max=sum;
				sum=0;
		       if(!q1.isEmpty())		//marking the level
		    	   q1.add(null);
			}else
			{
				sum+=curr.item;
				if(curr.left!=null) q1.add(curr.left);
				if(curr.right!=null) q1.add(curr.right);
			}
		}
		System.out.println(max);
	}
    void countMaxAtLevel(Node p)
    {
    	if(p==null)
    		return;
    	Queue<Node> q1=new LinkedList<>();
    	q1.add(p);
    	q1.add(null);		//for identification
    	int c=0,maxCount=Integer.MIN_VALUE;
    	int level=0,maxLevel=0;
    	while(!q1.isEmpty())
    	{
    		Node curr=q1.poll();
    		if(curr==null)
    		{
    			if(maxCount<c)
    			{	
                	maxCount=c;
                	maxLevel=level;
    			}
    			c=0;
    			if(!q1.isEmpty()){
    				q1.add(null);
    				level++;
    			}
    		}else
    		{
    			c++;
    			if(curr.left!=null) q1.add(curr.left);
    			if(curr.right!=null) q1.add(curr.right);
    		}
    	}
    	System.out.println(maxLevel+" "+maxCount);
    }
	Node mirrorOfBinaryTree(Node p)
	{
		if(p!=null)
		{
			mirrorOfBinaryTree(p.left);
			mirrorOfBinaryTree(p.right);
			Node temp=p.left;
			p.left=p.right;
			p.right=temp;
		}
		return p;
	}
	public static void main(String aa[]) throws IOException
	{
		Test t1=new Test();
		t1.root=t1.binaryInsert();
		t1.levelOrder(t1.root);
		//System.out.println(t1.findMax(t1.root));
		//System.out.println(t1.searchElement(t1.root, 14));
		//System.out.println(t1.searchElementRecursion(t1.root, 14));
		//System.out.println(t1.heightBinary(t1.root));
		//System.out.println(t1.noOfNonLeafNodes(t1.root));
		//t1.sumAtLevel(t1.root);
		//t1.countMaxAtLevel(t1.root);
		//t1.root=t1.mirrorOfBinaryTree(t1.root);
		//t1.levelOrder(t1.root);

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