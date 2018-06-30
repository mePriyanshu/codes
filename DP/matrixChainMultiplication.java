import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

//matrix chain multiplication
public class Test {

int lookup[][];
	Test(int n)
	{
		lookup=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				lookup[i][j]=-1;
		}
	}


int matrixChainMultiplicationByRecursion(int a[],int i,int j)
{
	if(i==j)
		return 0;
	int min=Integer.MAX_VALUE;
	if(lookup[i][j]!=-1)return lookup[i][j];
	for(int k=i;k<j;k++)
	{
		int res=matrixChainMultiplicationByRecursion(a,i,k)+matrixChainMultiplicationByRecursion(a,k+1,j)+a[i-1]*a[j]*a[k];
		min=Math.min(res,min);
	}
	lookup[i][j]=min;
return min;
}
public static void main(String aa[]) throws Exception
{
	Scan s=new Scan();
	int t=s.scanInt();
	
	while(t-->0)
	{
		int n=s.scanInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.scanInt();
		Test t1=new Test(n);
		System.out.println(t1.matrixChainMultiplicationByRecursion(a,1,a.length-1));
	}
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