
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//public static final int MAX=26;

class Test{
	
	public static final int MAX=26;
	
	static int stringValueAfterRemovingKCharacters(String str,int k)
	{
		int n=str.length();
		if(k>=n)
			return 0;
		int freq[]=new int[MAX];
		Arrays.fill(freq,0);
		PriorityQueue<Integer> p1=new PriorityQueue<>(MAX,Collections.reverseOrder());
		
		for(int i=0;i<n;i++)
		{
			freq[str.charAt(i)-'a']++;
			
		}
		
		for(int i=0;i<MAX;i++)
			p1.add(freq[i]);
		System.out.print(p1);
		int j=0;
		while(j!=k)
		{
			int temp=p1.poll();
			temp=temp-1;
			p1.add(temp);
			j++;
			
		}
		int res=0;
		while(!p1.isEmpty())
		{
			int temp=p1.poll();
			res+=(temp*temp);
		}
		return res;
	}
	public static void main(String  aa[])
	{
		String str="aaab";
		System.out.print(stringValueAfterRemovingKCharacters(str,2));
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