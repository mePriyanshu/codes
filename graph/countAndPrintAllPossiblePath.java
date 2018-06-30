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

//count and show the path between two pair of vertices
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
	Stack<Integer> showPath=new Stack<Integer>();
	void addEdge(int source,int destination)
	{
		adjList[source].add(destination);
		//adjList[destination].add(source);
	}
	

    int countPathUtil(int source,int destination,boolean isVisited[],int pathCount)
    {
    	isVisited[source]=true;
    	showPath.push(source);
    	if(source==destination)
    	{
    		pathCount++;
    		System.out.println(showPath);
    	}else
    	{
    	
    		Iterator<Integer> i1=adjList[source].listIterator();
    		while(i1.hasNext())
    		{
    			int k=i1.next();
    			if(!isVisited[k])
    			{
    				pathCount=countPathUtil(k,destination,isVisited,pathCount);
    			}
    		}
    	}
    	showPath.pop();
    	isVisited[source]=false;
    	return pathCount;
    }
    
    void countPath(int source,int destination)
    {
    	boolean isVisited[]=new boolean[vertex];
    	int pathCount=0;
    	int ans=countPathUtil(source,destination,isVisited,pathCount); 
    	System.out.println(ans);
    }
public static void main (String[] args) throws IOException{

		Test g=new Test(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
	    g.countPath(2, 3);
	    

		
		
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

