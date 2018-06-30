import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//finding a point in array such that left <a[i] and a[i]>right
class Test
{
	public static void main(String aa[]) throws IOException
	{
	Scan s=new Scan();
	//int n=s.scanInt();
	int a[]={1,11,8,7,23,4,33,56,45,99};
	int max=a[0];
	boolean bl=true;
	int index=1;
	
	for(int i=1;i<a.length-1;i++)
	{
		if(max<a[i])
		{
			max=a[i];
			if(bl)
			{
				index=i;
				bl=false;
			}
		}
		if(a[index]> a[i+1])
			bl=true;
		
	}
	System.out.println(a[index]);
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