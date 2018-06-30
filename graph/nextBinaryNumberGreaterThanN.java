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

//next Binary Number Greater than N
public class Test
{

static class Node
{
	boolean isOne;
	int value;
	Node prev;
	Node(boolean isOne,int value,Node prev)
	{
		this.isOne=isOne;
		this.value=value;
		this.prev=prev;
	}
	public String toString()
	{
		return this.value+" "+this.prev.value;
	}
}

static String smallestBinary(int n)
{
	Queue<Node> q1=new LinkedList<>();
	boolean isRemVisited[]=new boolean[n];
	q1.add(new Node(true,1%n,null));
	isRemVisited[1%n]=true;
	
	Node des=null;
	while(!q1.isEmpty())
	{
		Node curr=q1.poll();
		
		if(curr.value==0)
		{
			des=curr;
			break;
		}
		
		//add 0 to the string
		
		int next=(curr.value*10)%n;
		if(!isRemVisited[next])
		{
			q1.add(new Node(false,next,curr));
			isRemVisited[next]=true;
		}
		
		//add 1 to the String
		next=(next+1);
		if(next==n)
			next=0;
		if(!isRemVisited[next])
		{
			q1.add(new Node(true,next,curr));
			isRemVisited[next]=true;
		}
	}
	
	StringBuilder sb=new StringBuilder();
	while(des!=null)
	{
		sb.append(((des.isOne)?1:0));
		des=des.prev;
	}
	return sb.reverse().toString();
}
	
public static void main (String[] args) throws IOException{

		
        System.out.println(smallestBinary(3));
	    

		
		
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

