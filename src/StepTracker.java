import java.util.Scanner;

public class StepTracker {
    private final Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        int month = inputMonth();
        if (month < 0) {
            System.out.println("Номер месяца должен быть от 1 до 12");
            return;
        }

        System.out.print("Введите день от 1 до 30 (включительно): ");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Число дня должно быть от 1 до 30");
            return;
        }

        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Число шагов не должно быть отрицательным");
            return;
        }
        int[] days = monthToData[month].getDays();
        days[day - 1] = steps;
    }

    public void changeStepGoal() {
        System.out.println("Текущая цель " + goalByStepsPerDay + " шагов");
        System.out.print("Введите новую цель: ");
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Цель должна быть больше нуля.");
            return;
        }
        goalByStepsPerDay = newGoal;
        System.out.println("Новая цель " + newGoal + " шагов");
    }

    public void printStatistic() {
        int month = inputMonth();
        if (month < 0) {
            System.out.println("Номер месяца должен быть от 1 до 12");
            return;
        }
        System.out.println("Статистика за " + month + " месяц");
        System.out.println("Статистика по дням: ");
        monthToData[month].printDaysAndStepsFromMonth();

        int sumSteps = monthToData[month].sumStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количества шагов за месяц: " + maxSteps(month));
        System.out.println("Среднее пройденное количество шагов за месяц: " + averageStepsFromMonth(sumSteps));
        System.out.println("Пройдено за месяц " + converter.convertToKm(sumSteps) + " километров");
        System.out.println("Сожжено за месяц " + converter.convertStepsToKilocalories(sumSteps) + " ккалорий");
        System.out.println("Лучшая серия шагов составляет " + bestSeries(goalByStepsPerDay, month) + " дней");
    }

    private int averageStepsFromMonth(int sumSteps) {
        return sumSteps/ 30;
    }

    private int maxSteps(int month) {
        int[] days = monthToData[month].getDays();
        int maxSteps = 0;
        for (int day : days)
            if (day > maxSteps) {
                maxSteps = day;
            }
        return maxSteps;
    }

    private int bestSeries(int goalByStepsPerDay, int month) {
        int[] days = monthToData[month].getDays();
        int currentSeries = 0;
        int finalSeries = 0;

        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    private int inputMonth() {
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            return -1;
        }
        return month - 1;
    }
}

