import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            stack.push(input.charAt(i));

            if(stack.size() >= bomb.length()){
                boolean flag = true;

                for(int j = 0; j < bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(int j = 0; j < bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        for(int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i));
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}