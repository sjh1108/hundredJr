import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String str = br.readLine();

        int[] alpha = new int[26];

        for(int i = 0; i < str.length(); i++){
            int c = str.charAt(i) % 'A';
            alpha[c]++;
        }
        
        boolean isOneFlag = false;
        for(int i = 0; i < 26; i++){
            if(alpha[i] % 2 == 1){
                if(isOneFlag){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                isOneFlag = true;
            }
        }

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < alpha[i] / 2; j++){
                sb.append((char)(i + 'A'));
            }
        }
        String ans = sb.toString();
        StringBuilder reverse = sb.reverse();
        if(isOneFlag){
            for(int i = 0; i < 26; i++){
                if(alpha[i] % 2 == 1){
                    ans += (char)(i + 'A');
                    break;
                }
            }
        }
        ans += reverse.toString();
        System.out.println(ans);
    }
}