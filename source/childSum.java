import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//construct childSum
class Test
{

static	class Node
	{
			int data;
			Node left,right;
			Node(int a)
			{
				data=a;
				left=right=null;
			}
	}
Node root=null;

int getValue(Node p)
{
	if(p==null)return 0;
	return p.data;
}

void childSum(Node p)
{
	if(p==null)return;
	if(p.left==null&&p.right==null)				//checking for leaf nodes
		return;
	int sum=0;
	if(p.left!=null)
		sum+=getValue(p.left);
	if(p.right!=null)
		sum+=getValue(p.right);
	int d=p.data-sum;
	
	if(d>0)
	{
		if(p.left!=null)
			p.left.data+=d;
		if(p.right!=null)
			p.right.data+=d;
	}
	childSum(p.left);
	childSum(p.right);
	p.data=getValue(p.left)+getValue(p.right);
}
void inorderTraversal(Node p)
{
	if(p!=null)
	{
		inorderTraversal(p.left);
		System.out.print(p.data+" ");
		inorderTraversal(p.right);
	}
}
public static void main(String aa[])
{
	Test tree=new Test();
	tree.root = new Node(50);
    tree.root.left = new Node(7);
    tree.root.right = new Node(2);
    tree.root.left.left = new Node(3);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(1);
    tree.root.right.right = new Node(30);
	tree.inorderTraversal(tree.root);
	System.out.println();
	tree.childSum(tree.root);
	tree.inorderTraversal(tree.root);
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
