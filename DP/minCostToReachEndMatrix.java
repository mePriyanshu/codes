import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test{
	
	static int minCostPathInAMatrix(int a[][],int m,int n)
	{
		int table[][]=new int[m][n];
		table[0][0]=a[0][0];
		for(int i=1;i<table[0].length;i++)
		{
			table[0][i]=table[0][i-1]+a[0][i];
		}
		
		for(int j=1;j<table.length;j++)
		{
			table[j][0]=table[j-1][0]+a[j][0];
		}
		
		for(int i=1;i<table.length;i++)
		{
			for(int j=1;j<table[0].length;j++)
			{
				table[i][j]=Math.min(table[i][j-1],table[i-1][j])+a[i][j];
			}
		}
		return table[m-1][n-1];
	}
	public static void main(String ss[])throws Exception
	{
		Scan s=new Scan();
		int m=s.scanInt();
		while(m!=0)
		{
			int n=s.scanInt();
			int a[][]=new int[m][n];
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
					a[i][j]=s.scanInt();
			}
			System.out.println(minCostPathInAMatrix(a,m,n));
			m=s.scanInt();
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
	    
