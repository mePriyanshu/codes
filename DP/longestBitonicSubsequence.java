import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//longest bitonic subsequence which first  then decreases
class Test
{
	static int longestBitonicSubsequence(int a[])
    {
        int n=a.length;
        int incSub[]=new int[n];
        int decSub[]=new int[n];
        int i=0,j=0;
        for(i=0;i<n;i++)
           {
               incSub[i]=1;
               decSub[i]=1;
           }
        for(i=1;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i])
                  incSub[i]=Math.max(incSub[i],incSub[j]+1);
            }
        }
       i=0;j=0;
       for(i=n-2;i>=0;i--)
       {
           for(j=n-1;j>i;j--)
           {
               if(a[j]<a[i])
                decSub[i]=Math.max(decSub[i],decSub[j]+1);
           }
       }
       int max=incSub[0]+decSub[0]-1;
       for(i=1;i<n;i++)
       {
           max=Math.max(max,incSub[i]+decSub[i]-1);
       }
       return max;
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
		  System.out.print(longestBitonicSubsequence(a));
		  System.out.println();
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
