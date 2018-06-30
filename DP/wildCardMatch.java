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
 * T[i][j]=T[i-1][j-1] when pat[j]==text[i] || pat[j]=='?'
 * T[i][j]=T[i-1][j]||T[i][j-1] when pat[j]=='*'
 * */
class Test
{

	static boolean wildCardCharacterMatch(String s,String p)
	{
		char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
    
        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[str.length][writeIndex];	}
	public static void main (String[] args) throws IOException
	{
		
		System.out.println(wildCardCharacterMatch("ho","**ho"));
		
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

/*
O(1) space solution
For each element in s
If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
If not match, then we check if there is a * previously showed up,
       if there is no *,  return false;
       if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.

e.g.

abed
?b*d**

a=?, go on, b=b, go on,
e=*, save * position star=3, save s position ss = 3, p++
e!=d,  check if there was a *, yes, ss++, s=ss; p=star+1
d=d, go on, meet the end.
check the rest element in p, if all are *, true, else false;
*/
