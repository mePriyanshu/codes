import java.io.*;
import java.util.*;
public class My_Stack
{
	public static Stack<Integer> height(int a[])
	{
		int sum=0;
		Stack<Integer> st=new Stack<Integer>();
		for(int i=a.length-1;i>=0;i--)
		{
			sum+=a[i];
			st.push(sum);
		}
		
		return st;
	}
	
	public static void main(String aa[]) throws IOException
	{
		Scanner s=new Scanner(System.in);
		
		int n1=s.nextInt();
		int n2=s.nextInt();
		int n3=s.nextInt();
		
		int i;
		
		int h1[]=new int[n1];
		for(i=0;i<n1;i++)
		{
			h1[i]=s.nextInt();
		}
		
		int h2[]=new int[n2];
		for(i=0;i<n2;i++)
			h2[i]=s.nextInt();
		
		int h3[]=new int[n3];
		for(i=0;i<n3;i++)
			h3[i]=s.nextInt();
		
		Stack<Integer> s1=height(h1);
		Stack <Integer>s2=height(h2);
		Stack <Integer>s3=height(h3);
		
		if(s1.peek()==s2.peek()&&s2.peek()==s3.peek())
			{System.out.println(s1.peek());
			System.exit(0);
			}
	    
		while(true)
		{
			if(s1.peek()<s2.peek()&&s1.peek()<s3.peek())
			{
				if(s2.search(s1.peek())!=-1&&s3.search(s1.peek())!=-1)
					{System.out.println(s1.peek());break;}
				else
				{
					s1.pop();
					if(s3.isEmpty())
					{
                        System.out.print(0);break;
                    }
				}
			}else
			
			if(s2.peek()<s1.peek()&&s2.peek()<s3.peek())
			{
				if(s1.search(s2.peek())!=-1&&s3.search(s1.peek())!=-1)
					{System.out.println(s2.peek());break;}
				else
				{
					s2.pop();
					if(s2.isEmpty())
					{
                        System.out.print(0);break;
                    }
				}
			}
			else
			if(s3.peek()<s1.peek()&&s3.peek()<s2.peek())
			{
				if(s1.search(s3.peek())!=-1&&s2.search(s3.peek())!=-1)
					{System.out.println(s3.peek());break;}
				else
				{
					s3.pop();
					if(s3.isEmpty())
					{
                        System.out.print(0);break;
                    }
				}
			}
		}
	}
}

/*5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
5*/