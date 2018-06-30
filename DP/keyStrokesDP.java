import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//max A's with 4 key strokes
class Test
{
	public static final int SIZE=75;
	static int findMaxA(int n,int sol[])
	{
		if(n<0) return -1;
		if(n<=6) return n;
		int max=Integer.MIN_VALUE;
		int mul=2;
		int res=0;
		for(int i=n-3;i>=0;i--)
		{
			if(sol[i]==-1)
			{
				sol[i]=findMaxA(i,sol);
			}
			res=mul*sol[i];
			mul++;
			if(res>max)
				max=res;
		}
		return max;
	}
	
	public static void main(String aa[])
	{
		int sol[]=new int[SIZE];
		
		for(int i=0;i<SIZE;i++)
			sol[i]=-1;
		System.out.println(findMaxA(75,sol));
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
