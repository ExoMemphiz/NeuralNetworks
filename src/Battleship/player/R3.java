/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Battleship.player;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;
import NeuralNetworkModel.*;

/**
 *
 * @author Tobias Grundtvig
 */
public class R3 implements PlayerFactory<BattleshipsPlayer>
{

    NeuralNetwork brain;
    
    public R3(NeuralNetwork brain) {
        this.brain = brain;
    }
    
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        Player player = new Player();
        player.setBrain(brain);
        return player;
    }

    @Override
    public String getID()
    {
        return "R3";
    }

    @Override
    public String getName()
    {
        return "R3";
    }
    
}
