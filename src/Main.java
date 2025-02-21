import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker(scanner);

        stepTracker.addNewNumberStepsPerDay();

//        while (true) {
//            printMenu();
//        }

    }

    private static void printMenu() {
        System.out.println("Выберите комманду:");
        System.out.println("Ввести количество шагов за определённый день");
        System.out.println("Изменить цель по количеству шагов в день");
        System.out.println("Напечатать статистику за определённый месяц");
        System.out.println("Выйти из приложения");

    }
}