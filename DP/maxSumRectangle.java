import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//maximum rectangular matrix
/*4 5
2 1 -3 -4 5 0 6 3 4 1 2 -2 -1 4 -5 -3 3 1 0 3*/
class Test {
	public static Integer rec[][]=null;
	public static int noOfRows,noOfCol;
	static int maximum(int a,int b,int c)
	{
		int m=a;
		if(m<b)
			m=b;
	    if(m<c)
			m=c;
		return m;
 			
	}
	static int calculateSum(int rowStartIndex,int rowEndIndex,int colStartIndex,int colEndIndex)
	{
		if(rowStartIndex<0||rowEndIndex>=noOfRows||colStartIndex<0||colEndIndex>=noOfCol)
			return Integer.MIN_VALUE;
		int currentSum=0;
		for(int i=rowStartIndex;i<=rowEndIndex;i++)
			for(int j=colStartIndex;j<=colEndIndex;j++)
				currentSum+=rec[i][j];
		//System.out.println(currentSum);
		return Math.max(Math.max(currentSum,calculateSum(rowStartIndex,rowEndIndex,colStartIndex,colEndIndex+1)),calculateSum(rowStartIndex-1,rowEndIndex,colStartIndex,colEndIndex));
	}
	static int maximumSum(int noOfRows,int noOfCol)
	{
		int maxSum=0;
		for(int i=0;i<noOfRows;i++)
		{
			for(int j=0;j<noOfCol;j++){
				int temp=calculateSum(i,i,j,j);
				if(temp>maxSum)
					maxSum=temp;
			}
		}
		return maxSum;
	}
	
	public static void main(String aa[])throws IOException
	{
		Scan s=new Scan();
		 noOfRows=s.scanInt();
		 noOfCol=s.scanInt();
		rec=new Integer[noOfRows][noOfCol];
		for(int i=0;i<noOfRows;i++)
		{
			for(int j=0;j<noOfCol;j++)
				rec[i][j]=s.scanInt();
		}
		System.out.print(maximumSum(noOfRows,noOfCol));
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