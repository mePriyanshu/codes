import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Test{

	static void sort012(int a[])
	{
		int n=a.length;
		if(n==0)return;
		int left=0,right=n-1;
		int mid=0,temp;
		
		while(mid<=right)
		{
			if(a[mid]==0)
			{
				temp=a[mid];
				a[mid]=a[left];
				a[left]=temp;
				left++;mid++;
			}else if(a[mid]==1)
				mid++;
			else{
				temp=a[mid];
			    a[mid]=a[right];
			    a[right]=temp;
			    right--;
			}
		}
		
	}
public static void main(String aa[])throws IOException
{
	

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
	    
