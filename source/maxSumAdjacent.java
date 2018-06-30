import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//max sum without adjacent
class Test
{
	static int maxSumWithoutAdjacent(int a[])
	{
		int n=a.length;
		if(n==1)
			return a[0];
		if(n==2)
			return Math.max(a[0], a[1]);
		a[1]=Math.max(a[0], a[1]);
		for(int i=2;i<n;i++)
		{
			a[i]=Math.max(a[i-1], a[i]+a[i-2]);
		}
		return Math.max(a[1],a[n-1]);
	}
	public static void main(String aa[])
	{
		int a[]={5,  5, 10, 40, 50, 35};
		System.out.print(maxSumWithoutAdjacent(a));
		
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
