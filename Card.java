public class Card {
    private int card;
    private String rank;
    private String suit;
    private String face;
    


    public int drawN() 
    {
        card = (int)(Math.random()*13)+1;
            if (card==1)
                card = 11;
            else if (card >=10)
                card = 10;
        return card;
    }
    
    public String checkface()
    {
        if (card==11)
            face = "A";
        else if (card ==11)
            face = "J";
        else if (card ==12)
            face = "Q";
        else if (card ==13)
            face = "K";
        else
            face = null;
        return face;
    }

    public String drawS() 
    {
        int a = (int)(Math.random()*3)+1;
            if (a==1)
                suit = "♣";
            else if (a==2)
                suit = "♥";        
            else if (a==3)
                suit = "♦";         
            else if (a==4)
                suit = "♠"; 
        return suit;
    }

}
