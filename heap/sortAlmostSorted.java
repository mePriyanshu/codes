import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//sort almost sorted in array
class Test
{
	public static void main(String aa[])
	{
		int a[]={1,4,5,2,3,7,8,6,10,9};
		PriorityQueue<Integer> p1=new PriorityQueue<>();
		int k=2;
		for(int i=0;i<=k;i++)
			p1.add(a[i]);
		System.out.println(p1);
		int index=0;
		for(int i=k+1;i<a.length;i++)
		{
			a[index++]=p1.peek();
			p1.poll();
			p1.add(a[i]);
		}
		
		while(!p1.isEmpty())
		{
			a[index]=p1.poll();
			index++;
		}
		
	}
}

