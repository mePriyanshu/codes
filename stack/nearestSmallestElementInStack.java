import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//nearestSmallestElementInStack
class Test {
 

	static void nearestSmallestElement(int a[])
	{
		int n=a.length;
		System.out.print(-1+" ");
		for(int i=1;i<n;i++)
		{
			int min=-1;
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i])
				{
					min=a[j];
				}
			}
			System.out.print(min+" ");
		}
	}
	   
	static ArrayList<Integer> nearestSmallestElementByStack(int a[])
	{
		int n=a.length;
		Stack<Integer> s1=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			while(!s1.isEmpty()&&s1.peek()>=a[i])
				s1.pop();
			if(s1.isEmpty())
				ans.add(-1);
			else
				ans.add(s1.peek());
			s1.push(a[i]);
		}
		return ans;
	}
		public static void main(String aa[]){
			
			nearestSmallestElement(new int[]{4,5,2,10});
			System.out.println("\n"+nearestSmallestElementByStack(new int[]{4,5,2,10}));
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
