import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;
/*
 * T[i][j]=T[i-1][j-1] if pat[j]=='.'||pat[j]==text[i]
 * T[i][j]=T[i][j-2]||T[i-1][j]   if(pat[j]=='*') 
 * no character : pat[j-2]==text[i-1]||pat[j-2]=='.'
 * */
class Test
{

	static boolean regularExpressionMatch(String text,String pattern)
	{
		int textLength=text.length();
		int patternLength=pattern.length();
		
		boolean regex[][]=new boolean[textLength+1][patternLength+1];
		regex[0][0]=true;
		for(int i=1;i<=patternLength;i++)
		{
			if(pattern.charAt(i-1)=='*')
			{
				regex[0][i]=regex[0][i-2];
			}
		}
		
		for(int i=1;i<=textLength;i++)
		{
			for(int j=1;j<=patternLength;j++)
			{
				if(text.charAt(i-1)==pattern.charAt(j-1)||pattern.charAt(j-1)=='.')
				{
					regex[i][j]=regex[i-1][j-1];
				}else if(pattern.charAt(j-1)=='*')
				{
					regex[i][j]=regex[i][j-2];
					if(pattern.charAt(j-2)=='.'||pattern.charAt(j-2)==text.charAt(i-1))
					{
						regex[i][j]=regex[i][j]|regex[i-1][j];
					}
				}else 
					regex[i][j]=false;
			}
		}
	/*	for(int i=0;i<=textLength;i++)
		{
			for(int j=0;j<=patternLength;j++)
				System.out.print(regex[i][j]+" ");
			System.out.println();
		}*/
		return regex[textLength][patternLength];
	}
	public static void main (String[] args) throws IOException
	{
		
		System.out.println(regularExpressionMatch("xyz","x.y*z"));
		
	}

}

class Scan
{
   // BufferedReader br;
    StringTokenizer st;
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String scanString() throws IOException
    {
        while(st==null||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
       return st.nextToken();
      
    }
    int scanInt() throws IOException
    {
        return parseInt(scanString());
    }
    
    
}
