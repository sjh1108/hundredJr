import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int score = n;
        switch(str){
            case "miss"-> score *= 0;
            case "bad" -> score *= 200;
            case "cool" -> score *= 400;
            case "great" -> score *= 600;
            case "perfect" -> score *= 1000;
        }
        System.out.println(score);

        sc.close();
    }
}