
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;



class Test{

	static void sieveOfErathosthenes(int n)
	{
		
		boolean sieve[]=new boolean[n+1];
		sieve[0]=true;
		sieve[1]=true;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(!sieve[i])
			{
				for(int j=2;i*j<=n;j++)
					sieve[i*j]=true;
			}
		}
		for(int i=2;i<=n;i++)
			if(!sieve[i])
				System.out.print(i+" ");
	}
		
	public static void main(String  aa[])throws IOException
	{
		Scan s=new Scan();
		int n=s.scanInt();
		sieveOfErathosthenes(n);
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