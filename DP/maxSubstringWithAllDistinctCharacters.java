import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{

	static int lengthOfSubstringWithDistinctCharacters(String str)
	{
		int n=str.length();
		HashSet<Character> h1=new HashSet<>();
		int startIndex=0,endIndex=0;
		int max=Integer.MIN_VALUE;
		while(startIndex<n&&endIndex<n)
		{
			char ch=str.charAt(endIndex);
			if(!h1.contains(ch))
			{
				h1.add(ch);
				endIndex++;
				max=Math.max(max,endIndex-startIndex);
				
			}else
			{
				h1.remove(str.charAt(startIndex));
				startIndex++;
			}
		}
		return max;
		
	}
	public static void main(String aa[])throws IOException
	{
		   Scan s=new Scan();
		   int t=s.scanInt();
		   while(t-->0)
		   {
			   String str=s.scanString();
			   System.out.println(lengthOfSubstringWithDistinctCharacters(str));
		   }
		  
		
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
	    
