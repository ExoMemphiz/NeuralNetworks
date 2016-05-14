/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XOR.geneticalgorithm;

import XOR.model.Test;
import XOR.model.NeuralNetwork;

/**
 *
 * @author CHRIS
 */
public class GeneticAlgorithm {
 
    int population = 20;
    
    int layers, inputs, neuronsPerLayer, outputs, passableScore;
    NeuralNetwork[] networkPopulation;
    Test[] tests;
    NeuralNetwork bestNeural;

    public GeneticAlgorithm(Test[] tests, int layers, int inputs, int neuronsPerLayer, int outputs, int passableScore) {
        this.layers = layers;
        this.inputs = inputs;
        this.neuronsPerLayer = neuronsPerLayer;
        this.outputs = outputs;
        this.tests = tests;
        this.passableScore = passableScore;
        initPopulation();
        while (!passedTests()) {
            //Test them all
            for (NeuralNetwork n : networkPopulation) {
                TestNeuralNetwork(n);
            }
            //if passedTest return best one
            if (passedTests()) {
                bestNeural = getBestNeural();
                break;
            }
            //else reproduce with the top X amount
            
        }
    }
    
    public void initPopulation() {
        networkPopulation = new NeuralNetwork[population];
        for (int i = 0; i < population; i++) {
            networkPopulation[i] = new NeuralNetwork(layers, inputs, neuronsPerLayer, outputs);
        }
    }
    
    public void initPopulation(NeuralNetwork[] bestNetworks) {
        networkPopulation = new NeuralNetwork[population];
        for (int i = 0; i < population; i++) {
            networkPopulation[i] = new NeuralNetwork(layers, inputs, neuronsPerLayer, outputs);
        }
    }
    
    public boolean passedTests() {
        for (NeuralNetwork n : networkPopulation) {
            if (n.getScore() >= passableScore) {
                return true;
            }
        }
        return false;
    }
    
    public NeuralNetwork getBestNeural() {
        NeuralNetwork best = null;
        double bestScore = 0;
        for (NeuralNetwork n : networkPopulation) {
            if (n.getScore() > bestScore) {
                best = n;
                bestScore = n.getScore();
            }
        }
        return best;
    }
    
    public double TestNeuralNetwork(NeuralNetwork n) {
        n.setScore(0);
        for (Test t : tests) {
            calcFitness(n, t);
        }
        return n.getScore();
    }
    
    private void calcFitness(NeuralNetwork n, Test t) {
        n.feed(t.getInput());
        double[] actualOutputs = n.getOutputs();
        for (int i = 0; i < actualOutputs.length; i++) {
            if (actualOutputs[i] == t.getExpectedOutput()[i]) {
                n.addScore(100);
            } else {
                n.addScore(-3);
            }
        }
    }
    
}