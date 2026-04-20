import java.io.*;
import java.util.*;

public class Main {
    private static int cnt = 0;
    
    
    private static void merge_sort(int[] a, int left, int right, int k) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(a, left, mid, k);
            if (cnt == k) {
                return;
            }
            merge_sort(a, mid + 1, right, k);
            if (cnt == k) {
                return;
            }
            merge(a, left, mid, right, k);
            if (cnt == k) {
                return;
            }
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int k) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++];
            }
            else {
                tmp[t++] = a[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = a[i++];
        }
        while (j <= right) {
            tmp[t++] = a[j++];
        }
        i = left;
        t = 0;
        
        while (i <= right) {
            a[i++] = tmp[t++];
            cnt++;
            if (cnt == k) {
                return;
            }
        }
    }
    
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(a, 0, n-1, k);
        if (cnt == k) {
            for (int num : a) {
                System.out.print(num + " ");
            }
        }
        else {
            System.out.println(-1);
        }
    }

}