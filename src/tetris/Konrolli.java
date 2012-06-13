/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author HP_User
 */
import LayOut.Graphics;
import nappulat.Puikula;
import nappulat.Vihrea;
import nappulat.Nelio;
import java.util.ArrayList;
import java.util.Random;
import nappulat.*;

public class Konrolli {

    private Pelilauta pelilauta;
    private Graphics graphics;
    private Kello kello;
    private Next next;

    public Konrolli() {
        pelilauta = new Pelilauta(23, 12);
        kello = new Kello();
        graphics = new Graphics();
        next = pelilauta.getNext();
    }

    /**
     * Antaa ajan kauanko odotellaan ennen kuin tiputetaan nappulaa alas
     */
    public long annaVaikeustasoaVastaavaAika() {
        int vaikeustaso = pelilauta.getVaikeusTaso();
        if (vaikeustaso == 1) {
            return 1000;
        } else if (vaikeustaso == 2) {
            return 800;
        } else if (vaikeustaso == 3) {
            return 600;
        } else if (vaikeustaso == 4) {
            return 400;
        } else if (vaikeustaso == 5) {
            return 280;
        } else if (vaikeustaso == 6) {
            return 220;
        } else if (vaikeustaso == 7) {
            return 190;
        } else if (vaikeustaso == 8) {
            return 160;
        } else if (vaikeustaso == 9) {
            return 120;
        }
        return 200;
    }

    /**
     * tutkii onko aika jo käytetty, jos on niin tiputtaa nappulaa alas
     */
    public void josAikaMennytTiputaAlas() {
        if (kello.paljonkoOnKulunut() > annaVaikeustasoaVastaavaAika()) {

            pelilauta.update();
            pelilauta.siirraNappulaaAlas(1, false);
            kello.nollaaKello();
            graphics.paivitaTetrisPaneeli(pelilauta, next);
        }
    }

    /**
     * ottaa napuulan nextistä ja laittaa sen pelilaudalle, arpoo uuden nappulan
     * nextiin
     */
    public boolean annaAlustusToimet() {
        pelilauta.uusiNappulaNextista();
        pelilauta.uusiNappulaNextiin();
        graphics.paivitaTetrisPaneeli(pelilauta, next);

        pelilauta.update();
        boolean onnistuiko = pelilauta.siirraNappulaaAlas(2, false);
        return onnistuiko;

    }

    /**
     * muuttaa nappulan osaksi moykkya ja rysayttaa tarvittaessa nappulakasaa
     * alaspäin jos rivi täynnä
     */
    public void muutaMoykyksijaRysayta() {
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        graphics.paivitaTetrisPaneeli(pelilauta, next);
        if (pelilauta.onkoRysaytettavaa() == true) {
            ArrayList<Integer> rysaytettavatrivit = new ArrayList<Integer>();
            rysaytettavatrivit = pelilauta.annaRysaytettavatRivit();
            pelilauta.rysayta(rysaytettavatrivit);
            graphics.paivitaTetrisPaneeli(pelilauta, next);
        }
        pelilauta.setPisteMaara(pelilauta.getPisteMaara() + 10);
    }

    /**
     * tarkistaa missä vaikeustasossa mennään
     */
    public void tarkistaVaikeustaso() {
        int riveja = pelilauta.getRivienMaara();
        if (riveja > 10 && riveja < 20) {
            pelilauta.setVaikeusTaso(2);
        } else if (riveja > 20 && riveja < 30) {
            pelilauta.setVaikeusTaso(3);
        } else if (riveja > 30 && riveja < 40) {
            pelilauta.setVaikeusTaso(4);
        } else if (riveja > 40 && riveja < 50) {
            pelilauta.setVaikeusTaso(5);
        } else if (riveja > 50 && riveja < 60) {
            pelilauta.setVaikeusTaso(6);
        } else if (riveja > 60 && riveja < 70) {
            pelilauta.setVaikeusTaso(7);
        } else if (riveja > 70 && riveja < 80) {
            pelilauta.setVaikeusTaso(8);
        } else if (riveja > 80 && riveja < 90) {
            pelilauta.setVaikeusTaso(9);
        }
    }

    /**
     * pelilooppi
     */
    public void pelaa() {

        while (annaAlustusToimet() == true) {
            graphics.paivitaTetrisPaneeli(pelilauta, next);
            while (true) {
                Nappula nappula = pelilauta.getNappula();
                if (nappula.isNappulaElossa() == false) {
                    break;
                }
                josAikaMennytTiputaAlas();
            }
            muutaMoykyksijaRysayta();
            tarkistaVaikeustaso();
        }

    }
}
