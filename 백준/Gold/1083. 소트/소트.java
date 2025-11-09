import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());
 
        if (N*(N+1) / 2 < S) {
            Arrays.sort(arr, (a, b) -> b.compareTo(a));
            printArray(arr);
            return;
        }

        for (int k = 0; k < N && S > 0; k++) {
            int max = arr[k];
            int idx = -1;
            for (int i = k+1; i < N && i <= k+S; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    idx = i;
                }
            }

            if (idx == -1) continue;

            S -= idx-k;
            for (int i = idx; i >= k+1; i--) {
                int tmp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = tmp;
            }
        }

        printArray(arr);
    }

    private static void printArray(Integer[] arr){
        StringBuilder sb = new StringBuilder();
        for(int x: arr){
            sb.append(x + " ");
        }
        System.out.println(sb);
    }
}