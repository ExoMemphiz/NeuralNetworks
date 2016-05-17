/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NeuralNetworkModel;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Chris
 */
public class Neuron {
 
    private boolean recalc = true;
    private double activate, sigCalculation;    //If all inputs * weights > activate return 
    private double[] weights, inputs;
    private Random r;
    
    public Neuron(double[] inputs) {
        r = new Random();
        this.inputs = new double[inputs.length + 1];   //+ 1 because of bias, which has to be 1
        weights = new double[this.inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            weights[i] = range(-1, 1);
        }
        activate = range(0, 1);
        weights[this.inputs.length - 1] = 1;   //Bias
    }
    
    public void updateInputs(double[] inputs) {
        this.inputs = inputs;
        recalc = true;
    }
    
    public void setWeight(int index, double value) {
        weights[index] = value;
    }
    
    public void adjustWeight(int index, double diff) {
        weights[index] += diff;
    }
    
    private double range(double rangeMin, double rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
    
    public double calculateOutput() {
        if (recalc) {
            sigCalculation = sigmoid(calculateInputs());
            recalc = false;
        }
        if (sigCalculation >= activate) {
            return 1;
        }
        return 0;
    }
    
    private double calculateInputs() {
        double calc = 0.0;
        for (int i = 0; i < inputs.length; i++) {
            calc += inputs[i] * weights[i];
        }
        return calc;
    }
    
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
    
    public void printNeuron() {
        DecimalFormat format = new DecimalFormat("#.###");
        System.out.println("[Inputs: " + Arrays.toString(inputs) + 
                           ", activate Threshhold: " + format.format(activate) + 
                           ", current output: " + calculateOutput() + 
                           ", weights: " + Arrays.toString(weights) + "]");
    }
    
}