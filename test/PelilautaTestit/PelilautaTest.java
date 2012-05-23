/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelilautaTestit;

import org.junit.*;
import static org.junit.Assert.*;
import nappulat.Nelio;
import tetris.Pelilauta;

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
    public void poistaNappulaNakyvista() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        pelilauta.poistaNappulaNakyvista();
        int summa = pelilauta.pelilaudanSumma();
        assertEquals(280,
                summa);
    }

    @Test
    public void tiputaNappulaaAlasTrue() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        boolean onnistuiko = pelilauta.tiputaNappulaaAlas();

        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void tiputaNappulaaAlasFalse() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
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
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
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
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
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
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
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
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        for (int i = 0; i < 6; i++) {
            pelilauta.siirraNappullaaVasemmalle();
//        pelilauta.tulostaMatriisi();
        }
        boolean onnistuiko = pelilauta.siirraNappullaaVasemmalle();

        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void asetaNappulaPelilaudalle() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudallaYkkoseksi();
        int summa = pelilauta.pelilaudanSumma();
        assertEquals(284,
                summa);
    }

    @Test
    public void tyhjanPelilaudanSumma() {
        int summa = pelilauta.pelilaudanSumma();
        assertEquals(280,
                summa);
    }

    public void tyhjanPelilaudanAlkiot(int rivi, int sarake, int arvo) {
        int todellinenArvo = pelilauta.pelilaudanRuudunArvo(rivi, sarake);
        assertEquals(arvo,
                todellinenArvo);
    }

    @Test
    public void tyhjanPelilaudanAlkiotSyote() {
        for (int rivi = 0; rivi < 23; ++rivi) {
            for (int sarake = 0; sarake < 12; ++sarake) {
                if (rivi == 22) {
                    tyhjanPelilaudanAlkiot(rivi, sarake, 5);
                } else if (sarake == 0) {
                    tyhjanPelilaudanAlkiot(rivi, sarake, 5);
                } else if (sarake == 11) {
                    tyhjanPelilaudanAlkiot(rivi, sarake, 5);
                } else {
                    tyhjanPelilaudanAlkiot(rivi, sarake, 0);
                }
            }

        }
    }
}
