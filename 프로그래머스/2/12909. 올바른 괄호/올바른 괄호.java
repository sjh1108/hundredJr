import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            
            if(c == '('){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }
}