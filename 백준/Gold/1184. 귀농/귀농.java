import java.io.*;
import java.util.*;

class Main {
    private static int N;
    private static int[][] arr;
    private static int[][] psum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        psum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + arr[i][j];
            }
        }

        long ans = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {

                Map<Integer, Integer> map = new HashMap<>();
                
                // \
                for (int r = 1; r <= i; r++) {
                    for (int c = 1; c <= j; c++) {
                        int sum = getSum(r, c, i, j);
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                    }
                }

                for (int r = i + 1; r <= N; r++) {
                    for (int c = j + 1; c <= N; c++) {
                        int sum = getSum(i + 1, j + 1, r, c);
                        if (map.containsKey(sum)) {
                            ans += map.get(sum);
                        }
                    }
                }

                map.clear();
                
                // /
                for (int r = 1; r <= i; r++) {
                    for (int c = j + 1; c <= N; c++) {
                        int sum = getSum(r, j + 1, i, c);
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                    }
                }

                for (int r = i + 1; r <= N; r++) {
                    for (int c = 1; c <= j; c++) {
                        int sum = getSum(i + 1, c, r, j);
                        if (map.containsKey(sum)) {
                            ans += map.get(sum);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static int getSum(int r1, int c1, int r2, int c2) {
        return psum[r2][c2] - psum[r1 - 1][c2] - psum[r2][c1 - 1] + psum[r1 - 1][c1 - 1];
    }
}