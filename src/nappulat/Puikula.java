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
public class Puikula extends Nappula {

    public Puikula(int x, int y) {

        super(4, x, y);

        ArrayList<Palanen> palaset = super.getPalaset();

        for (int i = 1; i < palaset.size(); i++) {
            int rivi = 0;
            int sarake = 0;

            Palanen pala = palaset.get(i);
            if (i == 1) {
                rivi = 0;
                sarake = 1;
            }
            if (i == 2) {
                rivi = 0;
                sarake = 2;
            }
            if (i == 3) {
                rivi = 0;
                sarake = 3;
            }
            muutaKoordinaatteja(pala, rivi, sarake);
        }
        super.setPalaset(palaset);
        super.setAsento(1);
        super.setAloituskorkeus(1);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(2);
    }

    public boolean voinkoPyoria(Palanen[][] tutkittavaAlue) {
        int asento = super.getAsento();
        if (asento == 1) {
            if (tutkittavaAlue[1][2] instanceof Palanen || tutkittavaAlue[3][2] instanceof Palanen || tutkittavaAlue[4][2] instanceof Palanen) {
                return false;
            }

        }
        if (asento == 2) {
            if (tutkittavaAlue[2][1] instanceof Palanen || tutkittavaAlue[2][3] instanceof Palanen || tutkittavaAlue[2][4] instanceof Palanen) {
                return false;
            }
        }
        return true;
    }

    public void toteutaPyorahdys() {
        int asento = super.getAsento();
        if (asento == 1) {
            pyorahdys(true);
        }
        if (asento == 2) {
            pyorahdys(false);
        }
    }

    

    public void pyoraytaPalaa(ArrayList<Palanen> palaset, int i, boolean myotaPaivaan) {
        int rivi = 0;
        int sarake = 0;

        Palanen pala = palaset.get(i);
        if (i == 0) {
            rivi = -1;
            sarake = 1;
        }
        if (i == 1) {
            return;
        }
        if (i == 2) {
            rivi = 1;
            sarake = -1;
        }
        if (i == 3) {
            rivi = +2;
            sarake = -2;
        }
        if (myotaPaivaan == true) {
            muutaKoordinaatteja(pala, rivi, sarake);
             super.setAsento(2);
        } else {
            muutaKoordinaatteja(pala, rivi * (-1), sarake * (-1));
             super.setAsento(1);
        }

    }

    public void pyorahdys(boolean myotaPaivaan) {
        ArrayList<Palanen> palaset = super.getPalaset();

        for (int i = 0; i < palaset.size(); i++) {          
                pyoraytaPalaa(palaset, i, myotaPaivaan);

        }
        super.setPalaset(palaset);
       
    }

    public boolean pyorahda(Palanen[][] tutkittavaAlue) {
        if (voinkoPyoria(tutkittavaAlue) == false) {
            return false;
        }
        toteutaPyorahdys();
        return true;
    }
}
