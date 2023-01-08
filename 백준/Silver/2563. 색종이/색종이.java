import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        

        int N = s.nextInt();

        int[][] a = new int[101][101];
        int max = 0;
        
        for(int i = 0; i < N; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            if(a[x][y] != 1){
                max++;
                a[x][y] = 1;
            }

            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    if(a[j][k] == 1){
                        continue;
                    }
                    a[j][k] = 1;
                    max++;
                }
            }
        }

        System.out.println(max);

        s.close();
    }
}