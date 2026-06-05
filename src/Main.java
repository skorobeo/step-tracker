import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            if (choice == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (choice == 2) {
                stepTracker.changeStepGoal();
            } else if (choice == 3) {
                stepTracker.printStatistic();
            } else if (choice == 4) {
                System.out.println("Выход");
                scanner.close();
                break;
            }
        }
    }


    static void printMenu() {   //  Вывод меню
        System.out.println("Введите код команды:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}

