package hashing;
import java.util.*;
//subarray with a given sum
class My_Hash
{
	public static void main(String aa[])
	{
		int a[]={1,4,20,3,10};
		int curr_sum=a[0],sum=33;
		int i=0,j=0;
		
		for(i=1;i<=a.length;i++)
		{
			while(curr_sum>sum&&j<i-1)
			{
				curr_sum-=a[j];
				j++;
			}
			if(curr_sum==sum)
			{
				System.out.println(j+" "+(i-1));
			}
			if(i<a.length)
			curr_sum+=a[i];
		}
	}
}
		
		