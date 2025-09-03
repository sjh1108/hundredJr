import java.util.Scanner;

public class Solution {
    private static int N, M, C;
    private static int max;

    private static int[][] map;
    private static int[][] dp;

    private static int getDpValue(int x, int y){
        int max = 0;
        
        for(int i = 1; i < (1 << M); i++){
            int sum = 0;

            for(int b = 0; b < M; b++){
                if((i & (1 << b)) != 0){
                    sum += map[x][y + b];
                }
            }

            if(sum <= C){
                sum = 0;

                for(int b = 0; b < M; b++){
                    if((i & (1 << b)) != 0){
                        sum += map[x][y + b] * map[x][y + b];
                    }
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    private static void getMaxCombi(int x, int y){
        int sum = dp[x][y];
        
        for(int j = y + M; j < N - M + 1; j++){
            max = Math.max(max, sum + dp[x][j]);
        }
        for(int i = x+1; i < N; i++){
            for(int j = 0; j < N - M + 1; j++){
                max = Math.max(max, sum + dp[i][j]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new java.io.FileInputStream("sample_input.txt"));
        
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            map = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            dp = new int[N][N-M+1];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N - M + 1; j++){
                    dp[i][j] = getDpValue(i, j);
                }
            }

            // int[][] tmp = dp;

            // for(int[] a: dp){
            //     for(int i: a){
            //         System.out.print(i + " ");
            //     }
            //     System.out.println();
            // }

            max = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N - M + 1; j++){
                    getMaxCombi(i, j);
                }
            }

            System.out.println("#" + t + " " + max);
        }

        sc.close();
    }
}
