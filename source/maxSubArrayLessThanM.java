import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//two pointer approach
class Test{
	
	static long maxSubArrayLessThanM(int a[],int m)
	{
		int left=0,right=0;
		int n=a.length;
		long max=Long.MIN_VALUE;
		long sum=0;
		while(left<n)
		{
			while(right<n && a[right]+sum<=m)
			{
				sum+=a[right];
			
				right++;
			}
			max=Math.max(max,sum);
			sum-=a[left];
			left++;
		}
		return max;
	}
	public static void main(String aa[])throws Exception
	{
		
		Scan s=new Scan();
		int n=s.scanInt();
		int m=s.scanInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=s.scanInt();
		}
		System.out.println(maxSubArrayLessThanM(a,m));
		
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
	    
