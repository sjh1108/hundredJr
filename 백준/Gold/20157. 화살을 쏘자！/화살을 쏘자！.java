import java.util.*;
import java.io.*;

public class Main {

    // 유클리드 호제법
    public static int GCD(int x, int y) {
        if (y == 0) return x;
        return GCD(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = Math.abs(GCD(x, y)); // 기약분수 형태로 만들기 위해 GCD구하기.
            String slope = y / gcd + "/" + x / gcd; // 두 노드를 잇는 선의 기울기 구하기
            map.put(slope, map.getOrDefault(slope, 0) + 1);
            answer = Math.max(answer, map.get(slope));
        }
        System.out.println(answer);
    }
}