public class Player {
    private String name;
    private int age;
    private int money;
    private int bet;
    private int card;
    private int totalcard;
    private String totalhand;
    private String suit;
    private String face;
    private int aceCount;

    public Player() {
        name = "dealer";
        age = 18;
        money = 999999999;
        totalcard = 0;
        totalhand = "";
        aceCount = 0;
    }

    public Player(String n, int a) {
        name = n;
        age = a;
        money = 1000;
        totalcard = 0;
        totalhand = "";
        aceCount = 0;

        if (age < 18) {
            System.out.println(n + ", is too young to play. Goodbye.");
            System.exit(0);
        }

        if (age > 40) {
            System.out.println("Welcome unc.");
        }
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void resetHand() {
        totalcard = 0;
        totalhand = "";
        aceCount = 0;
    }

    public int drawN() {
        int raw = (int)(Math.random() * 13) + 1;

        if (raw == 1) {
            card = 11;
            aceCount++;
        } else if (raw >= 10) {
            card = 10;
        } else {
            card = raw;
        }

        return card;
    }

    public String checkface() {
        if (card == 11)
            face = "A";
        else if (card == 10)
            face = "10";
        else
            face = "" + card;
        return face;
    }

    public String drawS() {
        int a = (int)(Math.random() * 4) + 1;
        if (a == 1)
            suit = "♣";
        else if (a == 2)
            suit = "♥";
        else if (a == 3)
            suit = "♦";
        else
            suit = "♠";
        return suit;
    }

    public void atcv(int c) {
        totalcard += c;

        while (totalcard > 21 && aceCount > 0) {
            totalcard -= 10;
            aceCount--;
        }
    }

    public void hand(String a, int b) {
        totalhand += a + b + ", ";
    }

    public String handprint() {
        return totalhand;
    }

    public int handnum() {
        return totalcard;
    }

    public void betamount(int b) {
        bet = b;
    }

    public int lost() {
        money -= bet;
        return money;
    }

    public int won() {
        money += bet;
        return money;
    }
}
