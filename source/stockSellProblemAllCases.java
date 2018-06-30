import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.*;

//stock buy sell problem with all cases

/*
stock buy sell problem
    Base cases:
    T[-1][k][0] = 0, T[-1][k][1] = -Infinity
    T[i][0][0] = 0, T[i][0][1] = -Infinity

    Recurrence relation:
    T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
    T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])

 */
class Test
{
	
	
	/*
	 * Case 1: k=1
	 T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
	 T[i][1][1] = max(T[i-1][1][1], T[i-1][0][0] - prices[i]) = max(T[i-1][1][1], -prices[i]) 
	 
	 */
	
	int maxProfitByOneTransaction(int prices[])
	{
		int T_i10=0,T_i11=Integer.MIN_VALUE;
		
		for(int price:prices)
		{
			T_i10=Math.max(T_i10,T_i11+price);
			T_i11=Math.max(T_i11,-price);
		}
		return T_i10;
	}
	
	
	
	
	
	
	/*
	 * Case 2:k=infinite
	 * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
	   T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])=max(T[i-1][k][1],T[i-1][k][0]-prices[i])
	 * 
	 */
	
	int maxProfitByInfiniteTransaction(int prices[])
	{
		int T_ik0=0,T_ik1=Integer.MIN_VALUE;
		int old_ik0=0;
		
		for(int price:prices)
		{
			old_ik0=T_ik0;
			T_ik0=Math.max(T_ik0, T_ik1+price);
			T_ik1=Math.max(T_ik1,old_ik0-price);
		}
		return T_ik0;
	}
	
	

	/*
	 * 
	 * Case3:k=2
	 * T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
	   T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
       T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
       T[i][1][1] = max(T[i-1][1][1], -prices[i])
	 */
	
	int maxProfitByAtmostTwoTransaction(int prices[])
	{
		int T_i20=0,T_i21=Integer.MIN_VALUE;
		int T_i10=0,T_i11=Integer.MIN_VALUE;
		
		for(int price:prices)
		{
			T_i20=Math.max(T_i20,T_i21+price);
			T_i21=Math.max(T_i21,T_i10-price);
			T_i10=Math.max(T_i10, T_i11+price);
			T_i11=Math.max(T_i11,-price);
		}
		return T_i20;
	}
	
	/*
	 * Case 3:k is Arbitrary
	 * DP approach
	 * 
	 */
	
	int maxProfitbyKTransaction(int prices[],int k)
	{
		if(k>=prices.length/2)
		{
			return maxProfitByInfiniteTransaction(prices);
		}
		int n=prices.length;
		int T_ik0[]=new int[k+1];
		int T_ik1[]=new int[k+1];
		Arrays.fill(T_ik1, Integer.MIN_VALUE);
		
		for(int price:prices)
		{
			for(int i=1;i<=k;i++)
			{
				T_ik0[i]=Math.max(T_ik0[i],T_ik1[i]+price);
				T_ik1[i]=Math.max(T_ik1[i],T_ik1[i-1]-price);
			}
		}
		return T_ik0[k];
	}
	
	
	/*
	 * case 4:infinity but with cooldown
	 * we cannot buy on ith day if stock was sold at i-1th day
	 * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
	   T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
	 * 
	 */
	
	int maxProfitByInfiniteTransactionButWithCoolDown(int prices[])
	{
	    int T_ik0=0,T_ik1=Integer.MIN_VALUE;
	    int oldT_ik0=0,preT_ik0=0;
	    for(int price:prices)
	    {
	    	oldT_ik0=T_ik0;
	    	T_ik0=Math.max(T_ik0,T_ik1+price);
	    	T_ik1=Math.max(T_ik1, preT_ik0-price);
	    	preT_ik0=oldT_ik0;
	    }
	    return T_ik0;
	}
	
	/*
	 * case 5:k=infinite with transaction fee
	 * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
	   T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i] - fee)	//buying transaction fees
	   or
	   T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i] - fee)	//selling transaction fees
       T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
	 * 
	 */
	
	   int maxProfitInfiniteWithTransactionFee(int[] prices, int fee) {
	    int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
	    
	    for (int price : prices) {
	        int T_ik0_old = T_ik0;
	        T_ik0 = Math.max(T_ik0, T_ik1 + price);
	        T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
	    }
	        
	    return T_ik0;
	}
public static void main(String aa[]) throws Exception
{
	
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
