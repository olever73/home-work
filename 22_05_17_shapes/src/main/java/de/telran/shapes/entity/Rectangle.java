package de.telran.shapes.entity;

public class Rectangle extends Shape {
          private int width;
          private  int heigth;

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public Rectangle(char symbol, int width, int heigth) {
        super(symbol);
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public void draw() {
     StringBuilder sb =new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <heigth ; j++) {
                sb.append(symbol).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
