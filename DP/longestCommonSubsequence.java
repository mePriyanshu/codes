import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//longest common subsequence
class Test
{
	static int longestCommonSubSequence(String s1,String s2)
	{
		int table[][]=new int[s1.length()+1][s2.length()+1];
		int m=s1.length()+1;
		int n=s2.length()+1;
		int max=0;
		int i=0,j=0;
		for( i=0;i<m;i++)
		{
			for( j=0;j<n;j++)
			{
				if(i==0||j==0)
					table[i][j]=0;
				else
				if(s1.charAt(i-1)==s2.charAt(j-1))
					table[i][j]=1+table[i-1][j-1];
				else
					table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
				if(max<table[i][j])
					max=table[i][j];
			}
		}
		int index=table[m-1][n-1];
		char ans[]=new char[index+1];
		ans[index]='\0';
		i=m-1;j=n-1;
		while(i>0&&j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				ans[index-1]=s1.charAt(i-1);
				i--;j--;index--;
			}else if(table[i-1][j]>table[i][j-1])
				i--;
			else
				j--;
		}
		
		System.out.print(ans);
		return max;
	}

  
	public static void main (String[] args) throws IOException{
		String s1="AGGTAB";
		String s2="GXTXAYB";
		System.out.print(longestCommonSubSequence(s1,s2));
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
            st=new StringTokenizer(br.readLine(),"\n");
        }
       return st.nextToken();
      
    }
    int scanInt() throws IOException
    {
        return parseInt(scanString());
    }
    
    
}
