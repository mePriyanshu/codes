import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{

	static int longestPalendromicSubsequence(String str1)
	{
		String str2=new StringBuilder(str1).reverse().toString();
		int m=str1.length();
		int n=str2.length();
		int table[][]=new int[m+1][n+1];
		int max=0;
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0||j==0)table[i][j]=0;
				else if(str1.charAt(i-1)==str2.charAt(j-1)){
					table[i][j]=1+table[i-1][j-1];
				}
				else
					table[i][j]=Math.max(table[i-1][j], table[i][j-1]);
				max=Math.max(max, table[i][j]);
			}
		}
		return max;
	}
	public static void main(String aa[])throws IOException
	{
		   Scan s=new Scan();
		   int t=s.scanInt();
		   while(t-->0)
		   {
			   String str=s.scanString();
			   System.out.println(longestPalendromicSubsequence(str));
		   }
		  
		
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
	            st=new StringTokenizer(br.readLine(),"\t");
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
	    
