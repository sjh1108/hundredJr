import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int[] arr = new int[43];

        int count = 0;
        for(int i = 0; i < 10; i++){
            int a = s.nextInt();
            a %= 42;
            if(arr[a] == 0){
                arr[a]++;
                count++;
            }
        }
        System.out.println(count);

        s.close();
    }
}
