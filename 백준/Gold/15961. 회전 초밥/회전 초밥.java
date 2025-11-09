import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] eaten = new int[d + 1];
        
        int uniqueCount = 0;

        for (int i = 0; i < k; i++) {
            if (eaten[arr[i]] == 0) {
                uniqueCount++;
            }
            eaten[arr[i]]++;
        }

        int maxCount = uniqueCount;
        if (eaten[c] == 0) {
            maxCount++;
        }

        for (int i = 1; i < n; i++) {
            
            int sushiToRemove = arr[i - 1];
            eaten[sushiToRemove]--;
            if (eaten[sushiToRemove] == 0) {
                uniqueCount--;
            }

            int sushiToAdd = arr[(i + k - 1) % n];
            if (eaten[sushiToAdd] == 0) {
                uniqueCount++;
            }
            eaten[sushiToAdd]++;

            int currentCount = uniqueCount;
            if (eaten[c] == 0) {
                currentCount++;
            }
            
            maxCount = Math.max(maxCount, currentCount);
        }

        System.out.println(maxCount);
    }
}