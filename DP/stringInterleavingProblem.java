import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

//string interleaving problem
public class Test {
 
	

	boolean isInterleave(String s1,int i,String s2,int j,String s3,int k,int lookup[][])
	{
		if(i==s1.length())
			return s2.substring(j).equals(s3.substring(k));
		if(j==s2.length())
			return s1.substring(i).equals(s3.substring(k));
		
		
		if(lookup[i][j]>=0){
			return (lookup[i][j]==1)?true:false;
		}
			boolean ans=false;
		if(s3.charAt(k)==s1.charAt(i)&&isInterleave(s1,i+1,s2,j,s3,k+1,lookup)||s3.charAt(k)==s2.charAt(j)&&isInterleave(s1,i,s2,j+1,s3,k+1,lookup))
			ans=true;
		lookup[i][j]=ans?1:0;
		return ans;
	}

	public static void main(String aa[])throws Exception
	{
		
		String s1="YX";
		String s2="X";
		String s3="XXY";
		int lookup[][]=new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++)
			for(int j=0;j<s2.length();j++)
				lookup[i][j]=-1;
     System.out.println(new Test().isInterleave(s1, 0, s2, 0, s3, 0,lookup));
   /*  for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++)
				System.out.print(lookup[i][j]+"  ");
			System.out.println();
	}*/
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