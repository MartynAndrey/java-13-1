package ru.netology.domain;

public class TShort extends Product {
    private String color;

    public TShort() {
        super();
    }

    public TShort(int id, String name, int price, String color) {
        super(id, name, price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}