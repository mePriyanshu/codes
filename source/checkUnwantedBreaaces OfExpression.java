import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//check whether the expression has unwanted parenthesis or not
class Test {

	static	int braces(String str) {
	
		Stack<Character> s1=new Stack<>();
	    int index=0;
	    int n=str.length();
	    while(index<n)
	    {
	    	char temp=str.charAt(index);
	    	 if(temp==')')
	    	{
	    		char poppedElement=s1.pop();
	    		//System.out.println(poppedElement);
	    		boolean flag=false;
	    		while(poppedElement!='(')
	    		{
	    			if(poppedElement=='+'||poppedElement=='-'||poppedElement=='*'||poppedElement=='/')
	    			{
	    				flag=true;
	    			}
	    			poppedElement=s1.pop();
	    		}
	    		if(!flag)
	    			return 1;
	    	}else
	    		s1.push(temp);
	    
	    	index++;
	    }
	    return 0;
    }
	   
		public static void main(String aa[]){
			
	     String str="(a + b)";
	     System.out.println(braces(str));
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
