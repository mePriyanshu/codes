import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//letter combination on mobile
class Test{

	static List<String> letterCombinationOf(String digits)
	{
		
		HashMap<Character,char[]> h1=new HashMap<>();
		h1.put('0',new char[]{'0'});
		h1.put('1',new char[]{'1'});
		h1.put('2',new char[]{'a','b','c'});
		h1.put('3',new char[]{'d','e','f'});
		h1.put('4',new char[]{'g','h','i'});
		h1.put('5',new char[]{'j','k','l'});
		h1.put('6',new char[]{'m','n','o'});
		h1.put('7',new char[]{'p','q','r','s'});
		h1.put('8',new char[]{'t','u','v'});
		h1.put('9',new char[]{'w','x','y','z'});
		
		List<String> ans=new ArrayList<>();
		backTrack(ans,new StringBuilder(),0,digits,h1);
		return ans;

	}
	
	static void backTrack(List<String> ans,StringBuilder sb,int index,String digits,HashMap<Character,char[]> h1)
	{
		if(index>=digits.length())
		{
			ans.add(sb.toString());
			return;
		}
		char ch[]=h1.get(digits.charAt(index));
		for(int i=0;i<ch.length;i++)
		{
			sb.append(ch[i]);
			backTrack(ans,sb,index+1,digits,h1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
 public static void main(String aa[])
	{
		System.out.println(letterCombinationOf("0"));
	}

}
