import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //int N = s.nextInt();
        //int k = s.nextInt();

        int[] arr = new int[N];
        //ArrayList<Integer> list = new ArrayList<>();
        //int max = 0;
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            //arr[i] = s.nextInt();
            //list.add(a);
        }
       
        //Collections.sort(list);
        SORT.mergeSort(arr);
        
        double sum = 0;
        int prev = 50000;
        int count = 0;
        int maxCount = 0;
        int multipleMaxCount = 0;
        int maxNum = 40000;
        for(int value: arr){
            sum += value;
            // 첫번째 인덱스일때 prev를 value로 설정 후 continue
            if(prev == 50000){
                prev = value;
                count = 1;
                continue;
            }

            if(prev == value){
                count++;
                if(count > maxCount){
                    maxCount = count;
                    maxNum = value;
                    multipleMaxCount = 0;
                } else if(count == maxCount){
                    multipleMaxCount++;
                    if(multipleMaxCount == 1){
                        maxNum = value;
                    }
                }
            } else{
                count = 1;
            }
            prev = value;
            //sb.append(value).append(' ');
            //sb.append(value).append('\n');
        }
        if(maxNum == 40000){
            if(arr.length <= 1){
                maxNum = arr[0];
            } else{
                maxNum = arr[1];
            }
        }
        int range = arr[arr.length - 1] - arr[0];

        System.out.println((int) (Math.round(sum / arr.length)));
        System.out.println(arr[arr.length / 2]);
        System.out.println(maxNum);
        System.out.println(range);

        //System.out.println(sb);

        //s.close();
    }
}

class SORT{
    static int[] arr;
    static int[] sorted;

    public SORT(int[] ar, int sortCase){
        arr = ar;
        switch(sortCase){
            case 0:
            arr = quickSort(ar);
            case 1:
            mergeSort(ar);
        }
    }
    public SORT(int[] ar){
        arr = quickSort(ar);
    }

    static int[] quickSort(int[] ar){
        int[] prev;
        int[] next;

        int len = ar.length;
        int pLength = 0, nLength = 0;

        if(ar.length == 0){
            return ar;
        } else if(ar.length == 1){
            return ar;
        } else if(ar.length == 2){
            if(ar[0] < ar[1]){
                return ar;
            }
            int k = ar[0];
            ar[0] = ar[1];
            ar[1] = k;
            return ar;
        }
        
        prev = new int[ar.length];
        next = new int[ar.length];

        int pivot = ar[0];

        for(int i = 1; i < len; i++){
            if(ar[i] < pivot){
                prev[pLength++] = ar[i];
            } else{
                next[nLength++] = ar[i];
            }
        }
        
        if(pLength > 1){
            prev = quickSort(Arrays.copyOf(prev, pLength));
        } else{
            prev = Arrays.copyOf(prev, pLength);
        }
        if(nLength > 1){
            next = quickSort(Arrays.copyOf(next, nLength));
        } else{
            next = Arrays.copyOf(next, nLength);
        }


        for(int i = 0; i < len; i++){
            if(i < pLength){
                ar[i] = prev[i];
            } else if(i == pLength){
                ar[i] = pivot;
            } else{
                ar[i] = next[i - pLength];
            }
        }
        
        return ar;
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
    /**
     * @param mergeSort 병합정렬 
     * @param a
     */
    static void mergeSort(int[] a){
        sorted = new int[a.length];

        mergeSort(a, 0, a.length - 1);
    }


    /**
     * @param a     정렬할 배열
     */
    static void countingSort(int[] a){
        sorted = new int[10001];
        int len = a.length;
        int count = 0;

        for(int i = 0; i < len; i++){
            sorted[a[i]]++;
        }
        for(int i = 0; i < 10001; i++){
            if(sorted[i] == 0) continue;
            for(int j = count; j < sorted[i] + count; j++){
                a[j] = i;
            }
            count += sorted[i];
            if(count == len) break;
        }
    }
}