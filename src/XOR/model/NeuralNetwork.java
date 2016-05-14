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
public class NeuralNetwork {
 
    private double score;
    private int layers, inputs, neuronsPerLayer, outputs;

    NeuronLayer[] neuronLayers;

    public NeuralNetwork(int layers, int inputs, int neuronsPerLayer, int outputs) {
        this.layers = layers;
        this.inputs = inputs;
        this.neuronsPerLayer = neuronsPerLayer;
        this.outputs = outputs;
        init();
    }
    
    public NeuralNetwork() {
        layers = 3; 
        inputs = 2;
        neuronsPerLayer = 4;
        outputs = 1;
        init();
    }
    
    private void init() {
        neuronLayers = new NeuronLayer[layers];
        for (int i = 0; i < neuronLayers.length; i++) {
            if (i == 0) {
                //Case: Input layer
                neuronLayers[i] = new NeuronLayer(inputs, inputs);
            } else if (i == neuronLayers.length - 1) {
                //Case: Output layer
                int neuronInputs = neuronLayers[i - 1].getLayer().length;
                neuronLayers[i] = new NeuronLayer(neuronInputs, outputs);
            } else if (i == 1) {
                //Case: First hidden layer, which takes the output amount from the input layer
                neuronLayers[i] = new NeuronLayer(inputs, neuronsPerLayer);
            } else {
                //Case: All other hidden layers
                neuronLayers[i] = new NeuronLayer(neuronsPerLayer, neuronsPerLayer);
            }
        }
    }
    
    public NeuronLayer getInputLayer() {
        return neuronLayers[0];
    }
    
    public NeuronLayer[] getHiddenLayers() {
        NeuronLayer[] hiddenLayers = new NeuronLayer[layers - 2];
        for (int i = 1; i < layers - 1; i++) {
            hiddenLayers[i - 1] = neuronLayers[i];
        }
        return hiddenLayers;
    }
    
    public NeuronLayer getLastHiddenLayer() {
        NeuronLayer[] hiddenLayers = new NeuronLayer[layers - 2];
        for (int i = 1; i < layers - 1; i++) {
            hiddenLayers[i - 1] = neuronLayers[i];
        }
        int length = hiddenLayers.length - 1;
        if (length >= 0) {
            return hiddenLayers[length];
        }
        return null;
    }
    
    public NeuronLayer getOutputLayer() {
        return neuronLayers[layers - 1];
    }
    
    public void feed(Test t) {
        feed(t.getInput());
    }
    
    public void feed(double[] inputValues) {
        if (inputValues.length == inputs) {
            getInputLayer().feed(inputValues);
            NeuronLayer[] hiddenLayers = getHiddenLayers();
            for (int i = 0; i < hiddenLayers.length; i++) {
                if (i == 0) {
                    hiddenLayers[i].feed(getInputLayer());
                } else {
                    hiddenLayers[i].feed(hiddenLayers[i - 1]);
                }
            }
            NeuronLayer lastHidden = getLastHiddenLayer();
            if (lastHidden != null) {
                getOutputLayer().feed(lastHidden);
            } else {
                getOutputLayer().feed(getInputLayer());
            }
        } else {
            throw new AssertionError("Not the right amount of inputs for the input layer, inputValue amount: " + inputValues.length + ", amount of input neurons: " + inputs, null);
        }
    }
    
    public double[] getOutputs() {
        double[] finalOutputs = new double[outputs];
        NeuronLayer outputLayer = getOutputLayer();
        for (int i = 0; i < outputs; i++) {
            finalOutputs[i] = outputLayer.getLayer()[i].calculateOutput();
        }
        return finalOutputs;
    }
    
    public void printNetwork() {
        for (NeuronLayer layer : neuronLayers) {
            layer.printLayer();
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public void addScore(double score) {
        this.score += score;
    }
    
}