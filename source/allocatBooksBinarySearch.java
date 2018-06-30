import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;  
//allocate books binary search
class Test{

	static int allocateBooks(ArrayList<Integer> a1,int m)
	{
	  int n=a1.size();
	  if(n<m)
		  return -1;
	  Integer a[]=a1.toArray(new Integer[n]);
	  Integer min=0;
	  Integer max=0;
	  for(Integer temp:a)
	  {
		  max+=temp;
		  min=Math.max(min,temp);
	  }
	  Integer res=-1;
	  System.out.println(max+" "+min);
	  while(min<=max)
	  {
		  Integer mid=min+(max-min)/2;
		  
		  if(isValidConfiguration(a,m,mid))
		  {
			  //System.out.println(mid);
			  res=mid;
			  max=mid-1;
		  }else
		  {
			  min=mid+1;
		  }
	  }
	  return res;
	}
	
	static boolean isValidConfiguration(Integer a[],int m,int mid)
	{
		int noOfStudents=1;
		int n=a.length;
		int cur=0;
		for(int i=0;i<n;i++)
		{
			if(cur+a[i]>mid)
			{
				cur=a[i];
				noOfStudents++;
				if(noOfStudents>m)
				{
					return false;
				}
			}else
			{
				cur+=a[i];
			}
		}
		return true;
	}
 public static void main(String aa[])
{
     ArrayList<Integer> a1=new ArrayList<Integer>(Arrays.asList(31, 14, 19, 75));
     System.out.println(allocateBooks(a1,12));
     
	 
}

}
