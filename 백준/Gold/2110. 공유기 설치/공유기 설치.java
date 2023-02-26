import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[N - 1] - arr[0] + 1;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            if(canInstall(mid) < M){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }

    static int canInstall(int distance){
        int count = 1;
        int lastLocate = arr[0];

        for(int i = 1; i < arr.length; i++){
            int locate = arr[i];

            if(locate - lastLocate >= distance){
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }
}