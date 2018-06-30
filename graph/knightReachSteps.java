import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
/*
 * Given a square chessboard of N x N size, the position of Knight and position of a 
 * target is given. We need to find out minimum steps a Knight will take to reach the 
 * target position.
 */
class Test {

	int vertex;
	LinkedList<Integer> adjList[];
	Test(int v)
	{
		vertex=v;
		adjList=new LinkedList[v];
		
		for(int i=0;i<v;i++)
			adjList[i]=new LinkedList<>();
	}

	void addEdge(Test t1,int source,int destination)
	{
		t1.adjList[source].add(destination);
		t1.adjList[destination].add(source);
	}
	

	boolean isValid(int i,int j,int n,int m)
	{
		if(i>=1 && i<=n && j>=1&&j<=m)
			return true;
		return false;
	}
	
	 static class cell
	{
		int x,y,dist;
		cell(int x,int y,int dist)
		{
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
		cell(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	int minStepsToReach(cell src,cell dest,int n,int m)
	{
		HashSet<cell> h1=new HashSet<>();
		Queue<cell> q1=new LinkedList<>();
		q1.add(src);
		int dx[]={2,2,-2,-2,1,-1,-1,1};
		int dy[]={1,-1,-1,1,2,2,-2,-2};
		boolean isVisited[][]=new boolean[n+1][n+1];
		isVisited[src.x][src.y]=true;
		while(!q1.isEmpty())
		{
			cell curr=q1.poll();
			int x=curr.x;
			int y=curr.y;
			int distance=curr.dist;
			//System.out.println(x+" "+y+" "+distance);
			if(x==dest.x&&dest.y==y)
			{
				return distance;
			}

				for(int i=0;i<8;i++)
				{
					int fir=x+dx[i];
					int sec=y+dy[i];
					if(isValid(fir,sec,n,m)&&!isVisited[fir][sec])
					{
						q1.add(new cell(fir,sec,distance+1));
						isVisited[fir][sec]=true;
					}
				}
			
			
			
		}
		return Integer.MAX_VALUE;
	}
	public static void main(String aa[])
	{
	

		Test g=new Test(4);
		cell src=new cell(1,1);
		cell dest=new cell(8,8);
		System.out.println(g.minStepsToReach(src,dest,8,8));
		
	   
	    						
	
		 
		
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
