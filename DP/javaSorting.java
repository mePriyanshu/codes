import java.util.*;
public class Test
{
	String a[]=new String[5];
	
Test()
{
	a[0]="my";
	a[1]="name";
	a[2]="iss";
	a[3]="kitkat";
	a[4]="kidding";
}
 void sort()
{
	Arrays.sort(a,new dec());
	for(int i=0;i<a.length;i++)
		System.out.println(a[i]);
}
 
 private class dec implements Comparator<String>
 {

	@Override
	public int compare(String o1, String o2) {
		if(o1.charAt(1)>o2.charAt(1)) return 1;
		else
			return -1;
	
	}

 }
 /*private class compareString implements Comparator<String>
	{
		public int compare(String o1,String o2)			//big sorting
		{
			if(o1.length()>o2.length())
				return 1;
			else if(o1.length()==o2.length())
			{
				return o1.compareTo(o2);
			}
			return -1;
		}
	}*/
 public static void main(String aa[])
 {
	 Test t1=new Test();
	 t1.sort();
 }
}