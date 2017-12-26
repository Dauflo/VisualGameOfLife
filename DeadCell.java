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
public class DeadCell extends Cell {

	public Cell newGeneration(int nbNeighbours) {
		if (nbNeighbours == 3) {
			return new AliveCell();
		} else {
			return this;
		}
	}

	public String getAsString() {
		return "- ";
	}

	public boolean isAlive() {
		return false;
	}

}