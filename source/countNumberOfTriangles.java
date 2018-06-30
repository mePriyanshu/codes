import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//count number of triangles in an array
class Test {

	static int countNumberOfTriangle(int a[])
	{
		int n=a.length;
		Arrays.sort(a);
		int count=0;
		for(int i=0;i<n-2;i++)
		{
			int k=i+2;
			for(int j=i+1;j<n-1&&a[i]!=0;j++)
			{
				while(k<n&&(a[i]+a[j])>a[k])k++;
				count+=(k-j-1);
			}
		}
		return count;
	}
	

		public static void main(String aa[]){
			
		System.out.println(countNumberOfTriangle(new int[]{2,2,3,4}));
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
