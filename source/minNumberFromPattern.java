import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//min number from pattern
//I 12
//D 21
//IDD 1432
class Test{

static void minNumberFromPattern(String str)
{
	String res="";
	Stack<Integer> s1=new Stack<>();
	for(int i=0;i<=str.length();i++)
	{
		s1.push(i+1);
		if(i==str.length()||str.charAt(i)=='I')
		{
			while(!s1.isEmpty())
			{
				res=res+s1.pop();
			}
		}
	}
	System.out.print(res);
}
public static void main(String aa[])
{
minNumberFromPattern("IDID");	
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
