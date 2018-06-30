




public class Test {
	
	 Node start;
	static class Node				//class for link list
	{
		char info;
		Node next;
		Node(char a)
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

void insertEnd(char item)			//insertion at end
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

boolean ispal()					//CHECKING OF PALENDROME
{
	Node p=start;
	Node q=start;
	q=q.next;
	int c=0;
	if(start!=null){
	while(q!=null&&q.next!=null)
	{
		p=p.next;
		q=q.next.next;
		c++;
	}
	//System.out.print(c);
   q=start;
   while(q.info!=p.info)
   {
	   //System.out.print(q.info);
	   q=q.next;
   }
   int m=0;
   Node k=Rev(q.next);
   q=start;
   while(q.info!=p.info)
   {
	   if(q.info==k.info)
	   {
		m++;   
	   }
	   q=q.next;
	   k=k.next;
   }
   if(m==c)
	   return true;
 
  
	}
	  return false;
}
Node Rev(Node p)			//reversing a linked list using iteration
{
	Node prev=null;
	
	Node next=null;
	while(p!=null)
	{
		next=p.next;
		p.next=prev;
		prev=p;
		p=next;
		
	}
	return prev;
}
public static void main(String aa[])
{

	Test t1=new Test();
	t1.insertEnd('n');
	t1.insertEnd('a');
	t1.insertEnd('m');
	t1.insertEnd('a');
	t1.insertEnd('n');
t1.display(t1.start);
System.out.println(t1.ispal());

}
}
