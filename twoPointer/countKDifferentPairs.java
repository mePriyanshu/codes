import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//a-b=k
class Test{
	
static int countKDiffPairs(int a[],int k)
{
	int n=a.length;
	HashMap<Integer,Integer> h1=new HashMap<>();
    
	for(int i=0;i<n;i++)
	{
		if(h1.containsKey(a[i]))
			h1.put(a[i],h1.get(a[i])+1);
		else
			h1.put(a[i], 1);
	}
	
	int c=0;
	for(Map.Entry<Integer, Integer> m1:h1.entrySet())
	{
		if(k==0)
		{
			if(m1.getValue()>=2)
				c++;
		}else
		{
			if(h1.containsKey(m1.getKey()+k))
				c++;
		}
	}
	return c;
	
}

	
	

public static void main(String aa[])throws IOException
{
	int a[]={1, 3, 1, 5, 4};
	System.out.println(countKDiffPairs(a,0));
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
	    
