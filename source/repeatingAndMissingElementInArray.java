import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;

//repeating and missing element in an array
class Test {

  static void repeatingAndMissing(int arr[])
  {
	  	int n=arr.length;
	  	for(int i=0;i<n;i++)
	  	{

	        if(arr[Math.abs(arr[i])-1] > 0)
	            arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
	        else
	            System.out.println(Math.abs(arr[i]));
	  	}
	  	for(int i=0;i<n;i++)
	  	{
	  		
	  		if(arr[i]>0)
	  			System.out.println(i+1);
	  	}
  }

	
	public static void main(String aa[]){
			repeatingAndMissing(new int[]{3,1,3});
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


