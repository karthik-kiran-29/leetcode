class Solution {
    public int myAtoi(String s) {
        return AtoiHelper(s, 0, 0, 1, false);  
    }

    private int AtoiHelper(String s, int idx, int res, int sign, boolean started) {  
        if(idx == s.length()) {
            return sign * res;  
        }
        
        char firstChar = s.charAt(idx);

        if(!started && firstChar == ' ') {
            return AtoiHelper(s, idx+1, res, sign, false);
        }

        if(!started && firstChar == '-') {
            return AtoiHelper(s, idx+1, res, -1, true);  
        }

        if(!started && firstChar == '+') {
            return AtoiHelper(s, idx+1, res, 1, true);
        }

        if(firstChar <= '9' && firstChar >= '0') {
            int digit = firstChar - '0';
            
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res *= 10;
            res += digit;
            return AtoiHelper(s, idx+1, res, sign, true);
        }

        return sign * res;
    }
}