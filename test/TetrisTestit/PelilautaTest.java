/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TetrisTestit;

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
        pelilauta.asetaNappulanPaikkaLaudalla();
        boolean onnistuiko;
        Palanen tutkittava = pelilauta.annaPelilaudanAlkio(0, 5);
//        System.out.println("uusiaNappulaPelilaudalle");
//        pelilauta.tulostaMatriisi();
        if (tutkittava instanceof tetris.TetrisPalanen) {
            onnistuiko = true;
        } else {
            onnistuiko = false;
        }

        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void tiputaNappulaaAlasTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();

        boolean onnistuiko = pelilauta.tiputaNappulaaAlas();
        pelilauta.poistaNappulaNakyvista();
        pelilauta.asetaNappulanPaikkaLaudalla();
//        System.out.println("tiputaNappulaaAlasTrue");
//        pelilauta.tulostaMatriisi();
        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void tiputaNappulaaAlasReunaVastassaFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();


        for (int i = 0; i < 20; i++) {
            pelilauta.poistaNappulaNakyvista();
            pelilauta.tiputaNappulaaAlas();
            pelilauta.asetaNappulanPaikkaLaudalla();
//            System.out.println("tiputaNappulaaAlasReunaVastassaFalse");
//            pelilauta.tulostaMatriisi();
        }
//        System.out.println("tiputaNappulaaAlasReunaVastassaFalse");
//        pelilauta.tulostaMatriisi();
        boolean onnistuiko = pelilauta.tiputaNappulaaAlas();

        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaOikealleFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();

        for (int i = 0; i < 7; i++) {
            pelilauta.poistaNappulaNakyvista();
            pelilauta.siirraNappullaaOikealle();
            pelilauta.asetaNappulanPaikkaLaudalla();
            System.out.println("siirraNappulaaOikealleFalse");
            pelilauta.tulostaMatriisi();
        }
        System.out.println("siirraNappulaaOikealleFalse");
        pelilauta.tulostaMatriisi();
        boolean onnistuiko = pelilauta.siirraNappullaaOikealle();

        assertEquals(false,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaOikealleTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();

        for (int i = 0; i < 3; i++) {
            pelilauta.poistaNappulaNakyvista();
            pelilauta.siirraNappullaaOikealle();
            pelilauta.asetaNappulanPaikkaLaudalla();
//            System.out.println("siirraNappulaaOikealleTrue");
//            pelilauta.tulostaMatriisi();
        }
       
        boolean onnistuiko = pelilauta.siirraNappullaaOikealle();
        pelilauta.poistaNappulaNakyvista();
        pelilauta.asetaNappulanPaikkaLaudalla();
//        System.out.println("siirraNappulaaOikealleTrue");
//        pelilauta.tulostaMatriisi();
        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaVasemmalleTrue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();

        for (int i = 0; i < 3; i++) {
            pelilauta.poistaNappulaNakyvista();
            pelilauta.siirraNappullaaVasemmalle();
            pelilauta.asetaNappulanPaikkaLaudalla();
//            System.out.println("siirraNappulaaVasemmalleTrue");
//            pelilauta.tulostaMatriisi();
        }
//        System.out.println("siirraNappulaaVasemmalleTrue");
//        pelilauta.tulostaMatriisi();
        boolean onnistuiko = pelilauta.siirraNappullaaVasemmalle();
        pelilauta.poistaNappulaNakyvista();
        pelilauta.asetaNappulanPaikkaLaudalla();
        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void siirraNappulaaVasemmalleFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();

        for (int i = 0; i < 6; i++) {
            pelilauta.poistaNappulaNakyvista();
            pelilauta.siirraNappullaaVasemmalle();
            pelilauta.asetaNappulanPaikkaLaudalla();
//            System.out.println("siirraNappulaaVasemmalleFalse");
//            pelilauta.tulostaMatriisi();

        }

        boolean onnistuiko = pelilauta.siirraNappullaaVasemmalle();
        pelilauta.poistaNappulaNakyvista();

        pelilauta.asetaNappulanPaikkaLaudalla();
//        System.out.println("siirraNappulaaVasemmalleFalse");
//        pelilauta.tulostaMatriisi();
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
        pelilauta.asetaNappulanPaikkaLaudalla();

        for (int i = 0; i < 20; i++) {
            pelilauta.poistaNappulaNakyvista();
            pelilauta.tiputaNappulaaAlas();
            pelilauta.asetaNappulanPaikkaLaudalla();
//            System.out.println("muutaNappulaMoykyksiTrue");
//            pelilauta.tulostaMatriisi();
        }
        
        boolean onnistuiko =  pelilauta.tiputaNappulaaAlas();
        if(onnistuiko==false){
            pelilauta.muutaNappulaKuolleeksi();
        }
        boolean onnituikoMuunnos = pelilauta.muutaNappulaMoykyksi();;
        assertEquals(true,
                onnituikoMuunnos);
    }

    @Test
    public void onkoRysaytettavaaFalse() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.asetaNappulanPaikkaLaudalla();
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
           pelilauta.asetaNappulanPaikkaLaudalla();
        pelilauta.tulostaMatriisi();
        boolean onnistuiko = pelilauta.onkoPeliOhi();
        assertEquals(true,
                onnistuiko);
    }

    @Test
    public void annaTutkittavaAlue() {
        Nelio nelio = new Nelio(4, 0, 5);
        pelilauta.uusiNappulaLaudalle(nelio);
        pelilauta.annaTutkittavaAlue();
        boolean onnistuiko = pelilauta.onkoPeliOhi();
        assertEquals(true,
                onnistuiko);
    }
}
