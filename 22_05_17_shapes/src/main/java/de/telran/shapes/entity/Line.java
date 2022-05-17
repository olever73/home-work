package de.telran.shapes.entity;

public class Line extends Shape{


    private int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void draw() {
    StringBuilder sb=new StringBuilder();
       for (int i=1; i<length;i++){
           sb.append(symbol).append(" ");
       }
        System.out.println(sb);
    }
}
