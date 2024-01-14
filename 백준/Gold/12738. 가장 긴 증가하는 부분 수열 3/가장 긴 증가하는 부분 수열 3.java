import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr;
    static int[] index;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        index = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        list.add(Integer.MIN_VALUE);

        for(int i = 0; i < N; i++){
            
            if(list.get(list.size() - 1) < arr[i]){
                list.add(arr[i]);
                index[i] = list.size() - 1;

                continue;
            }
            
            int left = 0, right = list.size() - 1;

            while(left < right){

                int mid = (left+right) / 2;

                if(list.get(mid) < arr[i]) left = mid + 1;
                else right = mid;
            }

            list.set(right, arr[i]);
            index[i] = right;
        }
        System.out.println(list.size() - 1);
    }
}