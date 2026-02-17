class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = (dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);

        int quotient = 0;

        while(divid >= divis){
            int count = 0;

            while(divid>=(divis<<(count+1))){
                count++;
            }

            quotient += (1 << count);
            divid -= divis<< count;
        }

        if(quotient == (1<<31) && sign)  return Integer.MAX_VALUE;
        if(quotient == (1<<31) && !sign) return Integer.MIN_VALUE;

        return sign ? quotient: -1 * quotient;
    }
}