

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
int rec_count(Node p)		//recursion counting of list
{
if(p==null)
	return 0;
else return 1+rec_count(p.next);
}

int mergePoint(Node p,Node q)
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

public static void main(String aa[])
{
Test t1=new Test();
t1.insertEnd(4);
t1.insertEnd(6);
t1.insertEnd(7);
t1.insertEnd(1);

System.out.println("Linked List 1:");
t1.display(t1.start);


Test t2=new Test();
t2.insertEnd(9);
t2.insertEnd(3);
t2.insertEnd(5);
t2.insertEnd(7);
t2.insertEnd(1);
System.out.println("Linked List 2:");
t2.display(t2.start);


System.out.print(t1.mergePoint(t1.start, t2.start));

}
}
