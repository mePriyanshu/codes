import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//maximum sum subarray
class Test{
static int maxSumSubarray(int a[])
{
	int n=a.length;
	int currSum=a[0];
	int maxSum=a[0];
	int start=0,end=0;
	int orignalStart=0;
	for(int i=1;i<n;i++)
	{
		currSum+=a[i];
		if(maxSum<currSum)
		{
			maxSum=currSum;
			start=orignalStart;
			end=i;
		}
		if(currSum<0)
		{
			orignalStart=i+1;
			currSum=0;
		}
		
	}
	System.out.println(start+" "+end);
	return maxSum;
}

public static void main(String aa[])
{
	int a[]={-2, -3, 4, -1, -2, 1, 5, -3};
	System.out.print(maxSumSubarray(a));
}
}