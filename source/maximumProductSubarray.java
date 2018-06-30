import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;

class Test {
	
	static int maximumProductSubarray(int a[])
	{
		int n=a.length;
		int maxProduct=a[0];
		int minProduct=a[0];
	    int globalMax=a[0];
	    
	    for(int i=1;i<n;i++)
	    {
	    	//System.out.println("Before swap  "+"maxProduct: "+maxProduct+" "+"minProduct: "+minProduct);
	    	
	    	if(a[i]<0)
	    	{
	    		int temp=maxProduct;
	    		maxProduct=minProduct;
	    		minProduct=temp;
	    	}
	    	//System.out.println("maxProduct: "+maxProduct+" "+"minProduct: "+minProduct);
	    	maxProduct=Math.max(a[i],maxProduct*a[i]);
	    	minProduct=Math.min(a[i],minProduct*a[i]);
	    	globalMax=Math.max(globalMax,maxProduct);
	    }
	    return globalMax;
	}

		public static void main(String aa[]){
	
		System.out.println(maximumProductSubarray(new int[]{2,3,-2,4}));
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
