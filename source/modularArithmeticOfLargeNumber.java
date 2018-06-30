
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;


//modular Arithmetic of very large number upto an order of 10^1000000
class Test{

	static int mod=1000000007;
	
	static long  modularArithmetic(long x,long y)
	{
		if(y==0)
			return 1;
		
		long res=1;
		if(y%2==1)
		{
			return (x%mod*modularArithmetic(x,y-1)%mod)%mod;
		}else
		{
			res=modularArithmetic(x,y/2)%mod;
			return (res%mod*res%mod)%mod;
		}
	}
	public static void main(String  aa[])throws IOException
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			int a[]=new int[1000000];
			int b[]=new int[1000000];
			String str1=s.scanString();
			String str2=s.scanString();
			
			for(int i=0;i<str1.length();i++)
				a[i]=str1.charAt(i)-'0';
			
			for(int i=0;i<str2.length();i++)
				b[i]=str2.charAt(i)-'0';
			int m=1000000007,n=1000000006;
			
			long temp1=a[0]%m,temp2=b[0]%n;
			
			for(int i=1;i<str1.length();i++){
				temp1=(temp1*10 + a[i])%m;
			}
		
			for(int i=1;i<str2.length();i++){
				temp2=(temp2*10 + b[i])%n;
			}
			//System.out.println(temp1+" "+temp2);
			System.out.println(modularArithmetic(temp1,temp2));
			
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