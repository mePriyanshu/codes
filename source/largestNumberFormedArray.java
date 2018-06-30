import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//largest number formed from array
class Test
{
	class MySort implements Comparator<String>
	{

		
		public int compare(String o1, String o2) {
			String s1=o1+o2;
			String s2=o2+o1;
			return s2.compareTo(s1);
			
		}

		
		
	}
	public static void main (String[] args) throws IOException{
		//code
		Scan s=new Scan();
		int t=s.scanInt();
		Test t1=new Test();
		for(int k=0;k<t;k++)
		{
		    int n=s.scanInt();
		    int i=0;
		    String str[]=new String[n];
		    for(i=0;i<n;i++)
		    {
		    	int temp=s.scanInt();
		    	str[i]=Integer.toString(temp);
		    }
		    Arrays.sort(str,t1.new MySort());
		    	
		   
		    String ans="";
		    for(i=0;i<str.length;i++)
		    	ans+=str[i];
		    System.out.print(ans);   
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
    
    
}
