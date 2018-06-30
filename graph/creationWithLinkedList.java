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
			adjList[i]=new LinkedList<Integer>();
	}
	
	 void addEdge(Test t1,int source,int destination)
	{
		t1.adjList[source].addFirst(destination);
		t1.adjList[destination].addFirst(source);
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
	
	public static void main(String aa[])
	{
		Test t1=new Test(5);
		t1.addEdge(t1, 0, 1);
		t1.addEdge(t1, 0, 4);
		t1.addEdge(t1, 1,2);
		t1.addEdge(t1, 1, 3);
		t1.addEdge(t1, 1, 4);
		t1.addEdge(t1, 2, 3);
		t1.addEdge(t1, 3, 4);
		t1.printGraph(t1);
		
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