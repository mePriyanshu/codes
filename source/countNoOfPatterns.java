
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//count No. of patterns
class Test{
	
	
	public static void main(String aa[])
	{
		String text="hello";
		String pattern="ABC";
	//	int index=text.indexOf(pattern);
		int c=0;
		int index;
	
//	System.out.print(text);
		while(true)
		{
			

			index=text.indexOf(pattern);
			//System.out.println(index+"");
			text=text.replaceFirst(pattern,"");
			//System.out.println(text);
			if(index!=-1)
			{
				c++;
			}else
				break;
		}
		
		
		System.out.println(c);
		
	}
	
}