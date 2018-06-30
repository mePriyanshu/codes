import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total 
value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent 
values and weights associated with n items respectively. Also given an integer W which represents knapsack 
capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller 
than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).*/

class Test{

	HashMap<Integer,Integer> h1;
	Test()
	{
		h1=new HashMap<>();
	}
	 
	int knapSackProblemByRecursion(int wt,int w[],int val[],int n)
	{
		if(n==0||wt==0)return 0;
		
		if(w[n-1]>wt)
			return knapSackProblemByRecursion(wt,w,val,n-1);
		return Math.max(val[n-1]+knapSackProblemByRecursion(wt-w[n-1],w,val,n-1),knapSackProblemByRecursion(wt,w,val,n-1));
	}
	
	 int knapSackProblemByMemoization(int wt,int w[],int val[],int n)
		{
		    if(!h1.containsKey(n)){
			if(wt==0||n==0)
				h1.put(n,0);
		if(w[n-1]>wt)
			h1.put(n,knapSackProblemByRecursion(wt,w,val,n-1));
		else
			h1.put(n, Math.max(val[n-1]+knapSackProblemByRecursion(wt-w[n-1],w,val,n-1),knapSackProblemByRecursion(wt,w,val,n-1)));
		    }
		return h1.get(n);
		}
	 
	 int knapSackProblemByBottomUp(int wt,int w[],int val[],int n)
		{
		    int table[][]=new int[n+1][wt+1];
		    for(int i=0;i<=n;i++)
		    {
		    	for(int j=0;j<=wt;j++)
		    	{
		    		if(i==0||j==0)
		    			table[i][j]=0;
		    		else if(j>=w[i-1])
		    		{
		    			table[i][j]=Math.max(table[i-1][j],table[i-1][j-w[i-1]]+val[i-1]);
		    		}else
		    			table[i][j]=table[i-1][j];
		    		//System.out.print(table[i][j]+" ");	
		    	}
		    	//System.out.println();
		    }
		    return table[n][wt];
		}  
	public static void main(String aa[])throws IOException
	{
		   Scan s=new Scan();
		   int t=s.scanInt();
		   while(t-->0)
		   {
			   Test t1=new Test();
			   int wt=s.scanInt();
			   int n=s.scanInt();
			   int w[]=new int[n];
			   int val[]=new int[n];
			  for(int i=0;i<n;i++){
				  w[i]=s.scanInt();
				  val[i]=s.scanInt();
				  
			  }
			 System.out.println(t1.knapSackProblemByMemoization(wt, w, val, n-1));
			 //System.out.println(t1.h1+" ");
		   }
		
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
	   long scanLong() throws IOException
	    {
	        return parseLong(scanString());
	    }
}	    
	    
