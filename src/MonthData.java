public class MonthData {
    private int[] days = new int[30];

    public int[] getDays() {
        return this.days;
    }

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        return 0;
    }

}
