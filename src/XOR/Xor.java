/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XOR;

import NeuralNetworkModel.*;

/**
 *
 * @author Chris
 */
public class Xor {
    
    public static void main(String[] args) {
        
        Test t1 = new Test(new double[]{0.0, 0.0}, new double[]{0.0});
        Test t2 = new Test(new double[]{0.0, 1.0}, new double[]{0.0});
        Test t3 = new Test(new double[]{1.0, 0.0}, new double[]{0.0});
        Test t4 = new Test(new double[]{1.0, 1.0}, new double[]{1.0});
        
        Test[] tests = {t1, t2, t3, t4};
        
        int layers = 3;
        int inputs = 2;
        int neuronsPerLayer = 1;
        int outputs = 1;
        int passableScore = 400;
        
        GeneticAlgorithm algo = new XorGeneticAlgorithm(tests, layers, inputs, neuronsPerLayer, outputs, passableScore) {};
        
        algo.getBestNeural().printNetwork();
    }
    
}
