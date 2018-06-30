import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//bit manipulation Algorithms
class Test{
	static boolean powerOfTwo(int n)
	{
		int c=0;
		if(n==0||n==1){
			return false;
		}
		c=(n&(n-1));
		if(c==0){
			
			return true;}
		else
			return false;
	}
	static void unique(int a[],int n)			//finding a unique element {5,5,5,8};
	{
		int res=0,i=0;
	    for(i=0;i<Integer.SIZE;i++)
	    {
	        int sum=0;
	        int x=1<<i;
	        for(int j=0;j<n;j++)
	        {
	            if((a[j]&x)!=0)
	            sum++;
	        }
	      if(sum%2!=0)  
	     res|=x;
	        
	}
	System.out.println(res);
	}
	static int countNoOfOnes(int n)
	{
		int c=0;
		while(n>0)
		{
			n=(n&(n-1));			//flipps the rightmostOne of binary number
			c++;
		}
		return c;
	}
	static boolean ithBitSet(int n,int i)
	{
		int c=0;
		c=n&(1<<i);
		if(c!=0)
			return true;
		else
			return false;
	}
	public static void main (String[] args) throws IOException{
		
		//System.out.println(powerOfTwo(16));
		//System.out.println(countNoOfOnes(23));
		System.out.println(ithBitSet(20,2));
		
		
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


