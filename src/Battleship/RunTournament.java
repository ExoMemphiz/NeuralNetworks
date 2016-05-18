/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleship;

import battleshipstournament.TestTournament;
import java.util.ArrayList;
import tournament.impl.ParticipantInfo;

/**
 *
 * @author Chris
 */
public class RunTournament {
 
    public static void main(String[] args) {
        BattleshipAlgorithm algo = new BattleshipAlgorithm(null, 5, 100, 4, 100, 100);
        algo.runGeneration();
    }
    
}