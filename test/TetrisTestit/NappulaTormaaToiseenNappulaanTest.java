/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TetrisTestit;

import nappulat.Nelio;
import nappulat.Puikula;
import org.junit.*;
import static org.junit.Assert.*;
import tetris.Nappula;
import tetris.Pelilauta;

/**
 *
 * @author lehtimik
 */
public class NappulaTormaaToiseenNappulaanTest {

    Pelilauta pelilauta;
    Pelilauta pelilauta2;

    public NappulaTormaaToiseenNappulaanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        pelilauta = new Pelilauta(23, 12);
        pelilauta2 = new Pelilauta(12, 12);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kaksiNeliotaTormaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);
        pelilauta.siirraNappulaaAlas(21, true);
        pelilauta.muutaNappulaMoykyksi();
        Nelio nelio2 = new Nelio(0, 5);
        pelilauta.setNappula(nelio2);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio2);

        assertFalse(
                pelilauta.siirraNappulaaAlas(20, true));
    }

    @Test
    public void kaksiNeliotaTormaaEkaNelionStatusKuollut() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);
        pelilauta.siirraNappulaaAlas(21, false);
        assertFalse(
                nelio.isNappulaElossa());
    }

    @Test
    public void voinkoPyoriaPuikula() {


        asetaKaksiNappulaTorniaValiKaksi();
        uusiNappulaNextistaDUMMYPuikula();
        pelilauta2.uusiNappulaNextiin();
        pelilauta2.siirraNappulaaAlas(2, false);
        pelilauta2.pyoritaNappulaa();
        pelilauta2.siirraNappulaaAlas(3, false);
        boolean onnistuiko = pelilauta2.pyoritaNappulaa();
        assertFalse(
                onnistuiko);
    }

    @Test
    public void voinkoPyoriaPuikula3() {


        asetaKaksiNappulaTorniaValiKaksi();
        uusiNappulaNextistaDUMMYPuikula();
        pelilauta2.uusiNappulaNextiin();
        pelilauta2.siirraNappulaaAlas(2, false);
        pelilauta2.pyoritaNappulaa();
        pelilauta2.siirraNappulaaOikealle(1, false);
        pelilauta2.siirraNappulaaAlas(4, false);

        assertFalse(
                pelilauta2.pyoritaNappulaa(1, false));
    }

    @Test
    public void voinkoPyoriaPuikula2() {

        asetaKaksiNappulaTorniaValiYksi();
        uusiNappulaNextistaDUMMYPuikula();
        pelilauta2.uusiNappulaNextiin();
        pelilauta2.siirraNappulaaAlas(2, false);
        pelilauta2.pyoritaNappulaa();
        pelilauta2.siirraNappulaaOikealle(1, false);
        pelilauta2.siirraNappulaaAlas(2, false);
        assertFalse(
                pelilauta2.pyoritaNappulaa(1, false));
    }

    //asettaa pelilaudalle kaksi tornia joiden välissä on kaksi ruutua tyhjää tilaa jonne testattava nappula 
    //sitten laitetaan
    private void asetaKaksiNappulaTorniaValiKaksi() {
        //eka nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //toka nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //kolmas nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //neljäs nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //viides nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();
        //kuudes nappula laudalle
        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
    }

    //asettaa pelilaudalle kaksi tornia joiden välissä on yksi ruutua tyhjää tilaa jonne testattava nappula 
    //sitten laitetaan
    private void asetaKaksiNappulaTorniaValiYksi() {
        //eka nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaVasemmalle(1, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //toka nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaVasemmalle(1, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //kolmas nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaVasemmalle(1, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //neljäs nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //viides nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        //kuudes nappula laudalle
        annaAlustusToimet();
        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

    }

   
// uusi nappula laudalle
    private boolean annaAlustusToimet() {
        uusiNappulaNextistaDUMMY();
        pelilauta.uusiNappulaNextiin();
        //pelilauta.tulostaMatriisi("nextistä");
        pelilauta.update();
        boolean onnistuiko = pelilauta.siirraNappulaaAlas(2, false);
        return onnistuiko;

    }
    // uutta nappulaa ei arvota vaan pakotetaan se neliöksi
    private void uusiNappulaNextistaDUMMY() {
        Nelio nelio = new Nelio(0, 5);
        Nappula nappula = pelilauta.getNappula();
        nappula = nelio;
        pelilauta.uusiNappulaLaudalleNakyviin(nappula);
    }
// uutta nappulaa ei arvota vaan pakotetaan se puikulaksi
    private void uusiNappulaNextistaDUMMYPuikula() {
        Puikula puikula = new Puikula(0, 4);
        Nappula nappula = pelilauta.getNappula();
        nappula = puikula;
        pelilauta.uusiNappulaLaudalleNakyviin(nappula);
    }
}
