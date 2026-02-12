import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] arr;
    private static int[][] psum;
    
    // N이 최대 30, 값이 -1000~1000 범위이므로 합의 범위는 넉넉잡아 설정
    private static final int OFFSET = 2000000;
    private static int[] countArr = new int[OFFSET * 2 + 1];

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
                
                // ------------------------------------------------
                // Case 1: \ 방향 (왼쪽 위 -> 오른쪽 아래)
                // ------------------------------------------------
                
                // 1. 왼쪽 위 영역 (기록)
                for (int r = 1; r <= i; r++) {
                    for (int c = 1; c <= j; c++) {
                        int sum = getSum(r, c, i, j);
                        countArr[sum + OFFSET]++; // 배열에 카운팅
                    }
                }

                // 2. 오른쪽 아래 영역 (확인 및 정답 누적)
                for (int r = i + 1; r <= N; r++) {
                    for (int c = j + 1; c <= N; c++) {
                        int sum = getSum(i + 1, j + 1, r, c);
                        ans += countArr[sum + OFFSET]; // 배열에서 O(1) 조회
                    }
                }

                // 3. 배열 초기화 (중요: 전체 초기화가 아니라 기록했던 곳만 되돌림)
                for (int r = 1; r <= i; r++) {
                    for (int c = 1; c <= j; c++) {
                        int sum = getSum(r, c, i, j);
                        countArr[sum + OFFSET]--; // 0으로 원상복구
                    }
                }

                // ------------------------------------------------
                // Case 2: / 방향 (오른쪽 위 -> 왼쪽 아래)
                // ------------------------------------------------
                
                // 1. 오른쪽 위 영역 (기록)
                for (int r = 1; r <= i; r++) {
                    for (int c = j + 1; c <= N; c++) {
                        int sum = getSum(r, j + 1, i, c);
                        countArr[sum + OFFSET]++;
                    }
                }

                // 2. 왼쪽 아래 영역 (확인 및 정답 누적)
                for (int r = i + 1; r <= N; r++) {
                    for (int c = 1; c <= j; c++) {
                        int sum = getSum(i + 1, c, r, j);
                        ans += countArr[sum + OFFSET];
                    }
                }
                
                // 3. 배열 초기화
                for (int r = 1; r <= i; r++) {
                    for (int c = j + 1; c <= N; c++) {
                        int sum = getSum(r, j + 1, i, c);
                        countArr[sum + OFFSET]--;
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