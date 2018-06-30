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
	
	 void topologicalSortUtil(int source,boolean isVisited[],Stack<Integer> s1)
	 {
		 if(!isVisited[source])
			 isVisited[source]=true;
		 Iterator i1=adjList[source].iterator();
		 while(i1.hasNext())
		 {
			 int k=(int)i1.next();
			 if(!isVisited[k])
				 topologicalSortUtil(k,isVisited,s1);
		 }
	     	s1.push(source);	 
	 }
	 
	 void topologicalSort()
	 {
		 boolean isVisited[]=new boolean[vertex];
		 Stack<Integer> s1=new Stack<>();
		 for(int i=0;i<vertex;i++)
		 {
			 if(!isVisited[i])
				 topologicalSortUtil(i,isVisited,s1);
		 }
		 while(!s1.isEmpty())
			 System.out.print(s1.pop()+" ");
	 }
	
	 
	 void topologicalSortByKahnAlgorithm()
	 {
		 int inEdges[]=new int[vertex];
		 
		 for(int i=0;i<vertex;i++)
		 {
			 Iterator<?> i1=adjList[i].iterator();
			 while(i1.hasNext())
			 {
				 int k=(Integer) i1.next();
				 inEdges[k]++;
			 }
		 }
		 
		 Queue<Integer> q1=new LinkedList<>();
		 for(int i=0;i<vertex;i++)
		 {
			 if(inEdges[i]==0)
				 q1.add(i);
		 }
		 int countVertex=0;
		 ArrayList<Integer> ans=new ArrayList<>();
		 while(!q1.isEmpty())
		 {
			 int temp=q1.poll();
			 ans.add(temp);
			 Iterator<?> i2=adjList[temp].listIterator();
			 while(i2.hasNext())
			 {
				 int k=(Integer)i2.next();
				 if(--inEdges[k]==0)
					 q1.add(k);
			 }
			 countVertex++;
		 }
		 if(countVertex!=vertex)
			 System.out.print("Algorithm cant be applied due to cycle");
		 else
			 System.out.println(ans);
	 }
	 public static void main(String aa[])
	{
		Test g = new Test(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.printGraph(g);
		g.topologicalSort();
		System.out.println();
		g.topologicalSortByKahnAlgorithm();
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