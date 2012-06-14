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
        boolean onnistuiko = pelilauta.siirraNappulaaAlas(20, true);
        assertFalse(
                onnistuiko);
    }

    @Test
    public void kaksiNeliotaTormaaEkaNelionStatusKuollut() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);
        pelilauta.siirraNappulaaAlas(21, false);
        boolean onnistuiko = nelio.isNappulaElossa();
        assertFalse(
                onnistuiko);
    }

    @Test
    public void voinkoPyoriaPuikula() {
        pelilauta = new Pelilauta(12, 12);

        asetaKaksiNappulaTorniaValiKaksi();
        uusiNappulaNextistaDUMMYPuikula();
        pelilauta.uusiNappulaNextiin();
        pelilauta.siirraNappulaaAlas(2, false);
        pelilauta.pyoritaNappulaa();
        pelilauta.siirraNappulaaAlas(3, false);
        boolean onnistuiko = pelilauta.pyoritaNappulaa();
        assertFalse(
                onnistuiko);
    }

    @Test
    public void voinkoPyoriaPuikula3() {
        pelilauta = new Pelilauta(12, 12);

        asetaKaksiNappulaTorniaValiKaksi();
        uusiNappulaNextistaDUMMYPuikula();
        pelilauta.uusiNappulaNextiin();
        pelilauta.siirraNappulaaAlas(2, false);
        pelilauta.pyoritaNappulaa();
        pelilauta.siirraNappulaaOikealle(1, false);
        pelilauta.siirraNappulaaAlas(4, false);
        boolean onnistuiko = pelilauta.pyoritaNappulaa(1, false);
        assertFalse(
                onnistuiko);
    }

    @Test
    public void voinkoPyoriaPuikula2() {
        pelilauta = new Pelilauta(12, 12);

        asetaKaksiNappulaTorniaValiYksi();
        uusiNappulaNextistaDUMMYPuikula();
        pelilauta.uusiNappulaNextiin();
        pelilauta.siirraNappulaaAlas(2, false);
        pelilauta.pyoritaNappulaa();
        pelilauta.siirraNappulaaOikealle(1, false);
        pelilauta.siirraNappulaaAlas(2, false);
        boolean onnistuiko = pelilauta.pyoritaNappulaa(1,false);
        assertFalse(
                onnistuiko);
    }

    //asettaa pelilaudalle kaksi tornia joiden välissä on kaksi ruutua tyhjää tilaa jonne testattava nappula 
    //sitten laitetaan
    private void asetaKaksiNappulaTorniaValiKaksi() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
    }
    
      //asettaa pelilaudalle kaksi tornia joiden välissä on yksi ruutua tyhjää tilaa jonne testattava nappula 
    //sitten laitetaan

    private void asetaKaksiNappulaTorniaValiYksi() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(1, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(1, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(1, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

    }

        //asettaa pelilaudalle kaksi tornia joiden välissä on kolme ruutua tyhjää tilaa jonne testattava nappula 
    //sitten laitetaan
    
    private void asetaKaksiTorniaValiKolme() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(3, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(3, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(3, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(3, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
    }

     //asettaa pelilaudalle kaksi tornia joiden välissä on neljä ruutua tyhjää tilaa jonne testattava nappula 
    //sitten laitetaan
    
    private void kaksiTorniaValiNelja() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(4, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(4, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(4, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(10, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(8, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(6, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
    }

    private boolean annaAlustusToimet() {
        uusiNappulaNextistaDUMMY();
        pelilauta.uusiNappulaNextiin();
        //pelilauta.tulostaMatriisi("nextistä");
        pelilauta.update();
        boolean onnistuiko = pelilauta.siirraNappulaaAlas(2, false);
        return onnistuiko;

    }

    private void uusiNappulaNextistaDUMMY() {
        Nelio nelio = new Nelio(0, 5);
        Nappula nappula = pelilauta.getNappula();
        nappula = nelio;
        pelilauta.uusiNappulaLaudalleNakyviin(nappula);
    }

    private void uusiNappulaNextistaDUMMYPuikula() {
        Puikula puikula = new Puikula(0, 4);
        Nappula nappula = pelilauta.getNappula();
        nappula = puikula;
        pelilauta.uusiNappulaLaudalleNakyviin(nappula);
    }
}
