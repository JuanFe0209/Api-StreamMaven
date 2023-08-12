import org.example.domain.enums.ProductCategory;
import org.example.services.OrderService;
import org.example.services.ProductService;
import org.example.services.impl.OrderServiceImpl;
import org.example.services.impl.ProductServiceImpl;

import java.util.*;

public class Main {
    private static ProductService productService;
    private static OrderService orderService;

    public static void main(String[] args) {
        productService = new ProductServiceImpl();
        orderService = new OrderServiceImpl();
        displayMenu();
    }
    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Filter books with a price > 100");
            System.out.println("2. Filter products of babies category");
            System.out.println("3. Apply discount to toys");
            System.out.println("4. Show a list of orders made by client 2 between february 1st 2021 and april 1st 2021");
            System.out.println("5. Show the cheapest product of Books category");
            System.out.println("6. Show the 3 most recent products");
            System.out.println("7. Global Sum of orders made in an specific date");
            System.out.println("8. Global promedium of orders made in an especific date");
            System.out.println("9. Show a Map with the clients information");
            System.out.println("10. Get most expensive product by category");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println(productService.filterBooks());
                }
                case 2 -> {
                    System.out.println(orderService.filterBabyProducts());
                }
                case 3 -> {
                    System.out.println(productService.applyDiscountToToys());
                }
                case 4 -> {
                    System.out.println(orderService.productsClient2());
                }
                case 5 -> {
                    System.out.println(productService.getCheapestProductInCategory(ProductCategory.BOOKS));
                }
                case 6 -> {
                    System.out.println(orderService.displayMostRecentOrders());
                }
                case 7 -> {
                    System.out.println(orderService.calculateGlobalSum());
                }
                case 8 -> {
                    System.out.println(orderService.calculateGlobalPromedium());
                }
                case 9 -> {
                    System.out.println(orderService.getOrderMapPerClient());
                }
                case 10 -> {
                    System.out.println(productService.getMostExpensiveProduct());
                }
                case 11 -> {
                    System.out.println("Closing Menu");
                }
                default -> {
                    System.out.println("Wrong option, please try again.");
                }
            }
        } while (choice != 11);
    }
}