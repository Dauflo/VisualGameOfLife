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
public class AliveCell extends Cell {
	@Override
	public Cell newGeneration(int nbNeighbours) {

		if (nbNeighbours == 2 || nbNeighbours == 3) {
			return this;
		} else {
			return new DeadCell();
		}
	}

	@Override
	public String getAsString() {
		return "+ ";
	}

	@Override
	public boolean isAlive() {
		return true;
	}

}