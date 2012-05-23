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
public class Puikula extends Nappula {

    public Puikula(int x, int y) {

        super(x, y);
        super.setTokaRivi(x + 1);
        super.setKolmasRivi(x + 2);
        super.setNeljasivi(x + 3);
        super.setAsento(1);
        super.setKorkeus(1);
        super.setLeveys(4);
    }

    public boolean voinkoPyoria(ArrayList<Integer> tutkittavaAlue) {
        int asento = super.getAsento();
        if (asento == 1) {
            if (tutkittavaAlue.get(2) > 1 || tutkittavaAlue.get(0) > 1 || tutkittavaAlue.get(9) > 1) {
                return false;
            }
        }
        if (asento == 2) {
            if (tutkittavaAlue.get(3) > 1 || tutkittavaAlue.get(1) > 1 || tutkittavaAlue.get(8) > 1) {
                return false;
            }
        }
        return true;
    }

    public void toteutaPyorahdys() {
        int asento = super.getAsento();
        if (asento == 1) {
            int uusiEkaRivi = super.annaEkaRivi() - 1;
            int uusiEkaSarake = super.annaEkaSarake() + 1;
            int uusiKolmasRivi = super.annaKolmasRivi() + 1;
            int uusiKolmasSarake = super.annaKolmasSarake() - 1;
            int uusiNeljasRivi = super.annaNeljasRivi() + 2;
            int uusiNeljasSarake = super.annaNeljasSarake() - 2;
            super.setEkaRivi(uusiEkaRivi);
            super.setEkaSarake(uusiEkaSarake);
            super.setKolmasRivi(uusiKolmasRivi);
            super.setKolmasSarake(uusiKolmasSarake);
            super.setNeljasivi(uusiNeljasRivi);
            super.setNeljasSarake(uusiNeljasSarake);
        }
        if (asento == 2) {
            int uusiEkaRivi = super.annaEkaRivi()+1;
            int uusiEkaSarake = super.annaEkaSarake()-1;
            int uusiKolmasRivi = super.annaKolmasRivi()-1;
            int uusiKolmasSarake = super.annaKolmasSarake()+1;
            int uusiNeljasRivi = super.annaNeljasRivi()-2;
            int uusiNeljasSarake = super.annaNeljasSarake()+2;
            super.setEkaRivi(uusiEkaRivi);
            super.setEkaSarake(uusiEkaSarake);
            super.setKolmasRivi(uusiKolmasRivi);
            super.setKolmasSarake(uusiKolmasSarake);
            super.setNeljasivi(uusiNeljasRivi);
            super.setNeljasSarake(uusiNeljasSarake);
        }
    }

    public boolean pyorahda(ArrayList<Integer> tutkittavaAlue) {
        if (voinkoPyoria(tutkittavaAlue) == false) {
            return false;
        }
        toteutaPyorahdys();
        if(super.getAsento()==1){
            super.setAsento(2);
        } else{
            super.setAsento(1);      
    }
        return true;
    }
}
