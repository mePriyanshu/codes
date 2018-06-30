

public class Test {
	
	static Node start;
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

void detectAndRemove(Node st)
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
		


public static void main(String aa[])
{
Test t1=new Test();
t1.start=new Node(50);
t1.start.next=new Node(20);
t1.start.next.next=new Node(15);
t1.start.next.next.next=new Node(4);
t1.start.next.next.next.next=new Node(10);

t1.display(t1.start);
start.next.next.next.next.next =start.next.next;
t1.detectAndRemove(t1.start);


t1.display(start);


}
}
