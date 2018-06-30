import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
//pascal triangle
class Test {

	static List<List<Integer>> pascalTriangle(int n)
	{
		List<List<Integer>> triangle=new ArrayList<>();
		triangle.add(0,new ArrayList<Integer>());
		triangle.get(0).add(1);
		for(int i=1;i<n;i++)
		{
			List<Integer> rows=new ArrayList<Integer>();
			List<Integer> prev=triangle.get(i-1);
			rows.add(1);
			for(int j=1;j<i;j++)
			{
				rows.add(prev.get(j)+prev.get(j-1));
			}
			rows.add(1);
			triangle.add(rows);
		}
		return triangle;
	}
	
	static List<Integer> pascalTriangleKthRow(int n)
	{
		List<Integer> ans=new ArrayList<>();
		for(int i=0;i<=n;i++)
		{
			ans.add(1);
			for(int j=i-1;j>0;j--)
			{
				ans.set(j,ans.get(j)+ans.get(j-1));
			}
		}
		return ans;
		
	}
	
public static void main(String aa[]) throws Exception{
			
     Scan s=new Scan();
     System.out.println(pascalTriangle(13));
     System.out.println(pascalTriangleKthRow(3));

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


