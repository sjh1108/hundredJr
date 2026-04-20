import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] input, check;
    static boolean[] visited;
    static int flags = 0;
    
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        input = new String[N];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            input[i] = br.readLine();
            set.add(input[i]);
            if(input[i].equals("?")){
                flags = i;
            }
        }

        M = Integer.parseInt(br.readLine());
        check = new String[M];
        visited = new boolean[M];
        for(int i = 0; i < M; i++) {
            check[i] = br.readLine();
            if(set.contains(check[i])) {
                visited[i] = true;
            }
        }

        for(int i = 0; i < M; i++){
            if(visited[i]) continue;
            String s = check[i];
            char start = s.charAt(0), end = s.charAt(s.length() - 1);

            boolean flag = true;
            if(flags > 0){
                if(input[flags - 1].charAt(input[flags - 1].length() - 1) != start) flag = false;
            }
            if(flags < N - 1){
                if(input[flags + 1].charAt(0) != end) flag = false;
            }

            if(flag){
                System.out.println(s);
                return;
            }
        }
    }
}
