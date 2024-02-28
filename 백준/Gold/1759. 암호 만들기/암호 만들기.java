import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    static char[] arr, output;
    static char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new char[M];
        output = new char[N];
        for(int i = 0; i < M; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, 0, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int idx, int start, int con, int vow){
        if(idx == N){
            if(con >= 2 && vow >= 1){
                for(int i = 0; i < N; i++){
                    sb.append(output[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i < M; i++){
            output[idx] = arr[i];
            if(isVowel(arr[i])){
                dfs(idx + 1, i + 1, con, vow + 1);
            } else {
                dfs(idx + 1, i + 1, con + 1, vow);
            }
        }
    }

    static boolean isVowel(char c){
        for(int i = 0; i < 5; i++){
            if(c == vowel[i]) return true;
        }
        return false;
    }
}