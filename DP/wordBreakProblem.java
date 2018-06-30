import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

//word Break Problem
public class Test {
	static HashMap<String,List<String>> h1=new HashMap<>();
	static String dictionary[] = {"mobile","samsung","sam","sung",
            "man","mango","icecream","and",
             "go","i","like","ice","cream","love","cat", "cats", "sand", "dog"};
	
	static boolean containsWord(String word)
	{

		
		for(String x:dictionary)
		{
			if(x.equals(word))
				return true;
		}
		return false;
	}
	
	static boolean wordBreakByRecursion(String str,String Output)
	{
		
		int n=str.length();
		if(n==0){
			
			return true;
		}
		
		
		for(int i=1;i<=n;i++)
		{
			String spl=str.substring(0,i);
			if(containsWord(spl)&&wordBreakByRecursion(str.substring(i,n),Output+spl+" "))
			{
				
				return true;
			}
		}
		return false;
	}
	
	static boolean wordBreakBottomUp(String temp)
	{
		if(temp==null)return true;
		HashSet<String> h1=new HashSet<>();
		
		for(String x:dictionary)
			h1.add(x);
		
		int n=temp.length();
		
		boolean dp[]=new boolean[n+1];
		dp[0]=true;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(dp[j]&&h1.contains(temp.substring(j,i))){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[n];
	}
	
	static List<String> printAllCombination(String str,List<String> wordDict)
	{
		int n=str.length();
		if(h1.containsKey(str))
			return h1.get(str);
		List<String> result=new ArrayList<>();
		
		if(n==0)
		{
			result.add("");
			return result;
		}
		
		for(String x:wordDict)
		{
			if(str.startsWith(x))
			{
				List<String> a2=printAllCombination(str.substring(x.length()),wordDict);
				
				for(String temp:a2)
				{
					result.add(x+ (x.isEmpty()?"":" " ) + temp );
				}
			}
		}
		h1.put(str,result);
		return result;
	}

	static boolean wordBreak(HashSet<String> dic,String word,int lookup[])
	{
		int n=word.length();
		if(n==0)
			return true;
		if(lookup[n]==-1)	//subproblem is not visited
		{	
			lookup[n]=0;	//make subproblem false
			for(int i=0;i<=n;i++)
			{
				if(dic.contains(word.substring(0,i))&&wordBreak(dic,word.substring(i),lookup)){
					lookup[n]=1;
					return true;
					
				}
			}
		}
		return lookup[n]==1;
	}
	
	public static void main(String aa[])throws Exception
	{
		
		List<String> wordDict=Arrays.asList(dictionary);
		System.out.println(printAllCombination("catsanddog",wordDict));
		
		
		
	}
		
}




class Scan
{
   // BufferedReader br;
    StringTokenizer st;
  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String scanString() throws Exception
    {
    	
        while(st==null||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    int scanInt() throws Exception
    {
        return parseInt(scanString());
    }
    
    long scanLong() throws Exception
    {
        return parseLong(scanString());
    }
}
