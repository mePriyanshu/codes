import java.util.*;
import java.io.*;
//substring a[i]-a[i-1]
public class Test
{
	
	public static void main(String aa[]) throws IOException{
	
		Scan s=new Scan();
		int q=s.scanInt();
		StringBuilder sb=new StringBuilder();
		long x=0;
		for(int i=0;i<q;i++)
		{
			String st=s.scanString();
			String test="";
			boolean check=true;
			long fir=0;
			for(int j=1;j<st.length()/2;j++)
			{
				x=Long.parseLong(st.substring(0,j));
				 fir=x;
			    test=Long.toString(x);
			    
			    while(test.length()<st.length())
			    {
			    	test=test+Long.toString(++x);
			    }
			    if(test.equals(st))
			    {
			    	check=false;
			    	break;
			    }
			    
				
			}
			if(!check)
				sb.append("YES").append(" ").append(fir).append("\n");
			else
				sb.append("NO").append("\n");
		
			
		}
		
	   System.out.print(sb);
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