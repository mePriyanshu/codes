import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

//gcd between the given range
class Test
{
	
	public static void main(String aa[])throws Exception
	{
		Scan s=new Scan();
		int t=s.scanInt();
		while(t-->0){
		ArrayList<Integer> a1=new ArrayList<>();
		int n=s.scanInt();
		int q=s.scanInt();
		for(int i=0;i<n;i++)		//2,3,6,9,5
			a1.add(s.scanInt());
		SegmentTree s1=new SegmentTree();
		s1.root=s1.construct(a1,0,n-1);
		while(q-->0)
		{
			int left=s.scanInt()-1;
			int right=s.scanInt()-1;
			int gcdLeft=s1.querry(s1.root, 0,left-1);
			int gcdRight=s1.querry(s1.root,right+1,n-1);
			System.out.println(s1.gcd(gcdLeft,gcdRight));
		}
	}
	}
	
}

	
class SegmentTree
{
	int value,low,high;
	SegmentTree left,right;
	
	//constructors
	SegmentTree(){};
	SegmentTree root=null;
	
	SegmentTree(int value,int index)
	{
		this.value=value;
		low=high=index;
	}
	
	SegmentTree construct(ArrayList<Integer> a1,int low,int high)
	{
		if(low==high)
		{
			SegmentTree temp=new SegmentTree(a1.get(low),low);
			return temp;
		}
		int mid=(low+high)/2;
		SegmentTree root=new SegmentTree();
		root.left=construct(a1,low,mid);
		root.right=construct(a1,mid+1,high);
		root.low=root.left.low;
		root.high=root.right.high;
		root.value=merge(root,root.left,root.right);
		return root;
	}
	int gcd(int a,int b)
	{
		if(a<b)
		{
			int temp=a;
			a=b;
			b=temp;
		}
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	int  merge(SegmentTree root,SegmentTree left,SegmentTree right)
	{
		
		root.value=gcd(root.left.value,root.right.value);
		return root.value;
	}
	int querry(SegmentTree root,int ql,int qr)
	{
		if(ql<=root.low&&qr>=root.high)
			return root.value;
		if(qr<root.low||ql>root.high)
			return 0;
		return gcd(querry(root.left,ql,qr),querry(root.right,ql,qr));
	}
	void preOrder(SegmentTree root)
	{
		if(root!=null)
		{
			System.out.println(root.low+" "+root.high);
			preOrder(root.left);
			preOrder(root.right);
		}
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

