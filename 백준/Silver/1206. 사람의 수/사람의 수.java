import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), ".");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = a * 1000 + b;
        }

        for(int i = 1; i <= 1000; i++){
            if(isPossibleCnt(i)){
                System.out.println(i);
                return;
            }
        }
    }

    static boolean isPossibleCnt(int cntOfPeople){
        for(int avg : arr){
            int left = 0;
            int right = 10 * cntOfPeople;

            boolean isPossible = false;

            while(left <= right){
                int sumOfScore = (left + right) / 2;
                int currentAvg = (sumOfScore * 1000) / cntOfPeople;

                if(currentAvg == avg){
                    if(currentAvg > 10 * 1000){
                        continue;
                    }
                    isPossible = true;
                    break;
                } else if(currentAvg > avg){
                    right = sumOfScore - 1;
                } else {
                    left = sumOfScore + 1;
                }
            }

            if(!isPossible) return false;
        }

        return true;
    }
}