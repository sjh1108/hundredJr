//import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        SORT.mergeSort(arr, K);
        sb.append(SORT.chk);

        System.out.println(sb);
    }
}
class SORT{
    static int[] arr;
    static int[] sorted;

    static int ncnt = 0;
    static int cnt = 1;
    static int chk = -1;

    public SORT(int[] ar, int sortCase){
        arr = ar;
        switch(sortCase){
            case 0:
            //arr = quickSort(ar);
            case 1:
            //mergeSort(ar);
        }
    }

    public SORT(int K){
        ncnt = K;
    }

    /**
     * @param a     정렬할 배열
     * @param start 배열의 시작점
     * @param end   배열의 끝 점
     */
    private static void mergeSort(int[] a, int start, int end){
        if(start == end){
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);

        merge(a, start, mid, end);
    }
    /**
     * @param a     정렬할 배열
     * @param start 배열의 시작점
     * @param mid   배열의 중간점
     * @param end   배열의 끝 점
     */
    private static void merge(int[] a, int start, int mid, int end){
        int pp = start;
        int np = mid + 1;

        int idx = start;

        while(pp <= mid && np <= end){
            if(a[pp] < a[np]){
                sorted[idx] = a[pp];
                idx++; pp++;
            } else{
                sorted[idx] = a[np];
                idx++; np++;
            }
        }
        if(pp > mid){
            while(np <= end){
                sorted[idx] = a[np];
                idx++; np++;
            }
        }
        if(np > end){
            while(pp <= mid){
                sorted[idx] = a[pp];
                idx++; pp++;
            }
        }

        for(int i = start; i <= end; i++){
            a[i] = sorted[i];
            if(cnt == ncnt){
                chk = sorted[i];
                cnt++;
            } else if(cnt < ncnt){
                cnt++;
            }
        }
    }
    /**
     * @param mergeSort 병합정렬 
     * @param a
     */
    static void mergeSort(int[] a, int K){
        sorted = new int[a.length];
        ncnt = K;
        mergeSort(a, 0, a.length - 1);
    }

}