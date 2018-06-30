import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Test{
public static final int N=4;

boolean isSafe(int a[][],int row,int col)
{
	int i=0,j=0;
	for(i=0;i<=col;i++)						//checking for rows
	{
		if(a[row][i]==1)
			return false;
	}
	for(i=row,j=col;i>=0&&j>=0;i--,j--)			//check for leading diagonol
	{
		if(a[i][j]==1)return false;
	}
	
	for(i=row,j=col;i<N&&j>=0;i++,j--)			//check for off diagonal
	{
		if(a[i][j]==1)
			return false;
	}
	return true;
}

void print(int a[][])
{
System.out.print("[");
	for(int i=0;i<a.length;i++)
	{
		for(int j=0;j<a[0].length;j++)
		{
			//System.out.print(a[i][j]+" ");
			if(a[i][j]==1)
				System.out.print(j+1+" ");
			
		}
		//System.out.print("\n");
	}
	System.out.print("]"+" ");
	
	//System.out.println();
}

boolean nQueenUtil(int a[][],int col)
{
	if(col==N){
		print(a);
		return true;
	}
	for(int i=0;i<N;i++)
	{
		if(isSafe(a,i,col)){
			a[i][col]=1;
		nQueenUtil(a,col+1);	
		/*if(nQueenUtil(a,col+1))
			return true;*/
	a[i][col]=0;			
	}			
	}
	return false;
}
void nQueen(int a[][])
{
	if(nQueenUtil(a,0))
	{	System.out.print("Not Possible");
		return;
	}	
	//print(a);
}
void initialize(int a[][])
{
	for(int i=0;i<a.length;i++)
	{
		for(int j=0;j<a[0].length;j++)
			a[i][j]=0;
	}
}
public static void main(String aa[])
{
	int a[][]=new int[N][N];
	Test t1=new Test();
	t1.initialize(a);
	t1.nQueen(a);
}
}