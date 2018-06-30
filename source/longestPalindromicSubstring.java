import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//longest palindromic substring
class Test
{
	static String extend(String str,int left,int right)
	{
		int n=str.length();
		while(0<=left&&right<n)
		{
			if(str.charAt(left)!=str.charAt(right))
				break;
			left--;
			right++;
		}
		return str.substring(left+1,right);
	}
	
	static String longestPalindromicSubstring(String str)
	{
		int n=str.length();
		String max="";
		for(int i=0;i<n;i++)
		{
			String s1=extend(str,i,i); 						//even expand
			String s2=extend(str,i,i+1);					//odd expand
			//System.out.println(s1+" "+s2+"$");
		
			if(s1.length()>max.length())
				max=s1;
			if(s2.length()>max.length())
				max=s2;
		}
		return max;
	}
	public static void main(String aa[])throws Exception
	{
		String str="babad";
		System.out.println(longestPalindromicSubstring(str));
		
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
