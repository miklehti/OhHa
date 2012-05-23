/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

/**
 *
 * @author HP_User
 */
public class Moykky {

    private ArrayList<Palanen> palaset;

    public Moykky() {
        palaset = new ArrayList<Palanen>();
    }

    public ArrayList<Palanen> getPalaset() {
        return palaset;
    }

    public void lisaaPalanenMoykkyyn(Nappula nappula) {
        Palanen eka = nappula.getEka();
        Palanen toka = nappula.getToka();
        Palanen kolmas = nappula.getKolmas();
        Palanen neljas = nappula.getNeljas();
        palaset.add(eka);
        palaset.add(toka);
        palaset.add(kolmas);
        palaset.add(neljas);
    }

    public void tiputaMoykkya(int i) {
        for (int j = 0; j < palaset.size(); j++) {
            if (palaset.get(j).getRivi() == i) {
                palaset.remove(new Integer(j));
            }

        }
         for (int h = 0; h < palaset.size(); h++) {
             if(palaset.get(h).getRivi()<i){
                 Palanen palanen = palaset.get(h);
                 int rivi = palanen.getRivi();
                 palanen.setRivi(rivi+1);
             }
         }
    }
}
