import java.util.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.io.*;
class Test
{
	public static void main(String aa[]){
	SegmentTree s1=new SegmentTree();
	int a[]={0,3,4,2,1,6,-1};
	int segmentTree[]=s1.createSegmentTree(a);
	System.out.println(s1.rangeMinQuerry(segmentTree, 0, a.length-1, 1,5, 0));
	
	s1.updateSegmentTree(segmentTree, a,2, 1);
	System.out.println(s1.rangeMinQuerry(segmentTree, 0, a.length-1, 1,3, 0));
	//System.out.println(Arrays.toString(a));
	
	s1.updateRange(segmentTree, a, 3, 5, -2);
	System.out.println(s1.rangeMinQuerry(segmentTree, 0, a.length-1,0,3, 0));
	//System.out.println(Arrays.toString(a));
	int lazy[]=new int[segmentTree.length];
	s1.updateRangeLazy(segmentTree, a, lazy, 5,-2 , 3, 5, 0, 0, a.length-1);
	System.out.println(s1.rangeMinQuerry(segmentTree, 0, a.length-1,0,3, 0));
	}

	

}


class SegmentTree
{
	
	int getSizeOfSegmentTree(int n)
	{
		boolean bl=(n>0)&&(n&(n-1))==0;
		if(bl)
		{
			return 2*n-1;
		}
		int value=1;
		while(value<=n)
		{
			value*=2;
		}
		return 2*value-1;
	}
	int[] createSegmentTree(int input[])
	{
		int n=input.length;
		int sizeOfSegmentTree=getSizeOfSegmentTree(n);
		int segmentTree[]=new int[sizeOfSegmentTree];
		for(int i=0;i<sizeOfSegmentTree;i++)
			segmentTree[i]=Integer.MAX_VALUE;
		constructSegmentTree(segmentTree,input,0,n-1,0);
		return segmentTree;
	}
	 
	void constructSegmentTree(int segmentTree[],int input[],int low,int high,int pos)
	{
		if(low==high)
		{
			segmentTree[pos]=input[low];
			return ;
		}
		int mid=(low+high)/2;
		constructSegmentTree(segmentTree,input,low,mid,2*pos+1);
		constructSegmentTree(segmentTree,input,mid+1,high,2*pos+2);
		segmentTree[pos]=Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
	}
	int rangeMinQuerry(int segmentTree[],int low,int high,int ql,int qr,int pos)
	{
		if(ql<=low&&qr>=high)
			return segmentTree[pos];
		if(ql>high||qr<low)
			return Integer.MAX_VALUE;
		int mid=(low+high)/2;
		int leftMin=rangeMinQuerry(segmentTree,low,mid,ql,qr,2*pos+1);
		int rightMin=rangeMinQuerry(segmentTree,mid+1,high,ql,qr,2*pos+2);
		return Math.min(leftMin, rightMin);
	}
	
	void updateSegmentTree(int segmentTree[],int input[],int index,int delta)
	{
		input[index]+=delta;
		updateSegmentTreeUtil(segmentTree,input,0,input.length-1,index,delta,0);
	}
void updateSegmentTreeUtil(int segmentTree[],int input[],int low,int high,int index,int delta,int pos)
{
	if(index<low||index>high)
		return ;
	if(low==high)
	{
		segmentTree[pos]+=delta;
		return;
	}
	int mid=(low+high)/2;
	updateSegmentTreeUtil(segmentTree,input,low,mid,index,delta,2*pos+1);
	updateSegmentTreeUtil(segmentTree,input,mid+1,high,index,delta,2*pos+2);
	segmentTree[pos]=Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
}

void updateRange(int segmentTree[],int input[],int startRange,int endRange,int delta)
{
	for(int i=startRange;i<=endRange;i++)
		input[i]+=delta;
	updateRangeUtil(segmentTree,input,0,input.length-1, startRange, endRange, delta, 0);
}

void updateRangeUtil(int segmentTree[],int input[],int low,int high,int startRange,int endRange,int delta,int pos)
{
	if(low>high||startRange>high||endRange<low)
		return;
	if(low==high)
	{
		segmentTree[low]+=delta;
		return;
	}
	int mid=(low+high)/2;
	updateRangeUtil(segmentTree,input,low,mid,startRange,endRange,delta,2*pos+1);
	updateRangeUtil(segmentTree,input,mid+1,high,startRange,endRange,delta,2*pos+2);
	segmentTree[pos]=Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
}

int rangeMinimumQuerryLazy(int segmentTree[],int input[],int lazy[],int ql,int qr,int low,int high,int pos)
{
	if(low>high)
		return Integer.MAX_VALUE;
	if(lazy[pos]!=0)
	{
		segmentTree[pos]+=lazy[pos];
		if(low!=high)
		{
			segmentTree[2*pos+1]+=lazy[pos];
			segmentTree[2*pos+2]+=lazy[pos];
		}
		lazy[pos]=0;
	}
	if(ql<=low&&qr>=high)
		return segmentTree[pos];
	if(ql>high||qr<low)
		return Integer.MAX_VALUE;
	int mid=(low+high)/2;
	int leftMin=rangeMinimumQuerryLazy(segmentTree,input,lazy,ql,qr,low,mid,2*pos+1);
	int rightMin=rangeMinimumQuerryLazy(segmentTree,input,lazy,ql,qr,mid+1,high,2*pos+2);
	return Math.min(leftMin, rightMin);
}

void updateRangeLazy(int segmentTree[],int input[],int lazy[],int index,int delta,int startRange,int endRange,
		int pos,int low,int high)
{
	if(low>high)
		return;
	if(lazy[pos]!=0)
	{
		segmentTree[pos]+=lazy[pos];
		if(low!=high){
		segmentTree[2*pos+1]+=lazy[pos];
		segmentTree[2*pos+1]+=lazy[pos];
		}
		lazy[pos]=0;
	}
	if(startRange>high||endRange<low)
		return;
	 if(startRange <= low && endRange >= high) {
         segmentTree[pos] += delta;
         if(low != high) {
             lazy[2*pos + 1] += delta;
             lazy[2*pos + 2] += delta;
         }
         return;
	 	}
	 int mid = (low + high)/2;
	 updateRangeLazy(segmentTree,input,lazy,index,delta,startRange,endRange,2*pos+1,low,mid);
	 updateRangeLazy(segmentTree,input,lazy,index,delta,startRange,endRange,2*pos+2,mid+1,high);
     segmentTree[pos] = Math.min(segmentTree[2*pos + 1], segmentTree[2*pos + 2]);
}
}
class Scan
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	String scanString()throws IOException
	{
		while(st==null||!st.hasMoreTokens()){
		st=new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	
	}
	int scanInt() throws IOException
	{
		return Integer.parseInt(scanString());
	
	}

	long scanLong() throws IOException
	{
		return Long.parseLong(scanString());
	
	}
	String scanStringLine()throws IOException
	{
		while(st==null||!st.hasMoreTokens()){
		st=new StringTokenizer(br.readLine(),"\t");
		}
		return st.nextToken();
	
	}

}
