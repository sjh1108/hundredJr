import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //int N = s.nextInt();
        //int k = s.nextInt();

        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        //int max = 0;
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            //arr[i] = s.nextInt();
            list.add(a);
        }
       
        //Collections.sort(list);
        SORT.mergeSort(arr);
        
        for(int value: arr){
            sb.append(value).append(' ');
            //sb.append(value).append('\n');
        }

        System.out.println(sb);

        //s.close();
    }
}

class SORT{
    static int[] arr;
    static int[] sorted;

    public SORT(int[] ar, int sortCase){
        mergeSort(ar);
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
        }
    }
    static void mergeSort(int[] a){
        sorted = new int[a.length];

        mergeSort(a, 0, a.length - 1);
    }
}