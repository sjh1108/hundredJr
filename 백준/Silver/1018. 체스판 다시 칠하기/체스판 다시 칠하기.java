//import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][] chess = new boolean[N][M];
        int n = N - 7;
        int m = M - 7;
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'B'){
                    chess[i][j] = true;
                }
            }
        }
        int min = 64;
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean start = chess[i][j];
                for(int p = i; p < i + 8; p++){
                    for(int q = j; q < j + 8; q++){
                        if(((p - i) + (q - j)) % 2 == 1){
                            if(start != chess[p][q]) {
                                sum++;
                            }
                        } else{
                            if(start == chess[p][q]) {
                                sum++;
                            }
                        }
                    }
                }

                sum = Math.min(sum, 64 - sum);
                min = Math.min(sum, min);
                sum = 0;
                if(min == 0) {
                    System.out.println(0);
                    System.exit(0);
                }
            }
        }

        
        
        System.out.println(min);
    }
}