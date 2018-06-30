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
	
boolean eqaualLink(Test b)
	{
		Node p=this.start;
		Node q=b.start;
		
		while(p!=null&&q!=null)
		{
			if(p.info!=q.info)
			{
				return false;
			}
			p=p.next;
			q=q.next;
		}
		return true;
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
		Test t2=new Test();
		t2.insertEnd(10);
		t2.insertEnd(20);
		t2.insertEnd(30);
		t2.insertEnd(40);
		t2.insertEnd(50);
		t2.insertEnd(60);
		if(t1.eqaualLink(t2))
			System.out.println("Equal");
		else 
			System.out.println("Not equal");
		
	}
}