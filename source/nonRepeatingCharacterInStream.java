
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//first non repeating character in Stream

class Test{
	
	static void firstNonRepeatingCharacter(char str[])
	{
		int hash[]=new int[26];
		Arrays.fill(hash, 0);
		int n=str.length;
		Queue<Character> q1=new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			q1.add(str[i]);
			hash[getIndex(str[i])]++;
			while(!q1.isEmpty())
			{
				if(hash[getIndex(q1.peek())]>1)
					q1.poll();
				else
				{
					System.out.print(q1.peek()+" ");
					break;
				}
			}
			if(q1.isEmpty())
				System.out.print(-1+" ");
		}
		
		
	}
    static int getIndex(char ch)
    {
    	return ch-'a';
    }
    public static void main(String aa[])throws IOException
    {
    	Scan s=new Scan();
    	int n=s.scanInt();
    	char ch[]=new char[n];
    	for(int i=0;i<n;i++)
    	{
    		String str=s.scanString();
    		ch[i]=str.charAt(0);
    	}
    	firstNonRepeatingCharacter(ch);
    	
    	
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