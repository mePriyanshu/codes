import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
//nMaxPairCombinationByHeap
class Test {
 
	

	
	static ArrayList<Integer> nMaxPairCombinationByHeap(Integer a[],Integer b[])
	{
		int n=a.length;
		Arrays.sort(a,new Comparator<Integer>(){
			public int compare(Integer a1,Integer a2)
			{
				return a2.compareTo(a1);
			}
			
		});
		
		Arrays.sort(b,new Comparator<Integer>(){
			public int compare(Integer a1,Integer a2)
			{
				return a2.compareTo(a1);
			}
			
		});
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		PriorityQueue<Integer> p1=new PriorityQueue<>();
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				int sum=a[i]+b[j];
				//System.out.print(sum+" ");
				if(p1.size()<n)
					p1.add(sum);
				else {
					if(p1.peek()<sum)
					{
						p1.poll();
						p1.add(sum);
					}else
						break;
				}
				System.out.println(p1);
			}
		}
		while(!p1.isEmpty())
			ans.add(p1.poll());
		Collections.sort(ans,Collections.reverseOrder());
		return ans;
		
	}
	public static void main(String aa[]){
		System.out.println(nMaxPairCombinationByHeap(new Integer[]{ 1, 4, 2, 3 },new Integer[]{ 2, 5, 1, 6}));
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
