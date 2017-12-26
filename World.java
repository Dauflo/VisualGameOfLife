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
public class World {

    private Cell[][] map;

    public World(int nbColomns, int nbRows) {
        map = new Cell[nbColomns][nbRows];
    }

    /*public World(Cell[][] world) {
    }*/

    public void nextGeneration(int nbGeneration) {
        //for (int l = 0; l < nbGeneration; l++) {
            Cell[][] mapTemp = new Cell[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    mapTemp[i][j] = map[i][j];
                    int nbNeighbours = nbCloseNeighbours(i, j);
                    mapTemp[i][j] = mapTemp[i][j].newGeneration(nbNeighbours);
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = mapTemp[i][j];
                }
            }
            afficherGrille();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    //}

    public void initialisation() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (Math.random() > 0.5) {
                    map[i][j] = new AliveCell();
                } else {
                    map[i][j] = new DeadCell();
                }
            }
        }
    }

    public void afficherGrille() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[01].length; j++) {
                System.out.print(map[i][j].getAsString());
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int nbCloseNeighbours(int x, int y) {
        int nbNeigh = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!((i == x) && (j == y))) {
                    if (existingCell(i, j)) {
                        if (map[i][j].isAlive()) {
                            nbNeigh++;
                        }
                    }
                }
            }
        }

        return nbNeigh;
    }

    public boolean existingCell(int x, int y) {
        try {
            Cell exist = map[x][y];
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String toString() {
        return null;

    }
    
    public boolean getCellState(int i, int j) {
        return map[i][j].isAlive();
    }
}
