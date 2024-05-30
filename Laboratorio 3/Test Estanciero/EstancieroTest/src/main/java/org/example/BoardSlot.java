package org.example;

abstract class BoardSlot {
    protected String name;
    protected int position;

    public BoardSlot(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public abstract void handlePlayerAction(Player player);
}

