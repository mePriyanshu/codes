import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//2*min=max;
class Test
{
Deque<Integer> min=new LinkedList<>();
Deque<Integer> max=new LinkedList<>();
Deque<Integer> dq=new LinkedList<>();

void insert(int x)
{
	while(!min.isEmpty()&&min.peek()>x)
	{
		min.pollLast();
	}
	min.addLast(x);
	//System.out.println("Min Queue"+min);
	while(!max.isEmpty()&&max.peek()<x)
	{
		max.pollLast();
	}
	max.addLast(x);
	//System.out.println("Max Queue"+max);
	dq.addLast(x);
}

void delete()
{
	if(dq.peek()==min.peek())
		min.pollFirst();
	if(dq.peek()==max.peek())
		max.pollFirst();
	dq.pollFirst();
}

public static void main(String aa[])
{
	Test t1=new Test();

	//int a[]={4, 5, 100, 9, 10, 11, 12, 15, 200};
	//int a[]={4,7,5,6};
	int a[]={20, 7, 5, 6};
	int j=0;
	int ans=0;
	for(int i=0;i<a.length;i++)
	{
		t1.insert(a[i]);
		int currentMax=t1.max.peek();
		int currentMin=t1.min.peek();
		while(2*currentMin<=currentMax)
		{
			t1.delete();
			currentMax=t1.max.peek();
			currentMin=t1.min.peek();
			j++;
		}
		
		if(i-j+1>ans)
			ans=i-j+1;
	}
	System.out.print(a.length-ans);
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
