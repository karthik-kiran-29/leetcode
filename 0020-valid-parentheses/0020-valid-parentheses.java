class Solution {
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();

        Stack <Character> stack = new Stack<>();

        for(int i=0;i<charArr.length;i++){
            switch(charArr[i]){
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                    break;
            }
        }

        if(stack.size()>0){
            return false;
        }

        return true;
    }
}