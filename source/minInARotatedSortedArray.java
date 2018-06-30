import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test
{

	
	static int findMinElementInRotatedSortedArray(int a[])
	{
		int n=a.length;
		int left=0,right=n-1;
		
		while(left<right)
		{
			if(a[left]<a[right])return a[left];
			int mid=left+(right-left)/2;
			if(a[left]<=a[mid])
			{
				left=mid+1;
			}else
			{
				
				right=mid;
			}
			
		}
		return a[left];
	}
	static int minElementInRotatedSortedArrayThroughRecursion(int a[],int left,int right)
	{
		if(left==right)
			return a[left];
		if(a[left]<a[right])
			return a[left];
		int mid=left+(right-left)/2;
		if(a[left]<=a[mid])
			return minElementInRotatedSortedArrayThroughRecursion(a,mid+1,right);
		else
			return minElementInRotatedSortedArrayThroughRecursion(a,left,mid);
	}
	public static void main(String aa[]) throws  IOException
	{
		int a[]={5,6,7,1,2,3};
		//System.out.println(findMinElementInRotatedSortedArray(a));
		System.out.println(minElementInRotatedSortedArrayThroughRecursion(a,0,a.length-1));
	}
}
class Scan
{
	StringTokenizer st;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	String scanString() throws IOException
	{
		while(st==null||!st.hasMoreElements())
			st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	
	int scanInt() throws IOException
	{
		return parseInt(scanString());
	}
}

       