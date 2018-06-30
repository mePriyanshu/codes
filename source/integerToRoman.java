import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

import static java.lang.Integer.parseInt;
class Test {

	static String integerToRoman(int n)
	{
		int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String result[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<values.length;i++)
		{
			while(n>=values[i])
			{
				n-=values[i];
				sb.append(result[i]);
			}
		}
		return sb.toString();
	}
	public static void main(String aa[]){
		System.out.println(integerToRoman(420));
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


class KMPAlgorithm
{
	int[] createTempArray(String pattern)
	{
		int n=pattern.length();
		int temp[]=new int[n];
		int index=0;
		int r=0;
		for(int i=1;i<n;)
		{
			//if(r++==20)break;
			if(pattern.charAt(i)==pattern.charAt(index))
			{
				temp[i]=index+1;
				index++;
				i++;
			
			}else
			{
				if(index!=0)
				{
					index=temp[index-1];
				}else
				{
					temp[i]=0;
					i++;
				}
			}
			//System.out.print(index+" ");
		}
		//System.out.println(Arrays.toString(temp));
		return temp;
	}
	
	boolean kmpSearch(String text,String pattern)
	{
		int temp[]=createTempArray(pattern);
		int i=0;
		int j=0;
		int r=0;
		while(i<text.length()&&j<pattern.length())
		{
			
			if(text.charAt(i)==pattern.charAt(j))
			{	
				i++;
				j++;
			}else
			{
				if(j!=0)
				{
					j=temp[j-1];
				}else
					i++;
			}
			if(j==pattern.length()){
				System.out.println("Found Pattern At "+ (i-j));
				return true;
			}
		}
		return false;
	}
}
