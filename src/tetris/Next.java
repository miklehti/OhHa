/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Random;
import nappulat.*;

/**
 *
 * @author HP_User
 */
public class Next {

    /**
     * palasista koostuva matriisi jonne seuraava nappula kuvataan
     */
    private Palanen next[][];
    /**
     * mikä nappula on tulossa seuraavaksi
     */
    private Nappula nappula;
    /**
     * taulukko kaikista mahdollisista nappuloista, täältä sitten arvotaan
     * seuraava
     */
    private ArrayList<Nappula> arvottavatNappulat;

    public Next() {

        next = new Palanen[4][6];
        for (int rivi = 0; rivi < next.length; rivi++) {
            for (int sarake = 0; sarake < next[0].length; sarake++) {

                next[rivi][sarake] = null;


            }

        }



        uusiNappulaNextiin();
    }

    /**
     * käytetään apuna testauksessa
     */
    public void tulostaNext() {
        for (int rivi = 0; rivi < next.length; ++rivi) {
            for (int sarake = 0; sarake < next[rivi].length; ++sarake) {
                int alkionArvo = 0;
                Palanen palanen = next[rivi][sarake];
                if (palanen == null) {
                    alkionArvo = 0;
                } else if (palanen instanceof ReunaPalanen) {
                    alkionArvo = 5;
                } else if (palanen instanceof TetrisPalanen) {
                    alkionArvo = 1;
                }
                System.out.print(alkionArvo + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    /**
     * arpoo seuraavan nappulan
     *
     * @return Nappula arvottu nappula
     */
    public Nappula arvoNappula() {
        arvottavatNappulat = new ArrayList<Nappula>();
        Nelio nelio = new Nelio(0, 5);
        arvottavatNappulat.add(nelio);

        Puikula puikula = new Puikula(0, 4);
        arvottavatNappulat.add(puikula);

        Sininen sininen = new Sininen(0, 5);
        arvottavatNappulat.add(sininen);

        Vihrea vihrea = new Vihrea(0, 4);
        arvottavatNappulat.add(vihrea);

        SininenL sininenL = new SininenL(0, 7);
        arvottavatNappulat.add(sininenL);

        vaaleanpunainenL vaaleanpunainenL = new vaaleanpunainenL(0, 4);
        arvottavatNappulat.add(vaaleanpunainenL);

        ParasNappula parasnappula = new ParasNappula(0, 4);
        arvottavatNappulat.add(parasnappula);

        Random nappulanArpoja = new Random();
        int vastaus = nappulanArpoja.nextInt(7);


        return arvottavatNappulat.get(vastaus);
    }

    /**
     * Tyhjentää nextin
     */
    public void tyhjennaNexti() {
        for (int rivi = 0; rivi < next.length; rivi++) {
            for (int sarake = 0; sarake < next[0].length; sarake++) {

                next[rivi][sarake] = null;


            }

        }
    }

    /**
     * asettaa uuden nappulan nextiin
     */
    public void uusiNappulaNextiin() {

        this.nappula = arvoNappula();

        tyhjennaNexti();
        asetaNappulanPaikkaNextiin();

    }

    /**
     * asettaa uuden nappulan nextiin
     */
    public void asetaNappulanPaikkaNextiin() {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi() + 1;
            int sarakeNumero = palanen.getSarake() - 3;
//            System.out.println("rivi" + rivinNumero);
//            System.out.println("sarake" + sarakeNumero);
            next[rivinNumero][sarakeNumero] = palanen;
        }
    }

    public Nappula getNappula() {
        return nappula;
    }

    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }

    public Palanen[][] getNext() {
        return next;
    }

    public int getNextRivit() {
        return next.length;
    }

    public int getNextSarakkeet() {
        return next[0].length;
    }

    public Palanen annaNextPalanen(int rivi, int sarake) {
        return next[rivi][sarake];
    }
}
