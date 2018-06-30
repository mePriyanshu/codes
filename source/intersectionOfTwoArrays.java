import java.util.*;

import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//intersection of arrays
class Test{
	
static  int[] intersect(int[] a, int[] b) {
    int m=a.length;
    int n=b.length;
Arrays.sort(a);
Arrays.sort(b);

int fir=0,sec=0;
HashSet<Integer> h1=new HashSet<>();
while(fir<m&&sec<n)
{
	if(a[fir]==b[sec])
	{
		h1.add(a[fir]);
		fir++;sec++;
	}else if(a[fir]>b[sec])
	{
		sec++;
	}else
		fir++;
}
int k=0;
int res[]=new int[h1.size()];
for(int x:h1)
{
	res[k++]=x;
}
return res;
}



	public static void main(String aa[])throws Exception
	{
	System.out.println(Arrays.toString(intersect(new int[]{1,1},new int[]{1})));

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
	    
