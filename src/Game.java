import java.util.Random;

package montyhallproblem;

public class Game {
    private Random random = new Random();

    public Game() { }

    public boolean playGame(final int numDoors, final boolean switchDoors) {
        final int winningDoor = chooseDoor(numDoors);
        final int initialChoice = chooseDoor(numDoors);
        final int alternateChoice = collapseDoors(numDoors, initialChoice, winningDoor);
        final int finalChoice = (switchDoors) ? alternateChoice : initialChoice;
        return (finalChoice == winningDoor);
    }

    private int chooseDoor(final int numDoors) {
        return this.random.nextInt(numDoors);
    }

    private int changeDoor(final int numDoors, final int currentDoor) {
        final int newDoor = chooseDoor(numDoors);
        if (newDoor != currentDoor) {
            return newDoor;
        } else {
            return changeDoor(numDoors, currentDoor);
        }
    }

    private int collapseDoors(final int numDoors, final int currentChoice, final int winningDoor) {
        if (currentChoice == winningDoor) {
            return changeDoor(numDoors, currentChoice);
        } else {
            return winningDoor;
        }
    }
}
