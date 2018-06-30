import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

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
	//t1.adjList[destination].add(source);
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
	
	void breadthFirstSearch(int source)
	{
		boolean isVisited[]=new boolean[vertex];
		Queue<Integer> q1=new LinkedList<>();
		q1.add(source);
		isVisited[source]=true;
		
		while(!q1.isEmpty())
		{
			int ans=q1.poll();
			System.out.print(ans+" ");
			Iterator i1=adjList[ans].listIterator();
			while(i1.hasNext())
			{
				int k=(int)i1.next();
				if(!isVisited[k])
				{
					isVisited[k]=true;
					q1.add(k);
				}
			}
		}
	}
	
	public static void main(String aa[])
	{
		Test g=new Test(7);
		 	g.addEdge(g,1, 2);
	        g.addEdge(g,1, 3);
	        g.addEdge(g,2, 4);
	        g.addEdge(g,2, 5);
	        g.addEdge(g,4, 5);
	        g.addEdge(g,5, 6);
	        g.addEdge(g,4, 6);
		g.breadthFirstSearch(1);
		
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