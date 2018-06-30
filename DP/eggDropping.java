import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//egg dropping problem
class Test
{
	static int binomial(int x,int n,int k)
	{
		int ans=1;
		int total=0;
		for(int i=1;i<=n;i++)
		{
			ans*=((float)x-i+1);
			ans/=(float)i;
			total+=ans;
			if(total>k)
				break;
		}
		return total;
	}
  
	public static void main(String  aa[])
	{
		int k=10,n=2;
		int st=0,end=k;
		int mid=(st+end)/2;
		
		while((end-st)>1)
		{
		     mid=(st+end)/2;
			if(binomial(mid,n,k)<k)
				st=mid;
			else
				end=mid;
			
		}
		System.out.print(st+1);
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
            st=new StringTokenizer(br.readLine(),"\n");
        }
       return st.nextToken();
      
    }
    int scanInt() throws IOException
    {
        return parseInt(scanString());
    }
    
    
}
