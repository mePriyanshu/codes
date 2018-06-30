import java.security.Timestamp;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Integer.parseInt;

class Test{
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
		next=null;
	}
}
Node start=null;

void insertEnd(int data)
{
	Node p=new Node(data);
	if(start==null)
		start=p;
	else
	{
		Node q=start;
		while(q.next!=null)
			q=q.next;
		q.next=p;
	}
	
}

void display(Node p)
{
	
	if(p==null){
		System.out.println("Linked List Empty");
		return;
	}
	while(p!=null){
		System.out.print(p.data+" ");
		p=p.next;
	}
	System.out.println();
}
int findMiddleElement()
{
	if(start==null)
		return 0;
	Node slow=start;
	Node fast=start;
	while(fast!=null&&fast.next!=null)
	{
		fast=fast.next.next;
		slow=slow.next;
	}
	return slow.data;
}
 int countNoOfTimes(int data)
{
	Node q=start;
	int count=0;
	
	while(q!=null)
	{
		if(q.data==data)
			count++;
		q=q.next;
	}
	return count;
}
Node mergeTwoLinkedList(Node p,Node q)
{
	Node result=null;
	if(p==null)
		return q;
	if(q==null)
		return p;
	if(p.data<=q.data)
	{
		//result=p;
		p.next=mergeTwoLinkedList(p.next,q);
		return p;
	}else
	{
		
		q.next= mergeTwoLinkedList(p,q.next);
		return q;
	}
//	return result;
}

void swapNodes(int x,int y)
{
	if(x==y)return;
	Node currX=start,prevX=null;
	while(currX!=null&&currX.data!=x)
	{
		prevX=currX;
		currX=currX.next;
	}
	
	Node currY=start,prevY=null;
	while(currY!=null&&currY.data!=y)
	{
		prevY=currY;
		currY=currY.next;
	}
	
	if(prevX!=null)
		prevX.next=currY;
	else
		start=currY;
	if(prevY!=null)
		prevY.next=currX;
	else
		start=currY;
	Node temp=currX.next;
	currX.next=currY.next;
	currY.next=temp;
}

Node rearrangeEvenOdd(Node head)
{
	Node p=head;
	if(p==null)return p;
	Node evenHead=p.next;
	Node even;
	while(p!=null&&p.next!=null&&p.next.next!=null)
	{
		even=p.next;
		p.next=even.next;
		p=p.next;
		even.next=p.next;
	}
	p.next=evenHead;
	return head;
}

 int getRandomNode(Node p)
{
	if(p==null)
		return 0;
      
      int result=p.data;
      Math.abs(UUID.randomUUID().getMostSignificantBits());
       Random r=new Random();
      for(int i=2;p!=null;i++)
      {
    	  if(r.nextInt()%i==0)
    		  result=p.data;
    	  p=p.next;
      }
      return result;
}

 Node reverseInGroupAlternative(Node p,int k)
 {
	 if(p==null||p.next==null)
		 return p;
	 Node curr=p,prev=null,next=null;
	 int c=0;
	 while(c!=k&&curr!=null)
	 {
		 next=curr.next;
		 curr.next=prev;
		 prev=curr;
		 curr=next;
		 c++;
	 }
	p.next=next;
	 c=0;
	 while(++c!=k&&next!=null){
		 next=next.next;
		 //c++;
	 }
	 if(next!=null)
		 next.next=reverseInGroupAlternative(next.next,k);
	 return prev;
 }
 public static void main(String aa[])
{
	Test t1=new Test();
	t1.insertEnd(10);
	t1.insertEnd(30);
	t1.insertEnd(50);
	t1.insertEnd(70);
	t1.insertEnd(90);
	t1.insertEnd(100);
	
	//System.out.print(t1.findMiddleElement()+"\n");
	//System.out.println(t1.countNoOfTimes(10));
	t1.display(t1.start);
    //t1.start=t1.rearrangeEvenOdd(t1.start);
	//System.out.print(t1.getRandomNode(t1.start));
	//t1.display(t1.start);
	//t1.start=t1.reverseInGroupsOfSizeK(t1.start,2);
	//t1.swapNodes(10, 90);
	//t1.start=t1.reverseInGroupsByIteration(t1.start, 3);
	t1.start=t1.reverseInGroupAlternative(t1.start, 2);
	t1.display(t1.start);
	
	
	
	
	
	/*Test t2=new Test();
	t2.insertEnd(20);
	t2.insertEnd(40);
	t2.insertEnd(60);
	t2.insertEnd(80);
	t2.insertEnd(100);
	t2.display(t2.start);
	Test t3=new Test();
	Node p=t3.mergeTwoLinkedList(t1.start,t2.start);
	t3.display(p);*/
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

