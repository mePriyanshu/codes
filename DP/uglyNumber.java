
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Test {

	static int maxDivide(int a,int b)
	{
		while(a%b==0)
			a/=b;
		return a;
	}
	static boolean isUgly(int n)
	{
		int ans;
		n=maxDivide(n,2);
		n=maxDivide(n,3);
		n=maxDivide(n,5);
		if(n==1)return true;
		return false;
		
	}
	static int  countUgly(int n)
	{
		int i=1;
		int c=0;
		int ans=0;
		
		while(true)
		{
			if(isUgly(i))c++;
			if(c==n)
			{
				ans=i;		break;
			}
			i++;
		}
		return ans;

	}
	static int isUglyDp(int n)
	{
		int aux[]=new int[n];
		int i2=0,i3=0,i5=0;
	    
		int mul2=2,mul3=3,mul5=5;
		aux[0]=1;
		int ans=1;
		for(int i=1;i<n;i++)
		{
			ans=Math.min(Math.min(mul2, mul3), mul5);
			aux[i]=ans;
			if(ans==mul2)
			{
				i2=i2+1;
				mul2=aux[i2]*2;
			}
			
			if(ans==mul3)
			{
				i3=i3+1;
				mul3=aux[i3]*3;
			}
			
			if(ans==mul5)
			{
				i5=i5+1;
				mul5=aux[i5]*5;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
	System.out.println(isUglyDp(150));
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
   long scanLong() throws IOException
    {
        return parseLong(scanString());
    }
   int scanInt() throws IOException
   {
       return parseInt(scanString());
   }
    
    
}