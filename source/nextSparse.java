import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//last 1 bit=input~-input;
//last consecutive bits=(input+last 1 bit)&input
//next sparse number no consecutive 1s
class Test {
 
	static int nextSparse(int n)
	{
		int lastOnes=0,lastCombination=0;
		int res=0;
		while(n>0)
		{
			lastOnes=n&-n;
			lastCombination=~(n+lastOnes)&n;
			if(lastOnes==lastCombination)
			{
				res|=lastOnes;
				n&=(n-1);
			}else
			{
				n++;
				res=0;
			}
		}
		return res;
	}
	public static void main(String aa[])
	{
		System.out.print(nextSparse(6));
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