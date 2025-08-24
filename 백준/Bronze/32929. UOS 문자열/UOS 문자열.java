import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = (Integer.parseInt(br.readLine()) - 1) % 3;
        
        String uos = "UOS";
        System.out.println(uos.charAt(x));
    }
}
