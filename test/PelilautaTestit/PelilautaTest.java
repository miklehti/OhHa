/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelilautaTestit;

import org.junit.*;
import static org.junit.Assert.*;
import nappulat.Nelio;
import tetris.Pelilauta;
import tetris.Palanen;
import tetris.*;
import nappulat.*;

/**
 *
 * @author HP_User
 */
public class PelilautaTest {

    Pelilauta pelilauta;

    public PelilautaTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
     @Test
    public void uusiaNappulaPelilaudalle() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        //      pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
          boolean onnistuiko ;
          Palanen tutkittava = pelilauta.annaPelilaudanAlkio(0, 5);
                  
      if(tutkittava instanceof tetris.TetrisPalanen){
            onnistuiko = true;
        }else{
          onnistuiko = false;
      }

        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void tiputaNappulaaAlasTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        //      pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        boolean onnistuiko = pelilauta.tiputaNappulaaAlas();

        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void tiputaNappulaaAlasFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        //     pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        for (int i = 0; i < 20; i++) {
            pelilauta.tiputaNappulaaAlas();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.tiputaNappulaaAlas();

        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaOikealleFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        //   pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        for (int i = 0; i < 7; i++) {
            pelilauta.siirraNappullaaOikealle();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.siirraNappullaaOikealle();

        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaOikealleTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        //   pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        for (int i = 0; i < 3; i++) {
            pelilauta.siirraNappullaaOikealle();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.siirraNappullaaOikealle();

        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaVasemmalleTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        //    pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        for (int i = 0; i < 3; i++) {
            pelilauta.siirraNappullaaVasemmalle();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.siirraNappullaaVasemmalle();

        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaVasemmalleFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        // pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        for (int i = 0; i < 6; i++) {
            pelilauta.siirraNappullaaVasemmalle();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.siirraNappullaaVasemmalle();

        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void muutaNappulaMoykyksiFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        boolean onnistuiko = pelilauta.muutaNappulaMoykyksi();
        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void muutaNappulaMoykyksiTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        for (int i = 0; i < 20; i++) {
            pelilauta.tiputaNappulaaAlas();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.muutaNappulaMoykyksi();
        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void onkoRysaytettavaaFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        for (int i = 0; i < 20; i++) {
            pelilauta.tiputaNappulaaAlas();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.onkoRysaytettavaa();
        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void onkoPeliOhiTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.tulostaMatriisi();
        boolean onnistuiko = pelilauta.onkoPeliOhi();
        assertEquals(true,
                onnistuiko);
    }
}
