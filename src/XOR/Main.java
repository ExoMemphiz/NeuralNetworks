/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XOR;

import XOR.geneticalgorithm.GeneticAlgorithm;
import XOR.model.Test;
import XOR.model.NeuralNetwork;


/**
 *
 * @author Chris
 */
public class Main {
    
    public static void main(String[] args) {
        
        Test t1 = new Test(new double[]{0.0, 0.0}, new double[]{0.0});
        Test t2 = new Test(new double[]{0.0, 1.0}, new double[]{0.0});
        Test t3 = new Test(new double[]{1.0, 0.0}, new double[]{0.0});
        Test t4 = new Test(new double[]{1.0, 1.0}, new double[]{1.0});
        
        Test[] tests = {t1, t2, t3, t4};
        
        GeneticAlgorithm algo = new GeneticAlgorithm(tests, 3, 2, 4, 1, 401);
        NeuralNetwork bestScoring = null;
        double bestScore = 0;
        System.currentTimeMillis();
        while (bestScore != tests.length * 100) {
            NeuralNetwork n = new NeuralNetwork(2, 2, 4, 1);
            double testScore = algo.TestNeuralNetwork(n);
            if (testScore > bestScore) {
                bestScore = testScore;
                bestScoring = n;
                System.out.println("Found a better neural network with score of: " + bestScore);
                n.printNetwork();
            }
        }
    }
    
}
