import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
// construct tree from inorder and preorder traversal
class Test {

	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int a)
		{
			val=a;
			left=right=null;
		}
	}
	
	void inorderTraversal(TreeNode p)
	{
		if(p!=null)
		{
			inorderTraversal(p.left);
			System.out.print(p.val+" ");
			inorderTraversal(p.right);
		}
	}
	void postTraversal(TreeNode p)
	{
		if(p!=null)
		{
			postTraversal(p.right);
			postTraversal(p.left);
			System.out.print(p.val+" ");
			
		}
	}
	TreeNode root=null;

	TreeNode constructTree(int preorder[],int preStart,int preEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> h1)
	{
		if(preStart>preEnd||inStart>inEnd)
			return null;
		TreeNode root=new TreeNode(preorder[preStart]);
		int index=h1.get(root.val);
		int numLeft=index-inStart;
root.left=constructTree(preorder,preStart+1,preStart+numLeft,inorder,inStart,index-1,h1);
root.right=constructTree(preorder,preStart+numLeft+1,preEnd,inorder,index+1,inEnd,h1);
return root;

	}
	
	TreeNode buildTree(int preorder[],int inorder[])
	{
		HashMap<Integer,Integer> h1=new HashMap<>();
		for(int i=0;i<inorder.length;i++)
		{
			h1.put(inorder[i],i);
		}
		return constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,h1);
		
	}
public static void main(String aa[]){
			
		int preorder[]=new int[]{1,2,3};
		int inorder[]=new int[]{2,1,3};
		Test t1=new Test();
		t1.root=t1.buildTree(preorder, inorder);
		t1.inorderTraversal(t1.root);
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


