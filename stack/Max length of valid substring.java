import java.util.Stack;
public class My_Stack
{
	public static int max(int a,int b)
	{
		if(a>b)return a;
		else
			return b;
	}
	public static void main(String aa[])			//length of longest valid substring
	{
		String a ="()(()))))";
		
		char s[]=a.toCharArray();
		Stack<Integer>s1=new Stack<Integer>();
		int k=0;
		s1.push(-1);
		for(int i=0;i<s.length;i++)
		{
			if(s[i]=='(')
				s1.push(i);
			else 
			{
				s1.pop();
				if(!s1.isEmpty())
				{
				k=max(k,i-s1.peek());	
				}else
				{
					s1.push(i);
				}
			}
			
		}
		System.out.println(k);
	}
}