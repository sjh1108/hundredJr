import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int T;
    static int[] arrMachine = new int[2];
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int cntMachine = 0;
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == -1){
                    arrMachine[cntMachine++] = i;
                }
            }
        }


        for(int t = 0; t < T; t++){
            spreadDust();
            airCleaner();

            // sb.append('\n');
            // for(int i = 0; i < N; i++){
            //     for(int j = 0; j < M; j++){
            //         sb.append(arr[i][j] + " ");
            //     }
            //     sb.append('\n');
            // }
        }

        // System.out.println(sb);
        System.out.println(sumDust());
    }

    static void spreadDust(){
        int[][] temp = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] > 0){
                    int cnt = 0;
                    int spread = arr[i][j] / 5;

                    if(i - 1 >= 0 && arr[i - 1][j] != -1){
                        temp[i - 1][j] += spread;
                        cnt++;
                    }
                    if(i + 1 < N && arr[i + 1][j] != -1){
                        temp[i + 1][j] += spread;
                        cnt++;
                    }
                    if(j - 1 >= 0 && arr[i][j - 1] != -1){
                        temp[i][j - 1] += spread;
                        cnt++;
                    }
                    if(j + 1 < M && arr[i][j + 1] != -1){
                        temp[i][j + 1] += spread;
                        cnt++;
                    }

                    temp[i][j] += arr[i][j] - spread * cnt;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = temp[i][j];
            }
        }
    }

    static void airCleaner(){
        int up = arrMachine[0];
        int down = arrMachine[1];

        for(int i = up - 1; i > 0; i--){
            arr[i][0] = arr[i - 1][0];
        }
        for(int i = 0; i < M - 1; i++){
            arr[0][i] = arr[0][i + 1];
        }
        for(int i = 0; i < up; i++){
            arr[i][M - 1] = arr[i + 1][M - 1];
        }
        for(int i = M - 1; i > 1; i--){
            arr[up][i] = arr[up][i - 1];
        }
        arr[up][1] = 0;

        for(int i = down + 1; i < N - 1; i++){
            arr[i][0] = arr[i + 1][0];
        }
        for(int i = 0; i < M - 1; i++){
            arr[N - 1][i] = arr[N - 1][i + 1];
        }
        for(int i = N - 1; i > down; i--){
            arr[i][M - 1] = arr[i - 1][M - 1];
        }
        for(int i = M - 1; i > 1; i--){
            arr[down][i] = arr[down][i - 1];
        }
        arr[down][1] = 0;

        arr[up][0] = arr[down][0] = -1;
    }

    static int sumDust(){
        int sum = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] > 0){
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }
}