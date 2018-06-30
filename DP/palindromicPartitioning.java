import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

class Test
{


	static int palindromicPartioning(String str)
	{
		int n=str.length();
		int dp[]=IntStream.range(0, n).toArray();
		
		for(int mid=1;mid<n;mid++)
		{
			for(int start=mid,end=mid;start>=0&&end<n&&str.charAt(start)==str.charAt(end);start--,end++)
			{
				int temp=(start==0)?0:1+dp[start-1];
				dp[end]=Math.min(dp[end], temp);
			}
			
			for(int start=mid-1,end=mid;start>=0&&end<n&&str.charAt(start)==str.charAt(end);start--,end++)
			{
				int temp=(start==0)?0:1+dp[start-1];
				dp[end]=Math.min(dp[end], temp);
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[n-1];
		
	}

	public static void main (String[] args) throws IOException
	{
	 
		System.out.println(palindromicPartioning("aab"));
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
