 import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//is given preOrder valid
class Test{
 
    static boolean isPreOrderValid(int preOrder[])
    {
    	int root=Integer.MIN_VALUE;
    	Stack<Integer> s1=new Stack<>();
    	for(int i=0;i<preOrder.length;i++)
    	{
    		if(preOrder[i]<root)
    			return false;
    		while(!s1.isEmpty()&&s1.peek()<preOrder[i])
    			root=s1.pop();
    		s1.add(preOrder[i]);
    	}
    	return true;
    }
    
	public static void main (String[] args) throws IOException{
		//code
		System.out.print(isPreOrderValid(new int[]{2,4,3}));
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