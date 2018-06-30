import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//look sequence 1 11 21 1211 
class Test {
	static String lookSequence(int n)
	{
		if(n==1)return "1";
		if(n==2) return "11";
		String str="11";
		for(int i=3;i<=n;i++)
		{
			str=str+"$";
			int c=1;
			String temp="";
			for(int j=1;j<str.length();j++)
			{
				if(str.charAt(j-1)!=str.charAt(j))
				{
				  temp=temp+String.valueOf(c)+str.charAt(j-1)+"";
				  c=1;
				}else
					c++;
			}
			str=temp;
		}
		return str;
	}
	public static void main(String aa[])
	{
		System.out.print(lookSequence(5));
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