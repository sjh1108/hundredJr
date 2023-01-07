import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int x = s.nextInt(), y = s.nextInt();

        int[][] a = new int[x][y];
        int[][] b = new int[x][y];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                a[i][j] = s.nextInt();
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                b[i][j] = s.nextInt();
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                int k = a[i][j] + b[i][j];
                System.out.print(k + " ");
            }
            System.out.println();
        }

        s.close();
    }
}