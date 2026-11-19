import java.util.Scanner;

public class SmartRestaurantOrder {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Constant drink price
        final double DRINK_PRICE = 15.50;

        // Collect customer information
        System.out.print("Enter customer's name: ");
        String customerName = input.nextLine();

        System.out.print("Enter customer's age: ");
        int age = input.nextInt();

        System.out.print("Enter meal price: $");
        double mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        int numberOfDrinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        boolean isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1 to 5): ");
        int serviceRating = input.nextInt();

        // Validate service rating
        if (serviceRating < 1 || serviceRating > 5) {

            System.out.println("Error: Service rating must be between 1 and 5.");

        } else {

            // Calculate drinks and subtotal
            double drinksCost = numberOfDrinks * DRINK_PRICE;
            double subtotal = mealPrice + drinksCost;

            // Calculate discount
            double discountRate;

            if (isStudent) {
                discountRate = 0.10;

            } else if (age >= 60) {
                discountRate = 0.05;

            } else {
                discountRate = 0.0;
            }

            double discountAmount = subtotal * discountRate;
            double discountedTotal = subtotal - discountAmount;

            // Calculate tip
            double tipAmount;

            if (serviceRating >= 4 && serviceRating <= 5) {
                tipAmount = discountedTotal * 0.10;

            } else {
                tipAmount = 0.0;
            }

            // Calculate final bill
            double finalBill = discountedTotal + tipAmount;

            // Type casting
            int wholeAmount = (int) finalBill;

            // Print receipt
            System.out.println("\n========== SMART RESTAURANT ==========");
            System.out.println("Customer: " + customerName);

            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);

            System.out.println("Whole amount: $" + wholeAmount);

            System.out.println("======================================");
        }

        input.close();
    }
}