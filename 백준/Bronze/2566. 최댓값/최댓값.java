import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int x = 0, y = 0;
        int max = 0;

        int[][] a = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                a[i][j] = s.nextInt();
                if(a[i][j] >= max){
                    max = a[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x + " " + y);

        s.close();
    }
}