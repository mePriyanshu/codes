
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

//first Circular tour
class Test{
	
	static class PetrolPump
	{
       int petrol; 
		int distance;
		PetrolPump(int petrol,int distance)
		{
			this.petrol=petrol;
			this.distance=distance;
		}
	
	}
    static int circularTour(PetrolPump p[])
    {
    	int n=p.length;
    	int diff=0,sum=0,lsum=0,ans=0;
    	for(int i=0;i<n;i++)
    	{
    		int x=p[i].distance-p[i].petrol;
    		sum+=x;
    		lsum+=x;
    		System.out.println("sum="+sum);
    		System.out.println("lsum="+sum);
    		if(sum>0)
    		{
    			diff=lsum;
    			sum=0;
    			ans=i+1;
    		}
    	}
    	if(ans<n)
    	{
    		if(Math.abs(sum)<diff) ans=n;
    	}
    	if(ans==n)return -1;
    	return ans;
    }
    
    public static void main(String aa[])
    {
    	PetrolPump p[]=new PetrolPump[4];
    	p[0]=new PetrolPump(4,6);
    	p[1]=new PetrolPump(6,5);
    	p[2]=new PetrolPump(7,3);
    	p[3]=new PetrolPump(4,5);
    	
    	
    	/*p[0]=new PetrolPump(6,4);
    	p[1]=new PetrolPump(3,6);
    	p[2]=new PetrolPump(7,3);*/
    	System.out.print(circularTour(p));
    }
}	