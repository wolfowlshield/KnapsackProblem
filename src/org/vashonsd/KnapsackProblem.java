package org.vashonsd;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackProblem {

    Knapsack bag;
    ArrayList<Box> boxes = new ArrayList<>();

    private ArrayList<Box> bestSolution = new ArrayList<>();
    int bestValue = 0;

    public KnapsackProblem(int carryCap, int[] prices, int[] weights) {
        bag = new Knapsack(carryCap);
        for (int i = 0; i < prices.length; i++) {
            boxes.add(new Box(prices[i], weights[i]));
        }

        sortBoxes();
    }

    public void duplicateBoxSolver() { // This is bugged
        getMostValuableBoxes(0, boxes);
        System.out.println("Most valuable solution is: " + bestValue);
        for (Box b:bestSolution) {
            System.out.println(b);
        }
    }

    private void sortBoxes() {
        boxes.sort(new BoxComparator());
    }

    private void getMostValuableBoxes(int boxesIndex, ArrayList<Box> boxes) {
        for (Box b: boxes) {
            if (bag.getTotalValue() > bestValue) {
                bestValue = bag.getTotalValue();
                bestSolution.clear();
                bestSolution.addAll(bag.getBoxes());
            }
            if (bag.getCurrentWeight() == bag.getCarryCapacity()) {
                break;
            }

            if (bag.getCarryCapacity() - bag.getCurrentWeight() >= b.getWeight()) {
                bag.addBox(boxesIndex, b);
                getMostValuableBoxes(boxesIndex + 1, boxes);
                if (bag.getCurrentWeight() != bag.getCarryCapacity()) {
                    bag.removeBox(boxesIndex);
                }
            }
        }
    }
}