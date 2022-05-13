package org.vashonsd;

import java.util.ArrayList;

public class Knapsack {
    int carryCapacity;
    int currentWeight = 0;
    ArrayList<Box> boxes = new ArrayList<>();

    public Knapsack(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    public int getTotalValue() {
        return calculateValue();
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void addBox(int index, Box box) {
        boxes.add(index, box);
        currentWeight += box.getWeight();
    }

    public void removeBox(int index) {
        Box box = boxes.remove(index);
        currentWeight -= box.getWeight();
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    private int calculateValue() {
        int totalValue = 0;
        if (!boxes.isEmpty()) {
            for (Box b:boxes) {
                totalValue += b.getPrice();
            }
        }
        return totalValue;
    }
}
