package org.example;

class HumanPlayer extends Player {
    public HumanPlayer(String name, int money) {
        super(name, money);
    }

    @Override
    public void throwDice() {
        // Simulate throwing dice
        int roll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + roll);
        movePlayer(roll);
    }
}
