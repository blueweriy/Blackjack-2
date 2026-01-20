public class Player {
    private String name;
    private int age;
    private int money;
    private int totalcard;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.money = 1000;

        if (age < 18) {
            System.out.println("You are too young to play. Goodbye.");
            System.exit(0);
        }
        
        if (age>40) {
            System.out.println("Welcome unc.");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMoney() {
        return money;
    }

    public boolean canBet(int bet) {
        return bet > 0 && bet <= money;
    }

    public void win(int bet) {
        money += bet;
    }

    public void lose(int bet) {
        money -= bet;
    }
}
