import java.security.Timestamp;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;

class Test{
	static int comp=0;
static int quickSelect(int a[],int st,int end,int k)
{
	if(st<=end)
	{
		int pin=partition(a,st,end);
		if(pin==k)
			return k;
		else if(pin>k)
			return quickSelect(a,st,pin-1,k);
		else
			return quickSelect(a,pin+1,end,k);
		
	}
	return end+1;
}

static int partition(int a[],int st,int end)
{
	Random r=new Random();
	int rIndex=st+r.nextInt(end-st+1);
	int t=a[rIndex];
	a[rIndex]=a[end];
	a[end]=t;
	int pivot=a[end];
	int pin=st;
	for(int i=st;i<=end;i++)
	{
		if(a[i]<pivot)
		{
			int temp=a[i];
			a[i]=a[pin];
			a[pin]=temp;
			pin++;
		}
	}
	int temp=a[end];
	a[end]=a[pin];
	a[pin]=temp;
	return pin;		
}
	public static void main(String aa[])
	{
		int a[]={1,5,5,4,9};
		
		int r=quickSelect(a,0,a.length-1,3);
		System.out.println(a[r-1]);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}


	
	//901601001507006