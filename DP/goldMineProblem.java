import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{

	static int goldMineProblem(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println();
		for(int col=n-1;col>=0;col--)
		{
			for(int row=0;row<m;row++)
			{
				int right=(col==n-1)?0:a[row][col+1];
				int rightUp=(col==n-1||row==0)?0:a[row-1][col+1];
				int rightDown=(row==m-1||col==n-1)?0:a[row+1][col+1];
				a[row][col]=a[row][col]+Math.max(Math.max(right, rightUp),rightDown);
			}
		
	}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<m;i++)
			max=Math.max(max, a[i][0]);
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
			System.out.print(a[i][j]+" ");
		System.out.println();
	}
	return max;
	}
	public static void main(String aa[])throws IOException
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			int m=s.scanInt();
			int n=s.scanInt();
			int a[][]=new int[m][n];
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
					a[i][j]=s.scanInt();
			}
			
			System.out.println(goldMineProblem(a));
			
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
	   long scanLong() throws IOException
	    {
	        return parseLong(scanString());
	    }
}	    
	    
