import java.util.Scanner;

public class UserInterface {
    private static final DataBase dataBase = new DataBase();

    public static void main(String[] args) {
        new UserInterface().startWorkWithUser();
        //new CounterFrame(dataBase);
        /*System.out.println("You need to eat some food containing " +
                new DailyAmountCalories().amountCaloriesInDay() + " calories during the day!");*/
    }

    public void startWorkWithUser() {
        System.out.println("Please enter food name: ");
        Scanner sc = new Scanner(System.in);
        String foodName = sc.nextLine();
        Food food = dataBase.getFoodByName(foodName);
        if (food != null) {
            System.out.println(food);
        } else {
            System.out.println("Food with name " + foodName + " is not exist");
        }
    }
}
