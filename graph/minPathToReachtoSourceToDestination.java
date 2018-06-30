import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//minimum path to reach from source to destination in matrix
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
	
	void displayGraph(Test t1)
	{
		for(int i=0;i<t1.vertex;i++)
		{
			System.out.println("Connection of"+" "+i);
			Iterator<?> i1=adjList[i].iterator();
			while(i1.hasNext())
			{
				System.out.print(i1.next()+" ");
			}
			System.out.println();
		}
	}
	 boolean isSafe(int i,int j,int m[][])
	{
		int n=m.length;
		if((i<0||i>=n)||(j<0||j>=n)||m[i][j]==0)
			return false;
		return true;
	}

	 int path(Test t1,int mat[][])
	{
		int n=mat.length;
		int k=1,s=0,d=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(mat[i][j]!=0)
				{
					if(isSafe(i,j+1,mat))
						addEdge(t1,k,k+1);
					if(isSafe(i,j-1,mat))
						addEdge(t1,k,k-1);
					   if (j< n-1 && isSafe ( i+1 , j , mat ) )
		                    addEdge ( t1,k , k+n );
		                if ( i > 0 && isSafe ( i-1 , j , mat ) )
		                    addEdge ( t1,k , k-n );
		            }
		 
		        
		            if( mat[i][j] == 1 )
		                s = k ;

		            if (mat[i][j] == 2)
		                d = k;
		            k++;
				}
			}
		//displayGraph(t1);
		return bfs(s,d);
		}
		
//bfs that will count all the path from source to destination and store it in array
//bfs that will show minimum path
	 int bfs(int s,int d)
	 {
		 if(s==d)
			 return 0;
		 Queue<Integer> q1=new LinkedList<>();
		 q1.add(s);
		 int level[]=new int[vertex];
		 Arrays.fill(level, -1);
		 level[s]=0;
		 while(!q1.isEmpty())
		 {
			 int curr=q1.poll();
			 Iterator<Integer> i1=adjList[curr].iterator();
			 while(i1.hasNext())
			 {
				 int k=i1.next();
				 if(level[k]<0||level[k]>level[k]+1){
					 level[k]=level[curr]+1;
					 q1.add(k);
				 }
			 }
		 }
		 return level[d];
	 }
	
	public static void main(String aa[])
	{
		Test g=new Test(4*4+2);
		int mat[][]=new int[][]{{ 3 , 0 , 1 , 0 },
								{ 3 , 0 , 0 , 3 },
								{ 2 , 3 , 0 , 3 },
								{ 0 , 3 , 3 , 3 }
	    						};
		System.out.println(g.path(g,mat));
		 
		
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
