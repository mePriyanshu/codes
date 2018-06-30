package hashing;
import java.util.*;


public class My_Hash {
public static void main(String aa[])
{
	HashMap<Integer,String> h1=new HashMap<Integer,String>();
	h1.put(100,"Priyanshu");
	h1.put(200,"rajat");
	h1.put(300,"Karan");
	
	
	/*Set<?> set=h1.entrySet();  							//get the set entry

	
	
	Iterator<?> i=set.iterator();						//printing map
	while(i.hasNext())
	{
		Map.Entry<Integer,String> me= (Map.Entry<Integer,String>)i.next();
		System.out.println(me.getKey()+" "+me.getValue());
	}*/

	System.out.println(h1.get(100));
}
}
