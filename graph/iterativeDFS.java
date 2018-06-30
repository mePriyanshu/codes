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
	   // t1.adjList[destination].add(source);
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
		System.out.println();
	}
	
	void iterativeDepthFirstSearch(int source,boolean isVisited[])
	{
		
		Stack<Integer> s1=new Stack<>();
		s1.push(source);
		//isVisited[source]=true;
		while(!s1.isEmpty())
		{
			int temp=s1.peek();
			s1.pop();
			if(!isVisited[temp])
			{
				System.out.print(temp+" ");
				isVisited[temp]=true;
			}
			Iterator i1=adjList[temp].listIterator();
			while(i1.hasNext())
			{
				int k=(int)i1.next();
				if(!isVisited[k])
					s1.push(k);
			}
		}
	}
    void itDFS()
    {
    	boolean isVisited[]=new boolean[vertex];
    	for(int i=0;i<vertex;i++)
    	{
    		if(!isVisited[i])
    			iterativeDepthFirstSearch(i,isVisited);
    			
    	}
    		
    }
	public static void main(String aa[]) throws Exception
	{
	    Test t1=new Test(5);
		t1.addEdge(t1,1,0);
		//t1.addEdge(t1, 0, 2);
		t1.addEdge(t1,2,1);
		t1.addEdge(t1,3,4);
		t1.addEdge(t1,4,0);
		
		//t1.displayGraph(t1);
	t1.itDFS();
		
		
		
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