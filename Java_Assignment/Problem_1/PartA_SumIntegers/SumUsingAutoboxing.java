import java.util.ArrayList;
import java.util.Scanner;

public class SumUsingAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter integers (type 'done' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            // Parse string to int and autobox to Integer
            Integer num = Integer.parseInt(input);
            numbers.add(num);
        }

        int sum = 0;
        // Unboxing Integer to int automatically
        for (Integer num : numbers) {
            sum += num;
        }

        System.out.println("Total sum: " + sum);
    }
}
