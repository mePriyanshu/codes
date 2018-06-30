import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;

//connect nodes at same level for binary trees as well as complete binary trees
class Test {

	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int a)
		{
			val=a;
			next=left=right=null;
		}
	}
	TreeNode root;
	
	void connect(TreeNode p)
	{
		if(p==null)
			return;
		TreeNode dummy=new TreeNode(0);
		TreeNode pre=dummy;
		while(root!=null)
		{
			if(root.left!=null)
			{
				pre.next=root.left;
				pre=pre.next;
			}
			if(root.right!=null)
			{
				pre.next=root.right;
				pre=pre.next;
			}
			root=root.next;
			if(root==null)
			{
				pre=dummy;
				root=dummy.next;
				dummy.next=null;
			}
		}
	}
	

public static void main(String aa[]){
		Test tree=new Test();
		tree.root=new TreeNode(1);
		tree.root.left=new TreeNode(2);
		tree.root.left.left=new TreeNode(4);
		tree.root.left.right=new TreeNode(5);
		tree.root.right=new TreeNode(3);
		tree.root.right.right=new TreeNode(7);
		tree.connect(tree.root);
		
		
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


