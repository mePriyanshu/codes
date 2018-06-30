import java.util.Stack;
public class My_Stack			//traversals needed to balance a stack
{
	public static void main(String aa[])
	{
		String a="}{";
		
		char s[]=a.toCharArray();
		Stack<Character>s1=new Stack<Character>();
		if(s.length%2==1) {
			System.out.println("Cant be balanced");
		System.exit(0);
		}int i;
		for( i=0;i<s.length;i++)		//removing the balanced parenthesis
		{
			if(s[i]=='}'&&!s1.isEmpty())
			{
				if(s1.peek()=='{')
					s1.pop();
				else
					s1.push(s[i]);
			}else
				s1.push(s[i]);
		}
		
		int l=s1.size();
		System.out.println(l);
	    int count=0;
	    while(!s1.isEmpty()&&s1.peek()=='{')
	    {
	    	s1.pop();
	    	count++;
	    }
		System.out.println(l/2+count%2);
	}
}