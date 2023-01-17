import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int max = -1000000002;
    static int min = 1000000002;
    static int M = 1;

    static int[] arr;
    static int[] pm;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        pm = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            pm[i] = Integer.parseInt(st.nextToken());

            if(pm[i] == N - 1){
                max = arr[0];
                for(int j = 1; j < N; j++){
                    switch(i){
                        case 0:
                        max += arr[j];
                        break;
                        case 1:
                        max -= arr[j];
                        break;
                        case 2:
                        max *= arr[j];
                        break;
                        case 3:
                        max /= arr[j];
                        break;
                    }
                }
                System.out.println(max);
                System.out.println(max);
                System.exit(0);
            }
        }

        
        calculate(arr[0], 1);

        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    static void calculate(int n, int tmp){
        if(tmp == N){
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(pm[i] > 0){
                pm[i]--;

                switch(i){
                    case 0:
                        n += arr[tmp];
                        calculate(n, tmp + 1);
                        n -= arr[tmp];
                        break;
                    case 1:
                        n -= arr[tmp];
                        calculate(n, tmp + 1);
                        n += arr[tmp];
                        break;
                    case 2:
                        n *= arr[tmp];
                        calculate(n, tmp + 1);
                        n /= arr[tmp];
                        break;
                    case 3:
                        n /= arr[tmp];
                        calculate(n, tmp + 1);
                        n *= arr[tmp];
                        break;
                }

                pm[i]++;
            }
        }
    }
}