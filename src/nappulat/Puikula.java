/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nappulat;

import java.util.ArrayList;
import tetris.Nappula;
import tetris.Palanen;
import tetris.ReunaPalanen;

/**
 *
 * @author HP_User
 */
public class Puikula extends Nappula {

    public Puikula(int montakPalasta, int x, int y) {

        super(4, x, y);

        ArrayList<Palanen> palaset = super.getPalaset();
        Palanen toka = palaset.get(1);
        toka.setRivi(x + 1);

        Palanen kolmas = palaset.get(2);
        kolmas.setRivi(x + 2);

        Palanen neljas = palaset.get(3);
        neljas.setRivi(x + 3);

        super.setPalaset(palaset);
        super.setAsento(1);
        super.setKorkeus(1);
        super.setLeveys(4);
        super.setAloituskorkeus(1);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(2);
    }

    public boolean voinkoPyoria(Palanen[][] tutkittavaAlue) {
        int asento = super.getAsento();
        if (asento == 1) {
            if (tutkittavaAlue[1][2] instanceof ReunaPalanen || tutkittavaAlue[3][2] instanceof ReunaPalanen || tutkittavaAlue[4][2] instanceof ReunaPalanen) {
                return false;
            }
        }
        if (asento == 2) {
            if (tutkittavaAlue[2][1] instanceof ReunaPalanen || tutkittavaAlue[2][3] instanceof ReunaPalanen || tutkittavaAlue[2][4] instanceof ReunaPalanen) {
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
            int uusiEkaSarake = eka.getSarake() + 1;
            eka.setSarake(uusiEkaSarake);

            Palanen kolmas = palaset.get(2);
            int uusiKolmaRivi = kolmas.getRivi() + 1;
            kolmas.setRivi(uusiKolmaRivi);
            int uusiKolmasSarake = kolmas.getSarake() -1;
            kolmas.setSarake(uusiKolmasSarake);

            Palanen neljas = palaset.get(3);
                int uusiNeljasRivi = neljas.getRivi() + 2;
            neljas.setRivi(uusiNeljasRivi);
            int uusiNeljasSarake = neljas.getSarake() -2;
            neljas.setSarake(uusiNeljasSarake);
         
            super.setPalaset(palaset);
            super.setAsento(2);


        }
        if (asento == 2) {
            ArrayList<Palanen> palaset = super.getPalaset();

            Palanen eka = palaset.get(0);
            int uusiEkaRivi = eka.getRivi() +1;
            eka.setRivi(uusiEkaRivi);
            int uusiEkaSarake = eka.getSarake() - 1;
            eka.setSarake(uusiEkaSarake);

            Palanen kolmas = palaset.get(2);
            int uusiKolmaRivi = kolmas.getRivi() - 1;
            kolmas.setRivi(uusiKolmaRivi);
            int uusiKolmasSarake = kolmas.getSarake() +1;
            kolmas.setSarake(uusiKolmasSarake);

            Palanen neljas = palaset.get(3);
                int uusiNeljasRivi = neljas.getRivi() - 2;
            neljas.setRivi(uusiNeljasRivi);
            int uusiNeljasSarake = neljas.getSarake() +2;
            neljas.setSarake(uusiNeljasSarake);
         
            super.setPalaset(palaset);
            super.setAsento(1);

        }
    }

    public boolean pyorahda(Palanen[][] tutkittavaAlue) {
        if (voinkoPyoria(tutkittavaAlue) == false) {
            return false;
        }
        toteutaPyorahdys();
        if (super.getAsento() == 1) {
            super.setAsento(2);
        } else {
            super.setAsento(1);
        }
        return true;
    }
}
