import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String s = br.readLine();
        s = s.replace("A", "").replace("J", "").replace("V", "");

        if(s.length() == 0){
            System.out.println("nojava");
        }
        else{
            System.out.println(s);
        }
    }
}