import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long count = 0;

        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < N; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = c1; c2 < N; c2++) {
                        if (isPermutation(r1, c1, r2, c2)) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    static boolean isPermutation(int r1, int c1, int r2, int c2) {
        int size = (r2 - r1 + 1) * (c2 - c1 + 1);
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int val = A[i][j];
                if (set.contains(val)) return false;
                set.add(val);
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }

        return set.size() == size && min == 1 && max == size;
    }
}
