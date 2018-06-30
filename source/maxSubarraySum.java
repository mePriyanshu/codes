import java.util.*;
import java.io.*;

//max subarray sum
public class Test
{
static int maxSubArraySum(int a[],int mod)
{
	int curr_max=0,global_max=0;
	curr_max=a[0];
	global_max=a[0];
	
	for(int i=1;i<a.length;i++)
	{
		curr_max=Math.max(a[i],(curr_max+a[i]));
		//System.out.println(curr_max);
		global_max=Math.max(global_max, curr_max);
		//System.out.println(global_max+"%");
	}
	return global_max%mod;
}
public static void main(String aa[])throws IOException
{
	Scan s=new Scan();
	int q=s.scanInt();
	while(q-->0)
	{
		int n=s.scanInt();
		int a[]=new int[n];
		int mod=s.scanInt();
		for(int i=0;i<n;i++)
		{
			a[i]=s.scanInt();
		}
		System.out.println(maxSubArraySum(a,mod));
		
	}
	
}
}

			
class Scan
{
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	public Scan()
	{
		in=System.in;
	}
	public int scan()throws IOException
	{
		if(total<0)
		throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
			return -1;
		}
		return buf[index++];
	}
	public int scanInt()throws IOException
	{
		int integer=0;
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n))
		{
			if(n>='0'&&n<='9')
			{
				integer*=10;
				integer+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		return neg*integer;
	}
	public double scanDouble()throws IOException
	{
		double doub=0;
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n)&&n!='.')
		{
			if(n>='0'&&n<='9')
			{
				doub*=10;
				doub+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		if(n=='.')
		{
			n=scan();
			double temp=1;
			while(!isWhiteSpace(n))
			{
				if(n>='0'&&n<='9')
				{
					temp/=10;
					doub+=(n-'0')*temp;
					n=scan();
				}
				else throw new InputMismatchException();
			}
		}
		return doub*neg;
	}
	public String scanString()throws IOException
	{
		StringBuilder sb=new StringBuilder();
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		while(!isWhiteSpace(n))
		{
			sb.append((char)n);
			n=scan();
		}
		return sb.toString();
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
		return true;
		return false;
	}
}
 
class Print
{
	private final BufferedWriter bw;
	public Print()
	{
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void print(String str)throws IOException
	{
		bw.append(str);
	}
	public void printLine(String str)throws IOException
	{
		print(str);
		bw.append("\n");
	}
	public void close()throws IOException
	{
		bw.close();
	}
} 





