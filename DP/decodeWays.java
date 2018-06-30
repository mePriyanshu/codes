import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//decode ways as 12 can be decoded in 2 ways 1   12
class Test {

	static int decodeWays(String str)
	{
		int n=str.length();
		if(str==null||n==0)
			return 0;
		int dp[]=new int[n+1];
		dp[0]=1;
		if(str.charAt(0)!='0')
			dp[1]=1;
		for(int i=2;i<=n;i++)
		{
			int first=Integer.parseInt(str.substring(i-1,i));
			int second=Integer.parseInt(str.substring(i-2,i));
			if(first>=0&&first<=9)
				dp[i]+=dp[i-1];
			if(second>=10&&second<=26)
				dp[i]+=dp[i-2];
		}
		return dp[n];
		
	}
	public static void main(String aa[]){
	
		System.out.println(decodeWays("12"));
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
