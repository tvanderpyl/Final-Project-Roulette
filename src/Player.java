public class Player {
    private int money;
    private int bet;

    public Player() {
        money = 1000;
        bet = 0;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public int getMoney() {
        return money;
    }
}