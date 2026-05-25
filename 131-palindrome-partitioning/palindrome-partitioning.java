class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        fnc(0,s,new ArrayList<>(),ans);
        return ans;
    }

    private void fnc(int i, String s, List<String> temp, List<List<String>> ans){
        int n=s.length();
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j=i;j<n;j++){
            if(isPalindrome(s,i,j)){
                temp.add(s.substring(i,j+1));
                fnc(j+1,s,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int l,int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}