package question1;

public class PrintProduct {
    public void printTotalProductSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales(Product product) {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold());
    }

    public void printMostPopularProduct(Product product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    public void printReport(Product product) {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*********************************************");
        printTotalProductSales(product);
        printAverageProductSales(product);
        printMostPopularProduct(product);
        System.out.println("*********************************************");
    }
}
