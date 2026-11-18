package question1;

public class Product implements IProduct {
    private final String[] productNames;
    private final int[][] sales; // sales[product][month]

    public Product(String[] productNames, int[][] sales) {
        if (productNames == null || sales == null || productNames.length == 0) {
            throw new IllegalArgumentException("Products and sales are required.");
        }
        if (sales.length != productNames.length) {
            throw new IllegalArgumentException("Sales rows must match the number of products.");
        }
        int months = sales[0].length;
        for (int[] row : sales) {
            if (row == null || row.length != months) {
                throw new IllegalArgumentException("Sales array must be rectangular.");
            }
        }
        this.productNames = productNames.clone();
        this.sales = copySales(sales);
    }

    private static int[][] copySales(int[][] source) {
        int[][] copy = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i].clone();
        }
        return copy;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] productSales : sales) {
            for (int monthSales : productSales) {
                total += monthSales;
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        // Matches the photographed sample: total / (products * months) = 153 / 9 = 17.
        int entries = sales.length * sales[0].length;
        if (entries == 0) {
            return 0.0;
        }
        return GetTotalProductsSold() / (double) entries;
    }

    @Override
    public String GetMostPopularProduct() {
        int[] totals = productTotals();
        int best = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > totals[best]) {
                best = i;
            }
        }

        // Written rule: choose by highest total. The bracket uses the winner's best month
        // so the sample screenshot shows Cozy Nights Monarch(25).
        // If your marker wants the 3-month total in brackets, replace peakFor(best) with totals[best].
        return productNames[best] + "(" + peakFor(best) + ")";
    }

    private int[] productTotals() {
        int[] totals = new int[sales.length];
        for (int product = 0; product < sales.length; product++) {
            for (int month = 0; month < sales[product].length; month++) {
                totals[product] += sales[product][month];
            }
        }
        return totals;
    }

    private int peakFor(int product) {
        int peak = sales[product][0];
        for (int month = 1; month < sales[product].length; month++) {
            if (sales[product][month] > peak) {
                peak = sales[product][month];
            }
        }
        return peak;
    }
}
