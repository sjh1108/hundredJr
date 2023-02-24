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

        while(N != 0){
            arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, N - 1));
            sb.append('\n');
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);

    }

    static long getArea(int lo, int hi){
        if(lo == hi){
            return arr[lo];
        }

        int mid = (lo + hi) / 2;

        long leftArea =  getArea(lo, mid);
        long rightArea = getArea(mid + 1, hi);

        long max = Math.max(leftArea, rightArea);

        max = Math.max(max, getMidArea(lo, mid, hi));

        return max;
    }

    static long getMidArea(int lo, int mid, int hi){
        int toLeft = mid;
        int toRight = mid;

        long height = arr[mid];

        long maxArea = height;

        while(lo < toLeft && toRight < hi){
            if(arr[toLeft - 1] < arr[toRight + 1]){
                toRight++;
                height = Math.min(height, arr[toRight]);
            } else{
                toLeft--;
                height = Math.min(height, arr[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }


        while(toRight < hi){
            toRight++;
            height = Math.min(height, arr[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while(lo < toLeft){
            toLeft--;
            height = Math.min(height, arr[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }


        return maxArea;
    }
}