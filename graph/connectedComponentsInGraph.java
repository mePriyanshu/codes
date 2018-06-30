import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//algorithm for checking connected components in graph
class Test {

	int vertex;
	LinkedList<Integer> adjList[];
	
	Test(int v)
	{
		vertex=v;
		adjList=new LinkedList[v];
		
		for(int i=0;i<v;i++)
			adjList[i]=new LinkedList<Integer>();
	}
	
	 void addEdge(int source,int destination)
	{
		adjList[source].add(destination);
		//t1.adjList[destination].addFirst(source);
	}
    
	 void printGraph(Test t1)
	{
		for(int i=0;i<t1.vertex;i++)
		{
			System.out.println("AdjList for vertex"+i);
			Iterator i1=t1.adjList[i].iterator();
			while(i1.hasNext())
			{
				System.out.print(i1.next()+" ");
			}
			System.out.println();
		}
	}
	
	 Test transposeGraph()
	 {
		 Test gT=new Test(vertex);
		 
		 for(int i=0;i<vertex;i++)
		 {
			 Iterator i1=adjList[i].listIterator();
			 while(i1.hasNext())
			 {
				 gT.adjList[(int)i1.next()].add(i);
			 }
		 }
		 return gT;
	 }
	 
	 void DFSUtil(int s,boolean isVisited[])
	 {
		 if(!isVisited[s])
			 isVisited[s]=true;
		 Iterator i1=adjList[s].listIterator();
		 while(i1.hasNext())
		 {
			 int k=(int)i1.next();
			 if(!isVisited[k])
				 DFSUtil(k,isVisited);
		 }
	 }
	 
	 boolean isStronglyConnectedComponents()
	 {
		 boolean isVisited[]=new boolean[vertex];
		 

				 DFSUtil(0,isVisited);			//dfs from the 0 vertex
		 
		 for(int i=0;i<vertex;i++)				//checking dfs reached all vertices
		 {
			 if(!isVisited[i])
				 return false;
			 
		 }
		 Arrays.fill(isVisited, false);
		 Test transpose=transposeGraph();
		 
		 transpose.DFSUtil(0, isVisited);		//doing dfs for transpose graph
		 
		 for(int i=0;i<vertex;i++)				//checking dfs reached all vertices
		 {
			 if(!isVisited[i])
				 return false;
			 
		 }
		 return true;
	 }
	 public static void main(String aa[])
	{
		Test g = new Test(5);
		g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        //g.addEdge(4,2 );
        //g.printGraph(g);
		
       System.out.println(g.isStronglyConnectedComponents());
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