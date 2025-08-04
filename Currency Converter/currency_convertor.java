import java.util.*;

public class currency_convertor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("\nSupported currencies:");
        System.out.println("USD - US Dollar");
        System.out.println("INR - Indian Rupee");
        System.out.println("EUR - Euro");
        System.out.println("GBP - British Pound");
        System.out.println("JPY - Japanese Yen");
        System.out.println("CAD - Canadian Dollar");
        System.out.println("AUD - Australian Dollar");
        System.out.println("CNY - Chinese Yuan");
        System.out.println("CHF - Swiss Franc");
        System.out.println("AED - UAE Dirham\n");

        while (true) {
            System.out.print("Enter the source currency code: ");
            String from = in.next().toUpperCase();

            System.out.print("Enter the target currency code: ");
            String to = in.next().toUpperCase();

            double amt = 0.0;
            System.out.print("Enter amount: ");
            try {
                amt = in.nextDouble();
                if (amt < 0) {
                    System.out.println("Invalid input. Amount cannot be negative.");
                    System.out.println("Try Again (>T>)\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                in.nextLine(); // clear the buffer
                System.out.println("Try Again (>T>)\n");
                continue;
            }

            double result = convertCurrency(from, to, amt);

            if (result != -1) {
                System.out.printf("%.2f %s = %.2f %s%n", amt, from, result, to);
            }

            System.out.print("Do you want to continue? (Y/N): ");
            String go = in.next();
            if (!go.equalsIgnoreCase("Y")) {
                System.out.println("Thank You!");
                break;
            }
            System.out.println();
        }

        in.close();
    }

    public static double convertCurrency(String from, String to, double amt) {
        Map<String, Double> ratesToINR = new HashMap<>();
        ratesToINR.put("INR", 1.0);
        ratesToINR.put("USD", 83.29);
        ratesToINR.put("EUR", 91.45);
        ratesToINR.put("GBP", 106.31);
        ratesToINR.put("JPY", 0.58);
        ratesToINR.put("CAD", 61.55);
        ratesToINR.put("AUD", 56.10);
        ratesToINR.put("CNY", 11.47);
        ratesToINR.put("CHF", 95.05);
        ratesToINR.put("AED", 22.68);

        if (!ratesToINR.containsKey(from) || !ratesToINR.containsKey(to)) {
            System.out.println("Unsupported currency. Please try again.\n");
            return -1;
        }

        double amountInINR = amt * ratesToINR.get(from);
        double convertedAmount = amountInINR / ratesToINR.get(to);

        return convertedAmount;
    }
}
