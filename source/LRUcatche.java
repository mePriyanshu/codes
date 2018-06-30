
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//LRU catche
class Test{

	
	HashMap<Integer,Node> pageTable;
	DoublyLinkedList pageList;
	int capacity=16;
	Test(int capacity)
	{
		this.capacity=capacity;
		pageTable=new HashMap<>(this.capacity);
		pageList=new DoublyLinkedList();
	}
	void acessPage(int pageNumber)
	{
		Node page=pageTable.get(pageNumber);
		if(page!=null)
			pageList.moveToHead(page);
		else
		{
			if(pageTable.size()==this.capacity)
			{
				Node removePage=pageList.removeFromPageList();
				pageTable.remove(removePage.pageNumber);
			}
			page=new Node(pageNumber);
			pageList.addToPageList(page);
			pageTable.put(pageNumber,page);
		}
		pageList.printCatche();
	}
	class Node						
	{
		int pageNumber;
		Node prevLink;
		Node nextLink;
		
		
		Node(int a)
		{
			pageNumber=a;
			prevLink=null;
			nextLink=null;
		}
	}
	class DoublyLinkedList			//doubly linked list to represent nodes				
	{
		Node headPointer;
		Node tailPointer;
		
		void addToPageList(Node page)			//insertion at beginning of doubly linked list
		{
			if(headPointer==null)
				headPointer=tailPointer=page;
			else{
			page.nextLink=headPointer;
			headPointer.prevLink=page;
			headPointer=page;
			}
		}
		
		
		Node removeFromPageList()                           //removal from end
		{
			if(headPointer==tailPointer)
			{
				Node temp=headPointer;
				headPointer=tailPointer=null;
				return temp;
			}
			Node temp=tailPointer;
			tailPointer=tailPointer.prevLink;
			tailPointer.nextLink=null;
			return temp;
		}
		
		void  printCatche()
		{
			Node curr=headPointer;
			while(curr!=null)
			{
				System.out.print(curr.pageNumber+" ");
				curr=curr.nextLink;
			}
			System.out.println();
		}
		
		void moveToHead(Node page)
		{
			if(headPointer==null)
				return;
			page.prevLink.nextLink=page.nextLink;
			if(page.nextLink!=null)
				page.nextLink.prevLink=page.prevLink;
			addToPageList(page);
		}
		
	}
	
	
public static void main(String aa[])
{
	Test t1=new Test(4);
	t1.acessPage(10);
	t1.acessPage(11);
	t1.acessPage(12);
	t1.acessPage(13);
	t1.acessPage(14);
	t1.acessPage(11);
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