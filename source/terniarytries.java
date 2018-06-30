import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;

//terniary Tries for memory utilization	
class Test
{
	
class TrieNode
{
	int value;
	char ch;
	TrieNode left,right,mid;
}
TrieNode root;
TrieNode put(TrieNode x,String key,int val,int d)
{
	char ch=key.charAt(d);
	if(x==null)
	{
		x=new TrieNode();
		x.ch=ch;
	}
	if(ch<x.ch)
	{
		x.left=put(x.left,key,val,d);
	}else if(ch>x.ch)
	{
		x.right=put(x.right,key,val,d);
	}else if(d<key.length()-1)
	{
		x.mid=put(x.mid,key,val,d+1);
	}else
	{
		x.value=val;
	}
	return x;
}
public void put(String key,int value)
{
	root=put(root,key,value,0);
}
TrieNode get(TrieNode x,String key,int d)
{
	if(x==null) return x;
	char ch=key.charAt(d);
	if(ch<x.ch)
		return get(x.left,key,d);
	else if(ch>x.ch)
		return get(x.right,key,d);
	else if(d<key.length()-1)
		return get(x.mid,key,d+1);
	else
		return x;
}
int get(String key)
{
	TrieNode curr=get(this.root,key,0);
	if(curr==null) return -1;
	return curr.value;
}
public static void main(String aa[])
{
	Test t1=new Test();
	t1.put("aab", 3);
	t1.put("bba", 4);
	System.out.println(t1.get("aab"));
	
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