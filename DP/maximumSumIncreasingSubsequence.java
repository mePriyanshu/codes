import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//maximum sumincreasing subsequence
class Test {
 
static int maximumSumIncreasingSubsequence(int a[])
{
	int n=a.length;
	int t[]=new int[n];
	int i=0;
	for(i=0;i<n;i++)
		t[i]=a[i];
	int max=Integer.MIN_VALUE;
	for(i=1;i<n;i++)
	{
		int j=0;
		while(j<i)
		{   if(a[i]>a[j]) 
			t[i]=Math.max(t[i], a[i]+t[j]);
			j++;
		}
		
	}
	for( i=0;i<n;i++)
		max=Math.max(t[i], max);
	return max;
}

public static void main(String aa[])
{
	int a[]={1, 101, 2, 3, 100, 4, 5};
	System.out.print(maximumSumIncreasingSubsequence(a));
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