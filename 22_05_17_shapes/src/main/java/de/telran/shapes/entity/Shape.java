package de.telran.shapes.entity;

public abstract class Shape {
   protected char symbol;

    public char getSymbol() {
        return symbol;
    }

    public Shape(char symbol) {
        this.symbol = symbol;
    }
    public abstract void draw();

}
