import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char s[] = br.readLine().toCharArray();

        int cnt = 0;
        int len = 0;
        for(int i = 1; i < m - 1; i++){
            if(s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I'){
                len++;
                
                if(len == n){
                    len--;
                    cnt++;
                }
                i++;
            }
            else{
                len = 0;
            }
        }

        System.out.println(cnt);
    }
}