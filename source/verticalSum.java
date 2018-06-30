import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//vertical sum in a binary tree
class Test
{
public static TreeMap<Integer,Integer> tm;
public static int level;
	Test()
	{
		tm=new TreeMap<>();
		level=0;
	}
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

Node verticalSum(Node p,int level)
{
	if(p==null)
		return p;
	
	Node x=verticalSum(p.left,--level);
	if(x==null)
		level++;
	if(tm.containsKey(level))
	{
		tm.put(level,p.data+tm.get(level));
	}else
		tm.put(level,p.data);
	return verticalSum(p.right,++level);
}

void printVerticalSum()
{
	
	
	for(Map.Entry<Integer, Integer> m1:tm.entrySet())
	{
		System.out.println(m1.getKey()+":"+m1.getValue());
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
	t1.root=t1.verticalSum(t1.root,0);
	t1.printVerticalSum();
	
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
