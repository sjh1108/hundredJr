import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            int[] LIS = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            LIS[0] = arr[0];

            int len = 1;

            for(int i = 1; i < N; i++){
                int key = arr[i];

                if(LIS[len - 1] < key){
                    LIS[len++] = key;
                }

                else{
                    int lo = 0;
                    int hi = len;

                    while(lo < hi){
                        int mid = (lo + hi) / 2;

                        if(LIS[mid] < key){
                            lo = mid + 1;
                        }
                        else{
                            hi = mid;
                        }
                    }

                    LIS[lo] = key;
                }
            }

            System.out.println("#" + t + " " + len);
        }
    }
}
