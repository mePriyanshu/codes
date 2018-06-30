import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//maximum value of (i*a[i])
//r1=r0+arrSum-n*a[n-1];
//r2=r1+arrSum-n*a[n-2];
class Test {
	
	static int maxValueOfSum(int a[])
	{
		int n=a.length;
		int arraySum=0,currentSum=0;
		for(int i=0;i<n;i++)
		{
			arraySum+=a[i];
			currentSum+=(i*a[i]);
		}
		int maxSum=currentSum;					//r0
		for(int i=1;i<n;i++)
		{
			currentSum=currentSum+arraySum-n*a[n-i];
			maxSum=Math.max(currentSum, maxSum);
		}
		return maxSum;
	}
	public static void main(String aa[])throws IOException
	{
		System.out.print(maxValueOfSum(new int[]{1,20,2,10}));
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