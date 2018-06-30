import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//zero to flip to get max 1
class Test
{
	static int flipToGetMax1(int a[],int maxK)
	{
		int n=a.length;
		int wl=0,wr=0;
		int countZero=0;
		int bestWindow=0;
		int bestLeft=0;
		while(wr<n)
		{
			if(countZero<=maxK)
			{
				if(a[wr]==0)
				{
					countZero++;
				}
				wr++;
			}
			if(countZero>maxK)
			{
				if(a[wl]==0)
					countZero--;
				wl++;
			}
			if(wr-wl>bestWindow)
			{
				bestWindow=wr-wl;
				bestLeft=wl;
			}
		 
		}
		int i=0;
		for( i=0;i<bestWindow;i++)
		{
			System.out.println(a[i+wl]+" ");
		}
		return i;
	}
	public static void main (String[] args) throws IOException{
		//code
		Scan s=new Scan();
		int t=s.scanInt();
		
		for(int k=0;k<t;k++)
		{
		    int n=s.scanInt();
		    int i=0;
		    int a[]=new int[n];
		    for(i=0;i<n;i++)
		      a[i]=s.scanInt();
		    int maxK=s.scanInt();
		    System.out.print(flipToGetMax1(a,maxK));
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
    
    
}
