//Eric Wang and Paul
import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Casino.");
        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("What is your age? ");
        int age = input.nextInt();

        Player player = new Player(name, age);

        boolean running = true;

        while (running) {
            int cmoney = player.getMoney();
            
            System.out.println();
            System.out.println("Type: play, money, or quit");
            System.out.print("> ");
            String choice = input.nextLine();
            

            if (choice.toLowerCase().equals("money")) {
                System.out.println("You have $" + cmoney);
            }

            else if (choice.toLowerCase().equals("quit")) {
                System.out.print("Goodbye. You leave with $" + cmoney);
                    if (player.getMoney()>1000)
                        System.out.println(" (Profit of $" + (cmoney - 1000) + "). Good job :D");
                    else if (player.getMoney()==1000)
                        System.out.println(". No gain but at least no loss :)");
                    else if (player.getMoney()<1000)
                        System.out.println(" (You lost $" + (1000 - cmoney) + ") 99% of all gamblers stop right before their BIG HIT!");             
                running = false;
            }

            else if (choice.toLowerCase().equals("play")) {
                System.out.print("Enter your bet: ");
                int bet = input.nextInt();
                if (bet < cmoney)
                    System.out.println("\n not a vaild bet, you are broke");
                boolean playing = true;
                boolean playerTurn = true;
                Card card = new Card();
                while (playing)
                {
                    System.out.println("======== GAME START ========");
                    System.out.println("Dealer hand: " + card.drawS() + card.drawN());
                    
                    while (playerTurn)
                    {
                        System.out.println("Your hand: " + card.drawS() + card.drawN() + " and " + card.drawS() + card.drawN());
                        System.out.println("Hit or stand?");
                        String hs = input.nextLine();
                        if (hs.toLowerCase().equals("hit"))
                            System.out.println("Now your hand is:");
                    
                        if (hs.toLowerCase().equals("stand"))
                            playerTurn = false;
                    
            
            
                    }
                }
            }
                else
                System.out.println("Unknown option.");
            if (player.getMoney() <= 0) {
                    System.out.println("You are now homeless without a dollar to your name. Game over.");
                    System.exit(0);
                }    
            }
        }

    
    }
