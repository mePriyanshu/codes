import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//total no. of ways to reach right corner in matrix
class Test
{
	static int waysToReachRightCorner(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		int table[][]=new int[m][n];
		int i=0,j=0;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==0||j==0)
					table[i][j]=1;
				else
					table[i][j]=table[i-1][j]+table[i][j-1];
			}
		}
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		return table[m-1][n-1];
	}

	public static void main (String[] args) throws IOException{
		//code
		Scan s=new Scan();
		int t=s.scanInt();
		
		for(int k=0;k<t;k++)
		{
		    int a[][]=new int[4][4];
		    for(int i=0;i<4;i++)
		    {
		    	for(int j=0;j<4;j++)
		    		a[i][j]=s.scanInt();
		    }
		    System.out.println(waysToReachRightCorner(a));
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
