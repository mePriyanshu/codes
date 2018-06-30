import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{
static long mod=1000000007;
HashMap<Long,Long> h1=new HashMap<>();
 long fib(long n)
{
	if(n==0)return 0;
	if(n==1||n==2)h1.put(n, 1L);
	if(h1.containsKey(n))
		return h1.get(n);
	if(n%2==0)
	{
		long k=n/2;
		 h1.put(n,((2*fib(k-1)+fib(k))*fib(k))%mod);
	}else
	{
		long k=(n+1)/2;
		  h1.put(n,(fib(k-1)*fib(k-1)+fib(k)*fib(k))%mod);
	}
	return h1.get(n);
}
	public static void main(String aa[])throws IOException
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			long n=s.scanLong();
			Test t1=new Test();
			System.out.println(t1.fib(n+1));
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
	    
