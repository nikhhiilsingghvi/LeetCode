class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        int nse=0,pse=0;
        int element=0;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                element=st.peek();
                st.pop();
                nse=i;
                pse=st.isEmpty() ? -1:st.peek();
                maxArea=Math.max(heights[element]*(nse-pse-1),maxArea);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nse=n;
            element=st.peek();
            st.pop();
            pse=st.isEmpty() ? -1:st.peek();
            maxArea=Math.max(heights[element]*(nse-pse-1),maxArea);
        }
        return maxArea;
    }
}