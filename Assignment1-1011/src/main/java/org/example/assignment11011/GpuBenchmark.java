package org.example.assignment11011;

import java.util.Arrays;
import java.util.List;

public class GpuBenchmark {
    private String name;
    private double price;
    private int G3D_mark;

    public GpuBenchmark(String name, double price, int G3D_mark) {
        setName(name);
        setPrice(price);
        setG3D_mark(G3D_mark);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank() && name.length() >= 3)
            this.name = name;
        else
            throw new IllegalArgumentException("Product name must be longer than 3 characters");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must be a non-negative value");
    }

    public int getG3D_mark() {
        return G3D_mark;
    }

    public void setG3D_mark(int G3D_mark) {
        if (G3D_mark >= 0)
            this.G3D_mark = G3D_mark;
        else
            throw new IllegalArgumentException("G3D mark must be a non-negative value");
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: $%.2f, G3D Mark: %d",name, price, G3D_mark);
    }

    public static List<String> getOptions() {
        return Arrays.asList("Option1", "Option2", "Option3");
    }
}