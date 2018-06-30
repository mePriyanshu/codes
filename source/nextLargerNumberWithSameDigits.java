import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test {
 
static void nextGreaterElement(int n)
{
	String str=Integer.toString(n);

	char ch[]=str.toCharArray();
	int i=0;

	for(i=ch.length-1;i>0;i--)
	{
		
		if(ch[i]>ch[i-1])
			break;
	}
	if(i==0){
		System.out.print("Not Possible");
		return;
	}
	else{
		char temp=ch[i-1];
		int min=i;
		for(int j=i+1;j<ch.length;j++)
		{
			if(ch[j]>temp&&ch[j]<ch[min])
				min=j;
		}
		char f=ch[i-1];
		ch[i-1]=ch[min];
		ch[min]=f;
		Arrays.sort(ch,i,ch.length);
	}
	for(i=0;i<ch.length;i++)
		System.out.print(ch[i]);
}
public static void main(String aa[])throws IOException
{
	Scan s=new Scan();
	int t=s.scanInt();
	for(int k=0;k<t;k++)
	{
	    int n=s.scanInt();
	    nextGreaterElement(n);
}
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