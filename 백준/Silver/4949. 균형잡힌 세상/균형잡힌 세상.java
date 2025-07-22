import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(true){
            char[] sequence = br.readLine().toCharArray();
            if(sequence[0] == '.') break;

            boolean flag = true;
            for(char c: sequence){
                if(c == '['){
                    stack.push(c);
                } else if(c == '('){
                    stack.push(c);
                }

                else if(c == ']'){
                    if(stack.size() > 0 && stack.peek() == '['){
                        stack.pop();
                    } else{
                        flag = false;
                        break;
                    }
                }
                else if(c == ')'){
                    if(stack.size() > 0 && stack.peek() == '('){
                        stack.pop();
                    } else{
                        flag = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) {
                flag = false;
                while(!stack.isEmpty()) stack.pop();
            }

            if(flag) sb.append("yes");
            else     sb.append("no");

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
