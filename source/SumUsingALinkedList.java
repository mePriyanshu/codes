



public class Test {
	
	 Node start;
	static class Node				//class for link list
	{
		int info;
		Node next;
		Node(int a)
		{
			info=a;
			next=null;
		}
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


	void Sum(Node p,Node q)
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
	
public static void main(String aa[])
{

	Test t1=new Test();
	t1.insertEnd(1);
	t1.insertEnd(2);
	t1.insertEnd(3);
	t1.insertEnd(4);

	System.out.println("Linked List 1:");
	t1.display(t1.start);

	//System.out.println(t1.start);
	Test t2=new Test();
	t2.insertEnd(1);
	t2.insertEnd(2);
	t2.insertEnd(3);
	t2.insertEnd(4);
	t2.insertEnd(5);
	System.out.println("Linked List 2:");
	t2.display(t2.start);
	//System.out.println(t2.start);
t1.Sum(t1.start, t2.start);



}
}
