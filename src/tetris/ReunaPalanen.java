/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;

/**
 *
 * @author miklehti
 */
public class ReunaPalanen extends Palanen {
    private boolean reuna;
    
    public ReunaPalanen(int rivi, int sarake){
        super(rivi,sarake);
        reuna = true;
        super.setVari(Color.gray);
    }

    
    public boolean isReuna() {
        return reuna;
    }

    public void setReuna(boolean reuna) {
        this.reuna = reuna;
    }


}
