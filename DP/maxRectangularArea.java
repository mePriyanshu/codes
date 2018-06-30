import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

//maximum rectangular area in binaryMatrix
class Test
{
static	int AreaHistogram(int a[])
	{
		int n=a.length;
		Stack<Integer> s1=new Stack<>();
		int i=0;
		int maxArea=Integer.MIN_VALUE;
		while(i<n)
		{
			if(s1.isEmpty()||a[s1.peek()]<a[i])
				s1.push(i++);
			else
			{
				int top=s1.pop();
				int currentArea=a[top]*(s1.isEmpty()?i:i-s1.peek()-1);
				maxArea=Math.max(currentArea, maxArea);
			}
		}
		while(!s1.isEmpty())
		{
			int top=s1.pop();
			int currentArea=a[top]*(s1.isEmpty()?i:i-s1.peek()-1);
			maxArea=Math.max(currentArea, maxArea);
		}
		return maxArea;
	}
	
static void printArray(int a[])
{
	for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
}
	public static void main (String[] args) throws IOException{
		Scan s=new Scan();
		int m=s.scanInt();
		int n=s.scanInt();
		int a[][]=new int[m][n];
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=s.scanInt();
		
		int b[]=new int[n];
		for(int i=0;i<n;i++)
		{
			b[i]=a[0][i];
		}
	int maxArea=AreaHistogram(b);
	for(int i=1;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(a[i][j]==0)
				b[j]=0;
			else
				b[j]=b[j]+a[i][j];
		}
		int currentArea=AreaHistogram(b);
		maxArea=Math.max(maxArea, currentArea);
	}
		System.out.println(maxArea);
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

