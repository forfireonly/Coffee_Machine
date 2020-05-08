package machine;
import java.util.Scanner;

enum Beverages {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCHINO(200, 100, 12, 1, 6);

    int water;
    int milk;
    int coffeeBeans;
    int cups;
    int price;

    Beverages(int water, int milk, int coffeeBeans, int cups, int price) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.price = price;
    }
    int getWater() {
        return water;
    }
    int getMilk(){
        return milk;
    }
    int getCoffeeBeans() {
        return coffeeBeans;
    }
    int getCups(){
        return cups;
    }
    int getPrice() {
        return price;
    }
}
class MachineNeeds {
    public static String CHOICES = "Write action (buy, fill, take, remaining, exit):";
    private static int[] initialValues;


    MachineNeeds(int[]initialValues) {
        MachineNeeds.initialValues = initialValues;
    }

    public static void actionToTake(String action) {

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "1":
                resourcesCheck(initialValues, Beverages.ESPRESSO);
                break;
            case "2":
                resourcesCheck(initialValues, Beverages.LATTE);
                break;
            case "3":
                resourcesCheck(initialValues, Beverages.CAPPUCHINO);
                break;
            case "fill":
                fill(initialValues);
                break;
            case "take":
                take(initialValues);
                break;
            case "remaining":
                remaining(initialValues);
                break;
            case "exit":
                break;
            default:
        }

    }

    public static void remaining(int[] array) {
        System.out.printf("The coffee machine has: \n%d of water \n%d of milk \n%d of coffee beans \n%d of disposable" +
                " cups \n$%d of money", array[0], array[1], array[2], array[3], array[4]);
        System.out.println();
        System.out.println(CHOICES);

    }


    public static void adjustValues(int[] initialValues, Beverages beverage) {
        initialValues[0] -= beverage.getWater();
        initialValues[1] -= beverage.getMilk();
        initialValues[2] -= beverage.getCoffeeBeans();
        initialValues[3] -= beverage.getCups();
        initialValues[4] += beverage.getPrice();
    }

    public static void resourcesCheck(int[] initialValues, Beverages beverage) {
        String ingridientAbsent = "";
        if (initialValues[0] >= beverage.getWater() && initialValues[1] >= beverage.milk && initialValues[2] >= beverage.coffeeBeans &&
                initialValues[3] >= beverage.getCups()) {
            System.out.println("I have enough resources, making you a coffee!");
            adjustValues(initialValues, beverage);
        } else {
            if (initialValues[0] < beverage.getWater()) {
                ingridientAbsent += "water";
            }
            if (initialValues[1] < beverage.getMilk()) {
                ingridientAbsent += "milk";
            }
            if (initialValues[2] < beverage.getCoffeeBeans()) {
                ingridientAbsent += "coffee beans";
            }
            if (initialValues[3] < beverage.getCups()) {
                ingridientAbsent += "disposable cups";
            }
            System.out.printf("Sorry, not enough %s!", ingridientAbsent);
            System.out.println();
        }
        System.out.println(CHOICES);
    }

    public static void fill(int[] initialValues) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        initialValues[0] += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add: ");
        initialValues[1] += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        initialValues[2] += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        initialValues[3] += Integer.parseInt(scanner.nextLine());
        System.out.println(CHOICES);

    }

    public static void take(int[] initialValues) {
        System.out.printf("I gave you $%d", initialValues[4]);
        System.out.println();
        initialValues[4] = 0;
        System.out.println(CHOICES);
    }
}


    public class CoffeeMachine {

        public static void main(String[] args) {
            System.out.println(MachineNeeds.CHOICES);
            Scanner scn = new Scanner(System.in);
            MachineNeeds machineNeeds = new MachineNeeds(new int[]{400, 540, 120, 9, 550});
            while (scn.hasNext()) {
                MachineNeeds.actionToTake(scn.nextLine());
            }


        }

    }

