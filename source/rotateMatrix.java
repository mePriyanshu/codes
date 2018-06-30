import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import static java.lang.Integer.parseInt;
 //rotate matrix
class Test {

	static void rotateClockwise(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		
		for(int first=0,last=m-1;first<last;first++,last--)
		{
			int temp[]=a[first];
			a[first]=a[last];
			a[last]=temp;
		}
		//print(a);
		
		for(int i=0;i<m;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int temp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=temp;
			}
			//print(a);
		}
		print(a);
	}
	static void print(int a[][])
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
	static void rotateAntiClockwise(int a[][])
	{
		int m=a.length;
		int n=a[0].length;
		for(int first=0,last=n-1;first<last;first++,last--)
		{
			for(int j=0;j<m;j++)
			{
				int temp=a[j][first];
				a[j][first]=a[j][last];
				a[j][last]=temp;
			}
		}
		print(a);
		for(int i=0;i<m;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int temp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=temp;
						
			}
		}
		print(a);
	}
	
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int m=a.size();
        int n=a.get(0).size();
       
        for(int first=0,last=m-1;first<last;first++,last--)
        {
            ArrayList<Integer> temp1=a.get(first);
            ArrayList<Integer> temp2=a.get(last);
            ArrayList<Integer> temp=temp1;
            temp1=temp2;
            temp2=temp;
            //System.out.println(temp1);
           // System.out.println(temp2);
            a.set(first,temp1);
            a.set(last,temp2);
        }
        System.out.print(a);
        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp1=a.get(i).get(j);
                int temp2=a.get(j).get(i);
                int temp=temp1;
                temp1=temp2;
                temp2=temp;
                a.get(i).set(j, temp1);
                a.get(j).set(i, temp2);
            }
        }
    }
	public static void main(String aa[]) throws Exception{
			
     /*Scan s=new Scan();
     int m=s.scanInt();
     int n=s.scanInt();
     int a[][]=new int[m][n];
     for(int i=0;i<m;i++)
     {
    	 for(int j=0;j<n;j++)
    		 a[i][j]=s.scanInt();
    	 
     }
    // rotateClockwise(a);
     rotateAntiClockwise(a);*/
    ArrayList<ArrayList<Integer>> a1=new ArrayList<>();
    a1.add(new ArrayList<Integer>());
    a1.add(new ArrayList<Integer>());
    a1.get(0).add(0,1);
    a1.get(0).add(1,2);
    a1.get(1).add(0,3);
    a1.get(1).add(1,4);
    rotate(a1);
    System.out.println(a1);
    
     
     
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


