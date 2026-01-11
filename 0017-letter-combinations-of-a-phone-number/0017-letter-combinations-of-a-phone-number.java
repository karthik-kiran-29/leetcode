class Solution {
    private char[][] arr = {{'a','b','c'},
                    {'d','e','f'},
                    {'g','h','i'},
                    {'j','k','l'},
                    {'m','n','o'},
                    {'p','q','r','s'},
                    {'t','u','v'},
                    {'w','x','y','z'}};

    private List<String> finalStr = new ArrayList<>();
                    
    public List<String> letterCombinations(String digits) {

        int n = digits.length();
        
        backtrack(0,digits,n,"");

        return finalStr;
    }

    public void backtrack(int i,String digits,int n,String temp){
        if(i>=n){
            finalStr.add(new String(temp));
            return;
        }

        int idx = digits.charAt(i) - '0';

        char[] rangeArr = arr[idx-2];

        for(char tempChar:rangeArr){
            backtrack(i+1,digits,n,temp+tempChar);
        }
    }
}