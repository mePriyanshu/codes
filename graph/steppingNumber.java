import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//stepping number a number whose difference between alternative digits is 1
public class Test
{
static boolean isStep(int n)
{
	int prev=-1;
	
	while(n>0)
	{
		int currDigit=n%10;
		if(prev==-1)
			prev=currDigit;
		else
		{
			if(Math.abs(prev-currDigit)!=1)
				return false;
			prev=currDigit;
		}
		n/=10;
	}
	return true;
}

static void bfs(int a,int b,int num)
{
	Queue<Integer> q1=new LinkedList<>();
	q1.add(num);
	while(!q1.isEmpty())
	{
		int curr=q1.poll();
		if(curr>=a&&curr<=b)
			System.out.println(curr);
		if(curr==0||curr>b)
			continue;
		
		int lastDigit=curr%10;
		
		int step1=curr*10 + (lastDigit-1);
		int step2=curr*10 + (lastDigit+1);
		
		if(lastDigit==0)
		{
			q1.add(step2);
		}else if(lastDigit==9)
		{
			q1.add(step1);
		}else
		{
			q1.add(step1);
			q1.add(step2);
		}
		//System.out.println(q1);	
	}
	
}
static ArrayList<Integer> steppingNumber(int a,int b)
{
	ArrayList<Integer> a1=new ArrayList<>();
	for(int i=a;i<=b;i++)
	{
		if(isStep(i))
			a1.add(i);
			
	}
	return a1;
}

static void stepNumberBybfs(int a,int b)
{
	ArrayList<Integer> a1=new ArrayList<>();
	for(int i=0;i<=9;i++)
	{
		bfs(a,b,i);
	}
	System.out.println(a1);
}
public static void main (String[] args) throws IOException{

		
        System.out.println(steppingNumber(10,20));
	    stepNumberBybfs(10,20);

		
		
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
            st=new StringTokenizer(br.readLine(),"\n");
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

