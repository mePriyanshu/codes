public class Test
{
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
	void display()
	{
		Node q=start;
		try{
		while(q.next!=null)
		{
			System.out.print(q.info+" ");
			q=q.next;
		}
		System.out.print(q.info);
		}catch(Exception e){System.out.println("link list empty");};
	}
	
	void rotateLink(int k)
	{
		Node p=null;
		int count=1;
		p=start;
		while(count<k&&p!=null)		//moving the node towards the k node
		{
			p=p.next;
			count++;
			
		}
		Node kt=p;				//storing the kth node
		p=start;
		while(p.next!=null)
		{
			p=p.next;
		}
		if(p==null)return;
		p.next=start;
		start=kt.next;
		kt.next=null;
		
		
	}
	public static void main(String aa[])
	{
		Test t1=new Test();
		t1.insertEnd(10);
		t1.insertEnd(20);
		t1.insertEnd(30);
		t1.insertEnd(40);
		t1.insertEnd(50);
		t1.insertEnd(60);
		t1.display();
		System.out.println();
		t1.rotateLink(4);
		t1.display();
		
	}
}