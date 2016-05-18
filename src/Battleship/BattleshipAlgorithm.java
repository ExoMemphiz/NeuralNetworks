/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleship;

import Battleship.player.R3;
import NeuralNetworkModel.GeneticAlgorithm;
import NeuralNetworkModel.NeuralNetwork;
import NeuralNetworkModel.Test;
import battleshipstournament.TestTournament;
import java.util.ArrayList;
import tournament.impl.ParticipantInfo;

/**
 *
 * @author Chris
 */
public class BattleshipAlgorithm extends GeneticAlgorithm {

    
    
    public BattleshipAlgorithm(Test[] tests, int layers, int inputs, int neuronsPerLayer, int outputs, int passableScore) {
        super(tests, layers, inputs, neuronsPerLayer, outputs, passableScore);
    }

    @Override
    public void calcFitness(NeuralNetwork n, Test t) {
        
    }

    @Override
    public void runGeneration() {
        for (NeuralNetwork n : getNetworkPopulation()) {
            ArrayList<ParticipantInfo> list = RunTournament(n);
            printScore(list);
        }
    }
    
    private ArrayList<ParticipantInfo> RunTournament(NeuralNetwork n) {
        R3 r3 = new R3(n);
        TestTournament t = new TestTournament(r3, null);
        ArrayList<ParticipantInfo> list = t.run();
        return list;
    }
    
    public static void printScore(ArrayList<ParticipantInfo> list) {
        for (ParticipantInfo p : list) {
            System.out.println(p.getName() + " has " + p.getMinorPoints() + " minor points.");
        }
    }
    
    public static void printList(ArrayList<ParticipantInfo> list) {
        for (ParticipantInfo p : list) {
            System.out.println(p.getName() + " has " + p.getMatchesWon() + " matches won, "
                               + p.getMatchesLost() + " matches lost, " + p.getMatchesDraw()
                               + " matches drawn, and has " + p.getMajorPoints() + " major points.");
        }
    }
    
}