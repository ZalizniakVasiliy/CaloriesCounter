import java.util.Scanner;

public class DailyAmountCalories {

    public double amountCaloriesInDay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your weight in kilograms: ");
        int weight = sc.nextInt();
        System.out.println("Please enter your height in centimeters: ");
        int height = sc.nextInt();
        System.out.println("Please enter your age in years: ");
        int age = sc.nextInt();
        System.out.println("Please make choice about your coefficient physical activity: " + "\n" +
                " 1.2 - no physical activity;" + "\n" +
                " 1.3 - 1.4 - light activity (1 - 3 times a week);" + "\n" +
                " 1.5 - 1.6 - medium activity (3 - 5 times a week);" + "\n" +
                " 1.7 - 1.8 - high activity (hard training: 6 - 7 times a week);" + "\n" +
                " 1.9 - 2.0 - extremely high activity: ");
        double coefficientPhysicalActivity = sc.nextDouble();
        System.out.println("Please enter your gender (male or female): ");
        String gender = sc.next();

        double resultAmount = 0;
        if (gender.startsWith("m")) {
            resultAmount = (66 + (13.7 * weight) + (5 * height) - (6.76 * age)) * coefficientPhysicalActivity;
        } else if (gender.startsWith("f")) {
            resultAmount = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * coefficientPhysicalActivity;
        }
        return resultAmount;
    }
}
