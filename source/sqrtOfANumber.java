import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//sqrt of a number using binary search
class Test
{
	static int sqrt(int n)
	{
		int left=1,right=n;
		int ans=0;
		while(left<=right)
		{
			int mid=left+(right-left)/2;
		    
			if(mid<=n/mid)
			{
				left=mid+1;
				ans=mid;
			}else
			{
				right=mid-1;
			}
		//System.out.println("left:"+left+"\t"+"mid:"+mid+"\t"+"right:"+"\t"+right);	
		}
		return ans;
	}
	
		
	public static void main(String aa[]) throws Exception
	{
		System.out.println(sqrt(4));
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
