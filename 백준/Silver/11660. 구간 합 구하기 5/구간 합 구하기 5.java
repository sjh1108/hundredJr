import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(M--> 0){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            for(int i = x1; i <= x2; i++){
                sum += arr[i][y2] - arr[i][y1-1];
            }

            sb.append(sum);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}