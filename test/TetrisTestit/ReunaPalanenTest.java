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
public class ReunaPalanenTest {

    Pelilauta pelilauta;
   

    public ReunaPalanenTest() {
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

    }
}
