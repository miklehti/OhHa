/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nappulat;

import java.util.ArrayList;
import tetris.Nappula;
import tetris.Palanen;
import tetris.ReunaPalanen;
import tetris.TetrisPalanen;

/**
 *
 * @author HP_User
 */
public class Vihrea extends Nappula{
    public Vihrea(int x, int y) {

        super(4, x, y);

        ArrayList<Palanen> palaset = super.getPalaset();
        Palanen toka = palaset.get(1);
        toka.setSarake(y + 1);

        Palanen kolmas = palaset.get(2);
        kolmas.setSarake(y + 1);
        kolmas.setRivi(x+1);

        Palanen neljas = palaset.get(3);
        neljas.setRivi(x + 1);
        neljas.setSarake(y + 2);

        super.setPalaset(palaset);
        super.setAsento(1);
        super.setKorkeus(2);
        super.setLeveys(3);
        super.setAloituskorkeus(2);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(1);

    }
      public boolean voinkoPyoria(Palanen[][] tutkittavaAlue) {
        int asento = super.getAsento();
        if (asento == 1) {
            if (tutkittavaAlue[0][4] instanceof ReunaPalanen ||tutkittavaAlue[1][2] instanceof ReunaPalanen) {
                return false;
            }
            if (tutkittavaAlue[0][4] instanceof TetrisPalanen || tutkittavaAlue[1][2] instanceof TetrisPalanen) {
                return false;
            }
        }
        if (asento == 2) {
             if (tutkittavaAlue[1][0] instanceof ReunaPalanen ||tutkittavaAlue[2][2] instanceof ReunaPalanen) {
                return false;
            }
            if (tutkittavaAlue[1][0] instanceof TetrisPalanen || tutkittavaAlue[2][2] instanceof TetrisPalanen) {
                return false;
            }
        }
       
        return true;
    }

    public void toteutaPyorahdys() {
        int asento = super.getAsento();
        if (asento == 1) {
             ArrayList<Palanen> palaset = super.getPalaset();

            Palanen eka = palaset.get(0);
            int uusiEkaRivi = eka.getRivi() - 1;
            eka.setRivi(uusiEkaRivi);
            int uusiEkaSarake = eka.getSarake() + 2;
            eka.setSarake(uusiEkaSarake);


            Palanen neljas = palaset.get(3);
        
            int uusiNeljasRivi = neljas.getRivi() - 1;
            neljas.setSarake(uusiNeljasRivi);

            super.setPalaset(palaset);
            super.setAsento(2);
            
        }
        if (asento == 2) {
             ArrayList<Palanen> palaset = super.getPalaset();

            Palanen eka = palaset.get(0);
            int uusiEkaRivi = eka.getRivi() + 1;
            eka.setRivi(uusiEkaRivi);
            int uusiEkaSarake = eka.getSarake() - 2;
            eka.setSarake(uusiEkaSarake);

       

            Palanen neljas = palaset.get(3);
        
            int uusiNeljasRivi = neljas.getRivi() + 1;
            neljas.setSarake(uusiNeljasRivi);

            super.setPalaset(palaset);
            super.setAsento(1);

        
       
        }

    }

    public boolean pyorahda(Palanen[][] tutkittavaAlue) {
        if (voinkoPyoria(tutkittavaAlue) == false) {
            return false;
        }
        toteutaPyorahdys();
       
        return true;
    }
    
    
}
