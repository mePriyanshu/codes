import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//finding the word formed by number of deletions in a string from dictionary
class Test{

	static boolean isSubSequence(String s1,String s2)
	{
		
		int j=0;
		for(int i=0;i<s2.length()&&j<s1.length();i++)
		{
			if(s1.charAt(j)==s2.charAt(i))
				j++;
		}
		return s1.length()==j;
	}
	 static String findLongestWord(String s, List<String> d) {
	     String maxStr="";
	     
	     for(String temp:d)
	     {
	    	 if(isSubSequence(temp,s))
	    	 {
	    		 if(temp.length()>maxStr.length()||temp.length()==maxStr.length()&&temp.compareTo(maxStr)<0)
	    			 maxStr=temp;
	    	 }
	     }
		 return maxStr;
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
	    
