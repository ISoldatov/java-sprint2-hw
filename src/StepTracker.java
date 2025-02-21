import java.util.Scanner;

public class StepTracker {
    private Scanner scanner;
    private MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Номер месяца должен быть от 1 до 12");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Число дня должно быть от 1 до 30");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Число шагов не должно быть отрицательным");
            return;
        }
        int[] days = monthToData[month - 1].getDays();
        days[day] = steps;
    }

    public void changeStepGoal() {
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Цель должна быть больше нуля.");
            return;
        }
        goalByStepsPerDay = newGoal;
    }

    public void printDaysAndStepsFromMonth() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        int[] days = monthToData[month].getDays();


        for (int i = 0; i < days.length; i++) {
            int day = i + 1;
            System.out.println(day + " день: " + days[i]);


        }
    }

    int sumStepsFromMonth() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        int[] days = monthToData[month].getDays();
        int sum = 0;
        for (int i = 0; i < days.length; i++) {
            sum += days[i];
        }
        return sum;
    }

    public int maxSteps() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        int[] days = monthToData[month].getDays();
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        int[] days = monthToData[month].getDays();

        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                if (currentSeries > 0) {
                    currentSeries++;
                } else {
                    currentSeries = 1;
                }
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }
        return finalSeries;
    }
}
