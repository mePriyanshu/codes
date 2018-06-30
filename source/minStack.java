class MinStack {

    /** initialize your data structure here. */
   int a[];
	int top;
	int min;
    
    public MinStack() {
        a=new int[100000];
		top=-1;
		min=Integer.MAX_VALUE;
    }
    boolean isEmpty()
	{
		return (top==-1);
	}
    public void push(int item) {
      if(item<=min)
		{
			a[++top]=min;
			min=item;
		}
		a[++top]=item;
        
    }
    
    public void pop() {
        if(isEmpty())
			return;
		if(a[top--]==min) min=a[top--];
		
    }
    
    public int top() {
        return a[top];
    }
    
    public int getMin() {
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
