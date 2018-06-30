import java.util.Scanner;

public class Link
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

void insertBeg(int item)			//insertion at beginning
{
	Node p=new Node(item);
	p.next=start;
	start=p;
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

void insertLoc(int item,int data)		//insertion at a location
{
	Node p=new Node(item);

	if(p==start)
	{
		start=p;
		return;
	}
	Node q=start,r;
	while(q.info!=data)
	{
		q=q.next;
	}
	r=q.next;
	q.next=p;
	p.next=r;
	
}

void deletePos(int pos)
{
	Node q=start,r=null;
	if(start==null){
		System.out.println("linked list empty");
	return;
	}
	if(pos==0)
		start=q.next;
	else
	{
		int i=0;
		while(i!=pos-1)
		{
			r=q;
			q=q.next;
			i++;
			if(q==null||q.next==null)return;
		}
		r.next=q.next;
		
		
	}
}
public static void main(String aa[])
{
	Link l1=new Link();
	int item;
	Scanner in=new Scanner(System.in);
	do
	{
		System.out.println("\n1.Insertion at beginning");
		System.out.println("2.Insertion at end"); 
		System.out.println("3.Insertion at location");
		System.out.println("4.Deletion at location "); 
		System.out.println("5.Display");
		System.out.println("6.Close");
		int ch=in.nextInt();
		switch(ch)
		{
		case 1:System.out.print("Enter the item:");
			  item=in.nextInt();
			   l1.insertBeg(item);
	  		   break;
		case 2:System.out.print("Enter the item:");
		      item=in.nextInt();
		       l1.insertEnd(item);
		       break;
		case 3:System.out.print("Enter the item:");
				item=in.nextInt();
				System.out.println("Enter the location:");
				int loc=in.nextInt();
				l1.insertLoc(item, loc);
				break;
		case 4:System.out.println("Enter pos for deletion:");
				int pos=in.nextInt();
				l1.deletePos(pos);
				break;
		case 5:l1.display();
		break;
		case 6:System.exit(0);
		break;
		
		default:System.out.print("invalid entry");
		       
		
		}
	}while(true);
	






}
}