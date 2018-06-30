
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//sorted doubly linkedlist to Binary tree
class Test{
 class Node
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
Node start=null; 
 void inOrderTraversal(Node q)
 {
	if(q!=null)
	{
		inOrderTraversal(q.left);
		System.out.print(q.data+" ");
		inOrderTraversal(q.right);
	}
 }

void insertLinkedList(int item)
{
	Node p=new Node(item);
	p.left=null;
	p.right=start;
	if(start!=null)
		start.left=p;
	start=p;
}
int getCount(Node p)
{
	int c=0;
	p=start;
	while(p!=null)
	{
		c++;
		p=p.right;
	}
	return c;
}
void display(Node p)
{
	while(p!=null)
	{
		System.out.print(p.data+" ");
		p=p.right;
	}
}

Node sortedDLLtoBSTUtil(int noOfNodes)
{
	if(noOfNodes<=0)
		return null;
	Node leftSubtree=sortedDLLtoBSTUtil(noOfNodes/2);
	Node root=start;
	root.left=leftSubtree;
	start=start.right;
	root.right=sortedDLLtoBSTUtil(noOfNodes-noOfNodes/2-1);
	return root;
	
}

Node  sortedDLLtoBST(Node p)
{
	int n=getCount(p);
	//System.out.print(n);
	return sortedDLLtoBSTUtil(n);
}
public static void main(String aa[])
{
	Test t1=new Test();
    t1.insertLinkedList(7);
    t1.insertLinkedList(6);
    t1.insertLinkedList(5);
    t1.insertLinkedList(4);
    t1.insertLinkedList(3);
    t1.insertLinkedList(2);
    t1.insertLinkedList(1);
   // t1.display(t1.start);
    System.out.println();
    t1.root=t1.sortedDLLtoBST(t1.root);
    t1.inOrderTraversal(t1.root);
	
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