import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//min number of jumps to reach end
class Test{

static int minNumberOfJumpsToReachEnd(int a[])
{
	int n=a.length;
	int maxIndex=a[0];
	int step=a[0];
	int jump=1;
	for(int i=1;i<n;i++)
	{
		if(i==n-1)
			return jump;
		maxIndex=Math.max(maxIndex,i+a[i]);
		step--;
		if(step==0)
		{
			jump++;
			if(i>=maxIndex)
				return -1;
			step=maxIndex-i;
		}
	}
	return -1;
}
public static void main(String aa[])
{
	int a[]={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
	System.out.print(minNumberOfJumpsToReachEnd(a));
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
