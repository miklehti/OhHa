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
    
    private  Palanen eka;
    private Palanen toka;
    private Palanen kolmas;
    private Palanen neljas;
    
     private boolean onkoNappulaElossa;
    private int vari;
    private int korkeus;
    private int leveys;
    private int asento;
    private ArrayList<Palanen> palaset = new ArrayList<Palanen>();
    private Palanen keskipiste;
    private int sade;
    private int aloitussade; //käytetään game over alueen laskentaan
    
     public Nappula(int x, int y) {
          eka = new Palanen(x, y);
        toka = new Palanen(x, y);
        kolmas = new Palanen(x, y);
        neljas = new Palanen(x, y);
        palaset.add(eka);
        palaset.add(toka);
        palaset.add(kolmas);
        palaset.add(neljas);
        onkoNappulaElossa = true;
        vari = 1;
        keskipiste = toka; //default
       
  }

    public int getAloitussade() {
        return aloitussade;
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

    public void setAloitussade(int aloitussade) {
        this.aloitussade = aloitussade;
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

    public void setEka(Palanen eka) {
        this.eka = eka;
    }

    public void setKolmas(Palanen kolmas) {
        this.kolmas = kolmas;
    }

    public void setNeljas(Palanen neljas) {
        this.neljas = neljas;
    }

    public void setToka(Palanen toka) {
        this.toka = toka;
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
     
     

  public void setEkaRivi(int rivi){
      eka.setRivi(rivi);
  }
    public void setEkaSarake(int sarake){
      eka.setSarake(sarake);
  }
      public void setTokaRivi(int rivi){
      toka.setRivi(rivi);
  }
    public void setTokaSarake(int sarake){
      toka.setSarake(sarake);
  }
    
          public void setKolmasRivi(int rivi){
      kolmas.setRivi(rivi);
  }
    public void setKolmasSarake(int sarake){
      kolmas.setSarake(sarake);
  }
          public void setNeljasivi(int rivi){
      neljas.setRivi(rivi);
  }
    public void setNeljasSarake(int sarake){
      neljas.setSarake(sarake);
  }
    
    
       public void setVari(int vari) {
        this.vari = vari;
    }

    public Palanen getEka() {
        return eka;
    }

    public Palanen getToka() {
        return toka;
    }

    public Palanen getKolmas() {
        return kolmas;
    }

    public Palanen getNeljas() {
        return neljas;
    }

    public int getVari() {
        return vari;
    }

    public int annaEkaSarake() {
        int vastaus = eka.getSarake();
        return vastaus;
    }

    public int annaEkaRivi() {
        int vastaus = eka.getRivi();
        return vastaus;
    }

    public int annaTokaSarake() {
        int vastaus = toka.getSarake();
        return vastaus;
    }

    public int annaTokaRivi() {
        int vastaus = toka.getRivi();
        return vastaus;
    }

    public int annaKolmasSarake() {
        int vastaus = kolmas.getSarake();
        return vastaus;
    }

    public int annaKolmasRivi() {
        int vastaus = kolmas.getRivi();
        return vastaus;
    }

    public int annaNeljasSarake() {
        int vastaus = neljas.getSarake();
        return vastaus;
    }

    public int annaNeljasRivi() {
        int vastaus = neljas.getRivi();
        return vastaus;
    }

    public void liikuAlas() {
        int uusiRiviEka = eka.getRivi() + 1;
        int uusiRiviToka = toka.getRivi() + 1;
        int uusiRiviKolmas = kolmas.getRivi() + 1;
        int uusiRiviNeljas = neljas.getRivi() + 1;
        eka.setRivi(uusiRiviEka);
        toka.setRivi(uusiRiviToka);
        kolmas.setRivi(uusiRiviKolmas);
        neljas.setRivi(uusiRiviNeljas);
    }

    public void liikuOikealle() {
        int uusiSarakeEka = eka.getSarake() + 1;
        int uusiSarakeToka = toka.getSarake() + 1;
        int uusiSarakeKolmas = kolmas.getSarake() + 1;
        int uusiSarakeNeljas = neljas.getSarake() + 1;
        eka.setSarake(uusiSarakeEka);
        toka.setSarake(uusiSarakeToka);
        kolmas.setSarake(uusiSarakeKolmas);
        neljas.setSarake(uusiSarakeNeljas);
    }

    public void liikuVasemmalle() {
        int uusiRiviEka = eka.getSarake() - 1;
        int uusiRiviToka = toka.getSarake() - 1;
        int uusiRiviKolmas = kolmas.getSarake() - 1;
        int uusiRiviNeljas = neljas.getSarake() - 1;
        eka.setSarake(uusiRiviEka);
        toka.setSarake(uusiRiviToka);
        kolmas.setSarake(uusiRiviKolmas);
        neljas.setSarake(uusiRiviNeljas);
    }

    public void setOnkoNappulaElossa(boolean onkoNappulaElossa) {
        this.onkoNappulaElossa = onkoNappulaElossa;
    }

    public boolean isNappulaElossa() {
        return onkoNappulaElossa;
    }

    public abstract boolean pyorahda(ArrayList<Integer> tutkittavaAlue );

  
}
