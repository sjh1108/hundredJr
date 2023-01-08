import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        

        //int N = s.nextInt();

        int[] arr = new int[5];
        int max = 0;
        for(int i = 0; i < 5; i++){
            arr[i] = s.nextInt();
            
            max += arr[i];
        }
        for(int i = 0; i < 5; i++){
            for(int j = i; j < 5; j++){
                if(arr[i] > arr[j]){
                    int x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }
        
        System.out.println(max / 5);
        System.out.println(arr[2]);

        s.close();
    }
}