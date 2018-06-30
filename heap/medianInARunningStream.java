import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//median in a running stream
class Test
{
static	int avg(int a,int b)
	{
		return (a+b)/2;
	}
static int getRunningMedian(int element,int median,PriorityQueue<Integer> pl,PriorityQueue<Integer> pr)
{
	int ch=0;
	if(pl.size()==pr.size())
			ch=0;
	else
	if(pl.size()>pr.size())
			ch=1;
	else if(pl.size()<pr.size())
	        ch=-1;
	switch(ch)
	{
	case 1:if(element<median)
			{
				pr.add(pl.poll());
				pl.add(element);
			}else{
				pr.add(element);
				
			}
	median=avg(pl.peek(),pr.peek());	
			break;
	case 0:if(element<median)
			{
				pl.add(element);
				median=pl.peek();
			}else
			{
				pr.add(element);
				median=pr.peek();
			}
			break;
	case -1:if(element<median)
				{
					pl.add(element);
					
				}else
				{
					pl.add(pr.poll());
					pr.add(element);
				}
				median=avg(pl.peek(),pr.peek());
				break;
	}

	return median;
}
public static void main(String aa[]) throws  IOException
	{
	int a[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
	int n=a.length;
	int median=0;
	PriorityQueue<Integer> p1=new PriorityQueue<>(n,Collections.reverseOrder());
	PriorityQueue<Integer> p2=new PriorityQueue<>(n);
	for(int i=0;i<n;i++)
	{
		 median=getRunningMedian(a[i],median,p1,p2);
		System.out.print(median+" ");
	}
	}
}
class Scan
{
	StringTokenizer st;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	String scanString() throws IOException
	{
		while(st==null||!st.hasMoreElements())
			st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	
	int scanInt() throws IOException
	{
		return parseInt(scanString());
	}
}
