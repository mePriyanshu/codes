import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{

	static int bellNumber(int n)
	{
		int table[][]=new int[n+1][n+1];
		table[0][0]=1;
		
		for(int i=1;i<=n;i++)
		{
			table[i][0]=table[i-1][i-1];
			for(int j=1;j<=i;j++)
			{
				table[i][j]=table[i][j-1]+table[i-1][j-1];
			}
		}
		return table[n][0];
	}
	public static void main(String aa[])throws IOException
	{
		
		System.out.println(bellNumber(2));
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
	   long scanLong() throws IOException
	    {
	        return parseLong(scanString());
	    }
}	    
	    
