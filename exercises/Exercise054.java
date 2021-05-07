import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise054 {

    private static int wins1 = 0;
    private static int wins2 = 0;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("Exercise054.txt"));
        for (int game = 1; game <= 1000; game++)
        {
            String line = in.nextLine();
            String[] cards = line.split(" ");

            ArrayList<Card> player1 = new ArrayList<Card>();
            for (int j = 0; j < 5; j++)
            {
                Card c = new Card(getVal(cards[j].charAt(0)), cards[j].charAt(1));
                player1.add(c);
            }
            Collections.sort(player1);

            ArrayList<Card> player2 = new ArrayList<Card>();
            for (int j = 0; j < 5; j++)
            {
                Card c = new Card(getVal(cards[j + 5].charAt(0)), cards[j + 5].charAt(1));
                player2.add(c);
            }
            Collections.sort(player2);

            // check who won the game
            System.out.println("game: " + game);
            System.out.println("player1: ");
            for (Card c1 : player1)
                System.out.println(c1 + " ");
            System.out.println();

            System.out.println("player2: ");
            for (Card c2 : player2)
                System.out.println(c2 + " ");
            System.out.println();

            Compare(player1, player2);
            System.out.println("score: " + wins1 + " " + wins2);
            System.out.println();
        }

    }

    static void Compare(ArrayList<Card> player1, ArrayList<Card> player2)
    {
        boolean p1 = royalFlush(player1);
        boolean p2 = royalFlush(player2);
        if (updateScore(p1, p2)) return;

        p1 = straightFlush(player1);
        p2 = straightFlush(player2);
        if (updateScore(p1, p2)) return;

        p1 = fourOfAKind(player1);
        p2 = fourOfAKind(player2);
        if (updateScore(p1, p2)) return;

        p1 = fullHouse(player1);
        p2 = fullHouse(player2);
        if (updateScore(p1, p2)) return;

        p1 = flush(player1);
        p2 = flush(player2);
        if (updateScore(p1, p2)) return;

        p1 = straight(player1);
        p2 = straight(player2);
        if (updateScore(p1, p2)) return;

        p1 = three(player1);
        p2 = three(player2);
        if (updateScore(p1, p2)) return;

        p1 = twoPair(player1);
        p2 = twoPair(player2);
        if (updateScore(p1, p2)) return;

        int pair1 = pair(player1);
        int pair2 = pair(player2);
        if (pair1 > 0 || pair2 > 0)
        {
            if (pair1 > pair2)
            {
                wins1++;
                return;
            }
            if (pair2 > pair1)
            {
                wins2++;
                return;
            }
            if (player1.get(4).getVal() > player2.get(4).getVal())
            {
                wins1++;
                return;
            }
            if (player1.get(4).getVal() < player2.get(4).getVal())
            {
                wins2++;
                return;
            }
            throw new IllegalStateException("Both players have a pair with the same highest card");
        }

        int val1 = player1.get(4).getVal();
        int val2 = player2.get(4).getVal();
        if (val1 > val2)
        {
            wins1++;
            return;
        }
        if (val2 > val1)
        {
            wins2++;
            return;
        }
        throw new IllegalStateException("Both players have same highest card");
    }

    public static boolean updateScore(boolean p1, boolean p2)
    {
        if (p1 || p2)
        {
            if (p1 && !p2)
            {
                wins1++;
                return true;
            }
            if (p2 && !p1)
            {
                wins2++;
                return true;
            }
            throw new IllegalStateException("Both players won this game.");
        }
        return false;
    }

    public static int pair(ArrayList<Card> player)
    {
        for (int i = 0; i < 4; i++)
        {
            if (player.get(i).getVal() == player.get(i+1).getVal())
            {
                return player.get(i).getVal();
            }
        }
        return -1;
    }

    public static boolean twoPair(ArrayList<Card> player)
    {
        if (player.get(0).getVal() == player.get(1).getVal())
        {
            if (player.get(2).getVal() == player.get(3).getVal()) return true;
            if (player.get(3).getVal() == player.get(4).getVal()) return true;
        }
        if (player.get(1).getVal() == player.get(2).getVal())
        {
            if (player.get(3).getVal() == player.get(4).getVal()) return true;
        }
        return false;
    }

    public static boolean three(ArrayList<Card> player)
    {
        for (int i = 0; i < 3; i++)
        {
            if (player.get(i).getVal() == player.get(i+2).getVal())
                return true;
        }
        return false;
    }

    public static boolean fullHouse(ArrayList<Card> player)
    {
        if (player.get(0).getVal() == player.get(2).getVal() &&
                (player.get(3).getVal() == player.get(4).getVal()))
            return true;
        if (player.get(0).getVal() == player.get(1).getVal() &&
                player.get(2).getVal() == player.get(4).getVal())
            return true;
        return false;
    }

    public static boolean fourOfAKind(ArrayList<Card> player)
    {
        if (player.get(0).getVal() == player.get(3).getVal())
            return true;
        if (player.get(1).getVal() == player.get(4).getVal())
            return true;
        return false;
    }

    public static boolean flush(ArrayList<Card> player)
    {
        char suit = player.get(0).getSuit();
        for (Card c : player)
        {
            if (c.getSuit() != suit) return false;
        }
        return true;
    }

    public static boolean straight(ArrayList<Card> player)
    {
        for (int i = 0; i < 4; i++)
        {
            int val1 = player.get(i).getVal();
            int val2 = player.get(i+1).getVal();
            if (val1 + 1 != val2) return false;
        }
        return true;
    }

    public static boolean straightFlush(ArrayList<Card> player)
    {
        return straight(player) && flush(player);
    }

    public static boolean royalFlush(ArrayList<Card> player)
    {
        return straightFlush(player) && player.get(4).getVal() == 14;
    }

    public static int getVal(char val)
    {
        if (val == 'A') return 14;
        if (val == 'K') return 13;
        if (val == 'Q') return 12;
        if (val == 'J') return 11;
        if (val == 'T') return 10;
        return val - '0';
    }

    public static class Card implements Comparable<Card>
    {
        private int val;
        private char suit;

        public Card(int val, char suit)
        {
            this.val = val;
            this.suit = suit;
        }

        public String toString()
        {
            return val + "" + suit;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public char getSuit() {
            return suit;
        }

        public void setSuit(char suit) {
            this.suit = suit;
        }

        @Override
        public int compareTo(Card o) {
            if (val == o.getVal())
                return Character.compare(suit, o.getSuit());
            return Integer.compare(val, o.getVal());
        }
    }

}
