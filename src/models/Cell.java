package models;

public class Cell {
    int x, y;
    Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cell(int x, int y, Symbol symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
