import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//minimum edit distance 
class Test{
	static void printTable(int table[][])
	{
		int i=0,j=0;
		for(i=0;i<table.length;i++)
		{
			for(j=0;j<table[0].length;j++)
				System.out.print(table[i][j]+" ");
			System.out.println();
		}
	}
	static int min(int a,int b,int c)
	{
		int m=a;
		if(m>b)
			m=b;
		if(m>c)
			m=c;
		return m;
	}
	static int minEditDistance(String s1,String s2)
	{
		
		int table[][]=new int[s1.length()+1][s2.length()+1];
		int i=0,j=0;
		
		for(i=0;i<=s1.length();i++)
		{
			for(j=0;j<=s2.length();j++)
			{

				if(i==0)
					table[i][j]=j;
				else if(j==0)
					table[i][j]=i;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					table[i][j]=table[i-1][j-1];
				else
					table[i][j]=1+min(table[i-1][j-1],table[i][j-1],table[i-1][j]);
			}
		}
		printTable(table);
		
		return table[s1.length()][s2.length()];
	}
	
	public static void main(String ss[])
	{
		System.out.print(minEditDistance("sunday","saturday"));
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

//10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6