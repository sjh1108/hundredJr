import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1, cnt = 0, m = 1_000_000;
        arr[0] = -1_000_000;
        boolean sorted = true, flag = true;

        for(int i = 1; i <= N; i++){
            if(arr[i] < arr[i-1]) {
                sorted = false;
                ++cnt;
            }

            if(cnt > 0 && arr[i] > arr[1]) flag = false;
        }

        if(sorted) System.out.println(1);
        else if(cnt == 1 && flag) System.out.println(2);
        else System.out.println(3);
    }
}