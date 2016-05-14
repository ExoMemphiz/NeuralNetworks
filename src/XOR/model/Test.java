/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XOR.model;

/**
 *
 * @author CHRIS
 */
public class Test {
 
    double[] input, expectedOutput;

    public Test(double[] input, double[] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    public double[] getInput() {
        return input;
    }

    public double[] getExpectedOutput() {
        return expectedOutput;
    }
    
}