import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        

        int N = s.nextInt();
        int k = s.nextInt();

        int[] arr = new int[N];
        //int max = 0;
        for(int i = 0; i < N; i++){
            arr[i] = s.nextInt();
            
            //max += arr[i];
        }
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                if(arr[i] < arr[j]){
                    int x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }
        
        //System.out.println(max / 5);
        System.out.println(arr[k - 1]);

        s.close();
    }
}