import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

//cost of minimum rope
//There are given n ropes of different lengths, we need to connect these ropes into one rope. 
//The cost to connect two ropes is equal to sum of their lengths.
//We need to connect the ropes with minimum cost.
class Test
{
	static int minCostRope(int a[])
	{
		int n=a.length;
		int result=0;
		PriorityQueue<Integer> p1=new PriorityQueue<>();
		for(int i=0;i<n;i++)
			p1.add(a[i]);
		while(p1.size()>1)
		{
			int first=p1.poll();
			int second=p1.poll();
			result+=first+second;
			p1.add(first+second);
		}
		return result;
	}
public static void main(String aa[])
{
	int a[]={4,3,2,6};
	System.out.print(minCostRope(a));
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

