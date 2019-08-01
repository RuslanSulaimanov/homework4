import java.util.Random;

public class Main {

    public static int[] health = {700, 250, 250, 250, 250};
    public static int[] hits = {50, 20, 20, 20, 20};

    public static String[] hitTypes = {
        "Physical", "Physical", "Magical", "Mental", "Medic"};


    public static void main(String[] args) {
        printStatistic();
        while (!isFinished()) {
            changeBossDefense();
            round();
            printStatistic();
            medicHeal();
        }
    }

    public static void changeBossDefense() {
        Random r = new Random();
        int randomNumber = r.nextInt(4)+1;
        hitTypes[0] = hitTypes[randomNumber];

    }

    public static void round() {
        for (int i = 1; i <=4; i++) {
            health[i] = bossHit(i);
        }
        for (int i = 1; i <=3; i++) {
            int healthRemain = playerHit(i);
            if (healthRemain < 0) {
                health[0] = 0;
            } else {
                health[0] = healthRemain;

            }
        }
    }

    public static int playerHit(int playerIndex) {
        if (hitTypes[0].equals(hitTypes[playerIndex]))
        {
            Random r = new Random();
            int randomNomber = r.nextInt(7) + 2;
            System.out.println(hitTypes[playerIndex] + "critically hits Boss" + hits[playerIndex] * randomNomber);
            return health[0] - hits[playerIndex] * randomNomber;
        } else {
            return health[0] - hits[playerIndex];
        }
    }

    public static int bossHit(int playerIindex) {
        return health[playerIindex] - hits[0];
    }
        public static void medicHeal() {
            if (health[4] > 0) {
                for (int i = 1; i < 3; i++) {
                    health[i] = health[i] + hits[4];
                }

            }
        }
        public static boolean isFinished() {
        if (health[0] <=0) {
            System.out.println("Heroes won the game!!!");
        return true;
        }
        if (health[1] <= 0 && health[2] <= 0 && health[3] <= 0) {
            System.out.println("Boss won the game!!!");
            return true;
        }
        return false;
    }


    public static void printStatistic() {
        System.out.println("___________");
        System.out.println("Boss health: " + health[0]);
        System.out.println("Boss defense: " + hitTypes[0]);
        System.out.println("Warior health:" + health[1]);
        System.out.println("Magic health:" + health[2]);
        System.out.println("Mental health:" + health[3]);
        System.out.println("Medic health:" + health[4]);
        System.out.println("____________________");
    }
}