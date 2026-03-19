import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int farr[][] = new int[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();

            for(int j = 0; j < N; j++){
                char c = s.charAt(j);

                if(c == 'N'){
                    farr[i][j] = 0;
                } else{
                    farr[i][j] = 1;
                }
            }
        }

        int arr[] = new int[N];
        int max = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(farr[i][j] == 1){
                    arr[i]++;
                    continue;
                }
                
                for(int k = 0; k < N; k++){
                    if(k == i || k == j) continue;

                    if(farr[i][k] == 1 && farr[k][j] == 1){
                        arr[i]++;
                        break;
                    }
                }
            }
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}