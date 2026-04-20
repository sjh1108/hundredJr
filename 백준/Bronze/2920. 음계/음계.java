//import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] read = br.readLine().split(" ");
        int[] ring = new int[read.length];
        for(int i = 0; i < read.length; i++){
            ring[i] = Integer.parseInt(read[i]);
        }
        boolean ac = true, dc = true;
        if(ring[0] != 1){
            ac = false;
        } else if(ring[0] != 8){
            dc = false;
        }
        for(int i = 1; i < 8; i++){
            if(ac || dc){
                if(ring[i] != ring[i - 1] + 1){
                    ac = false;
                }
                if(ring[i] != ring[i - 1] - 1){
                    dc = false;
                }
            } else{
                break;
            }
        }
        if(ac){
            System.out.println("ascending");
        } else if(dc){
            System.out.println("descending");
        } else{
            System.out.println("mixed");
        }
       
        //s.close();
    }
}