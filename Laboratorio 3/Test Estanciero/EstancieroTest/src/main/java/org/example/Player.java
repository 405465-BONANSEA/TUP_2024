package org.example;

abstract class Player {
    protected String name;
    protected int money;
    protected int position;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.position = 0;
    }

    public abstract void throwDice();

    public void movePlayer(int spaces) {
        position += spaces;
    }

    public int getPosition() {
        return position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
