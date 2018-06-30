import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
//set rows and columns zero
class Test {

	static void setRowAndColumnZero(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		boolean fr=false;
		boolean fc=false;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==0)
				{
					if(i==0)fr=true;
					if(j==0)fc=true;
					a[i][0]=0;
					a[0][j]=0;
				}
			}
		}
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(a[i][0]==0||a[0][j]==0)
					a[i][j]=0;
			}
		}
		if(fr)
		{
			for(int i=0;i<n;i++)
				a[0][i]=0;
		}
		
		if(fc)
		{
			for(int i=0;i<m;i++)
				a[i][0]=0;
		}
		print(a);
	}
	static void print(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		
	}
public static void main(String aa[]) throws Exception{
			
     Scan s=new Scan();
     int m=s.scanInt();
     int n=s.scanInt();
     int a[][]=new int[m][n];
     for(int i=0;i<m;i++)
     {
    	 for(int j=0;j<n;j++)
    	 {
    		 a[i][j]=s.scanInt();
    	 }
     }
     ArrayList<ArrayList<Integer>> a1=new ArrayList<>();
     
     setRowAndColumnZero(a);
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


