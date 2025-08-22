import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] dx = {-2, 0, 2, 0};
    private static int[] dy = {0, -2, 0, 2};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Pair> initialPositions = new HashSet<>();
        List<Pair> dabbabas = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair currentPos = new Pair(x, y);
            initialPositions.add(currentPos);
            dabbabas.add(currentPos);
        }

        Set<Pair> destinationPositions = new HashSet<>();
        
        for (Pair p : dabbabas) {
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (isIn(nx, ny) && !initialPositions.contains(new Pair(nx, ny))) {
                    destinationPositions.add(new Pair(nx, ny));
                }
            }
        }

        System.out.println(destinationPositions.size());
    }

    private static boolean isIn(int x, int y) {
        return (x > 0 && x <= N) && (y > 0 && y <= N);
    }
}