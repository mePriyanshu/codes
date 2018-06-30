import java.util.*;
import static java.lang.Integer.parseInt;
import java.io.*;
class Test
{
	static long maxArea(long a[])
	{
		int n=a.length;
		Stack<Integer> s1=new Stack<>();
		long currentArea=0,maxArea=0;
		int i=0;
		for( i=0;i<n;)
		{
			if(s1.isEmpty()||a[s1.peek()]<=a[i])
			{
				s1.push(i++);
			}else
			{
				int top=s1.pop();
				currentArea=a[top]*(s1.isEmpty()?i:i-s1.peek()-1);
				maxArea=Math.max(currentArea, maxArea);
			}
			//System.out.println(s1);
			//System.out.println(currentArea+" "+maxArea);
			
		}
		while(!s1.isEmpty())
		{
			int top=s1.pop();
			currentArea=a[top]*(s1.isEmpty()?i:i-s1.peek()-1);
			maxArea=Math.max(currentArea, maxArea);
			//System.out.println(currentArea+" "+maxArea);
			//System.out.println(s1);
			
		}
		return maxArea;
	}
	
	public static void main(String aa[]) throws Exception
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0)
		{
			String str=s.scanString();
			String input[]=str.split(" ");
			long a[]=new long[input.length];
			for(int i=0;i<input.length;i++)
			{
				a[i]=Long.parseLong(input[i]);
			}
			System.out.println(maxArea(a));
		}
	}
	
	

}

class Scan
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	String scanString()throws IOException
	{
		while(st==null||!st.hasMoreTokens()){
		st=new StringTokenizer(br.readLine(),"\t");
		}
		return st.nextToken();
	
	}
	int scanInt() throws IOException
	{
		return Integer.parseInt(scanString());
	
	}

}
