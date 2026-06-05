public class Converter {

    private Converter() {

    }

    // Конвертация шагов в пройденные километры.
    // 1 шаг = 75 см → steps * 0.75 метра → steps * 75 / 100_000 = км
    static int convertToKm(int steps) {
        return steps * 75 / 100000;
    }

    // Конвертация шагов в сожжённые килокалории.
    // 1 шаг ≈ 0.05 ккал → steps * 50 / 1000
    static int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}
