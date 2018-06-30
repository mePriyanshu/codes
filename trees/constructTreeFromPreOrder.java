
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

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
 
 void inOrderTraversal(Node q)
 {
	if(q!=null)
	{
		inOrderTraversal(q.left);
		System.out.print(q.data+" ");
		inOrderTraversal(q.right);
	}
 }
 
void preOrderToBST(int pre[],int size)					//iterative approach in O(n)
{
	if(size==0)return;
	Stack<Node> s1=new Stack<>();
	Node root=new Node(pre[0]);
	s1.push(root);
	
	for(int i=1;i<size;i++)
	{
		Node temp=null;
		while(!s1.isEmpty()&&s1.peek().data<pre[i])
			temp=s1.pop();
		if(temp!=null)
		{
			temp.right=new Node(pre[i]);
			s1.push(temp.right);
		}else
		{
			temp=s1.peek();
			temp.left=new Node(pre[i]);
			s1.push(temp.left);
		}
		
	}
	inOrderTraversal(root);
}
static int preIndex=0;

static Node preToBSTbyRecursion(int pre[],int size,int min,int max)
{
	if(preIndex>=size||pre.length==0)
		return null;
	Node root=null;
	if(pre[preIndex]>min&&pre[preIndex]<max)
	{
		root=new Node(pre[preIndex++]);
		if(preIndex<size)
		{
			root.left=preToBSTbyRecursion(pre,size,min,root.data);
			root.right=preToBSTbyRecursion(pre,size,root.data,max);
		}
	}
	return root;
}

class Index
{
	int postIndex=0;
}
static Node postOrderToBSt(int post[],Index postIndex,int size,int min,int max)		//postorder to bst
{
	if(postIndex.postIndex<0)
		return null;
	Node root=null;
	if(post[postIndex.postIndex]>min&&post[postIndex.postIndex]<max)
	{
		root=new Node(post[postIndex.postIndex--]);
		if(postIndex.postIndex>=0)
		{
			
			root.right=postOrderToBSt(post,postIndex,size,root.data,max);
			root.left=postOrderToBSt(post,postIndex,size,min,root.data);
		}
	}
	return root;
	
}
public static void main(String aa[])
{
	Test tree=new Test();
	int pre[]={10, 5, 1, 7, 40, 50};
	int post[]={1, 7, 5, 50, 40, 10};
	int size=pre.length;
	//tree.preOrderToBST(pre,size);
	//Node res=tree.preToBSTbyRecursion(pre, size, Integer.MIN_VALUE,Integer.MAX_VALUE);
	Index i1=tree.new Index();
	i1.postIndex=size-1;
	Node res=tree.postOrderToBSt(post,i1,size, Integer.MIN_VALUE, Integer.MAX_VALUE);
	tree.inOrderTraversal(res);
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