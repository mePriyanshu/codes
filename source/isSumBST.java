import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//finding a pair in bst;
class Test
{
	class Node
	{
		int data;
		Node left;
		Node right;
		Node(int a)
		{
			data=a;
			left=right=null;
		}
	}
Node root=null;

void inOrderTraversal(Node p)
{
	if(p!=null)
	{
		inOrderTraversal(p.left);
		System.out.print(p.data+" ");
		inOrderTraversal(p.right);
	}
}


boolean isSumPair(Node p,int sum)
{
	if(p==null)return false;
	
	Stack<Node> s1=new Stack<>();
	Stack<Node> s2=new Stack<>();
	
	Node x=p,y=p;
	while(true)
	{
		while(x!=null)
		{
			s1.push(x);
			x=x.left;
		}
		
		while(y!=null)
		{
			s2.push(y);
			y=y.right;

	
		}
		int a=s1.peek().data;
		int b=s2.peek().data;
	if(s1.isEmpty()||s2.isEmpty()||a>=b)
		return false;
	if(a+b==sum)
	{
		System.out.print("Pair:"+a+" "+b+" ");
		return true;
	}else if(a+b<sum)
	{
		x=s1.peek().right;
		s1.pop();
	}else if(a+b>sum)
	{
		y=s2.peek().left;
		s2.pop();
	}
		
	
	
	}
	
}
public static void main(String aa[])
{
	Test t1=new Test();
	t1.root=t1.new Node(15);
	  t1.root.left = t1.new Node(10);
	   t1.root.right = t1.new Node(20);
	    t1.root.left.left = t1.new Node(8);
	    t1.root.left.right = t1.new Node(12);
	    t1.root.right.left = t1.new Node(16);
	    t1.root.right.right = t1.new Node(25);
	    t1.inOrderTraversal(t1.root);
	    System.out.println();
	 if(t1.isSumPair(t1.root,133)==false)
		 System.out.print("Not found");
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
