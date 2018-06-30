import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Test{
	
static int countSubArrayWithProductK(int a[],int k)
{
	int n=a.length;
	
	if(k<=1)
		return 0;
	int prod=1;
	int left=0;
	int ans=0;
	for(int i=0;i<n;i++)
	{
		prod*=a[i];
		while(k<=prod) prod/=a[left++];
		ans+=i-left+1;
	}
	return ans;
	
	
	
}

	
	

public static void main(String aa[])throws IOException
{
	int a[]={10,5,2,6};
	System.out.println(countSubArrayWithProductK(a,100));
	
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
	    
