import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int sum = 0;
        int numberOfNumbers = scn.nextInt();
        for (int i = 1; i <= numberOfNumbers; i++) {
            int n = scn.nextInt();
            if (n % 6 == 0) {
                sum += n;
            }
        }
        System.out.println(sum);
    }
}