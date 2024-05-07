package org.example;

import java.util.List;
import java.util.ArrayList;

class Board {
    private List<BoardSlot> slots;

    public Board() {
        slots = new ArrayList<>();
        // Initialize board slots
        //...
    }

    public BoardSlot getSlotAtPosition(int position) {
        return slots.get(position);
    }
}