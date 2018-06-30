import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
class Test{

	void solve(int x[][])
	{
		Box boxes[]=new Box[x.length*3];
		
		for(int i=0;i<x.length;i++)
		{
			int ht= x[i][0];
			int wth=x[i][1];
			int dpt=x[i][2];
			boxes[3*i]=new Box(ht,wth,dpt);			//Simple way
			boxes[3*i+1]=new Box(wth,ht,dpt);		//first way
			boxes[3*i+2]=new Box(dpt,ht,wth);		//second way
		}
		Arrays.sort(boxes);

	/*	for(int i=0;i<boxes.length;i++)
		{
			System.out.println(boxes[i].height+" "+boxes[i].width+" "+boxes[i].depth);
		
		}*/
		
		int optimalHeight[]=new int[x.length*3];
		for(int i=0;i<boxes.length;i++)
			optimalHeight[i]=boxes[i].height;
		for(int i=1;i<boxes.length;i++)
		{
			int j=0;
			while(j<i)
			{
				if(boxes[j].width>boxes[i].width&&boxes[j].depth>boxes[i].depth)
				{
					if(optimalHeight[i]<optimalHeight[j]+boxes[i].height)
						optimalHeight[i]=optimalHeight[j]+boxes[i].height;
				}
				j++;
			}
		}
		//System.out.println("\n\n");
		int max=Integer.MIN_VALUE;
		for(int i=0;i<optimalHeight.length;i++)
			max=Math.max(max,optimalHeight[i]);
		System.out.println(max);
	}

	public static void main(String aa[])throws IOException
	{
		   Scan s=new Scan();
		   Test t1=new Test();
		   int x[][]=new int[][]{ {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
		  t1.solve(x);
		
	}
}
class Box implements Comparable<Box>
{
	int height;
	int width;
	int depth;
	Box(int h,int w,int d)
	{
		height=h;
		width=w;
		depth=d;
	}
	@Override
	public int compareTo(Box o) {
		// TODO Auto-generated method stub
		int area=o.depth*o.width;
		int thisArea=this.depth*this.width;
		return area-thisArea;
	
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
	   long scanLong() throws IOException
	    {
	        return parseLong(scanString());
	    }
}	    
	    
