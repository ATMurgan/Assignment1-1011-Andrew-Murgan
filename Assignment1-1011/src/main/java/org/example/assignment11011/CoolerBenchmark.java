package org.example.assignment11011;

import java.util.Arrays;
import java.util.List;

public class CoolerBenchmark {
    private String name;
    private int rpm;
    private double cpu_load;

    public CoolerBenchmark(String name, int rpm, double cpu_load) {
        setName(name);
        setRpm(rpm);
        setCpu_load(cpu_load);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank() && name.length() >= 3)
            this.name = name;
        else
            throw new IllegalArgumentException("Cooler name must be longer than 3 characters");
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        if (rpm >= 0)
            this.rpm = rpm;
        else
            throw new IllegalArgumentException("RPM must be a non-negative value");
    }

    public double getCpu_load() {
        return cpu_load;
    }

    public void setCpu_load(double cpu_load) {
        if (cpu_load >= 0.0 && cpu_load <= 100.0)
            this.cpu_load = cpu_load;
        else
            throw new IllegalArgumentException("CPU load must be between 0.0 and 100.0");
    }

    @Override
    public String toString() {
        return String.format("Name: %s, RPM: %d, CPU Load: %.2f%%",name, rpm, cpu_load);
    }

    public static List<String> getOptions() {
        return Arrays.asList("Low Noise", "High Performance", "RGB Lighting");
    }
}
