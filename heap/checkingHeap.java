import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//checking an array is maxHeap or Min heap
class Test
{
	static boolean isMinHeap(int a[],int n)			//min Heap Checking in Array
	{
		int i=0;
		if(n==1)
			return true;
		for(i=(n-2)/2;i>=0;i--)
		{
			if(a[i]>a[2*i+1])
				return false;
			if((2*i+1)<n)
			{
				if(a[i]>a[2*i+1])
					return false;
			}
		}
		return true;
	}
	
	static boolean isMaxHeap(int a[],int n)
	{
		int i=0;
		if(n==1)
		return true;
		for(i=(n-2)/2;i>=0;i--)
		{
			if(a[i]<a[2*i+1])
				return false;
			if(2*i+2<n)
			{
				if(a[i]<a[2*i+1])
					return false;
			}
		}
		return true;
	}
	public static void main(String aa[])
	{
		int a[]={10, 15, 14, 25, 30};
		int b[]={90, 15, 10, 7, 12, 2, 7, 3};
		System.out.println(isMinHeap(a,a.length));
		System.out.println(isMaxHeap(b,b.length));
		
	}
}

