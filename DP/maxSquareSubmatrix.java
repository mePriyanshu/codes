import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
class Test
{
	static int min(int a,int b,int c)
	{
		int m=a;
		if(m>b)
			m=b;
		 if(m>c)
			m=c;
		return m;
	}
	public static void main(String ar[]) throws IOException
	{
		Scan s=new Scan();
	int a[][]=new int[6][6];
	int table[][]=new int[6][6];
	int i=0,j=0;
	for(i=0;i<6;i++)
	{
		for(j=0;j<6;j++)
			a[i][j]=s.scanInt();
	}
	int max=Integer.MIN_VALUE;
	for(i=0;i<6;i++)
	{
		for(j=0;j<6;j++)
		{
			if(i==0||j==0)
				table[i][j]=a[i][j];
			else if(a[i][j]==0)
				table[i][j]=0;
			else
				table[i][j]=min(table[i-1][j-1],table[i-1][j],table[i][j-1])+1;
			if(table[i][j]>max)
				max=table[i][j];
		}
	}
	
	System.out.println(max);
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
