class Solution {
    private List<List<String>> finalList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();

        int n = s.length();

        backtrack(0,list,s,n);

        return finalList;
    }

    private void backtrack(int i,List<String> list,String s,int n){
        if(i==n){
            finalList.add(new ArrayList<>(list));
            return;
        }

        for(int k=i;k<n;k++){
            if(isPalindrome(s,i,k)){
                list.add(s.substring(i,k+1));
                backtrack(k+1,list,s,n);
                list.remove(list.size()-1);
            }
        }

        return;
    }

    private boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++; 
            end--;
        }

        return true;
    }

}