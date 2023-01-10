//import java.util.*;

public class Main {
    public static void main(String[] args){
        //Scanner s = new Scanner(System.in);
        
        boolean[] arr = new boolean[10001];

        getSelfNum(arr);

        //s.close();
    }
    static void getSelfNum(boolean[] arr){
        for(int i = 1; i < 10000; i++){
            if(!arr[i]){
                System.out.println(i);
            }
            int a = i;
            a = aa(a);
            if(a < 10000){
                arr[a] = true;
            }
        }
    }

    static int aa(int a){
        int num = a;
        while(a != 0){
            num += a % 10;
            a /= 10;
        }
        return num;
    }
}
