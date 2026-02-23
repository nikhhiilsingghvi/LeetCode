class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix[0].length;
        int[] height=new int[m];
        int maxArea=0;

        for(char[] row:matrix){
            for(int i=0;i<m;i++){
                if(row[i]=='1') height[i]++;
                else height[i]=0;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;
    }

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