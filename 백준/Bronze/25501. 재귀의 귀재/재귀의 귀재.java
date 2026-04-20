//import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            int a = isPalindrome(s);
            sb.append(a).append(' ');
            sb.append(count).append('\n');
        }


        System.out.println(sb);
    }

    static int recursion(String s, int l, int r){
        if(l >= r){
            count++;
            return 1;
        } else if(s.charAt(l) != s.charAt(r)){
            count++;
            return 0;
        } else{
            count++;
            return recursion(s, l + 1, r - 1);
        }
    }

    static int isPalindrome(String s){
        count = 0;
        return recursion(s, 0, s.length() - 1);
    }
}