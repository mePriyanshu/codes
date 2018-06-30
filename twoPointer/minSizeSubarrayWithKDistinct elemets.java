import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//two pointer approach
class Test{
	
static int minElementWithkDistinct(int a[],int k)
{
	int left=0,right=0;
	int n=a.length;
	int freq[]=new int[n];
	HashSet<Integer> h1=new HashSet<>();
	int ans=Integer.MAX_VALUE;
	while(left<n)
	{
		while(right<n && h1.size()<k)
		{
			h1.add(a[right]);
			freq[a[right]]++;
			right++;
		}
		if(h1.size()>=k)
		ans=Math.min(ans,right-left);
		
		if(freq[a[left]]==1) h1.remove(a[left]);
		freq[a[left]]--;
		left++;
		
	}
	return (ans==Integer.MAX_VALUE)?-1:ans;
}
	public static void main(String aa[])throws Exception
	{
		
		Scan s=new Scan();
		int n=s.scanInt();
		int k=s.scanInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=s.scanInt();
		}
		System.out.println(minElementWithkDistinct(a,k));	
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
	    
