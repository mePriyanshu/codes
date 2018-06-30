import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
//no. of subsets by backtracking
class Test{

	static List<List<Integer>> subset(int a[])
	{
		
		List<List<Integer>> ans=new ArrayList<>();
		backTrack(ans,new ArrayList<Integer>(),a,0);
		return ans;
	}
    
	static void backTrack(List<List<Integer>> ans,List<Integer> temp,int a[],int start)
	{
		ans.add(new ArrayList<Integer>(temp));
		for(int i=start;i<a.length;i++)
		{
			temp.add(a[i]);
			System.out.println(temp+" "+temp.size());
			backTrack(ans,temp,a,i+1);
			temp.remove(temp.size()-1);
		}
	}



	public static void main(String aa[])
	{
		System.out.println(subset(new int[]{1,2,3}));
		
	}

}
