package montyhallproblem;

public class MontyHall {

    public static void main(String[] args) {
        final int doors = 3;
        final int tests = 1000000;

        boolean[] outcomesWithSwitching = new boolean[tests];
        boolean[] outcomesWithoutSwitching = new boolean[tests];

        Game montyHall = new Game();

        for (int i = 0; i < tests; i++) {
            outcomesWithSwitching[i] = montyHall.playGame(doors, true);
            outcomesWithoutSwitching[i] = montyHall.playGame(doors, false);
        }

        System.out.printf("Running %d simulations with %d doors.\n", doors, tests);
        System.out.printf("Proportion of times won with switching = %f\n", proportionTrue(outcomesWithSwitching));
        System.out.printf("Proportion of times won without switching = %f\n", proportionTrue(outcomesWithoutSwitching));

    }

    public static double proportionTrue(boolean[] list) {
        double nTotal = list.length;
        double nTrue = 0;

        for (boolean item : list) {
            if (item) nTrue++;
        }

        return nTrue / nTotal;
    }
}
