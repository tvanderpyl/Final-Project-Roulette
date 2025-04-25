public class Player {
    private int money;
    private int bet;

    public Player() {
        money = 1000;
        bet = 20;
    }

    public int getBet(){
        return bet;
    }

    public int betUp(){
        return 1;
    }

    public int betDown(){
        return 1;
    }

    public int getMoney() {
        return money;
    }

    public void editMoney(int change){
        money += change;
    }
}