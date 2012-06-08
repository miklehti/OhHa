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
import java.awt.Color;
/**
 *
 * @author HP_User
 */
public class SininenL extends Nappula {

    public SininenL(int x, int y) {

        super(4, x, y);
        ArrayList<Palanen> palaset = super.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            int rivi = 0;
            int sarake = 0;

            Palanen pala = palaset.get(i);
            if (i == 1) {
                rivi = 0;
                sarake = -1;
            }
            if (i == 2) {
                rivi = 0;
                sarake = -2;
            }
            if (i == 3) {
                rivi = 1;
                sarake = -2;
            }
             pala.setVari(Color.BLUE);
            muutaKoordinaatteja(pala, rivi, sarake);
        }

        super.setPalaset(palaset);
        super.setAsento(1);
        super.setAloituskorkeus(2);
        super.setKeskipiste(super.getPalanen(1));
        super.setSade(1);

    }
    
                        /**
     * voiko palanen pyöriä
     *
     *
     *@param tutkittavaAlue tutkittava alue, 
     
     *@return onnaako
     */

    public boolean voinkoPyoria(Palanen[][] tutkittavaAlue) {
        int asento = super.getAsento();
        if (asento == 1) {
            if (tutkittavaAlue[0][0] instanceof Palanen || tutkittavaAlue[0][1] instanceof Palanen || tutkittavaAlue[2][1] instanceof Palanen) {
                return false;
            }

        }
        if (asento == 2) {
            if (tutkittavaAlue[0][2] instanceof Palanen || tutkittavaAlue[1][2] instanceof Palanen || tutkittavaAlue[1][0] instanceof Palanen) {
                return false;
            }

        }
        if (asento == 3) {
            if (tutkittavaAlue[2][1] instanceof Palanen || tutkittavaAlue[2][2] instanceof Palanen || tutkittavaAlue[0][1] instanceof Palanen) {
                return false;
            }

        }
        if (asento == 4) {
            if (tutkittavaAlue[1][0] instanceof Palanen || tutkittavaAlue[2][0] instanceof Palanen || tutkittavaAlue[1][2] instanceof Palanen) {
                return false;
            }

        }
        return true;
    }
    
    
                      /**
     * toteuta pyörähdys nappulatasolla
     *
     *

     */
     public void toteutaPyorahdys() {
        int asento = super.getAsento();
        if (asento == 1) {
            pyorahdysYksi(true);

        }
        if (asento == 2) {
            pyorahdysKaksi(true);

        }
        if (asento == 3) {
            pyorahdysYksi(false);


        }
        if (asento == 4) {
            pyorahdysKaksi(false);

        }

    }
     
                          /**
     * toteuta pyörähdys ja mihin suuntaan
     *
     *@param myotaPaivaan kumpaan suuntaan pyöritään
     */
     
      public void pyorahdysYksi(boolean myotaPaivaan) {
        ArrayList<Palanen> palaset = super.getPalaset();

        for (int i = 0; i < palaset.size(); i++) {          
                pyoraytaPalaaYksi(palaset, i, myotaPaivaan);

        }
        super.setPalaset(palaset);
       // super.setAsento(2);
    }
      
                                     /**
     * toteuta pyörähdys palastasolla
     *
     *@ param palaset palaset
     * @param i mikä palanen?
     * @param myotaPaivaan kumpaan suuntaan pyöritetään?
     */
     
     public void pyoraytaPalaaYksi(ArrayList<Palanen> palaset, int i, boolean myotaPaivaan) {
        int rivi = 0;
        int sarake = 0;

        Palanen pala = palaset.get(i);
        if (i == 0) {
            rivi = 1;
            sarake = -1;
        }
        if (i == 1) {
            return;
        }
        if (i == 2) {
            rivi = -1;
            sarake = 1;
        }
        if (i == 3) {
            rivi = -2;
            sarake = 0;
        }
        if (myotaPaivaan == true) {
            muutaKoordinaatteja(pala, rivi, sarake);
            super.setAsento(2);
        } else {
            muutaKoordinaatteja(pala, rivi * (-1), sarake * (-1));
            super.setAsento(4);
        }

    }
     
                          /**
     * toteuta pyörähdys ja mihin suuntaan
     *
     *@param myotaPaivaan kumpaan suuntaan pyöritään
     */
     
      public void pyorahdysKaksi(boolean myotaPaivaan) {
        ArrayList<Palanen> palaset = super.getPalaset();

        for (int i = 0; i < palaset.size(); i++) {          
                pyoraytaPalaaKaksi(palaset, i, myotaPaivaan);

        }
        super.setPalaset(palaset);
       
    }
      
                                     /**
     * toteuta pyörähdys palastasolla
     *
     *@ param palaset palaset
     * @param i mikä palanen?
     * @param myotaPaivaan kumpaan suuntaan pyöritetään?
     */
     
     public void pyoraytaPalaaKaksi(ArrayList<Palanen> palaset, int i, boolean myotaPaivaan) {
        int rivi = 0;
        int sarake = 0;

        Palanen pala = palaset.get(i);
        if (i == 0) {
            rivi = -1;
            sarake = -1;
        }
        if (i == 1) {
            return;
        }
        if (i == 2) {
            rivi = 1;
            sarake = 1;
        }
        if (i == 3) {
            rivi = 0;
            sarake = 2;
        }
        if (myotaPaivaan == true) {
            muutaKoordinaatteja(pala, rivi, sarake);
             super.setAsento(3);
        } else {
            muutaKoordinaatteja(pala, rivi * (-1), sarake * (-1));
             super.setAsento(1);
        }

    }


                /**
     * jokaiselle aliluokan tulee toteuttaa oma pyörimisensä
     *
     *
     *@param tutkittavaAlue tutkittava alue, 
     
     *
     */
     

    public boolean pyorahda(Palanen[][] tutkittavaAlue) {
        if (voinkoPyoria(tutkittavaAlue) == false) {
            return false;
        }
        toteutaPyorahdys();


        return true;
    }
}
