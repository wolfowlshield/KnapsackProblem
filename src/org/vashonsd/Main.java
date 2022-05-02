package org.vashonsd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("how big do you want the bag to be?");
        int carryCap = input.nextInt();
        System.out.println("How Many boxes do you want?");
        int numBoxes = input.nextInt();
        int[] prices = new int[numBoxes];
        int[] weights = new int[numBoxes];
        for (int i = 0; i < numBoxes; i++) {
            System.out.println("What is the price of Box " + (i + 1));
            prices[i] = input.nextInt();
            System.out.println("What is the weight of Box " + (i + 1));
            weights[i] = input.nextInt();
        }

        KnapsackProblem problem = new KnapsackProblem(carryCap, prices, weights);
        problem.duplicateBoxSolver();
    }
}
