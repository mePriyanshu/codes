import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
class Test {

	class ListNode
	{
		int val;
		ListNode next;
		ListNode(int val)
		{
			this.val=val;
			next=null;
		}
		public String toString()
		{
			return val+" ";
		}
	}
 ListNode start=null;

 void insert(int item)
 {
	 ListNode p=new ListNode(item);
	 if(start==null)
	 {
		 start=p;
	 }else
	 {
		 ListNode q=start;
		 while(q.next!=null)
		 {
			 q=q.next;
		 }
		 q.next=p;
	 }
 }

 void display(ListNode p)
 {
	 if(p==null)
	 {
		 System.out.println("Linked List Empty");
		 return;
	 }
	 ListNode q=p;
	 while(q!=null)
	 {
		 System.out.print(q.val+" ");
		 q=q.next;
	 }
	 System.out.println();
 }
 
 ListNode reverse(ListNode p)
 {
	 ListNode prev=null,next=null;
	 ListNode curr=p;
	 while(curr!=null)
	 {
		 next=curr.next;
		 curr.next=prev;
		 prev=curr;
		 curr=next;
	 }
	//display(prev);
	 return prev;
 }

 ListNode reverseByRecursion(ListNode p)
 {
	if(p==null||p.next==null)return p;
	ListNode next=reverseByRecursion(p.next);
	p.next.next=p;
	p.next=null;
			return next;
	
 }
	
 ListNode findMiddle(ListNode p)
 {
	 if(p==null)
		 return p;
	 ListNode fast=p;
	 ListNode slow=p;
	 while(fast!=null&&fast.next!=null)
	 {
		 fast=fast.next.next;
		 slow=slow.next;
	 }
	 
	 return slow;
 }
 
 boolean isPalindrome(ListNode p)
 {
	 ListNode slow=findMiddle(p);
	 
	 ListNode firstHalf=p;
	 ListNode secondHalf=reverse(slow);
	 //display(firstHalf);
	 //display(secondHalf);
	 while(secondHalf!=null)
	 {
		 
		 if(firstHalf.val!=secondHalf.val)
			 return false;
		 firstHalf=firstHalf.next;
		 secondHalf=secondHalf.next;
	 }
	 return true;
 }

 int countListNode(ListNode p)
 {
	 if(p==null)
		 return 0;
	 return 1+countListNode(p.next);
 }
 
ListNode removeFromList(ListNode q,int n)
 {
	 ListNode p=q;
	
	 if(p==null)
		 return p;
	 ListNode r=null;
	 if(n==1){
		 
		 p=p.next;
		return p;
		}
	 while(p!=null)
	 {
		 //r=p;
		 if(--n==0)
		 {
			 r.next=p.next;
			 //System.out.println("hello");
			 break;
		 }
		 r=p;
		 p=p.next;
	 }
	 return q;
 }

ListNode reOrderList(ListNode p)
{
	if(p==null)return p;
	
	ListNode slow=findMiddle(p);
	slow=reverse(slow);
	ListNode p1=p;
	ListNode p2=slow;
	while(p1!=null)
	{
		ListNode r=p1.next;
		p1=p1.next=p2;
		p2=r;
	}
	return p;
}
	
ListNode removeDublicates2(ListNode p)
{
	if(p==null)
		return null;
	ListNode ans=new ListNode(0);
	
	ListNode fast=p;
	ListNode slow=ans;
	slow.next=p;
	boolean bl=false;
	while(fast!=null)
	{
		while(fast.next!=null&&fast.val==fast.next.val)
		{
			bl=true;
			fast=fast.next;
		}
		if(bl)
		{
			slow.next=fast.next;
			fast=slow.next;
			bl=false;
		}else
		{
			slow=slow.next;
			fast=fast.next;
		}
	}
	return ans.next;
}

ListNode partitionList(ListNode p,int x)
{
	if(p==null)
		return p;
	ListNode l1=new ListNode(0);
	ListNode l2=new ListNode(0);
	ListNode ans1=l1;
	ListNode ans2=l2;
	while(p!=null)
	{
		if(p.val<x)
		{
			ans1.next=p;
			ans1=ans1.next;
		}else
		{
			ans2.next=p;
			ans2=ans2.next;
		}
		p=p.next;
	}
	ans2.next=null;
   ans1.next=l2.next;
   return l1.next;
   
}

ListNode sortedMerge(ListNode p,ListNode q)
{
	if(p==null)
		return q;
	if(q==null)
		return p;
	if(p.val<=q.val){
		p.next=sortedMerge(p.next,q);
		return p;
	}else
	{
		q.next=sortedMerge(p,q.next);
		return q;
	}
}

ListNode mergeSortLinkedList(ListNode p)
{
	if(p==null||p.next==null)
		return p;
	//partition the list into two halves
	ListNode fast=p,slow=p;
	ListNode firstListEnd=null;
	while(fast!=null&&fast.next!=null)
	{
		firstListEnd=slow;
		slow=slow.next;
		fast=fast.next.next;
	}
	firstListEnd.next=null;
	ListNode left=mergeSortLinkedList(p);
	ListNode right=mergeSortLinkedList(slow);
	return sortedMergeIteration(left,right);
	
}

ListNode sortedMergeIteration(ListNode p,ListNode q)
{
	ListNode ans=new ListNode(0);
	ListNode curr=ans;
	while(p!=null&&q!=null)
	{
		if(p.val<=q.val)
		{
			curr.next=p;
			p=p.next;
		}else{
			curr.next=q;
			q=q.next;
		}
		curr=curr.next;
	}
	
	while(p!=null)
	{
		curr.next=p;
		curr=curr.next;
		p=p.next;
	}
	while(q!=null)
	{
		curr.next=q;
		curr=curr.next;
		q=q.next;
	}
	return ans.next;
}

ListNode insertionSortLinkedList(ListNode p)
{
	if(p==null)
		return p;
	ListNode ans=new ListNode(0);
	ListNode curr=p;
	ListNode pre=ans;
	while(curr!=null)
	{
		ListNode next=curr.next;
		while(pre.next!=null&&pre.next.val<curr.val)
			pre=pre.next;
		curr.next=pre.next;
		pre.next=curr;
		pre=ans;
		curr=next;
	}
	return ans.next;
}

ListNode reverseKGroup(ListNode head, int k) {
   
	if(head==null)
		return null;
	ListNode dummy=new ListNode(0);
	ListNode start=dummy;
	dummy.next=head;
	while(true)
	{
		ListNode p=start,n=start,c;
		start=p.next;
		for(int i=0;i<k&&n!=null;i+=1)
			n=n.next;
		if(n==null)break;
		for(int i=0;i<k-1;i++)
		{
			c=p.next;
			//System.out.println(c);
			p.next=c.next;
			//System.out.println(p.next);
			c.next=n.next;
			//System.out.println(c.next);
			n.next=c;
			//System.out.println(n.next);
			
			//System.out.println();
		}
	}

return dummy.next;
        
}

ListNode deleteNode(ListNode p,int n)
{
	if(p==null)
		return p;
	ListNode ans=new ListNode(0);
	ListNode curr=ans;
	
	while(p!=null)
	{
		if(p.val==n)
		{
			curr.next=p.next;
		}else
		{
			curr.next=p;
		}
		curr=p;
		p=p.next;
	}
	return ans.next;
}

ListNode reverseFromMtoN(ListNode head,int m,int n)
{
	ListNode dummy=new ListNode(0);
	ListNode slow=dummy;
	ListNode fast=dummy;
	dummy.next=head;
	for(int i=0;i<m-1;i++)
		slow=slow.next;
	while(n-->0)
		fast=fast.next;
	//System.out.println(slow);
	//System.out.println(fast);
	ListNode curr=slow.next;
	ListNode prev=fast.next;
	slow.next=fast;
	for(int i=0;i<n-m+1;i++)
	{
		ListNode next=curr.next;
		curr.next=prev;
		prev=curr;
		curr=next;
	}
	
	return dummy.next;
}

ListNode oddEvenList(ListNode head) {
    
    ListNode odd=head;
    if(odd==null)
        return odd;
    ListNode even=head.next;
    ListNode evenHead=even;
    while(even!=null&&even.next!=null)
    {
        odd.next=even.next;
        odd=odd.next;
        even.next=odd.next;
        even=even.next;
    }
    odd.next=evenHead;
    return head;
}
public static void main(String aa[]){
		Test t1=new Test();
		t1.insert(2);
		t1.insert(1);
		t1.insert(3);
		t1.insert(4);
		t1.insert(5);
		
		t1.display(t1.start);
		t1.start=t1.oddEvenList(t1.start);
		t1.display(t1.start);
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


