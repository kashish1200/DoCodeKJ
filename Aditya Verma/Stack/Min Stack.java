//using extra space - TC O(n) SC O(n)
//ek supporting stack lia hai ss, usme min element daal rhe hai compare krke uske top se, and 
//pop krne ke liye agar st(main) stack me se element pop ho raha hai,wahi ss ke top pr bhi hai toh usko bhi pop krdo
class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> ss = new Stack<>();

    public MinStack() {
    }
    //Imp.. <= lagana hai (not <) kyuki arr[i] - 0 1 0' 2...pop hua pehle 0' fir agar 0 ko pop krenge toh element hoga hi nahi stack ss me
    public void push(int val) {
        st.push(val);
        if(ss.isEmpty() || val <= ss.peek()){
            ss.push(val);
        }
        
    }
    
    public void pop() {
        int popped = st.pop();
        if(!ss.isEmpty() && ss.peek() == popped){
            ss.pop();
        }
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        if(!ss.isEmpty()){
            return ss.peek();
        }
        return -1;
    }
}

//Do without extra space, samjh nahi aaya itna
