import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
//disjoint set ds
class Test {

	HashMap<Integer,Node> h1;
	Test()
	{
		h1=new HashMap<>();
	}
	
	class Node											//node for representing disjoint sets
	{
		int value;
		int rank;
		Node parent;
	}
	
	void makeSet(int data)
	{
		Node disjointSet=new Node();
		disjointSet.value=data;
		disjointSet.parent=disjointSet;
		disjointSet.rank=0;
		h1.put(data, disjointSet);
	}
	
	Node findSet(Node p)
	{
		Node parent=p.parent;
		if(parent==p)
			return p;
		p.parent=findSet(p.parent);
		return p.parent;
	}
	
	int findSet(int data)
	{
		return findSet(h1.get(data)).value;
	}
	
	boolean union(int a,int b)		//checks if a and b are in same set
	{
		Node node1=h1.get(a);
		Node node2=h1.get(b);
		Node parent1=findSet(node1);
		Node parent2=findSet(node2);
		
		if(parent1==parent2)
			return false;
		if(parent1.rank>=parent2.rank)
		{
			parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
			parent2.parent=parent1;
		}else
			parent1.parent=parent2;
		return true;
	}
	public static void main(String args[]) {
        Test ds = new Test();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
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