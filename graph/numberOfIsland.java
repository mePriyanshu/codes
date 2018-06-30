import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Test {



	
	static int numberOfIslands(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		int c=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==1)
				{
					dfsMarking(a,i,j,m,n);
					c++;
				}
			}
		}
		return c;
		
	}
	
	static void dfsMarking(int a[][],int i,int j,int m,int n)
	{
		if(i<0||j<0||i>=m||j>=n||a[i][j]==0)
			return;
		a[i][j]=0;			//marking the i,j index
		dfsMarking(a,i,j-1,m,n);
		dfsMarking(a,i,j+1,m,n);
		dfsMarking(a,i+1,j,m,n);
		dfsMarking(a,i-1,j,m,n);
	}

	public static void main(String aa[])
	{
	
		int a[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
               };
		System.out.println(numberOfIslands(a));
		
		
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
