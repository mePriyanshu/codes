import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

//optimal strategy in a game
public class Test {
 
static HashSet<Integer> h1=new HashSet<>();
	static int f(int v[],int i,int j,int result)
	{
		if(h1.contains(result))
			return result;
		if(i>j)
			return 0;
		else
			  result=Math.max(v[i]+Math.min(f(v,i+2,j,result),f(v,i+1,j-1,result)),v[j]+Math.min(f(v,i+1,j-1,result),f(v,i,j-2,result)));
	h1.add(result);
	return result;
	}
	
	static int optimalStrategyInAGame(int v[])
	{
		int n=v.length;
		int table[][]=new int[n][n];
		
		for(int intervel=0;intervel<n;intervel++)
		{
			for(int i=0,j=intervel;j<n;i++,j++)
			{
				int a=(i+2<=j)?table[i+2][j]:0;
				int b=(i+1<=j-1)?table[i+1][j-1]:0;
				int c=(i<=j-2)?table[i][j-2]:0;
				
				table[i][j]=Math.max(v[i]+Math.min(a, b),v[j]+Math.min(b, c));
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(table[i][j]+"\t");
			System.out.println();
		}
		return table[0][n-1];
	}
	public static void main(String aa[])
	{
		//int a[]={20, 30, 2, 2, 2, 10};
		int a[]={3,2,1,4};
		//System.out.println(f(a,0,a.length-1,0));
		System.out.println(optimalStrategyInAGame(a));
	}
}



class Scan
{
   // BufferedReader br;
    StringTokenizer st;
  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String scanString() throws Exception
    {
    	
        while(st==null||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    int scanInt() throws Exception
    {
        return parseInt(scanString());
    }
    
    long scanLong() throws Exception
    {
        return parseLong(scanString());
    }
}