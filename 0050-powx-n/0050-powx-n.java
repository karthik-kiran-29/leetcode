class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            return 1/powHelper(x,-n);
        }

        return powHelper(x,n);
    }

    private double powHelper(double x, int n){
        if(n==0){
            return 1;
        }
        
        if(n==1 || n ==1.00 || n==-1){
            return x;
        }

        if(n % 2 == 0){
            return powHelper(x * x,n/2);
        }

        return x * powHelper(x,n-1);
    }
}