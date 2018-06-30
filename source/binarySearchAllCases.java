import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//Binary Search Templates
class Test
{
	
/*
 * Case 1:left<=right
 * 
 */
	int binarySearchCase1(int a[],int key)
	{
		int n=a.length;
		int left=0,right=n-1;
		
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			if(a[mid]==key)
				return mid;
			else if(a[mid]>key)
			{
				right=mid-1;
			}else
			{
				left=mid+1;
			}
		}
		return -1;
	}
	
	/*
	 * Case 2:left<right
	 * Search Condition needs to access element's immediate right neighbor
	 */
		int binarySearchCase2(int a[],int key)
		{
			int n=a.length;
			if(a==null||n==0)return -1;
			int left=0,right=n;
			while(left<right)
			{
				int mid=left+(right-left)/2;
				
				if(a[mid]==key)return mid;
				
				if(a[mid]<key)
				{
					left=mid+1;
				}else
				{
					right=mid;
				}
				//System.out.println(left+"\t"+mid+"\t"+right);
			}
			if(a[left]==key)return left;
			return -1;
		}
		
		/*
		 * Case 3:left+1<right
		 * Use element's neighbors to determine if condition is met and decide whether to go left or right
		 * 
		 */
		int binarySearchCase3(int nums[],int target)
		{
			 if(nums == null || nums.length == 0)
				    return -1;

				  int left = 0, right = nums.length - 1;
				  while(left + 1 < right){
			
					    int mid = left + (right - left) / 2;
					    if(nums[mid] == target){ return mid; }
					    else if(nums[mid] < target) { left = mid; }
					    else { right = mid; }
				  }

				 
				  if(nums[left] == target) return left;
				  if(nums[right] == target) return right;
				  return -1;
		}
		
	public static void main(String aa[]) throws Exception
	{
		int a[]={1,2};
		int key=3;
		Test t1=new Test();
		//System.out.println(t1.binarySearchCase1(a, key));
		System.out.println(t1.binarySearchCase2(a, key));
		//Math.pow(a, b)
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
