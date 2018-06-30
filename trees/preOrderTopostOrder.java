import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
class Test{
    static int preIndex=0;
  
    static int search(int inStart,int inEnd,int inOrder[],int key)
    {
        for(int i=inStart;i<=inEnd;i++)
        {
            if(inOrder[i]==key)
               return i;
        }
        return -1;
    }
    static boolean isPreOrderValid(int preOrder[])
    {
    	boolean bl=false;
    	if(preOrder.length==1)
    		return true;
    	int i=0,j=0;
    	for(i=1;i<preOrder.length;i++)
    	{
    		if(preOrder[i]>preOrder[i-1])
    			break;
    	}
    	for(j=i;j<preOrder.length-1;j++)
    	{
    		if(preOrder[j]>preOrder[j+1]){
    			bl=true;
    			break;
    		}
    	}
    	if(bl)return false;
    	return true;
    }
    static void printPostOrder(int inStart,int inEnd,int inOrder[],int preOrder[])
    {
        if(inStart>inEnd)return;
        if(inStart==inEnd)
        {
            System.out.print(preOrder[preIndex++]+" ");
            return;
        }
        int index=search(inStart,inEnd,inOrder,preOrder[preIndex++]);
        printPostOrder(inStart,index-1,inOrder,preOrder);
        printPostOrder(index+1,inEnd,inOrder,preOrder);
    
  
        System.out.print(inOrder[index]+" ");
    }
	public static void main (String[] args) throws IOException{
		//code
		Scan s=new Scan();
		int t=s.scanInt();
		
		for(int k=0;k<t;k++)
		{
		    int n=s.scanInt();
		    int i=0;
		    int a[]=new int[n];
		    int b[]=new int[n];
		    for(i=0;i<n;i++){
		      a[i]=s.scanInt();
		      b[i]=a[i];
		    }
		    Arrays.sort(b);
		     if(isPreOrderValid(a))
		    printPostOrder(0,b.length-1,b,a);
		     else
		    	 System.out.print("No");
		    preIndex=0;
		 
		    System.out.println();
	//	 System.out.print(isPreOrderValid(new int[]{2,4,3}));   
		}
	}
}

//LCA of binary tree
/*
public Node lca(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }
        
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }*/
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