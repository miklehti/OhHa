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
       
        super.setPalasenRivi(x + 1, 1);
        super.setPalasenSarake(y + 1, 2);
        super.setPalasenRivi(x + 1, 3);
        super.setPalasenSarake(y + 1, 3);
        super.setAsento(1);
        super.setKorkeus(2);
        super.setLeveys(2);
        super.setAloitussade(2);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(2);
    }

    public boolean pyorahda(Palanen[][]  tutkittavaAlue) {
        return false;
    }
}
