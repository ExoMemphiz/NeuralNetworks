/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NeuralNetworkModel;

/**
 *
 * @author CHRIS
 */
public class NeuronLayer {

    private final Neuron[] neurons;
    
    public NeuronLayer(int inputs, int neuronsInLayer) {
        neurons = new Neuron[neuronsInLayer];
        for (int i = 0; i < neuronsInLayer; i++) {
            Neuron n = new Neuron(new double[inputs]);
            neurons[i] = n;
        }
    }
 
    public void feed(NeuronLayer layer) {
        for (Neuron n : neurons) {          //Iterate over the neurons in the layer - Will look like this: http://www.theprojectspot.com/images/post-assets/ann.jpg
            double[] nInputs = new double[layer.getLayer().length];
            for (int i = 0; i < nInputs.length; i++) { //Iterate over the input neurons
                nInputs[i] = layer.getLayer()[i].calculateOutput();
            }
            n.updateInputs(nInputs);
        }
    }
    
    public void feed(double[] inputs) {
        if (inputs.length == neurons.length) {
            for (int i = 0; i < inputs.length; i++) {
                neurons[i].updateInputs(new double[]{inputs[i]});
            }
        } else {
            throw new AssertionError("Not the right amount of inputs for the input layer, input amount: " + inputs.length + ", amount of input neurons: " + neurons.length, null);
        }
    }
    
    public Neuron[] getLayer() {
        return neurons;
    }
    
    public void printLayer() {
        System.out.println("------------------------------------");
        for (Neuron n : neurons) {
            n.printNeuron();
        }
    }
    
}