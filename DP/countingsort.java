import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test			  
{
public static void countingSort(int a[])
{
	int max=0,i=0;
	
	for(i=0;i<a.length;i++)				//find the maximum value
	max=maximum(max,a[i]);
	//System.out.println(max);
	int aux[]=new int[max+1];
	int sor[]=new int[a.length];
	
	for(i=0;i<=max;i++)					//initialize the aux array
	{
		aux[i]=0;
	}
	
	for(i=0;i<a.length;i++)
	{
		aux[a[i]]++;
		
	}
	
	/*for(i=0;i<a.length;i++)
	{
		System.out.print(aux[i]+" ");
		
	}*/
	
	int j=0;
	for(i=0; i<=max; i++) {
        int tmp = aux[i];
        // Aux stores which element occurs how many times,
        // Add i in sortedA[] according to the number of times i occured in A[]
        while(tmp-->0) {
            //cout << Aux[i] << endl;
            sor[j] = i;
            j++;
        }
	}
	for(i=0;i<sor.length;i++)
		System.out.print(sor[i]+" ");
}
public static int maximum(int a,int b)
{
	if(a>b)return a;
	else return b;
}
	public static void main(String aa[]) throws IOException 
	{
		Scan s1=new Scan();
		int n=s1.scanInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
		{
			a[i]=s1.scanInt();
		}
		countingSort(a);
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

