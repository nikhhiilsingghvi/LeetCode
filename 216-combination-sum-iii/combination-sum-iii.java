class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        fnc(1,k,n,ans,new ArrayList<>());
        return ans;
    }

    private void fnc(int num,int k,int n,List<List<Integer>> ans,List<Integer> ds){
        if(n==0 && ds.size()==k) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(num > 9 || ds.size()>k || n < 0) return;

        ds.add(num);
        fnc(num+1,k,n-num,ans,ds);
        ds.remove(ds.size()-1);
        fnc(num+1,k,n,ans,ds);
    }
}