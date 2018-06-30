import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

//weighted job sheduling
public class Test {
 
	static class Intervel
	{
		int startTime;
		int endTime;
		int profit;
		
		Intervel(int a,int b,int c)
		{
			startTime=a;
			endTime=b;
			profit=c;
		}
		public String toString()
		{
			String ans=startTime+" "+endTime+" "+profit;
			return ans;
		}
	}
	
	public class mySort implements Comparator<Intervel>
	{
		public int compare(Intervel i1,Intervel i2)
		{
			if(i1.endTime>i2.endTime)
				return 1;
			else if(i1.endTime==i2.endTime)
				return 0;
			else
				return -1;
		}
	}
	static boolean overLap(Intervel i1,Intervel i2)
	{
		if(i1.endTime<=i2.startTime)
			return false;
		return true;
	}
	public static void main(String aa[]) throws Exception
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0){
		int n=s.scanInt();
		Intervel job[]=new Intervel[n];
		for(int i=0;i<n;i++)
		{
			int a=s.scanInt();
			int b=s.scanInt();
			int c=s.scanInt();
			job[i]=new Intervel(a,b,c);
		}
		Arrays.sort(job,new Test().new mySort());
		
		/*for(Intervel i:job)
			System.out.println(i);*/
		
		int ans[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			ans[i]=job[i].profit;
		}
		//System.out.println(Arrays.toString(ans));
		//ans[0]=job[0].profit;
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(!overLap(job[j],job[i]))
				{
					ans[i]=Math.max(ans[i],ans[j]+job[i].profit);
					
				}
			}
			
		}
		int max=Integer.MIN_VALUE;
		
		for(int x:ans)
			max=Math.max(max, x);
		//System.out.println(Arrays.toString(ans));
	System.out.println(max);
		}
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


/*
4
1 2 50
6 19 100
3 5 20
2 100 200
*/

/*
 1
5
1 3 50
2 4 20
4 6 40
3 5 60
7 9 100
1 3 50
2 4 20
3 5 60
4 6 40
7 9 1001 3 50
2 4 20
3 5 60
4 6 40
7 9 100*/
