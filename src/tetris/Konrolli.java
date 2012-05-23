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

public class Konrolli {

    private Pelilauta pelilauta;
    private int riveja;
    private int pisteita;

    public Konrolli() {
        pelilauta = new Pelilauta();
    }

    public Nappula annaSeuraavaNappula() {
        Random nappulanArpoja = new Random();
        int vastaus = nappulanArpoja.nextInt(8) + 1;

        if (vastaus == 1) {
            Nelio nelio = new Nelio(0, 5);
            return nelio;
        }
        if (vastaus == 2) {
            Puikula puikula = new Puikula(0, 4);
            return puikula;
        }
        if (vastaus == 3) {
            Vihrea vihrea = new Vihrea(0, 5);
        }

    }

    public void pelaa() {
        ArrayList<Nappula> nappulajono = new ArrayList<Nappula>();
        Nappula ekaLisattava = annaSeuraavaNappula();
        nappulajono.add(ekaLisattava);
        Nappula tokaLisattava = annaSeuraavaNappula();
        nappulajono.add(tokaLisattava);
        
        pelilauta.tulostaMatriisi();

        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        pelilauta.tulostaMatriisi();
    }
}
