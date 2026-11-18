package question1;

import java.util.Scanner;

public class SalesReportApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // sales[product][month]
        int[][] sales = new int[productNames.length][3];

        for (int product = 0; product < productNames.length; product++) {
            for (int month = 1; month <= 3; month++) {
                System.out.printf("Enter number of sales for month %d for %s mattress: ",
                        month, productNames[product]);
                sales[product][month - 1] = readNonNegativeInt(input);
                System.out.println();
            }
        }

        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct();
        System.out.println();
        printer.printReport(product);
    }

    private static int readNonNegativeInt(Scanner input) {
        while (true) {
            try {
                int value = Integer.parseInt(input.nextLine().trim());
                if (value < 0) {
                    System.out.print("Please enter a non-negative whole number: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid number. Enter a whole number: ");
            }
        }
    }
}
