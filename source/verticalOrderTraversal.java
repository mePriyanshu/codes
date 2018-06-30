import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//vertical Order in a binary tree
class Test
{
public static TreeMap<Integer,ArrayList<Integer>> tm;
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
ArrayList<Integer> a1;

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
		a1=tm.get(level);
		a1.add(p.data);
		tm.put(level, a1);
	}else{
		a1=new ArrayList<Integer>();
		a1.add(p.data);
		tm.put(level,a1);
	}
	return verticalSum(p.right,++level);
}

void printVerticalSum()
{
	
	
	for(Map.Entry<Integer,ArrayList<Integer>> m1:tm.entrySet())
	{
		System.out.println(m1.getKey()+":"+m1.getValue());
	}
}
	

public static void main(String aa[])
{
	Test t1=new Test();
	t1.root=t1.new Node(1);
	t1.root.left = t1.new Node(2);
	t1.root.right = t1.new Node(3);
	t1.root.left.left = t1.new Node(4);
	t1.root.left.right = t1.new Node(5);
	t1.root.right.left = t1.new Node(6);
	t1.root.right.right = t1.new Node(7);
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
