import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Test{
	
static boolean isPermutationByFrequencyArray(String s1,String s2)
{
	int m=s1.length();
	int n=s2.length();
	int freq1[]=new int[26];
	
	for(int i=0;i<m;i++)
	{
		freq1[s1.charAt(i)-'a']++;
	}
	
	for(int i=0;i<=n-m;i++)
	{
		int freq2[]=new int[26];
		
		for(int j=0;j<m;j++)
		{
			freq2[s2.charAt(i+j)-'a']++;
		}
		if(Arrays.equals(freq1, freq2))
			return true;
	}
	return false;
	
}

static boolean isPermutationBySlidingWindow(String s1,String s2)
{
	int m=s1.length();
	int n=s2.length();
	
	int freq1[]=new int[26];
	int freq2[]=new int[26];
	
	for(int i=0;i<m;i++)
	{
		freq1[s1.charAt(i)-'a']++;
		freq2[s2.charAt(i)-'a']++;
	}
	
	for(int i=0;i<n-m;i++)
	{
		if(Arrays.equals(freq1, freq2))return true;
		freq2[s2.charAt(i+m)-'a']++;
		freq2[s2.charAt(i)-'a']--;
	}
	return Arrays.equals(freq1,freq2);
}

	
	

public static void main(String aa[])throws IOException
{
	System.out.println(isPermutationBySlidingWindow("hello","ahello"));
	
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
	    
