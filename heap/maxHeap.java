import java.util.*;
import java.io.*;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
//maxHeap
class Test
{
	public static void main(String aa[])
	{
		MaxHeap m1=new  MaxHeap(10);
		m1.insert(10);
		m1.insert(40);
		m1.insert(60);
		System.out.print(m1.extractMax());
		System.out.print(m1.extractMax());
		
		
	}
}

class MaxHeap
{
	int heap[];
	int heapSize;
	int capacity;
	MaxHeap(int cap)
	{
		heapSize=0;
		capacity=cap;
		heap=new int[capacity];
	}
	
	int parent(int i) {return (i-1)/2;}
	int left(int i){return (2*i+1);}
	int right(int i){return (2*i+2);}
	
	void insert(int item)
	{
		if(heapSize==capacity)
			return;
		heapSize=heapSize+1;
		int i=heapSize-1;
		heap[heapSize-1]=item;
		while(i!=0&&heap[parent(i)]<heap[i])
		{
			int temp=heap[parent(i)];
			heap[parent(i)]=heap[i];
			heap[i]=temp;
			i=parent(i);
		}
	}
	
	int extractMax()
	{
		if(heapSize<=1)
			return Integer.MAX_VALUE;
		if(heapSize==1)
		{
			heapSize--;
			return heap[0];
		}
		int temp=heap[0];
		heap[0]=heap[heapSize-1];
		heapSize--;
		maxHeapHeapify(0);
		return temp;
	}
	void maxHeapHeapify(int i)
	{
		int l=left(i);
		int r=right(i);
		int largest=i;
		if(l<heapSize&&heap[l]>heap[i])
			largest=l;
		if(r<heapSize&&heap[r]>heap[largest])
			largest=r;
		if(largest!=i)
		{
			int temp=heap[largest];
			heap[largest]=heap[i];
			heap[i]=temp;
			maxHeapHeapify(largest);
		}
	}
}
