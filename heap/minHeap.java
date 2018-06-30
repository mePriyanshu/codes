import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//Min heap Implementation
class Test
{
	public static void main(String aa[])
	{
		MinHeap m1=new MinHeap(10);
		m1.insert(10);
		m1.insert(20);
		m1.insert(30);
		//System.out.print(m1.extractMin());
		m1.deleteKey(200);
		System.out.print(m1.extractMin());
		System.out.print(m1.extractMin());
		System.out.print(m1.extractMin());
	}
}


class MinHeap
{
	int heap[];
	int capacity;
	int heapSize;
	MinHeap(int cap)
	{
		heapSize=0;
		capacity=cap;
		heap=new int[capacity];
	}
	int parent(int i)					//parent node
	{
		return (i-1)/2;
	}
	
	int left(int i)						//left child node
	{
		return (2*i+1);
	}
	
	int right(int i)					//right child node
	{
		return (2*i+2);
	}
	
	void insert(int item)
	{
		if(heapSize==capacity)
			return;
		heapSize++;
		int i=heapSize-1;
		heap[i]=item;
		while(i!=0&&heap[parent(i)]>heap[i])
		{
			int temp=heap[parent(i)];
			heap[parent(i)]=heap[i];
			heap[i]=temp;
			i=parent(i);	
		}
	}
	
	
	int extractMin()
	{
		if(heapSize<=0)
		  return Integer.MAX_VALUE;
		if(heapSize==1)
		{
			heapSize--;
			return heap[0];
		}
		int temp=heap[0];
		heap[0]=heap[heapSize-1];
		heapSize--;
		minHeapHeapify(0);
		return temp;
	}
	
	void deleteKey(int i)
	{

		if(i>capacity)
			return;
		int temp=heap[i];
		if(heapSize<=0)
			return;
		if(heapSize==1)
			heapSize--;
		else{
		int sw=heap[i];
		heap[i]=heap[heapSize-1];
		heap[heapSize-1]=sw;
		heapSize--;
		minHeapHeapify(0);}
		System.out.println(temp);	
	}
	void minHeapHeapify(int i)
	{
		int l=left(i);
		int r=right(i);
		int smallest=i;
		if(l<heapSize&&heap[l]<heap[i])
			smallest=l;
		if(r<heapSize&&heap[r]<heap[smallest])
			 smallest=r;
		if(smallest!=i)
		{
			int temp=heap[i];
			heap[i]=heap[smallest];
			heap[smallest]=temp;
			minHeapHeapify(smallest);
		}
	}
}