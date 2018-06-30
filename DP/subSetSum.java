import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test{
	
	static boolean subSetSumRecursion(int a[],int n,int sum)
	{
		//2 options either include the last element to check subset aur exclude
		
		if(sum==0)return true;
		if(n==0&&sum!=0)return false;
		if(a[n-1]>sum) return subSetSumRecursion(a,n-1,sum);
		return subSetSumRecursion(a,n-1,sum)||subSetSumRecursion(a,n-1,sum-a[n-1]);
	}
		
    static boolean subSetSum(int a[],int n,int sum)
    {
        boolean table[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        	table[i][0]=true;
        for(int i=1;i<=sum;i++)
        	table[0][i]=false;
        for(int i=1;i<=n;i++)
        {
        	for(int j=1;j<=sum;j++)
        	{
        		if(j>=a[i-1])
        		{
        			table[i][j]=table[i-1][j]||table[i-1][j-a[i-1]];
        			
        		}else
        			table[i][j]=table[i-1][j];
        	}
        }
        	return table[n][sum];
    }
	public static void main(String ss[])throws Exception
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			int n=s.scanInt();
			int sum=s.scanInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=s.scanInt();
			if(subSetSumRecursion(a,n,sum))
				System.out.println(1);
			else
				System.out.println(0);
		}
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
	    
