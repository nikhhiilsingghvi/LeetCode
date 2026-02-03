class Solution {
    public int hammingDistance(int x, int y) {
        int ans=x^y;
        int cnt=0;

        for(int i=0;i<32;i++){
            cnt+=ans&1;
            ans=ans>>1;
        }
        return cnt;
    }
}