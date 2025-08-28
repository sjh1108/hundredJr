import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0; i < k; i++){
            int g = sc.nextInt();

            int grade = g * 100 / n;

            if (0 <= grade  && grade <= 4) {
                System.out.print("1 ");
            } else if (4 < grade && grade <= 11) {
                System.out.print("2 ");
            } else if (11 < grade && grade <= 23) {
                System.out.print("3 ");
            } else if (23 < grade && grade <= 40) {
                System.out.print("4 ");
            } else if (40 < grade && grade <= 60) {
                System.out.print("5 ");
            } else if (60 < grade && grade <= 77) {
                System.out.print("6 ");
            } else if (77 < grade && grade <= 89) {
                System.out.print("7 ");
            } else if (89 < grade && grade <= 96) {
                System.out.print("8 ");
            } else if (96 < grade && grade <= 100) {
                System.out.print("9 ");
            }
        }

        sc.close();
    }
}