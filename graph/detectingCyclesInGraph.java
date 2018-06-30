import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//Detecting Cycles in a dependency of graph
//Used in Job Scheduling Algorithm
class Test {

	int vertex;
	LinkedList<Integer> adjList[];
	Test(int v)
	{
		vertex=v;
		adjList=new LinkedList[v+1];
		
		for(int i=0;i<=v;i++)
			adjList[i]=new LinkedList<>();
	}

	void addEdge(Test t1,int source,int destination)
	{
		t1.adjList[source].add(destination);
	    t1.adjList[destination].add(source);
	}
	
	void displayGraph(Test t1)
	{
		for(int i=0;i<=t1.vertex;i++)
		{
			System.out.println("Connection of"+" "+i);
			Iterator<?> i1=adjList[i].iterator();
			while(i1.hasNext())
			{
				System.out.print(i1.next()+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
    boolean isCyclic()
    {
    	boolean isVisited[]=new boolean[vertex+1];
    	boolean recStack[]=new boolean[vertex+1];
    	
    	for(int i=0;i<=vertex;i++)
    	{
    		if(isCyclicUtil(i,isVisited,recStack))
    			return true;		
    	}
    	return false;
    }
    
    boolean isCyclicUtil(int source,boolean isVisited[],boolean recStack[])			//DFS in a graph
    {
    	if(!isVisited[source])
    	{
    		isVisited[source]=true;
    		recStack[source]=true;
    	}
    	Iterator i1=adjList[source].listIterator();
    	
    	while(i1.hasNext())
    	{
    		int k=(int)i1.next();
    		if(!isVisited[k]&&isCyclicUtil(k,isVisited,recStack))
    		{
    			isVisited[k]=true;
    		}else if(recStack[k])
    			return true;
    	}
    	recStack[source]=false;
    	return false;
    }
	public static void main(String aa[]) throws Exception
	{
	    Test t1=new Test(6);
		t1.addEdge(t1,1,4);
		t1.addEdge(t1,1,2);
		t1.addEdge(t1,2,6);
		t1.addEdge(t1,3, 4);
		t1.addEdge(t1,3, 6);
		t1.addEdge(t1,3, 5);
		t1.addEdge(t1, 5, 6);
		t1.displayGraph(t1);
		System.out.println(t1.isCyclic());
		
		
		
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