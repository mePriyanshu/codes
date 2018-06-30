import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
/*
There is a m*n rectangular matrix whose top-left(start) location is (1, 1) and 
bottom-right(end) location is (m*n). There are k circles each with radius r. 
Find if there is any path from start to end without touching any circle.
The input contains values of m, n, k, r and two array of integers X and Y, each of length k.
X[i], Y[i]) is the centre of ith circle.
*/
class Test {


static    String pathInRect(int m,int n,int numberOfCircles,int radius,ArrayList<Integer> x,ArrayList<Integer> y)
{
	boolean isPossible[][]=new boolean[m+1][n+1];
	boolean isVisited[][]=new boolean[m+1][n+1];
	//In starting all cells are possible
	for(int i=0;i<=m;i++)
	{
		for(int j=0;j<=n;j++)
		{
			isPossible[i][j]=true;
		}
	}
	
	//mark the cells false which are in circle
	for(int i=0;i<=m;i++)
	{
		for(int j=0;j<=n;j++)
		{
			for(int k=0;k<x.size();k++)
			{
				int x1=x.get(k);
				int y1=y.get(k);
			    int dis=(x1-i)*(x1-i) + (y1-j)*(y1-j);
			    if(dis<=radius*radius){
			    	isPossible[i][j]=false;
			    	break;
			    }
			}
		}
	}
	
/*	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			System.out.print(isPossible[i][j]+" ");
		}
		System.out.println();
	}
*/
	
if(path(0,0,isVisited,isPossible,m,n))
{
	return "YES";
}
    return "NO";
}

static boolean path(int i,int j,boolean isVisited[][],boolean isPossible[][],int m,int n)
{
	if(i<0||j<0||i>=m+1||j>=n+1)
		return false;
	if(isVisited[i][j])
	    return false;
	if(!isPossible[i][j])	//if the cell is blocked return false
		return false;
	if(i==m&&j==n)
		return true;
	//check explore all the paths
	isVisited[i][j]=true;
	return (path(i+1,j,isVisited,isPossible,m,n)||path(i-1,j,isVisited,isPossible,m,n)||
			path(i,j-1,isVisited,isPossible,m,n)||path(i,j+1,isVisited,isPossible,m,n)||
			path(i-1,j+1,isVisited,isPossible,m,n)||path(i+1,j-1,isVisited,isPossible,m,n)||
			path(i+1,j+1,isVisited,isPossible,m,n)||path(i-1,j-1,isVisited,isPossible,m,n));
			
	
}

	public static void main(String aa[])throws Exception
	{
	
		Scan s=new Scan();
		ArrayList<Integer> a1=new ArrayList<>();
		ArrayList<Integer> a2=new ArrayList<>();
		a1.add(1);a1.add(1);a2.add(2);a2.add(3);
		System.out.println(pathInRect(5,5,2,1,a1,a2));
		
	}

}




class Scan
{
   // BufferedReader br;
    StringTokenizer st;
  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String scanString() throws Exception
    {
    	
        while(st==null||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    int scanInt() throws Exception
    {
        return parseInt(scanString());
    }
    
    long scanLong() throws Exception
    {
        return parseLong(scanString());
    }
}
