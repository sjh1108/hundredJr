import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int t = s.nextInt();

        int[][] apt = new int[15][15];
        for(int i = 0; i < 15; i++){
            apt[0][i] = i;
        }
        for(int i = 1; i < 15; i++){
            for(int j = 1; j < 15; j++){
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }
        for(int x = 0; x < t; x++){
            int k = s.nextInt();
            int n = s.nextInt();
            System.out.println(apt[k][n]);
        }

        s.close();
    }
}
