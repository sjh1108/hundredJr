import java.io.*;
import java.util.*;

class Main {
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = Math.abs(gcd(a, b));
            String key = (b/gcd) + "/" + (a/gcd);

            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
        }

        System.out.println(max);
    }
}