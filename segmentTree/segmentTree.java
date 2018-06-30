import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

//segment tree 
class Test
{
	
	public static void main(String aa[])
	{
		ArrayList<Integer> a1=new ArrayList<>(6);
		a1.add(1);
		a1.add(3);
		a1.add(5);
		a1.add(7);
		a1.add(9);
		a1.add(11);
		SegmentTree s1=new SegmentTree();
		s1.root=s1.constructTree(a1, 0, a1.size()-1);
		System.out.print(s1.getSum(s1.root, 1, 3));
		System.out.print("\n"+a1+"\n");
		
		int index=2;
		int update=10;
		s1.update(s1.root, index,update-a1.get(index));
	    System.out.print(s1.getSum(s1.root, 1, 3));
		
	}
}


class SegmentTree
{
	int value;
	int low,high;
	SegmentTree left,right;
	
	//constructors
	SegmentTree(){};
	
	SegmentTree(int val,int index)
	{
		value=val;
		low=index;
		high=index;
		left=right=null;
	}

SegmentTree constructTree(ArrayList<Integer> a1,int low,int high)
{
	if(low==high)
	{
		SegmentTree temp=new SegmentTree(a1.get(low),low);
		return temp;
	}
	int mid=(low+high)/2;
	SegmentTree root=new SegmentTree();
	root.left=constructTree(a1,low,mid);
	root.right=constructTree(a1,mid+1,high);
	root.low=root.left.low;
	root.high=root.right.high;
	root.value=root.left.value+root.right.value;
	return root;
}
SegmentTree root=null;


int getSum(SegmentTree root,int ql,int qr)
{
	if(ql<=root.low&&qr>=root.high)
		return root.value;
	if(qr<root.low||ql>root.high)
		return 0;
	return getSum(root.left,ql,qr)+getSum(root.right,ql,qr);
}


void update(SegmentTree root,int index,int diff)
{
	if(root==null)
		return;
	if(index<root.low||index>root.high)
		return;
	else if(index>=root.low&&index<=root.high)
		root.value+=diff;
	update(root.left,index,diff);
	update(root.right,index,diff);
}
}