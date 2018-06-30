import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//No of binary search tree with given n
//nth catalan number
class Test {
 
	static int countBst(int n)
	{
		if(n==1)return 1;
		if(n==0)return 0;
		int t[]=new int[n+1];
		t[0]=1;
		t[1]=1;
	
		int i=0;
		t[2]=0;
		for( i=2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
				t[i]+=t[j]*t[i-j-1];
		}
		return t[n];
	}
	
	public static void main(String  aa[])
	{
		System.out.print(countBst(16));
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