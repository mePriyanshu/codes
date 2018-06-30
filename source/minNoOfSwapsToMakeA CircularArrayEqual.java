import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//minimum no of swaps to make characater equals in circular array
/*  Input Case
1
7
DDKDKDK
*/
class Test{
	
	static void display(String str,int left,int right)
	{
		for(int i=left;i<=right;i++)
			System.out.print(str.charAt(i)+" ");
		System.out.println();
	}
	public static void main(String ss[])throws Exception
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			int n=s.scanInt();
			String str=s.scanString();
			str+=str;
			int countK=0,k=0;
			display(str,0,str.length()-1);
			for(int i=0;i<n;i++)
			{
				char temp=str.charAt(i);
				if(temp=='K')
					k++;
			}
			System.out.println("K:"+k);
			for(int i=0;i<k;i++)
			{
				char temp=str.charAt(i);
				if(temp=='K')
					countK++;
			}
			System.out.println("countK:"+countK);
			
			int max=countK;
			for(int i=k;i<n+n;i++)
			{
				countK=countK+((str.charAt(i)=='K')?1:0)-((str.charAt(i-k)=='K')?1:0);
				display(str,i-k,i);
				//System.out.print(countK+" ");
				//max=Math.max(countK, max);
			}
			System.out.println("\n"+(k-max));
			
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
	    
