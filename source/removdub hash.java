package hashing;
import java.util.*;
//checking if array contains dublicates in range of k by hashing

public class My_Hash {
public static void main(String aa[])
{
	int a[]={1,2,3,4,};
    HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();	
    int k=3;
    for(int i=0;i<a.length;i++)
    {
    	if(h1.containsValue(a[i]))
    		System.out.println("true");
    	else
    		h1.put(i,a[i]);
    	if(i>=k)
    		h1.remove(a[i-k]);
    }
}
}