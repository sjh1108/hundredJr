import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{
                Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken())
            };
        }

        int[] ans = new int[N+1];
        Arrays.fill(ans, 1 << 30);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int x = arr[i][0];
                int y = arr[j][1];

                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for(int k = 0; k < N; k++){
                    pq.add(getDistance(x, y, arr[k][0], arr[k][1]));
                }

                int cnt = 0;
                int sum = 0;
                while(!pq.isEmpty()){
                    sum += pq.poll();

                    if(ans[cnt + 1] > sum){
                        ans[cnt + 1] = sum;
                    }
                    
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++)
            sb.append(ans[i] + " ");
        System.out.println(sb);
    }

    private static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}