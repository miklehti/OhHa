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

    private boolean onkoNappulaElossa;
    private int vari;
    private int korkeus;
    private int leveys;
    private int asento;
    private ArrayList<Palanen> palaset = new ArrayList<Palanen>();
    private Palanen keskipiste;
    private int sade;
    private int aloituskorkeus; //käytetään game over alueen laskentaan

    public Nappula(int montakoPalasta, int x, int y) {

        for (int i = 0; i < montakoPalasta; i++) {
            TetrisPalanen lisattava = new TetrisPalanen(x, y);
            palaset.add(lisattava);

        }
        onkoNappulaElossa = true;
        vari = 1;
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

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setAsento(int asento) {
        this.asento = asento;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    

    public int getVari() {
        return vari;
    }

   

    public void liikuAlas() {
        
        for(int i = 0; i<palaset.size();i++){
            Palanen tutkittava = palaset.get(i);
            int uusiRivi = tutkittava.getRivi()+1;
            tutkittava.setRivi(uusiRivi);
        }
        
    }

    public void liikuOikealle() {
        
        for(int i = 0; i<palaset.size();i++){
            Palanen tutkittava = palaset.get(i);
            int uusiSarake = tutkittava.getSarake()+1;
            tutkittava.setSarake(uusiSarake);
        }
        
    }

    public void liikuVasemmalle() {
         for(int i = 0; i<palaset.size();i++){
            Palanen tutkittava = palaset.get(i);
            int uusiSarake = tutkittava.getSarake()-1;
            tutkittava.setSarake(uusiSarake);
        }
    }

    public void setOnkoNappulaElossa(boolean onkoNappulaElossa) {
        this.onkoNappulaElossa = onkoNappulaElossa;
    }

    public boolean isNappulaElossa() {
        return onkoNappulaElossa;
    }

    public abstract boolean pyorahda(Palanen[][] tutkittavaAlue);
}
