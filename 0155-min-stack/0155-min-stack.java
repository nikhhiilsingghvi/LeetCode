class MinStack {
    Stack<Long> st=new Stack<>();
    long mini=Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        long x=val;
        if(st.isEmpty()){
            mini=x;
            st.push(x);
        }
        else{
            if(x>=mini) st.push(x);
            else{
                st.push(2*x-mini);
                mini=x;
            }
        }
    }
    
    public void pop() {
        long x=st.peek();
        st.pop();
        if(x<mini){
            mini=2*mini-x;
        }
    }
    
    public int top() {
        long x=st.peek();
        if(mini<x) return (int)x;
        return (int)mini;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */