package org.example;

class BotPlayer extends Player {
    private PlayStyle playStyle;

    public BotPlayer(String name, int money, PlayStyle playStyle) {
        super(name, money);
        this.playStyle = playStyle;
    }

    @Override
    public void throwDice() {
        // Simulate throwing dice based on play style
        int roll;
        if (playStyle == PlayStyle.AGGRESSIVE) {
            roll = (int) (Math.random() * 6) + 1;
        } else {
            roll = (int) (Math.random() * 3) + 1;
        }
        System.out.println("Bot rolled a " + roll);
        movePlayer(roll);
    }
}