/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XOR;

import NeuralNetworkModel.GeneticAlgorithm;
import NeuralNetworkModel.NeuralNetwork;
import NeuralNetworkModel.Test;

/**
 *
 * @author CHRIS
 */
public class XorGeneticAlgorithm extends GeneticAlgorithm {

    public XorGeneticAlgorithm(Test[] tests, int layers, int inputs, int neuronsPerLayer, int outputs, int passableScore) {
        super(tests, layers, inputs, neuronsPerLayer, outputs, passableScore);
    }

    @Override
    public void calcFitness(NeuralNetwork n, Test t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
