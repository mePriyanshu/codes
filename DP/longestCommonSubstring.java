import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;


class Test
{
	static int longestCommonSubstring(String s1,String s2)
	{
		if(s1==""||s2=="")
			return -1;
		int m=s1.length();
		int n=s2.length();
		int table[][]=new int[m+1][n+1];
		int i=0,j=0;
		int max=0;
		for(i=0;i<=m;i++)
		{
			for(j=0;j<=n;j++)
			{
				if(i==0||j==0)
					table[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					table[i][j]=1+table[i-1][j-1];
				else
					table[i][j]=0;
			max=Math.max(table[i][j], max);	
			}
		}
			return max;
	}

	public static void main (String[] args) throws IOException{
		//code
		Scan s=new Scan();
		int t=s.scanInt();
		
		for(int k=0;k<t;k++)
		{
		    String s1="abcda";
		    String s2="zbcdaf";
		    System.out.println(longestCommonSubstring(s1,s2));
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
            st=new StringTokenizer(br.readLine());
        }
       return st.nextToken();
      
    }
    int scanInt() throws IOException
    {
        return parseInt(scanString());
    }
    
    
}
