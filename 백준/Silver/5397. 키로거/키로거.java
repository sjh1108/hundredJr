import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();
            
            Deque<Character> dq = new ArrayDeque<>();
            Deque<Character> temp = new ArrayDeque<>();
            int len = arr.length;

            for(int j = 0; j < len; j++){
                if(arr[j] == '<'){
                    if(dq.isEmpty()){
                        continue;
                    } else{
                        temp.addLast(dq.pollLast());
                    }
                }
                else if(Character.isAlphabetic(arr[j]) || Character.isDigit(arr[j])){
                    dq.addLast(arr[j]);
                }
                else if(arr[j] == '>'){
                    if(temp.isEmpty()){
                        continue;
                    } else{
                        dq.addLast(temp.pollLast());
                    }
                }
                else if(arr[j] == '-'){
                    if(dq.isEmpty()){
                        continue;
                    } else{
                        dq.pollLast();
                    }
                }
            }

            if(!temp.isEmpty()){
                while(!temp.isEmpty()){
                    dq.addLast(temp.pollLast());
                }
            }

            while(!dq.isEmpty()){
                sb.append(dq.pollFirst());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}