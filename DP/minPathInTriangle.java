import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//min path in a triangle
class Test {

	
	static int minPathInATriangle(List<List<Integer>> l1)
	{
		int n=l1.size();
		List<Integer> minLen=new ArrayList<Integer>(l1.get(n-1)); //copy the last layer
		System.out.println(minLen);
		for(int layer=n-2;layer>=0;layer--)//checking every layer
		{
			
			for(int i=0;i<=layer;i++)
			{
				//checking bottom layer consecutive elements and adding current elements
				int min=Math.min(minLen.get(i),minLen.get(i+1))+l1.get(layer).get(i);
				minLen.set(i,min);
				
			}
			System.out.println(minLen);
		}
		return minLen.get(0);
	}
	
	public static void main(String aa[])throws IOException
	{
		List<List<Integer>> l1=new ArrayList<>();
		List<Integer> a1=new ArrayList<>();
		
		a1.add(2);
		l1.add(a1);
		
		a1=new ArrayList<>();
		a1.add(3);
		a1.add(4);
		l1.add(a1);
		
		a1=new ArrayList<>();
		a1.add(6);
		a1.add(5);
		a1.add(7);
		l1.add(a1);
		
		a1=new ArrayList<>();
		a1.add(4);
		a1.add(1);
		a1.add(8);
		a1.add(3);
		l1.add(a1);
		
		System.out.println(minPathInATriangle(l1));
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
