import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
/*
 * Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
The goal of the problem is to find largest distance between two nodes in a tree. 
Distance between two nodes is a number of edges on a path between the nodes (there will
be a unique path between any pair of nodes since it is a tree). The nodes will be 
numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). 
Exactly one of the i’s will have P[i] equal to -1, it will be root node.

Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 

 * */
class Test {

	 class Point
	 {
		 int depth;
		 int pos;
		 Point()
		 {
			depth=0;
			pos=0;
		 }
		 public String toString()
		 {
			 return depth+" "+pos;
		 }
		 
	 }
	  int solve(ArrayList<Integer> A) 
	  {
		 int n=A.size();
		 int res=0;
		 Point[] p=new Point[n];
		 
		 for(int i=0;i<n;i++)
		 {
			 p[i]=new Point();
		 }
		 
		 for(int i=n-1;i>0;i--)
		 {
			 int k=A.get(i);
			 if(p[k].depth<p[k].pos)
			 {
				 p[k].depth=Math.max(p[k].depth, Math.max(p[i].depth, p[i].pos)+1);
			 }else
			 {
				 p[k].pos=Math.max(p[k].pos, Math.max(p[i].pos, p[i].depth)+1);
			 }
			  int y=p[k].pos+p[k].depth;
			  if(res<y)res=y;  
			  System.out.println(p[k]);
		 }
		 if(res<p[0].pos+p[0].depth)
			 res=p[0].pos+p[0].depth;
		 return res;
	  }
	public static void main(String aa[])throws Exception
	{
		Test t1=new Test();
		ArrayList<Integer> a1=new ArrayList<>();
		a1.add(-1);
		a1.add(0);
		a1.add(0);
		a1.add(0);
		a1.add(3);System.out.println(t1.solve(a1));
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


