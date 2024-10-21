package org.example.assignment11011;

import java.util.Arrays;
import java.util.List;

public class CpuBenchmark {
    private String name;
    private double price;
    private int fps;
    private String resolution;


    public CpuBenchmark(String name, double price, int fps, String resolution) {
        setName(name);
        setPrice(price);
        setFps(fps);
        setResolution(resolution);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank() && name.length() >= 10)
            this.name = name;
        else
            throw new IllegalArgumentException("CPU name must be longer than 10 characters");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 99)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must be at least $99");
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        if (fps >= 0)
            this.fps = fps;
        else
            throw new IllegalArgumentException("FPS must be a non-negative value");
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        if (!resolution.isBlank())
            this.resolution = resolution;
        else
            throw new IllegalArgumentException("Resolution cannot be empty");
    }

    @Override
    public String toString() {
        return String.format("%s, $%.2f, %d FPS, %s", name, price, fps, resolution);
    }


    public static List<String> getOptions() {
        return Arrays.asList("1920x1080", "2560x1440", "3840x2160");
    }


}
