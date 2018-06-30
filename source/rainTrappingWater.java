import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//rainTrappingWater
class Test {


	   static int rainTrappingWater(int a[])
	   {
		   int n=a.length;
		   int maxLeft[]=new int[n];
		   int maxRight[]=new int[n];
		   System.out.println(Arrays.toString(a));
		   maxLeft[0]=a[0];
		   for(int i=1;i<n;i++)
		   {
			   maxLeft[i]=Math.max(maxLeft[i-1],a[i]);
		   }
		   
		   maxRight[n-1]=a[n-1];
		   for(int i=n-2;i>=0;i--)
		   {
			   maxRight[i]=Math.max(maxRight[i+1],a[i]);
		   }
		  
		   System.out.println(Arrays.toString(maxLeft));
		   System.out.println(Arrays.toString(maxRight));
		   
		   int water=0;
		   for(int i=0;i<n;i++)
		   {
			   water+=Math.min(maxLeft[i], maxRight[i])-a[i];
		   }
		   return water;
	   }
		public static void main(String aa[]){
			
			int a[]={0,1,0,2,1,0,1,3,2,1,2,1};
			System.out.println(rainTrappingWater(a));
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
