import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int[] save;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        save = new int[10];
        int fruitCount = 0, fruitCheck = 0, left = 0;
        for(int i = 0; i < N; i++){
            int fruit = arr[i];
            save[fruit]++;
            if(save[fruit] == 1){
                fruitCheck++;

                if(fruitCheck > 2){
                    max = Math.max(fruitCount, max);

                    while(fruitCheck > 2){
                        if(save[arr[left++]]-- == 1){
                            fruitCheck--;
                        }
                        fruitCount--;
                    }
                }
            }

            fruitCount++;
        }

        max = Math.max(max, fruitCount);

        System.out.println(max);
    }
}