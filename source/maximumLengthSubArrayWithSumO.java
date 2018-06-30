import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

//maximum length of subarray with sum=0;
class Test
{
public static void main(String aa[])
{
	int a[]={15, -2, 2, -8, 1, 7, 10, 23};
	
	HashMap<Integer,Integer> h1=new HashMap<>();
	int sum=0;
	int maxLength=0;
	h1.put(0, -1);
	for(int i=0;i<a.length;i++)
	{
		sum=sum+a[i];
		Integer index=h1.get(sum);
		if(index!=null)
		{
			int length=i-index;
			maxLength=Math.max(maxLength, length);
		}else
			h1.put(a[i], i);
		
	}
	System.out.println(maxLength);
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

/*1, 2, -1, -4, -20},
{-8, -3, 4, 2, 1},
{3, 8, 10, 1, 3},
{-4, -1, 1, 7, -6}*/