import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

//word wrap problem
public class Test {
 
	static void printTable(int cost[][])
	{
		for(int i=0;i<cost.length;i++)
		{
			for(int j=0;j<cost.length;j++)
			{
				System.out.print(cost[i][j]+"\t");
			}
			System.out.println();
		}
	}
	static String justify(String words[],int width)
	{
		int n=words.length;
		
		int total=0;
		int cost[][]=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			cost[i][i]=width-words[i].length();
			
			for(int j=i+1;j<n;j++)
			{
				cost[i][j]=cost[i][j-1]-words[j].length()-1;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				if(cost[i][j]<0)
					cost[i][j]=Integer.MAX_VALUE;
				else
					cost[i][j]=(int)Math.pow(cost[i][j], 2);
			}
		}
		
		printTable(cost);
		
		int minCost[]=new int[n];
		int result[]=new int[n];
		
		for(int i=n-1;i>=0;i--)
		{
			minCost[i]=cost[i][n-1];
			result[i]=n;
			
			for(int j=n-1;j>i;j--)
			{
				if(cost[i][j-1]==Integer.MAX_VALUE)
					continue;
				else
				{
					if(minCost[i]>minCost[j]+cost[i][j-1])
					{
						minCost[i]=minCost[j]+cost[i][j-1];
						result[i]=j;
					}
				}
			}
		}
		System.out.println(Arrays.toString(minCost));
		System.out.println(minCost[0]);
		System.out.println(Arrays.toString(result));
		StringBuilder sb=new StringBuilder();
		int i=0,j;
		do{
			j=result[i];
			
			for(int k=i;k<j;k++){
				sb.append(words[k]+" ");
			}
			sb.append("\n");
			i=j;
		}while(j<n);
		return sb.toString();
	
	}
	
	public static void main(String aa[]) throws Exception
	{
		System.out.println(justify(new String[]{"Tushar","roy","likes","to","code"},10));
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