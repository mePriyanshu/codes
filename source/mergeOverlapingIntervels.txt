import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//merge overlaping intervels
class Test{

static class Intervel
{
	int start,end;
	Intervel(int start,int end)
	{
		this.start=start;
		this.end=end;
	}
}

static class Sort implements Comparator<Intervel>
{
	public int compare(Intervel i1,Intervel i2)
	{
		return Integer.compare(i1.start, i2.start);
	}
}
public static void main(String aa[])
{
	List<Intervel> l1=new LinkedList<>();
	l1.add(new Intervel(1,2));
	l1.add(new Intervel(3,5));
	l1.add(new Intervel(6,7));
	l1.add(new Intervel(8,10));
	l1.add(new Intervel(12,16));
	l1.add(new Intervel(4,9));
	List<Intervel> ans=new LinkedList<>();
	
	Collections.sort(l1,new Sort());
	
	int start=l1.get(0).start;
	int end=l1.get(0).end;
	
	for(Intervel i1:l1)
	{
		if(i1.start<=end)
			end=Math.max(i1.end, end);
		else
		{
			ans.add(new Intervel(start,end));
			start=i1.start;
			end=i1.end;
		}
			
			
	}
	ans.add(new Intervel(start,end));
	for(Intervel i1:ans)
		System.out.println(i1.start+" "+i1.end);
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
	            st=new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }
	    int scanInt() throws IOException
	    {
	        return parseInt(scanString());
	    }
	    
	    
	}
