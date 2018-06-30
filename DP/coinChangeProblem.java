import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//coin change problem minimum number of coins
class Test{
	static int coinChange(int coins[],int total)
	{
		int table[][]=new int[coins.length+1][total+1];
		int i=0,j=0;
		for(i=0;i<=coins.length;i++)
		{
			for(j=0;j<=total;j++)
			{
				if(i==0)
					table[i][j]=j;
				else if(j==0)
					  table[i][j]=0;
				else if(j>=coins[i-1])
				{
					table[i][j]=Math.min(table[i-1][j], 1+table[i][j-coins[i-1]]);
				}else
					table[i][j]=table[i-1][j];
			}
		}
		
		for(i=0;i<table.length;i++)
		{
			for(j=0;j<table[0].length;j++)
				System.out.print(table[i][j]+" ");
			System.out.println();
		}
		return table[coins.length][total];
	}
	
	public static void main(String aa[])
	{
		int coins[]={1,5,6,8};
		int total=11;
		System.out.print(coinChange(coins,total));
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
