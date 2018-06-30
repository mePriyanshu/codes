
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//maximum depth of valid parenthesis
class Test{
	
	static int maxDepthOfValidParenthesis(String s)
	{
		Stack<Character> s1=new Stack<>();
		int count=0;
		int maxCount=Integer.MIN_VALUE;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
			{
				count++;
				maxCount=Math.max(count, maxCount);
			}else
			{
				if(s.charAt(i)==')')
				{
					if(count>0)
						count--;
					else
						return -1;
				}
			}
		}
		if(count!=0)
			return -1;
		return maxCount;
	}
	public static void main(String aa[])
	{
		String str="( p((q)) ((s)t) )";
		System.out.print(maxDepthOfValidParenthesis(str));
	}
	
}