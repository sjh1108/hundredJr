//import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        /*
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();

        int count = 0;
        for(int i = 0; i < b; i++){
            int c = s.nextInt();
            int n = s.nextInt();
            count += c*n;
        }
        if(a == count){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
        //System.out.println(b);

        s.close();
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            bw.write(a+b+"\n");
        }
        bw.flush();
    }
}
