/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TetrisTestit;

import java.util.ArrayList;
import nappulat.Nelio;
import org.junit.*;
import static org.junit.Assert.*;
import tetris.Nappula;
import tetris.Pelilauta;

/**
 *
 * @author lehtimik
 */
public class RysaytysTest {

    Pelilauta pelilauta;

    public RysaytysTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        pelilauta = new Pelilauta(8, 12);
    }

    @After
    public void tearDown() {
    }


    @Test
    public void siirraNeliotaOikealle4Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);
        pelilauta.siirraNappulaaVasemmalle(5, false);
        pelilauta.siirraNappulaaAlas(5, false);
   
        assertFalse(
                pelilauta.onkoRysaytettavaa());
    }

    @Test
    public void rysaytys1() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(4, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();


        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(4, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

      
        assertTrue(
                pelilauta.onkoRysaytettavaa());
    }

    @Test
    public void rysaytys2() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(4, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(2, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();


        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(4, false);
        pelilauta.siirraNappulaaAlas(5, false);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        ArrayList<Integer> rivit = pelilauta.annaRysaytettavatRivit();
        int ekarivi = rivit.get(0);
        int tokarivi = rivit.get(1);

        boolean onnistuiko = false;
        if (ekarivi == 5 && tokarivi == 6) {
            onnistuiko = true;
        }
        assertTrue(
                onnistuiko);
    }

    @Test
    public void rysaytys3() {
        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(4, true);
        pelilauta.siirraNappulaaAlas(5, true);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaVasemmalle(2, true);
        pelilauta.siirraNappulaaAlas(5, true);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();


        pelilauta.siirraNappulaaAlas(5, true);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(2, true);
        pelilauta.siirraNappulaaAlas(5, true);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();

        annaAlustusToimet();

        pelilauta.siirraNappulaaOikealle(4, true);
        pelilauta.siirraNappulaaAlas(5, true);
        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        ArrayList<Integer> rysaytettavatrivit = new ArrayList<Integer>();
        rysaytettavatrivit = pelilauta.annaRysaytettavatRivit();
        pelilauta.rysayta(rysaytettavatrivit);
          pelilauta.update();
           annaAlustusToimet();
              pelilauta.update();
       int pelilaudansumma = pelilauta.pelilaudanSumma();
//       pelilauta.tulostaMatriisi("rysä");
        assertEquals(134,
                pelilaudansumma);
    }

    public boolean annaAlustusToimet() {
        uusiNappulaNextistaDUMMY();
        pelilauta.uusiNappulaNextiin();
        //pelilauta.tulostaMatriisi("nextistä");
        pelilauta.update();
        boolean onnistuiko = pelilauta.siirraNappulaaAlas(2, true);
        return onnistuiko;

    }
           public void uusiNappulaNextistaDUMMY() {
        Nelio nelio = new Nelio(0, 5);
        Nappula nappula = pelilauta.getNappula();
        nappula = nelio;
        pelilauta.uusiNappulaLaudalleNakyviin(nappula);
    }
}
