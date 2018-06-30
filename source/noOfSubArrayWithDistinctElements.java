import java.io.*;
import java.util.*;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//no. of subarray with distinct elements
class Test {

    public static void main(String args[] ) throws Exception {
        
        Scan s=new Scan();
        
        int n=s.scanInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        	a[i]=s.scanInt();
        HashSet<Integer> h1=new HashSet<>();
	    int lastIndex=0;
	    for(int i=0;i<n;i++)
	    {
	    	if(h1.add(a[i]))
	    		lastIndex=i;
	    }
	    //System.out.print(lastIndex+" "+a[lastIndex]);
	    long c=1+(n-lastIndex-1);
	   int subStart=0,subEnd=lastIndex;
	   while(subStart<n&&subEnd<n)
	   {
		   int temp=a[subStart];
		   int i=subStart+1;
		   for(;i<n;i++)
		   {
			   if(temp==a[i])
				   break;
		   }
		   if(i>=n)break;
		   if(i>subEnd)
			   subEnd=i;
		   subStart++;
		   c+=1+(n-subEnd-1);
	   }
	   System.out.print(c);
    }
}


class Scan
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
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
    
    int scanInt()throws IOException
    {
        return parseInt(scanString());
    }
}
