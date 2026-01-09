class Solution {
    private List<List<Integer>> finalList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        
        backtrack(0,arr,new ArrayList<Integer>(),k,n,0);

        return finalList;
    }

    private void backtrack(int i,int[] arr,List<Integer> list,int k,int n,int sum){
        if(sum>n) return;
        if(k==0 && sum==n){
            finalList.add(new ArrayList<>(list));
            return;
        }
        if(i>=arr.length){
            return;
        }
        if(k<0){
            return;
        }

        list.add(arr[i]);

        backtrack(i+1,arr,list,k-1,n,sum+arr[i]);

        list.remove(list.size()-1);

        backtrack(i+1,arr,list,k,n,sum);

    }
}