class Solution {
    private static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenPos = (n+1)/2;
        long oddPos = n/2;

        long ans = (pow(5,evenPos) * pow(4,oddPos))% MOD;

        return (int)ans;
    }

    private long pow(long base,long power){
        if(power==0){
            return 1;
        }
        long value = 1;

        while(power>0){
            if(power%2==1){
                value = (value * base)%MOD;
            }
            base = (base * base)%MOD;
            power/=2;
        }

        return value;
    }
}