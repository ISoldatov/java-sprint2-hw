public class Converter {
    private final int cenInstep = 75;
    private final int cenInKil = 100000;
    private final int stepInKal = 50;
    private final int kkal = 1000;


    public int convertToKm(int steps) {
        return steps * cenInstep / cenInKil;
    }

    public int convertStepsToKilocalories(int steps) {
        return steps * stepInKal / kkal;
    }
}
