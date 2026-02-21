class Solution {
    public long subArrayRanges(int[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            long largest=nums[i];
            long smallest=nums[i];

            for(int j=i+1;j<nums.length;j++){
                largest=Math.max(largest,nums[j]);
                smallest=Math.min(smallest,nums[j]);
                sum+=largest-smallest;
            }
        }
        return sum;
    }
}