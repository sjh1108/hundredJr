import java.io.*;
import java.util.*;

class Main {
    private static long N, P, Q, X, Y;

    private static HashMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());

        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        map = new HashMap<>();

        System.out.println(dfs(N));
    }

    private static long dfs(long n){
        if(n <= 0) return 1;
        if(map.containsKey(n)) return map.get(n);

        long p = dfs(Math.floorDiv(n, P) - X);
        long q = dfs(Math.floorDiv(n, Q) - Y);

        map.put(n, p+q);
        
        return p + q;
    }
}