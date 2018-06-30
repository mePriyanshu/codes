import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;  
//median in a row wise sorted matrix
class Test{


	static int getCount(int a[],int target)
    {
        int left=0,right=a.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(a[mid]<target)
            {
                left=mid+1;
            }else
                right=mid-1;
        }
        return left;
    }
    static boolean isLessThanHalf(int a[][],int mid)
    {
        int c=0;
        int m=a.length;
        int n=a[0].length;
        for(int i=0;i<m;i++)
        {
            c+=getCount(a[i],mid);
        }
        return c<m*n/2 + 1;
    }
    
    static int medianOfAnMatrix(int a[][])
    {
        int m=a.length;
        int n=a[0].length;
        int low=0;
        int high=Integer.MAX_VALUE;
        int res=1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isLessThanHalf(a,mid))
            {
                low=mid+1;
            }else
            {
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
	public static void main(String aa[])
	{
		int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
		System.out.println(medianOfAnMatrix(m));
	}

}
