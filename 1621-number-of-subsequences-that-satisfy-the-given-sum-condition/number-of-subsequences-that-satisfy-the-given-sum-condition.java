class Solution {
    int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
       Arrays.sort(nums);
       int n=nums.length;
       int[] power = new int[n];
       power[0] = 1;

       for(int i=1;i<n;i++){
        power[i] = (power[i - 1] * 2) % MOD;
        }
        int left = 0;
        int right = n - 1;
        int count = 0;

        while(left<=right){
            if(nums[left]+nums[right] <= target){
                count=(count+power[right-left])%MOD;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}