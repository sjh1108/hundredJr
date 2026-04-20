import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int size = Integer.parseInt(br.readLine());
        int[][] box = new int[size][size];
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean ch = true;

        while(ch){
            ch = false;

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(box[i][j] == 0){

                        for(int k = 0; k < size; k++){
                            if(box[i][k] == 0 || j == k) continue;

                            if(box[k][j] == 1) {
                                box[i][j] = 1;
                                ch = true;
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sb.append(box[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}