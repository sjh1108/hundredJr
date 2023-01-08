import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        

        int N = s.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = s.nextInt();
        }
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                if(arr[i] > arr[j]){
                    int x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }

        s.close();
    }
}