import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean flag = false;
        String s = br.readLine();
        int len = s.length();
        
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = (int)(s.charAt(i) - '0');
        }
        
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        for(int i = 0; i < len - 1; i++){
            int j = len - (i + 1);
            
            if(i == 0){
                arr1[i] = arr[i];
                arr2[j] = arr[j];
                continue;
            }
            
            arr1[i] = arr1[i - 1] * arr[i];
            arr2[j] = arr2[j + 1] * arr[j];
        }
        
        for(int i = 0; i < len - 1; i++){
            if(arr1[i] == arr2[i + 1]){
                flag = true;
                break;
            }
        }
        
        if(flag){
            System.out.print("YES");
        } else{
            System.out.print("NO");
        }
    }
}