import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;


//best time to buy and sell stock with k transaction
//T[i][j]=max{T[i][j-1],max{p[j]-p[m]+T[i-1][m}}  where 0<m<j
class Test
{
	
	static int maxProfitByDoingKTransaction(int a[],int k)
	{
		int n=a.length;
		
		int T[][]=new int[k+1][n+1];
		
		for(int i=0;i<=k;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0||j==0)
					T[i][j]=0;
				else
				{
					int max=Integer.MIN_VALUE;
					for(int m=0;m<j;m++)
					{
						
						max=Math.max(a[j]-a[m]+T[i-1][m],max);
					}
					T[i][j]=Math.max(T[i][j-1],max);
				}
			}
			
		}
		return T[k][n-1];
	}

	

public static void main(String aa[]) throws Exception
{
	int a[]={10,22,5,75,65,80};
	int k=2;
	System.out.println(maxProfitByDoingKTransaction(a,k));
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
