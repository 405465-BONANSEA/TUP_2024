package org.example;

class Bank {
    private int money;

    public Bank() {
        this.money = 10000;
    }

    public void payAmountToPlayer(Player player, int amount) {
        player.setMoney(player.getMoney() + amount);
        money -= amount;
    }
}

