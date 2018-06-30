import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;
//median of two sorted arrays
class Test{

	static int findMedianOfTwoSortedArrays(int x[],int y[])
	{
		
		if(x.length>y.length){
			
			findMedianOfTwoSortedArrays(y,x);
			
		}
		int m=x.length;
		int n=y.length;
		System.out.println(m+" "+n);
		
		int low=0,high=m;
		while(low<=high)
		{
			int partitionX=(low+high)/2;
		    int partitionY=(m+n+1)/2 - partitionX;
		    //System.out.println(partitionX+" "+partitionY);
		    int maxLeftX=(partitionX==0)?Integer.MIN_VALUE:x[partitionX-1];
		    int minRightX=(partitionX==m)?Integer.MAX_VALUE:x[partitionX];
		    
		    int maxLeftY=(partitionY==0)?Integer.MIN_VALUE:y[partitionY-1];
		    int minRightY=(partitionY==n)?Integer.MAX_VALUE:y[partitionY];
		   // System.out.println(maxLeftX+" "+maxLeftY+ " " + minRightX+" "+minRightX);
		    if(maxLeftX<=minRightY&&maxLeftY<=minRightX)
		    {
		    	if((m+n)%2==0)
		    		return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX,minRightY))/2;
		    	else 
		    		return (Math.max(maxLeftX,maxLeftY));
		    }else if(maxLeftX>minRightY)
		    {
		    	high=partitionX-1;
		    }else 
		       low=partitionX+1;
		   // System.out.printyln(low+" "+high);
		  
		 
		} 
		throw new IllegalArgumentException();
	}
	
 public static void main(String aa[])
{
     int x[]={};
     int y[]={20};
     System.out.println(findMedianOfTwoSortedArrays(x,y));
	 
}

}
