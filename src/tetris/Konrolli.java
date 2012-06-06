/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author HP_User
 */
import nappulat.Puikula;
import nappulat.Vihrea;
import nappulat.Nelio;
import java.util.ArrayList;
import java.util.Random;
import nappulat.*;

public class Konrolli {

    private Pelilauta pelilauta;
    private int kierroksenPisteet;
    long sallittuAikaVaikeustasonMukaan;
    long paljonkoKulunutAikaa;
    private Graphics graphics;
    private TetrisPaneeli tetrispaneeli;
    private Kello kello;

    public Konrolli() {
        pelilauta = new Pelilauta(23, 12);
        kello = new Kello();
        graphics = new Graphics();

    }

    /**
     * pelilooppi
     *
     *
     *
     *
     */
    public boolean annaAlustusToimet() {
        pelilauta.uusiNappulaNextista();
        pelilauta.uusiNappulaNextiin();
        //pelilauta.tulostaMatriisi("nextistä");
        pelilauta.update();
        boolean onnistuiko = pelilauta.siirraNappulaaAlas(2, true);
        return onnistuiko;

    }

    public void pelaa() {

        while (annaAlustusToimet() == true) {
            //annaAlustusToimet();
             
            graphics.paivitaTetrisPaneeli(pelilauta);
            while (true) {
                Nappula nappula = pelilauta.getNappula(); 
                if (nappula.isNappulaElossa() == false) {
                    break;
                }
              
                if (kello.paljonkoOnKulunut() > 200.0) {
                    pelilauta.update();
                     pelilauta.siirraNappulaaAlas(1, false);
                     kello.nollaaKello();
                    graphics.paivitaTetrisPaneeli(pelilauta);
                }
            }
            //nappula ei enää liiku, tutkitaan rysäytettävät

            pelilauta.muutaNappulaMoykyksi();    
            pelilauta.update();
            graphics.paivitaTetrisPaneeli(pelilauta);
            
            if (pelilauta.onkoRysaytettavaa() == true) {
                ArrayList<Integer> rysaytettavatrivit = new ArrayList<Integer>();
                rysaytettavatrivit = pelilauta.annaRysaytettavatRivit();
                pelilauta.rysayta(rysaytettavatrivit);
                graphics.paivitaTetrisPaneeli(pelilauta);
            }
        }

    }
}
