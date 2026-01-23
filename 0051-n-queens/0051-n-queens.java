class Solution {

    private List<List<String>> finalList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        ArrayList<String> arr = new ArrayList<>();
        
        backtrack(n,0,arr);

        return finalList;
    }

    private void backtrack(int n,int i,List<String> arr){
        if(i==n){
            finalList.add(new ArrayList(arr));
            return;
        }

        for(int k=0;k<n;k++){
            if(checkPositionPossible(k,i,arr,n)){
                String colStr = buildString(k,n);
                arr.add(colStr);
                backtrack(n,i+1,arr);
                arr.remove(arr.size() - 1);
            }
        }
    }

    private boolean checkPositionPossible(int col,int row,List<String> arr,int n){
        for(int i=0;i<row;i++){
            if(arr.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //diagonal left
        int maxLeft = Math.min(col,row);
        for(int i = 1;i<=maxLeft;i++){
            if(arr.get(row - i).charAt(col - i) == 'Q'){
                return false;
            }
        }

        int maxRight = Math.min(row,n - col - 1);
        for(int i =1;i<=maxRight;i++){
            if(arr.get(row - i).charAt(col + i) == 'Q'){
                return false;
            }
        }

        return true;
    }

    private String buildString(int col,int n){
        String str = "";

        for(int i =0;i<n;i++){
            if(i==col){
                str+="Q";
            }else{
                str+=".";
            }
        }

        return str;
    }
}