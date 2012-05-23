/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author miklehti
 */
public class ReunaPalanen extends Palanen {
    private boolean reuna;
    
    public ReunaPalanen(int rivi, int sarake){
        super(rivi,sarake);
        reuna = true;
    }

    
    public boolean isReuna() {
        return reuna;
    }

    public void setReuna(boolean reuna) {
        this.reuna = reuna;
    }


}
