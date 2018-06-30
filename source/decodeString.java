
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//decode a string 2[ab]=abab;
class Test{
	
	public static void main(String aa[])
	{
		String str="7[ab]";
		
		Stack<Integer> integerStack=new Stack<>();
		Stack<Character> characterStack=new Stack<>();
		String temp="",result="";
		for(int i=0;i<str.length();i++)
		{
			int c=0;
			if(Character.isDigit(str.charAt(i)))
			{
			while(Character.isDigit(str.charAt(i)))
			{
				c=c*10+str.charAt(i)-'0';
				i++;
			}
			i--;
			integerStack.push(c);
			}
			else if(str.charAt(i)==']')
			{
				temp="";
				c=0;
				if(!integerStack.isEmpty())
					c=integerStack.pop();
				while(!characterStack.isEmpty()&&characterStack.peek()!='[')
				{
					temp=characterStack.pop()+temp;
				}
				if(!characterStack.isEmpty()&&characterStack.peek()=='[')
					characterStack.pop();
				for(int j=0;j<c;j++)
					result=result+temp;
				for(int j=0;j<result.length();j++)
					characterStack.push(result.charAt(j));
				result="";
			}else if(str.charAt(i)=='[')
			{
				if(Character.isDigit(str.charAt(i-1)))
				{
					characterStack.push(str.charAt(i));
				}else
				{
					characterStack.push(str.charAt(i));
					integerStack.push(1);
				}
			}else
				characterStack.push(str.charAt(i));
			
		}
		while(!characterStack.isEmpty())
			result=characterStack.pop()+result;
		System.out.print(result);
	} 
}