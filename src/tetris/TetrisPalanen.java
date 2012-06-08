/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author miklehti
 */

import java.awt.Color;

public class TetrisPalanen extends Palanen{
     private boolean tetrispalanen;
     
     public TetrisPalanen(int rivi, int sarake){
         super(rivi,sarake);
         tetrispalanen=true;
         
     }

    public boolean isTetrispalanen() {
        return tetrispalanen;
    }

    public void setTetrispalanen(boolean tetrispalanen) {
        this.tetrispalanen = tetrispalanen;
    }
     
}
