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
public abstract class Nappula {

    /**
     * voiko nappulaa enää siirtää
     */
    private boolean onkoNappulaElossa;

    /**
     * missä asennossa nappula on 1-4
     */
    private int asento;
    /**
     * lista nappulan palasista, perustetriksessä 4.
     */
    private ArrayList<Palanen> palaset = new ArrayList<Palanen>();
    /**
     * mikä palanen on keskipiste, eli minkä palasen suhteen pyöritään ympäri
     */
    private Palanen keskipiste;
    /**
     * kuinka paljon tilaa nappula tarvitsee pyöriäkseen ympäri, perusnappulalle
     * 1, paitsi puikulalle 2.
     */
    private int sade;
    /**
     * käytetään game over alueen laskentaan
     */
    private int aloituskorkeus; //käytetään game over alueen laskentaan

    public Nappula(int montakoPalasta, int x, int y) {

        for (int i = 0; i < montakoPalasta; i++) {
            TetrisPalanen lisattava = new TetrisPalanen(x, y);
            palaset.add(lisattava);

        }
        onkoNappulaElossa = true;

        keskipiste = null;

    }
    

    public Palanen getKeskipiste() {
        return keskipiste;
    }

    public ArrayList<Palanen> getPalaset() {
        return palaset;
    }

    public int getSade() {
        return sade;
    }

    public int getAloituskorkeus() {
        return aloituskorkeus;
    }

    public void setAloituskorkeus(int aloituskorkeus) {
        this.aloituskorkeus = aloituskorkeus;
    }

    public void setKeskipiste(Palanen keskipiste) {
        this.keskipiste = keskipiste;
    }

    public void setSade(int sade) {
        this.sade = sade;
    }

    public void setPalaset(ArrayList<Palanen> palaset) {
        this.palaset = palaset;
    }

    public boolean isOnkoNappulaElossa() {
        return onkoNappulaElossa;
    }

    public void setPalanen(Palanen asetettava, int moneskoListassa) {
        palaset.set(moneskoListassa, asetettava);
    }

    public Palanen getPalanen(int moneskoListassa) {
        return palaset.get(moneskoListassa);
    }

    public void setPalasenRivi(int rivi, int moneskoListassa) {
        Palanen tutkittava = palaset.get(moneskoListassa);
        tutkittava.setRivi(rivi);
    }

    public void setPalasenSarake(int sarake, int moneskoListassa) {
        Palanen tutkittava = palaset.get(moneskoListassa);
        tutkittava.setSarake(sarake);
    }

    public int getPalasenRivi(int moneskoListassa) {
        return palaset.get(moneskoListassa).getRivi();
    }

    public int getPalasenSarake(int moneskoListassa) {
        return palaset.get(moneskoListassa).getSarake();
    }

    public int getAsento() {
        return asento;
    }

    public void setAsento(int asento) {
        this.asento = asento;
    }



       /**
     * siirtää nappulan jokaista palasta oikeaan, alas tai vasemmalle yhden yksiköän verran.
     */
    public void liiku(String suunta) {
        int rivi = 0;
        int sarake = 0;
        if (suunta.equals("alas")) {
            rivi = 1;
            sarake = 0;
        }
        if (suunta.equals("vasemmalle")) {
            rivi = 0;
            sarake = -1;
        }
        if (suunta.equals("oikealle")) {
            rivi = 0;
            sarake = 1;
        }
        toteutaLiikkuminen(rivi, sarake);
    }

          /**
     * toteuttaa nappulan jokaista palasta oikeaan, alas tai vasemmalle yhden yksiköän verran.
     */
    public void toteutaLiikkuminen(int rivi, int sarake) {
        for (int i = 0; i < palaset.size(); i++) {
            Palanen tutkittava = palaset.get(i);
            int uusiRivi = tutkittava.getRivi() + rivi;
            int uusiSarake = tutkittava.getSarake() + sarake;
            tutkittava.setRivi(uusiRivi);
            tutkittava.setSarake(uusiSarake);
        }
    }

   

    public void setOnkoNappulaElossa(boolean onkoNappulaElossa) {
        this.onkoNappulaElossa = onkoNappulaElossa;
    }

    public boolean isNappulaElossa() {
        return onkoNappulaElossa;
    }

    /**
     * pyörimistä varten, muuttaa nappulan palasten koordinaatteja kun nappula
     * pyörii
     * @param pala muutettava palanen,
     * @param rivi on uusi rivi, @sarake sarake on uusi sarake
     *
     */
    public void muutaKoordinaatteja(Palanen pala, int rivi, int sarake) {
        int uusiEkaRivi = pala.getRivi() + rivi;
        pala.setRivi(uusiEkaRivi);
        int uusiEkaSarake = pala.getSarake() + sarake;
        pala.setSarake(uusiEkaSarake);
    }

    /**
     * jokaiselle aliluokan tulee toteuttaa oma pyörimisensä
     *
     *
     * @param tutkittavaAlue tutkittava alue,      *
     *
     */
    public abstract boolean pyorahda(Palanen[][] tutkittavaAlue);
}
