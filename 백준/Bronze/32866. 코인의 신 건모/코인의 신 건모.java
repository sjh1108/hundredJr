import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double origin = Double.parseDouble(br.readLine());
        double loss = origin - (origin * (Double.parseDouble(br.readLine()) / 100));

        System.out.println(((origin / loss) - 1) * 100);
    }
}