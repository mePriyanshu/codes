import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{
	long mod=1000000007;
void square(long f[][])
{
	long x=((f[0][0]*f[0][0])%mod+(f[0][1]*f[1][0])%mod)%mod;
	long y=((f[0][0]*f[0][1])%mod+(f[0][1]*f[1][1])%mod)%mod;
	long z=((f[1][0]*f[0][0])%mod+(f[1][1]*f[1][0])%mod)%mod;
	long w=((f[1][0]*f[0][1])%mod+(f[1][1]*f[1][1])%mod)%mod;
	
	f[0][0]=x;
	f[0][1]=y;
	f[1][0]=z;
	f[1][1]=w;
}

void power(long f[][])
{
	long m[][]=new long[][]{
		{1,1},{1,0}
	};
	long x=((f[0][0]*m[0][0])%mod+(f[0][1]*m[1][0])%mod)%mod;
	long y=((f[0][0]*m[0][1])%mod+(f[0][1]*m[1][1])%mod)%mod;
	long z=((f[1][0]*m[0][0])%mod+(f[1][1]*m[1][0])%mod)%mod;
	long w=((f[1][0]*m[0][1])%mod+(f[1][1]*m[1][1])%mod)%mod;
	
	f[0][0]=x;
	f[0][1]=y;
	f[1][0]=z;
	f[1][1]=w;
}
 void fib(long n,long f[][])
{
	if(n<=1)return;
	fib(n/2,f);
	square(f);
	if(n%2!=0)
		power(f);
	
}
	public static void main(String aa[])throws IOException
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			long l=s.scanLong();
			Test t1=new Test();
		
			long f[][]=new long[2][2];

			f[0][0]=1;	
			f[0][1]=1;
			f[1][0]=1;	
			f[1][1]=0;	
			t1.fib(l,f);
			System.out.println(f[0][0]);
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
	    
