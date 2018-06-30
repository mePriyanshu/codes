
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Test {

	static int longestIncreasingSubsequence(int a[])
	{
		int n=a.length;
		int temp[]=new int[n];
		
		Arrays.fill(temp,1);
		int max=Integer.MIN_VALUE;
		for(int i=1;i<n;i++)
		{
			int j=0;
			while(j<i)
			{
				if(a[j]<a[i])
					temp[i]=Math.max(temp[j]+1, temp[i]);
				j++;
			}
			max=Math.max(max,temp[i]);
		}
		
		return max;
	}
	
	static int longestIncreasingSubsequence_OlogN(int a[])
	{
		int n=a.length;
		int temp[]=new int[n];
		int len=0;
		for(int x:a)
		{
			int i=Arrays.binarySearch(a,0,len,x);
			//System.out.print(i+" ");
			if(i<0)i=-(i+1);
			
		    temp[i]=x;
		    if(i==len)len++;
		    System.out.print(len+" ");
		}
		System.out.println("\n"+Arrays.toString(temp));
		return len;
	}
	public static void main(String[] args) throws Exception{
		System.out.println(longestIncreasingSubsequence_OlogN(new int[]{1,3,6,7,9,4,10,5,6}));
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
   long scanLong() throws IOException
    {
        return parseLong(scanString());
    }
   int scanInt() throws IOException
   {
       return parseInt(scanString());
   }
    
    
}