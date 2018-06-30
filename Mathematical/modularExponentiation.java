import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
class Test
{
	static long powMod(long a,long b,long p)
	{
		if(b==0)
			return 1;
		else if(b%2==0)
		{
			long y=powMod(a,b/2,p);
			return (y*y)%p;
		}else
			return ((a%p)*powMod(a,b-1,p))%p;
	}
   public static void main(String aa[])throws Exception
   {
       Scan s=new Scan();
       System.out.println(powMod(2,3,6));

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