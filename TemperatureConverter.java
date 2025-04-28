import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Temperature Converter =====");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            double temp, converted;

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    temp = sc.nextDouble();
                    converted = (temp * 9 / 5) + 32;
                    System.out.println("Fahrenheit: " + converted);
                    break;

                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temp = sc.nextDouble();
                    converted = (temp - 32) * 5 / 9;
                    System.out.println("Celsius: " + converted);
                    break;

                case 3:
                    System.out.print("Enter temperature in Celsius: ");
                    temp = sc.nextDouble();
                    converted = temp + 273.15;
                    System.out.println("Kelvin: " + converted);
                    break;

                case 4:
                    System.out.print("Enter temperature in Kelvin: ");
                    temp = sc.nextDouble();
                    converted = temp - 273.15;
                    System.out.println("Celsius: " + converted);
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
