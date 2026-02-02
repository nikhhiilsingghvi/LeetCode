class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor) return 1;

        boolean sign = true;
        if (dividend > 0 && divisor < 0) sign = false;
        if (dividend < 0 && divisor > 0) sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            long temp = d;
            long multiple = 1;

            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            n -= temp;
            ans += multiple;
        }

        return sign ? (int) ans : (int) -ans;
    }
}
