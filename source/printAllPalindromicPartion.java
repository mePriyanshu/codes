import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test{


	static boolean isPalindrome(String str,int i,int j)
	{
	     while(i<j)
	     {
	    	 if(str.charAt(i++)!=str.charAt(j--))
	    		 return false;
	     }
	     return true;
	     
	}

	static List<List<String>> palindromicPartition(String str)
	{
		List<List<String>> ans=new ArrayList<>();
		backTrack(ans,new ArrayList<String>(),0,str);
		return ans;
		
	}
	
	static void backTrack(List<List<String>> ans,List<String> temp,int start,String str)
	{
		if(start==str.length())
		{
			ans.add(new ArrayList<String>(temp));
		}else
		{
			for(int i=start;i<str.length();i++)
			{
				if(isPalindrome(str,start,i))
				{
					temp.add(str.substring(start,i+1));
					backTrack(ans,temp,i+1,str);
					temp.remove(temp.size()-1);
				}
			}
		}
	}
	public static void main(String aa[])
	{
		System.out.println(palindromicPartition("aab"));
		
	}

}
