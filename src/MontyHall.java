package montyhallproblem;

public class MontyHall {

    public static void main(String[] args) {
        final int doors = 3;
        final int tests = 4;

        boolean[] outcomesWithSwitching = new boolean[tests];
        boolean[] outcomesWithoutSwitching = new boolean[tests];

        Game montyHall = new Game();

        for (int i = 0; i < tests; i++) {
            outcomesWithSwitching[i] = montyHall.playGame(doors, true);
            outcomesWithoutSwitching[i] = montyHall.playGame(doors, false);
        }

        System.out.println("Running " + tests + " simulations with " + doors + " doors.");
        System.out.println("Percent of times won with switching = " + percentTrue(outcomesWithSwitching));
        System.out.println("Percent of times won without switching = " + percentTrue(outcomesWithoutSwitching));
    }

    public static double percentTrue(boolean[] list) {
        double nTotal = list.length;
        double nTrue = 0;

        for (boolean item : list) {
            if (item) nTrue++;
        }

        return nTrue / nTotal;
    }
}
