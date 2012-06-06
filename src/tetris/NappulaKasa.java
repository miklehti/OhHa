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
public class NappulaKasa {

    private ArrayList<Palanen> palaset;

    public NappulaKasa() {
        palaset = new ArrayList<Palanen>();
    }

    public ArrayList<Palanen> getPalaset() {
        return palaset;
    }

    
        /**
     * lisää nappulan kasaan
     *
     *
     *@param nappula lisättävä nappula
     *
     */
    
    public void lisaaPalanenMoykkyyn(Nappula nappula) {
        ArrayList<Palanen> nappulanPalat= nappula.getPalaset();
        for(int i = 0; i<nappulanPalat.size();i++){
             Palanen lisattava = nappulanPalat.get(i);
             palaset.add(lisattava);
        }

    }

          /**
     * lisää nappulan kasaan
     *
     *
     *@param i rivi jolta tiputettava
     *
     */
    
    public void tiputaMoykkya(int i) {
        
        for (int j = 0; j < palaset.size(); j++) {
            if (palaset.get(j).getRivi() == i) {
                palaset.remove(j);
                j=j-1;
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
