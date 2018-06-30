import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
//DS supporting basic operations in O(1)
class Test
{
	HashMap<Integer,Integer> h1;
	ArrayList<Integer> a1;
	
	Test()
	{
		h1=new HashMap<Integer,Integer>();
		a1=new ArrayList<Integer>();
	}
	void insert(int item)
	{
		if(h1.containsKey(item))
			return;
		int in=a1.size();
	//	System.out.print(in+" ");
		a1.add(item);
		h1.put(item, in);
	}
	
    void delete(int item)
    {
    	Integer index=h1.get(item);
    	if(index==null)
    		return;
    	h1.remove(item);
    	int size=a1.size();
    	//System.out.print(size+" ");
    	int last=a1.get(size-1);
    	Collections.swap(a1, index, size-1);
    	a1.remove(size-1);
    	h1.put(last,index);
    }
	int  search(int item)
	{
		if(h1.containsKey(item))
		return h1.get(item)+1;
		return -1;
	}
	int getRandom()
	{
		if(a1.isEmpty())
			return -1;
		Random r=new Random();
		int k=r.nextInt(a1.size());
		return a1.get(k);
	}
	void printArrayList()
	{
		if(a1.isEmpty())
			System.out.print("list is empty");
		for(int i=0;i<a1.size();i++)
		{
			System.out.print(a1.get(i)+" ");
		}
	}
	
	public static void main(String  aa[])
	{
		Test t1=new Test();
		t1.insert(10);
		t1.insert(20);
		t1.insert(30);
		t1.insert(40);
		t1.insert(50);
		t1.insert(60);
		t1.delete(10);
		t1.printArrayList();
		System.out.println("\nRandom Number:"+t1.getRandom());
		System.out.println("Search index:"+t1.search(60));
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
