import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//kmp algorithm
class Test {

	static String shortestPalindrome(String str)
	{
		StringBuilder sb=new StringBuilder(str);
		String s2=sb.reverse().toString();
		int n=str.length();
		for(int i=0;i<n;i++)
		{
			String first=str.substring(0,n-i);
			String second=s2.substring(i);
			
			System.out.println(first);
			System.out.println(second);
			
			if(first.equals(second))
				return s2.substring(0,i)+str;
		}
		return "";
		
	}
	
	
	
	public static void main(String aa[]){
		KMPAlgorithm k1=new KMPAlgorithm();
		System.out.print(k1.kmpSearch("hellohoello", "ello"));
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


class KMPAlgorithm
{
	int[] createTempArray(String pattern)
	{
		int n=pattern.length();
		int temp[]=new int[n];
		int index=0;
		for(int i=1;i<n;)
		{
			if(pattern.charAt(i)==pattern.charAt(index))
			{
				temp[i]=index+1;
				index++;i++;
			
			}else
			{
				if(index!=0)
				{
					index=temp[index-1];
				}else
				{
					temp[i]=0;
					i++;
				}
			}
		}
		return temp;
	}
	
	boolean kmpSearch(String text,String pattern)
	{
		int temp[]=createTempArray(pattern);
		int i=0;
		int j=0;
		while(i<text.length()&&j<pattern.length())
		{
			if(text.charAt(i)==pattern.charAt(j))
			{	
				i++;
				j++;
			}else
			{
				if(j!=0)
				{
					j=temp[j-1];
				}else
					i++;
			}
			if(j==pattern.length()){
				System.out.println("Found Pattern At "+ (i-j));
				return true;
			}
		}
		return false;
	}
}
