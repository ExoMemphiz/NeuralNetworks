/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XOR;

import java.util.Random;

/**
 *
 * @author Chris
 */
public class Neuron {
 
    double activate;    //If all inputs * weights > activate return 
    double[] weights, inputs;
    Random r;
    
    public Neuron(double[] inputs) {
        r = new Random();
        this.inputs = new double[inputs.length + 1];   //+ 1 because of bias, which has to be 1
        weights = new double[this.inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            weights[i] = range(-1, 1);
        }
        weights[this.inputs.length - 1] = 1;   //Bias
    }
    
    void updateInputs(double[] inputs) {
        this.inputs = inputs;
    }
    
    void setWeight(int index, double value) {
        weights[index] = value;
    }
    
    private double range(double rangeMin, double rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
    
    public double activate() {
        return sigmoid(calculateInputs());
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
    
}