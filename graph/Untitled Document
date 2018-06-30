import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
/*Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord, 
such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. 
Note that beginWord is not a transformed word.

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5
*
*/
class Test {

	static int wordLadder(String begin,String end,List<String> l1)
	{
		if(!l1.contains(end))
			return 0;
		Queue<String> q1=new LinkedList<>();
		q1.add(begin);
		q1.add(null);
	
		HashSet<String> h1=new HashSet<>();
		int level=1;
		while(!q1.isEmpty())
		{
			String temp=q1.poll();
			if(temp==null)
			{
				System.out.println(q1);
				level++;
				if(!q1.isEmpty())
					q1.add(null);
			}else
			{
				for(int i=0;i<temp.length();i++)
				{
					char word[]=temp.toCharArray();
					for(char j='a';j<='z';j++)
					{
						word[i]=j;
						String test=new String(word);
						if(test.equals(end))return level+1;
						
						if(l1.contains(test)&&!h1.contains(test))
						{
							q1.add(test);
							h1.add(test);
						}
							
						
					}
				}
			}
			
		}
		return 0;
	}
	public static void main(String aa[])throws Exception
	{
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordlist = new ArrayList<>();
	
		wordlist.add("hot");
		wordlist.add("dot");
		wordlist.add("dog");
		wordlist.add("lot");
		wordlist.add("cog");
		System.out.println(wordLadder(beginWord,endWord,wordlist));
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
