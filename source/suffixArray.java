import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{
	
	public static void main(String aa[])throws Exception
	{
		
		Scan s=new Scan();
		String str=s.scanString();
		SuffixArray s1=new SuffixArray(str,str.length());
		s1.createSuffixArray();
		//s1.displaySuffixArray();
		
		s1.longestRepeatedSubstring();
	}
}
//bababababababaaa
class suffix
{
 String str;
 int index;	
 suffix(String str,int index)
 {
	 this.str=str;
	 this.index=index;
 }
}

class SuffixArray
{
	String text;
	int len;
	suffix sf[];
	
	SuffixArray(String st,int len)
	{
		text=st;
		this.len=len;
		sf=new suffix[len];
	}
	
	void createSuffixArray()
	{
		for(int i=0;i<len;i++)
		{
			String temp=text.substring(i,len);
			sf[i]=new suffix(temp,i);

		}
		Arrays.sort(sf,new mySort());
	}
private class mySort implements Comparator<suffix>
{

	@Override
	public int compare(suffix o1, suffix o2) {
		// TODO Auto-generated method stub
	   return o1.str.compareTo(o2.str);
	}
	
}
	void displaySuffixArray()
	{
		Arrays.sort(sf,new mySort());
		for(int i=0;i<len;i++)
		{
			System.out.println(sf[i].str+" "+sf[i].index);
		}
	}
	
	String longestCommonPrefix(String s1,String s2)
	{
		int i=0;
		int n=Math.min(s1.length(), s2.length());
		for( i=0;i<n;i++)
		{
			if(s1.charAt(i)!=s2.charAt(i))
				return s1.substring(0,i);
		}
		return s1.substring(0,n);
	}
	
	void longestRepeatedSubstring()
	{
		String lrs="";
		
		for(int i=0;i<len-1;i++)
		{
			//System.out.println(sf[i].str+" "+sf[i+1].str);
		String x=longestCommonPrefix(sf[i].str,sf[i+1].str);
			if(x.length()>lrs.length()){
				lrs=x;
				//System.out.println(lrs);
			}
		}
		System.out.println(lrs);
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
	    
