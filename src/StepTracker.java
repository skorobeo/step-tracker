import java.util.Scanner;


public class StepTracker {

    Scanner scanner;

    MonthData[] monthToData = new MonthData[12];

    int goalByStepsPerDay = 10000;


    StepTracker(Scanner scanner) {

        this.scanner = scanner;


        for (int i = 0; i < monthToData.length; i++) {

            monthToData[i] = new MonthData();

        }

    }


    void addNewNumberStepsPerDay() { // Команда 1. Ввести количество шагов за определённый день

        System.out.println("Введите номер месяца");

        int month = scanner.nextInt();

        if (month < 1 || month > 12) {  // ввод и проверка номера месяца

            System.out.println("Ошибка. Число должно быть от 1 до 12.");

            return;

        }


        System.out.println("Введите день от 1 до 30 (включительно)");

        int day = scanner.nextInt();

        if (day < 1 || day > 30) {  // ввод и проверка дня

            System.out.println("Ошибка. Число должно быть от 1 до 30.");

            return;

        }


        System.out.println("Введите количество шагов");

        int steps = scanner.nextInt();  // ввод и проверка количества шагов

        if (steps < 0) {// ввод и проверка количества шагов

            System.out.println("Ошибка. Число должно быть положительным.");

            return;

        }


        // получение соответствующего объекта MonthData из массива

        MonthData monthData = monthToData[month - 1];

        // сохранение полученных данных

        monthData.days[day - 1] = steps;

    }


    void changeStepGoal() { // Команда 2. Изменить цель по количеству шагов вдень

        System.out.println("Введите новую цель по количеству шагов в день");

        int newStepGoal = scanner.nextInt();

        if (newStepGoal < 0) {

            System.out.println("Ошибка. Число должно быть положительным.");

            return;

        }

        goalByStepsPerDay = newStepGoal;

    }


    void printStatistic() { // Команда 3. Напечатать статистику за определённый месяц

        System.out.println("Введите число месяца");

        int numMonth = scanner.nextInt();

        if (numMonth < 1 || numMonth > 12) {

            System.out.println("Ошибка. Неверный номер месяца.");

            return;

        }

        MonthData monthData = monthToData[numMonth - 1]; // получение соответствующего месяца


        int sumSteps = monthData.sumStepsFromMonth();   // Общее кол-во шагов

        System.out.println("Общее количество шагов за месяц: " + sumSteps + "\n");


        int maxSteps = monthData.maxSteps();    //  Максималное кол-во шагов

        System.out.println("Максимальное пройденное количество шагов за месяц: " + maxSteps + "\n");


        int averageSteps = sumSteps / monthData.days.length;    // Среднее кол-во шагов

        System.out.println("Среднее количество шагов: " + averageSteps + "\n");


        int stepsKm = Converter.convertToKm(sumSteps); //   Дистанция в км

        System.out.println("Пройденная дистанция (в км): " + stepsKm + "\n");


        int stepsKcal = Converter.convertStepsToKilocalories(sumSteps); //  Потрачено ккал

        System.out.println("Количество сожжённых килокалорий: " + stepsKcal + "\n");


        int goatSeries = monthData.bestSeries(goalByStepsPerDay);   //  Лучшая серия

        System.out.println("Лучшая серия: " + goatSeries + "\n");


    }


}