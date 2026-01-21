//Eric Wang and Paul Lei
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Blackjack.");
        System.out.print("What is your name? ");
        String name1 = input.nextLine();

        System.out.print("What is your age? ");
        int age1 = input.nextInt();
        input.nextLine();

        Player dealer = new Player();
        Player p1 = new Player(name1, age1);

        boolean running = true;
        while (running) {

            System.out.println();
            System.out.println("Type: play, money, or quit");
            System.out.print("> ");
            String choice = input.nextLine().trim().toLowerCase();
            System.out.println();

            if (choice.equals("money")) {
                System.out.println("you have $" + p1.getMoney());
            }

            else if (choice.equals("quit")) {
                System.out.println("You leave with $" + p1.getMoney());
                System.out.println("Goodbye");
                running = false;
            }

            else if (choice.equals("play")) {

                p1.resetHand();
                dealer.resetHand();

                System.out.print("enter your bet: ");
                int bet = input.nextInt();
                input.nextLine();
                p1.betamount(bet);
                System.out.println();

                while (bet > p1.getMoney() || bet <= 0) {
                    System.out.println("not a valid bet");
                    System.out.print("please enter a valid bet: ");
                    bet = input.nextInt();
                    input.nextLine();
                    p1.betamount(bet);
                }

                boolean playing = true;
                boolean playerTurn = true;

                while (playing) {
                    System.out.println("======== GAME START ========");

                    String dealersuit1 = dealer.drawS();
                    int dealernum1 = dealer.drawN();
                    dealer.atcv(dealernum1);
                    dealer.hand(dealersuit1, dealernum1);

                    String dealersuit2 = dealer.drawS();
                    int dealernum2 = dealer.drawN();
                    dealer.atcv(dealernum2);
                    dealer.hand(dealersuit2, dealernum2);

                    System.out.println("Dealer shows: " + dealersuit1 + dealernum1 + " and ??");

                    String ps1 = p1.drawS();
                    int pn1 = p1.drawN();
                    p1.atcv(pn1);
                    p1.hand(ps1, pn1);

                    String ps2 = p1.drawS();
                    int pn2 = p1.drawN();
                    p1.atcv(pn2);
                    p1.hand(ps2, pn2);

                    System.out.println("======= PLAYER'S TURN =======");
                    System.out.println("Your hand: " + p1.handprint() + " (total: " + p1.handnum() + ")");

                    while (playerTurn) {
                        if (p1.handnum() > 21) {
                            System.out.println("you busted, you lost");
                            p1.lost();
                            System.out.println("Now you have $" + p1.getMoney());
                            playerTurn = false;
                            playing = false;
                            break;
                        }

                        System.out.println("Hit or stand?");
                        String hs = input.nextLine().trim().toLowerCase();

                        if (hs.equals("hit")) {
                            String ps = p1.drawS();
                            int pn = p1.drawN();
                            p1.atcv(pn);
                            p1.hand(ps, pn);
                            System.out.println("Now your hand is: " + p1.handprint() + " (total: " + p1.handnum() + ")");
                        }
                        else if (hs.equals("stand")) {
                            playerTurn = false;
                        }
                        else {
                            System.out.println("Please type hit or stand.");
                        }
                    }
                    if (!playing) {
                        break;
                    }

                    System.out.println("======= DEALER'S TURN =======");
                    System.out.println("Dealer hand: " + dealer.handprint() + " (total: " + dealer.handnum() + ")");

                    while (dealer.handnum() < 17) {
                        String dealers = dealer.drawS();
                        int dealern = dealer.drawN();
                        dealer.atcv(dealern);
                        dealer.hand(dealers, dealern);
                        System.out.println("Dealer hits: " + dealer.handprint() + " (total: " + dealer.handnum() + ")");
                    }
                    if (dealer.handnum() > 21) {
                        System.out.println("Dealer busted. You won. You earned $" + bet);
                        p1.won();
                        System.out.println("Now you have $" + p1.getMoney());
                        playing = false;
                    }
                    else {
                        if (dealer.handnum() > p1.handnum()) {
                            System.out.println("You lost. You lost $" + bet);
                            p1.lost();
                            System.out.println("Now you have $" + p1.getMoney());
                            playing = false;
                        }
                        else if (dealer.handnum() < p1.handnum()) {
                            System.out.println("You won. You earned $" + bet);
                            p1.won();
                            System.out.println("Now you have $" + p1.getMoney());
                            playing = false;
                        }
                        else {
                            System.out.println("You tied. Nothing happened, just wasted some time");
                            System.out.println("Now you have $" + p1.getMoney());
                            playing = false;
                        }
                    }
                }
            }
            else {
                System.out.println("Unknown option.");
            }
            if (p1.getMoney() <= 0) {
                System.out.println("You are now homeless without a dollar to your name. Game over.");
                System.exit(0);
            }
        }
        input.close();
    }
}
