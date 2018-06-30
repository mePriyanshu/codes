import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//extra element in two sorted array
class Test {
static public int findExtra(int a[],int b[],int n)
    {
     int left=0;
     int right=n-1;
     int index=-1;
     while(left<=right)
     {
         int mid=(left+right)/2;
         System.out.println(mid);
         if(mid==n-1)
         {
             index=mid;
             break;
         }
         if(a[mid]==b[mid])
         {
             left=mid+1;
         }else
         {
             index=mid;
             right=mid-1;
         }
     }
    return index;
    }

public static void main(String aa[])
{
	int a[]={2,4,6,8,10,12,13};
	int b[]={2,4,6,8,10,12};
	System.out.print(findExtra(a,b,a.length));
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
