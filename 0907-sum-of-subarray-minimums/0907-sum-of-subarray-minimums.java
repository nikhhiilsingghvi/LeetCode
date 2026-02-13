class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int[] nse = findnse(arr);
        int[] pse = findpsee(arr);
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum = (sum + (right * left % mod * arr[i]) % mod) % mod;
        }
        return (int)sum;
    }

    public int[] findnse(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findpsee(int[] nums) {
        int n = nums.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if (st.isEmpty())
                psee[i] = -1;
            else
                psee[i] = st.peek();
            st.push(i);
        }
        return psee;
    }
}