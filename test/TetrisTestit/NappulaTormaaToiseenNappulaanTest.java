/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TetrisTestit;

import nappulat.Nelio;
import org.junit.*;
import static org.junit.Assert.*;
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
}
