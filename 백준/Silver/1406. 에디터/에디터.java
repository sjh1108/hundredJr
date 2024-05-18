import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        N = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(int i=0; i<s.length(); i++){
            left.push(s.charAt(i));
        }

        while(N-->0){
            String str = br.readLine();
            char c = str.charAt(0);
            
            switch(c){
                case 'L':
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case 'P':
                    left.push(str.charAt(2));
                    break;
            }
        }

        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);
    }
}