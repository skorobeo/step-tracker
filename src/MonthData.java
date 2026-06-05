public class MonthData {

    // массив 30 дней
    // индекс 0 = 1-й день месяца
    int[] days = new int[30];

    // вывод шагов за каждый день месяца
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + "-ый день : " + days[i]);
        }
    }

    // общее колличество шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    // максимально количество шагов за один день в месяце
    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    // лучшая серия
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;  // текущая длина серии
        int finalSeries = 0;    // лучшая найденная серия

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                // цель достигнута - серия продолжается
                currentSeries++;
            } else {
                // серия прервалась - фиксируем лучшую и сбрасываем
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
