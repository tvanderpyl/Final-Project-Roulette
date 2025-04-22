public class Player {
    private int money;

    public Player() {
        money = 1000;
    }

    public int getMoney() {
        return money;
    }

    public void editMoney(int change){
        money += change;
    }
}