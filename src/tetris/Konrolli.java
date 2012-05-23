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
    private Next next;
    private int riveja;
    private int pisteita;

    public Konrolli() {
        pelilauta = new Pelilauta(20, 10);
        next = new next();
    }

    public Nappula annaSeuraavaNappula() {


        ArrayList<Nappula> arvottavatNappulat = new ArrayList<Nappula>();
        
        Nelio nelio = new Nelio(4, 0, 5);
        arvottavatNappulat.add(nelio);

        Puikula puikula = new Puikula(4, 0, 4);
        arvottavatNappulat.add(puikula);
        
        Sininen sininen = new Sininen(4,0,5);
        arvottavatNappulat.add(sininen);
        
          Vihrea vihrea = new Vihrea(4,0,5);
        arvottavatNappulat.add(vihrea);
        
          SininenL sininenL = new SininenL(4,0,5);
        arvottavatNappulat.add(sininenL);
        
          VaaleanpunainenL vaaleanpunainenL = new VaaleanpunainenL(4,0,5);
        arvottavatNappulat.add(vaaleanpunainenL);
        
          ParasNappula parasnappula = new ParasNappula(4,0,5);
        arvottavatNappulat.add(parasnappula);
        
        Random nappulanArpoja = new Random();
        int vastaus = nappulanArpoja.nextInt(7);
        return arvottavatNappulat.get(vastaus);

       
   
    }

public void pelaa() {
        ArrayList<Nappula> nappulajono = new ArrayList<Nappula>();
        Nappula ekaLisattava = annaSeuraavaNappula();
        nappulajono.add(ekaLisattava);
        Nappula tokaLisattava = annaSeuraavaNappula();
        nappulajono.add(tokaLisattava);
        


        pelilauta.uusiNappulaLaudalle(nelio);

        pelilauta.tulostaMatriisi();
    }
}
