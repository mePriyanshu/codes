import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
//Given an array A of integers, find the maximum of j - i subjected to the
//constraint of A[i] <= A[j].
class Test {


	static int maxGap(int a[])
	{
		int n=a.length;
		int left[]=new int[n];
		int right[]=new int[n];
		left[0]=a[0];
		
		for(int i=1;i<n;i++)
			left[i]=Math.min(a[i], left[i-1]);
		
		right[n-1]=a[n-1];
		for(int i=n-2;i>=0;i--)
		{
			right[i]=Math.max(a[i],right[i+1]);
		}
		
		int i=0,j=0;
		int max=0;
		while(i<n&&j<n)
		{
			if(left[i]<=right[j])
			{
				max=Math.max(max,j-i);
				j++;
			}else
				i++;
		}
		return max;
	}
public static void main(String aa[]){
		System.out.println(maxGap(new int[]{3,5,4,2}));
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


