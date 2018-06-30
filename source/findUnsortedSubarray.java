import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
//find unsorted subarray
class Test {
	 public static int findUnsortedSubarray(int[] a) {
	        
	        boolean flag1=false;
	        boolean flag2=false;
	        int n=a.length;
	        int left=Integer.MAX_VALUE;
	        int right=Integer.MIN_VALUE;
	        ArrayList<Integer> a1=new ArrayList<Integer>();
	        for(int i=1;i<n;i++)
	        {
	            if(a[i]<a[i-1])
	                flag1=true;
	            
	            if(flag1)
	            {
	                left=Math.min(left,a[i]);
	            }
	        }
	        
	        for(int i=n-2;i>=0;i--)
	        {
	            if(a[i]>a[i+1])
	                flag2=true;
	            if(flag2)
	            {
	                right=Math.max(right,a[i]);
	            }
	        }
	       // System.out.println(left+" "+right);
	        int l=0;
	        for( l=0;l<n;l++)
	        {
	            if(left<a[l])
	                break;
	        }
	        int r=0;
	        for(r=n-1;r>=0;r--)
	        {
	            if(right>a[r])
	                break;
	        }
	        a1.add(l);
	        a1.add(r);
	        if(a1.contains(-1))
	        	System.out.println(-1);
	        else
	        	System.out.println(a1);
	        
	        return r-l>0?r-l+1:0;
	    }
		public static void main(String aa[]) throws Exception{
	
	int a[]=new int[]{1,2,3,4,5};
	System.out.println(findUnsortedSubarray(a));
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


