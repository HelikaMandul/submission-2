import java.util.Scanner;

public class RabbitProblem {

    public static int rabbits(int month) {
        if (month <= 2) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= month; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of months: ");
        int months = input.nextInt();

        if (months < 1) {
            System.out.println("Invalid month");
        } else {
            System.out.println("Rabbit pairs: " + rabbits(months));
        }

        input.close();
    }
}