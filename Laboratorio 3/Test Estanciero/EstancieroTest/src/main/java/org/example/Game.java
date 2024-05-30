package org.example;

import java.util.ArrayList;

class Game {
    private Bank bank;
    private Board board;
    private ArrayList<Player> players;
    private GameMode gameMode;

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        this.bank = new Bank();
        this.board = new Board();
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // Initialize game state
        for (Player player : players) {
            player.setMoney(1000);
        }

        // Game loop
        while (true) {
            for (Player player : players) {
                player.throwDice();
                int position = player.getPosition();
                BoardSlot slot = board.getSlotAtPosition(position);
                // Handle slot actions (e.g., buying properties, paying rent)
                //...
            }
        }
    }
}

