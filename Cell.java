/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualgameoflife;

/**
 *
 * @author alois
 */
public abstract class Cell {
	
	public abstract Cell newGeneration(int nbNeighbours);

	public abstract String getAsString();

	public abstract boolean isAlive();
}