/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author HP_User
 */

public class Palanen {
    
    private int rivi;
    private int sarake;
    
    public Palanen(int rivi, int sarake){
        this.rivi =rivi;
        this.sarake =sarake;
    }

    public int getRivi() {
        return rivi;
    }

    public int getSarake() {
        return sarake;
    }

    public void setRivi(int rivi) {
        this.rivi = rivi;
    }

    public void setSarake(int sarake) {
        this.sarake = sarake;
    }


    
}
