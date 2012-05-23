/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nappulat;

import java.util.ArrayList;
import tetris.Nappula;

/**
 *
 * @author HP_User
 */
public class Nelio extends Nappula {

 
   

    public Nelio(int x, int y) {

        super(x,y);
        super.setTokaRivi(x+1);
        super.setKolmasSarake(y+1);
        super.setNeljasSarake(y+1);
        super.setNeljasivi(x+1);
        super.setAsento(1);
        super.setKorkeus(2);
        super.setLeveys(2);
    }

    public boolean pyorahda(ArrayList<Integer> tutkittavaAlue ){
        return false;
    }
 
}
