import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Test{
	
static int minSizeSubarray(int a[],int k)
{
	
	int n=a.length;
	
	if(a==null||n==0)return 0;
	int min=Integer.MAX_VALUE;
	int i=0,left=0;
	int sum=0;
	for( i=0;i<n;i++)
	{
		sum+=a[i];
		while(sum>=k) {
		min=Math.min(i-left+1,min);
		sum=sum-a[left++];
		}
	}
	return (min==Integer.MIN_VALUE)?0:min;
}
public static void main(String aa[])throws IOException
{
	int a[]={1,2,3,4};
	System.out.println(minSizeSubarray(a,3));
	
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
	    
