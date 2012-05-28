/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nappulat;

import java.util.ArrayList;
import tetris.Nappula;
import tetris.Palanen;

/**
 *
 * @author HP_User
 */
public class Nelio extends Nappula {

    public Nelio(int x, int y) {
        
        super(4, x, y);
        
        
        ArrayList<Palanen> palaset = super.getPalaset();

        for (int i = 1; i < palaset.size(); i++) {
            int rivi = 0;
            int sarake = 0;

            Palanen pala = palaset.get(i);
            if (i == 1) {
                rivi = 1;
                sarake = 0;
            }
            if (i == 2) {
                rivi = 0;
                sarake = 1;
            }
            if (i == 3) {
                rivi = 1;
                sarake = 1;
            }
            muutaKoordinaatteja(pala, rivi, sarake);
        }          
     super.setPalaset(palaset);
     
        super.setAsento(1);
        super.setAloituskorkeus(2);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(0);
    }

    public boolean pyorahda(Palanen[][]  tutkittavaAlue) {
        return false;
    }
}
