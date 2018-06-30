import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//finding the mother vertex in graph

public class Test
{

	int vertex;
	LinkedList<Integer> adjList[];
	
	Test(int vertex)
	{
		this.vertex=vertex;
		adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++)
		{
			adjList[i]=new LinkedList<>();
		}
	}
	
	void addEdge(int source,int destination)
	{
		adjList[source].add(destination);
		//adjList[destination].add(source);
	}
	
	void bfs(int source)
	{
		boolean isVisited[]=new boolean[vertex];
		Queue<Integer> q1=new LinkedList<>();
		q1.add(source);
		isVisited[source]=true;
		
		while(!q1.isEmpty())
		{
			int ans=q1.poll();
			System.out.print(ans+" ");
			Iterator<Integer> i1=adjList[ans].listIterator();
			while(i1.hasNext())
			{
				int k=i1.next();
				if(!isVisited[k])
				{
					isVisited[k]=true;
					q1.add(k);
				}
			}
			
		}
	}

	void dfsUtil(int source,boolean isVisited[])
	{
		isVisited[source]=true;
		//System.out.print(source+" ");
		Iterator<Integer> i1=adjList[source].listIterator();
		
		while(i1.hasNext())
		{
			int k=i1.next();
			
			if(!isVisited[k])
				dfsUtil(k,isVisited);
					
		}
		
	}
	
	void dfs(int source)
	{
		boolean isVisited[]=new boolean[vertex];
			dfsUtil(source,isVisited);
	}
	
	void findMotherVertex()
	{
		boolean isVisited[]=new boolean[vertex];
		int lastUnfinishedVertex=-1;
		//finding the last unfinished vertex in a graph
		for(int i=0;i<vertex;i++)
		{
			if(!isVisited[i]){
				dfsUtil(i,isVisited);
				System.out.println(Arrays.toString(isVisited));
				lastUnfinishedVertex=i;
				System.out.println(lastUnfinishedVertex+" ");
			}
		}
		Arrays.fill(isVisited,false);
		//doing dfs to check whether we can reach all vertex from unfinished vertex
		dfsUtil(lastUnfinishedVertex,isVisited);
		
		for(int i=0;i<vertex;i++)
		{
			if(!isVisited[i])
			{
				System.out.println("No Mother Vertex");
				return;
			}
		}
		System.out.println("Mother Vertex:"+ lastUnfinishedVertex);
	}
	
public static void main (String[] args) throws IOException{

		Test g=new Test(7);
		g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 3);
	    g.addEdge(4, 1);
	    g.addEdge(6, 4);
	    g.addEdge(5, 6);
	    g.addEdge(5, 2);
	    g.addEdge(6, 0);
		g.findMotherVertex();
		
		
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
            st=new StringTokenizer(br.readLine(),"\n");
        }
       return st.nextToken();
      
    }
    int scanInt() throws IOException
    {
        return parseInt(scanString());
    }
    
    long scanLong() throws IOException
    {
        return parseLong(scanString());
    }
    
    
}

