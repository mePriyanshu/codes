import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
//AntiDiagonal and diagonalTraverse 
class Test {

	
	static ArrayList<ArrayList<Integer>> antiDigonal(int mat[][])
	{
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		int m=mat.length;
		int n=mat[0].length;
	
		for(int s=0;s<=2*(m-1);s++)
		{
			ArrayList<Integer> a1=new ArrayList<>();
			for(int i=0;i<=s;i++)
			{
				int j=s-i;
				if(i>=m||j>=n)
					continue;
				a1.add(mat[i][j]);
			}
			ans.add(a1);
		}
		return ans;
	}
	
	static ArrayList<ArrayList<Integer>> diagonalTraverse(int mat[][])
	{
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		int m=mat.length;
		int n=mat[0].length;
	    boolean bl=false;
		for(int s=0;s<=m+n-2;s++)
		{
			ArrayList<Integer> a1=new ArrayList<>();
			for(int i=0;i<=s;i++)
			{
				int j=s-i;
				if(i>=m||j>=n)
					continue;
				a1.add(mat[i][j]);
			}
			if(!bl)
				Collections.reverse(a1);
			bl=!bl;
			ans.add(a1);
		}
		int res[]=new int[m*n];
		int k=0;
		for(int i=0;i<ans.size();i++)
		{
			for(int j=0;j<ans.get(i).size();j++)
			{
				res[k++]=ans.get(i).get(j);
			}
		}
		System.out.println(Arrays.toString(res));
		return ans;
	}

	
	public static void main(String aa[]) throws Exception{
			
     Scan s=new Scan();
     int m=s.scanInt();
     int n=s.scanInt();
     int a[][]=new int[m][n];
     for(int i=0;i<m;i++)
     {
    	 for(int j=0;j<n;j++)
    		 a[i][j]=s.scanInt();
    	 
     }
     //System.out.println(antiDigonal(a));
     System.out.println(diagonalTraverse(a));
     

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


