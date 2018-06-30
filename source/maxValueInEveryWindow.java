
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//max of all subArraysOf size of window k

class Test{
	
	static void maxOfSubArraysOfK(int a[],int k)
	{
		int n=a.length;
		ArrayList<Integer> a1=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			a1.add(a[i]);
			int max=Integer.MIN_VALUE;
			if(a1.size()==k)
			{
				Iterator it=a1.iterator();
				while(it.hasNext())
					max=Math.max(max, (int)it.next());
				System.out.print(max+" ");
				a1.remove(0);
			}
			
		}
	}
	
	public static void main(String  aa[])
	{
		int a[]={12, 1, 78, 90, 57, 89, 56};
		maxOfSubArraysOfK(a,3);
		
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