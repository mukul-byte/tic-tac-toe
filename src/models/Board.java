package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    ArrayList<List<Cell>> boardCells = new ArrayList<>();

    public Board(int size) {
        for(int idx=0; idx<size; idx++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int colIdx = 0; colIdx < size; colIdx++) {
                row.add(new Cell(idx, colIdx));
            }
            boardCells.add(row);
        }
    }
}
