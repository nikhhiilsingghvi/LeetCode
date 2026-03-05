class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        long nn=n;
        if(nn<0) nn=-1*nn;

        while (nn > 0) {
            if ((nn & 1) == 1){
                result = (result * x);
                nn=nn-1;
            }
            else{
                x=x*x;
                nn=nn/2;
            }
            
        }

        if(n<0) result=(double)(1.0)/(double)(result);
        return result;
    }
}