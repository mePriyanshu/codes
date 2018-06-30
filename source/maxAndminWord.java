import java.util.*;
import java.util.Map.Entry;
import java.io.*;

//finding max word and min word
public class Test
{

	public static void main(String aa[])
	{
       String s="GeeksforGeeks A computer Science portal for Geeks";
       String st[]=s.trim().split("\\s+");
       int max=Integer.MIN_VALUE;
       int min=Integer.MAX_VALUE;
       String maxlen="";
       String minlen="";
       for(int i=0;i<st.length;i++)
       {
    	//   if(st[i]=="")break;
    	  if(st[i].length()>max)
    	  {
    		  max=st[i].length();
    		  maxlen=st[i];
    	  }
    	  if(st[i].length()<min)
    	  {
    		  min=st[i].length();
    		  minlen=st[i];
    	  }
    	   
       }
       System.out.println("Maximum Word:"+maxlen);
       System.out.println("Minimum Word:"+minlen);
	}
}




