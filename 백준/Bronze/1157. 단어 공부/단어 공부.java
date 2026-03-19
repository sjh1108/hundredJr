import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        String str = s.nextLine();
        int[] arr = new int[26];
        int max = -1;
        char c = '?';

        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                c = (char) (i + 'A');
            } else if(arr[i] == max){
                c = '?';
            }
        }

        System.out.println(c);
        
        s.close();
    }
}
