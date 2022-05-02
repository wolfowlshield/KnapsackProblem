package org.vashonsd;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
        double box1AverageValue = (double) o1.getPrice() / o1.getWeight();
        double box2AverageValue = (double) o2.getPrice() / o2.getWeight();

        return Double.compare(box2AverageValue, box1AverageValue);
    }
}
