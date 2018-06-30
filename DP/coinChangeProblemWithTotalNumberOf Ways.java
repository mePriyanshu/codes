import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//coins change problem with total number of ways
class Test
{
	static int coinChangeProblem(int coins[],int n)
	{
		if(n==0)return 0;
		int m=coins.length;
		int table[][]=new int[m+1][n+1];
		
		for(int i=1;i<=n;i++)
		{
			table[0][i]=0;
		}
		
		for(int j=0;j<=m;j++)
		{
			table[j][0]=1;
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(j>=coins[i-1])
				{
					table[i][j]=table[i-1][j]+table[i][j-coins[i-1]];
				}else
					table[i][j]=table[i-1][j];
			}
		}
		return table[m][n];
	}
	
	static int coinChangeByRecursion(int coins[],int n,int i)
	{
		if(n==0)return 1;
		if(n<0)return 0;
		if(coins.length==i&&n>0)return 0;
		return coinChangeByRecursion(coins,n-coins[i],i)+coinChangeByRecursion(coins,n,i+1);
	}
	public static void main(String ar[]) throws IOException
	{
		System.out.println(coinChangeByRecursion(new int[]{1,2,3},4,0));
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
