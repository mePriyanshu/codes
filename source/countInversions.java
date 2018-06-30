import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

import java.math.BigInteger;


class Test
{
	static long mergeSort(int a[])
	{
		int n=a.length;
		if(n<2)return 0;
		int mid=n/2;
		
		int left[]=new int[mid];
		int right[]=new int[n-mid];
		
		left=Arrays.copyOfRange(a, 0, mid);
		right=Arrays.copyOfRange(a, mid,n);
		//System.out.println(Arrays.toString(left)+" "+Arrays.toString(right));
		return mergeSort(left)+mergeSort(right)+merge(a,left,right);
		
	}
	
	static long merge(int a[],int left[],int right[])
	{
		int i=0,j=0,k=0;
		int m=left.length;
		int n=right.length;
		long inversionCount=0;
		while(i<m&&j<n)
		{
			if(left[i]<=right[j]){
				a[k]=left[i];
				i++;
			}
			else{
				a[k]=right[j];
				j++;
				inversionCount+=m-i;
			}
			k++;
		}
		
		while(i<m)
		{
			a[k]=left[i];
			i++;
			k++;
		}
		
		while(j<n)
		{
			a[k]=right[j];
			j++;
			k++;
		}
		return inversionCount;
	}
	public static void main(String aa[])
	{
		int a[]={1,1,1,2,2,2};
		System.out.println(mergeSort(a));
		System.out.println(Arrays.toString(a));
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
    long scanLong() throws IOException
    {
        return parseLong(scanString());
    }
    
}

