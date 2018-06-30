
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;



class Test{

	static void factorsOfANumber(int n)
	{
		TreeSet<Integer> ans=new TreeSet<>();
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				ans.add(i);
				if(i!=Math.sqrt(n))
					ans.add(n/i);
			}
		}
		System.out.println(ans);
	}
	
	static void primeFactorsOfANumber(int n)
	{
		int c=0;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				 c=0;
				while(n%i==0)
				{
					c++;
					n/=i;
				}
				System.out.println(i+"^"+c);
			}
			
			
		}
		if(n!=1)
			System.out.println(n+"^"+1);
	}
	public static void main(String  aa[])throws IOException
	{
		Scan s=new Scan();
		int n=s.scanInt();
		primeFactorsOfANumber(n);
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