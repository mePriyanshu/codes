import java.util.Scanner;
import java.util.Stack;

public class Test
{
	Stack nm=new Stack();
	Stack min=new Stack();
	
	public void push(long item)
	{
	
		if(nm.isEmpty()||item>=(long)min.peek()||min.isEmpty())
		{
			min.push(item);
		}
		nm.push(item);
	}
	
	public long pop()
	{
		if(nm.isEmpty())return -1;
		long k=(long)nm.pop();
		if(k==(long)min.peek())
		{
			min.pop();
		}
		return k;
	}
	
	public long getMax()
	{
		if(min.isEmpty())return -1;
		return (long)min.peek();
	}
	
	/*public void display()
	{
		System.out.println(nm);
	}*/
	public static void main(String aa[])
	{
		Test t1=new Test();
		int ch;
		Scanner in=new Scanner(System.in);
		long i=0;
        long x=in.nextInt();
        while(i!=x){
        ch=in.nextInt();
		switch(ch)
		{
		case 1:long item=in.nextInt();
		t1.push(item);
		break;
		case 2:t1.pop();
		break;
		case 3:System.out.println(t1.getMax());
		break;
		}
            i++;
        }
	//t1.display();
	}
}