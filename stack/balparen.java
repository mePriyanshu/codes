import java.util.Scanner;
import java.util.Stack;

public class My_Stack {
	  Stack<Integer>s1=new Stack<Integer>();
	
	
/*static	int checkPar(char ch1,char ch2)			//checking both characters and balancing ()()(
	{
		if(ch1=='('&&ch2==')')
			return 1;
		else if(ch1=='{'&&ch2=='}')
			return 1;
		else if(ch1=='['&&ch2==']')
			return 1;
        else    
		return 0;
		
	}
	
	int balStack(char a[])
	{
		int i=0;
		for(;i<a.length;)
		{
			if(a[i]=='{'||a[i]=='('||a[i]=='[')
				s1.push(a[i]);
			 if(a[i]=='}'||a[i]==')'||a[i]==']')
			{
				if(s1.isEmpty())
				{
					
				s1.clear();return 0;
				}
				char t=(char)s1.pop();
				int p=checkPar(t,a[i]);
				if(p==0){s1.clear();
					return 0;
				
				}
			}
            i++;
		}
		if(s1.isEmpty())return 1;
		else {
		s1.clear();
		return 0;
		}
	}*/
  
	  
	  void nextGreatestElement(int a[])
	  {
		  s1.push(a[0]);
		  int el,next;
		  for(int i=1;i<a.length;i++)
		  {
			  next=a[i];
			  if(!s1.isEmpty())
			  {
				  el=s1.pop();
				  
				  while(el<next)
				  {
					  System.out.println(el+"-----"+next);
					  if(s1.isEmpty())break;
					  el=s1.pop();
				  }
				  if(el>next)
					  s1.push(el);
			  }
			  s1.push(next);
		  }
		  while(!s1.isEmpty())
		  {
			  el=s1.pop();
			  next=-1;
			  System.out.println(el+"***"+next);
		  }
	  }
	  public static void main(String aa[])
  {
	  int a[]={11,13,21,3};
	  My_Stack s1=new My_Stack();
	  s1.nextGreatestElement(a);
		
}
  
}
