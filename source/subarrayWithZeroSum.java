import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//subarray with Zero sum
class Test {


	static ArrayList<Integer> largestSubarrayWithZeroSum(int a[])
	{
		int n=a.length;
		HashMap<Integer,Integer> h1=new HashMap<>();
		int sum=0;
		int maxLen=0;
		int startIndex=0,endIndex=0;
		h1.put(0,-1);
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			Integer index=h1.get(sum);
			if(index!=null)
			{
				int len=i-index;
				if(maxLen<len)
				{
					startIndex=index+1;
					endIndex=i;
					maxLen=len;
				}
				
			}else
			{
				h1.put(sum,i);
			}
		}
		
		ArrayList<Integer> ans=new ArrayList<Integer>();
		//System.out.println(maxLen);
		if(maxLen==0)
			return new ArrayList<Integer>();
		for(int i=startIndex;i<=endIndex;i++)
			ans.add(a[i]);
		System.out.println(maxLen);
		return ans;
	}
	public static void main(String aa[])
	{
		System.out.println(largestSubarrayWithZeroSum(new int[]{-19, 8, 2, -8, 19, 5, -2, -23}));
	
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


