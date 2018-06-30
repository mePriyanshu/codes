import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
/*
 * Count of n digit numbers whose sum of digits equals to given sum
 * */
class Test {

	

	static int noOfDigitsToSumS(int n,int sum,int lookup[][])
	{
		if(n==0)
		{
			return (sum==0)?1:0;
		}
		if(sum==0)return 1;
		int ans=0;
		if(lookup[n][sum]!=-1)
			return lookup[n][sum];
		for(int i=0;i<=9;i++)
		{
			if((sum-i)>=0)
				ans+=noOfDigitsToSumS(n-1,sum-i,lookup);
		}
		return ans;
	}
	static int finalCount(int n,int sum)
	{
		int ans=0;
		int lookup[][]=new int[n+1][sum+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				lookup[i][j]=-1;
			}
		}
		for(int i=1;i<=9;i++)
		{
			if((sum-i)>=0)
			ans+=noOfDigitsToSumS(n-1,sum-i,lookup);
		}
		return ans;
	}
	
	public static void main(String aa[]){
	System.out.println(finalCount(2,5));
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
