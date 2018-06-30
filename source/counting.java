
public class Test {
	Node start;
	static class Node					//class for link list
	{
		int info;
		Node next;
		Node(int a)
		{
			info=a;
			next=null;
		}
	}
	void insertEnd(int item)			//insertion at end
	{
		Node p=new Node(item);
		if(start==null)
		{
			start=p;
			return;
		}
		//p.next=null;
		Node q=start;
		while(q.next!=null)
		{
			q=q.next;
		}
		q.next=p;
	}
	void display(Node q)
{
    q=start;
	try{
	while(q!=null)
	{
		System.out.print(q.info+" ");
		q=q.next;
	}
	System.out.println();
	}catch(Exception e){System.out.println("link list empty");}
}
	int rec_count(Node p)				//recursion counting of list
	{
	if(p==null)
		return 0;
	else return 1+rec_count(p.next);
	}
	int mergePoint(Node p,Node q)		//Finding the merge point
	{
		int m=rec_count(p);
		int n=rec_count(q);
		
		int d=n-m;
		if(m>n)
		{
			Node temp=p;
			p=q;
			q=temp;
			d=m-n;
		}
		for(int i=0;i<d;i++)		//making both the pointers in list equal
			q=q.next;
		while(p!=null&&q!=null)
		{
			if(p.info==q.info)
			{
				return p.info;
			}
			p=p.next;
			q=q.next;
		}
		
		return 0;
	}
	void Sum(Node p,Node q)				//finding sum of 2 numbers
	{
		int sum,c=0;
		Node r=null;
	    Node res=null,prev=null;
	    
	  while(p!=null||q!=null)
	  {
		  sum=c+(p!=null?p.info:0)+(q!=null?q.info:0);
		  c=(sum>10?1:0);
		  sum=sum%10;
		 r=new Node(sum);
		  if(res==null)
			  res=r;
		  else
			  prev.next=r;
		  prev=r;
		  
		  if(p!=null)p=p.next;
		  if(q!=null)q=q.next;
	  }
	  if(c>10)
		  r.next=new Node(c);
     while(res!=null)
     {
    	 System.out.print(res.info+" ");
    	 res=res.next;
     }
	   //t.display();
	}
	void linkZigZag()					//Zig Zag link list
	{
		Node q;
		boolean b=true;
		int temp;
		q=start;
		while(q.next!=null)
		{
			if(b)
			{
				if(q.info>q.next.info)
				{
				 temp=q.info;
				 q.info=q.next.info;
				 q.next.info=temp;
				}
			}else
			{
				if(q.info<q.next.info)
				{
					temp=q.info;
					q.info=q.next.info;
					q.next.info=temp;
				}
			}
			q=q.next;
			b=!b;
		}
		
	}
	void detectAndRemove(Node st)		//Detection of loop
	{
		Node slow=null,fast=null;
		slow=start;
	     fast=start;
		while(slow!=null&&fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{System.out.println("loop is there");
				break;
			}
				
			
		}
		
		if(slow==fast)
		{
			slow=start;
			while(slow!=fast.next)
			{
				slow=slow.next;
				fast=fast.next;
			}
			fast.next=null;
			
		}
		}	
}
