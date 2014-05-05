/*
    name: Joshua Rodriguez
    email: ewized@gmail.com
    problem: P8.9 pg 407
    description: Make a class that acts like a combo lock
*/
public class ComboLock {
    private int numberOne, numberTwo, numberThree, currentNumber, stage;

    public ComboLock(int one, int two, int three) {
        numberOne = one;
        numberTwo = two;
        numberThree = three;
        stage = 1;
    }

    /** Rest the lock turns */
    public void rest() {
        currentNumber = 0;
        stage = 1;
    }

    /** Turn the lock to the right. */
    public void turnLeft(int ticks) {
        currentNumber -= ticks;
    }

    /** Turn the lock to the left. */
    public void turnRight(int ticks) {
        currentNumber += ticks;
    }

    /** Try to open the lock. */
    public boolean open() {
        if (stage == 1) {
            if (currentNumber == numberOne) {
                stage++;
                System.out.println("First combo has been unlocked.");
                return true;
            }
            else {
                System.out.printf("The number %s does not match the first combo.\n", currentNumber);
            }
        }
        else if (stage == 2) {
            if (currentNumber == numberTwo) {
                stage++;
                System.out.println("Second combo has been unlocked.");
                return true;
            }
            else {
                System.out.printf("The number %s does not match the next combo.\n", currentNumber);
            }
        }
        else if (stage == 3) {
            if (currentNumber == numberThree) {
                stage++;
                System.out.println("Third combo has been unlocked, you have cracked the lock.");
                return true;
            }
            else {
                System.out.printf("The number %s does not match the last combo.\n", currentNumber);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Fist Lock 4,2,7");
        ComboLock lock = new ComboLock(4, 2, 7);

        lock.turnRight(4);
        lock.open();
        lock.turnLeft(2);
        lock.open();
        lock.turnRight(5);
        lock.open();

        System.out.println();

        System.out.println("Next Lock 12,4,7");
        ComboLock bob = new ComboLock(12, 4, 7);

        bob.turnRight(12);
        bob.open();
        bob.turnLeft(8);
        bob.open();
        bob.turnRight(2);
        bob.open();
    }
}