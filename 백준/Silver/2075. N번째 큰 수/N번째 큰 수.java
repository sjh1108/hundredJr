import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                pq.add(arr[i][j]);
            }
        }

        for(int i = 0; i < n-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}