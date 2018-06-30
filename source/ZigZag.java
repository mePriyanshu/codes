

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

void linkZigZag()
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
		


public static void main(String aa[])
{
Test t1=new Test();
t1.start=new Node(1);
t1.start.next=new Node(2);
t1.start.next.next=new Node(3);
t1.start.next.next.next=new Node(4);
//t1.start.next.next.next.next=new Node(10);

t1.display(t1.start);

t1.linkZigZag();


t1.display(t1.start);


}
}
