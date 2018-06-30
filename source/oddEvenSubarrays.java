import java.util.*;
import java.io.*;
 
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
 
 
import java.util.*;
import java.io.*;
 
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
 
 
class Test
{
	
	
	public static void main(String aa[])throws Exception
	{
		Scan s=new Scan();
	
		int n=s.scanInt();
		int a[]=new int[n];
		long sum[]=new long[n];
		for(int i=0;i<n;i++)
		{
			int temp=s.scanInt();
			a[i]=(temp%2==0)?-1:1;
			if(i==0)
			{
				sum[i]=a[i];
			}else
			{
				sum[i]=sum[i-1]+a[i];
			}
		}
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(sum));
	 HashMap<Long,Integer> h1=new HashMap<>();
	 int ans=0;
	 for(int i=0;i<sum.length;i++)
	 {
		 long temp=sum[i];
		 if(temp==0)
		 {
			 ans+=1;
			 //continue;
		 }
		if(h1.containsKey(sum[i]))
		{
			ans+=h1.get(sum[i]);
			h1.put(temp,h1.get(sum[i])+1);
		}else
		{
			h1.put(temp,1);
		}
	 }
	// System.out.println(h1);
	 System.out.println(ans);
	 
	 
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

