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

    public Nelio(int montakoPalaa, int x, int y) {
        
        super(4, x, y);
     ArrayList<Palanen> palaset = super.getPalaset();
     Palanen toka = palaset.get(1);
     toka.setRivi(x+1);
     toka.setSarake(y);
     Palanen kolmas = palaset.get(2);
     kolmas.setRivi(x);
     kolmas.setSarake(y+1);
      Palanen neljas = palaset.get(3);
     neljas.setRivi(x+1);
     neljas.setSarake(y+1);
     super.setPalaset(palaset);
     
        super.setAsento(1);
        super.setKorkeus(2);
        super.setLeveys(2);
        super.setAloituskorkeus(2);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(0);
    }

    public boolean pyorahda(Palanen[][]  tutkittavaAlue) {
        return false;
    }
}
