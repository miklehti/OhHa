/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TetrisTestit;

import nappulat.*;
import org.junit.*;
import static org.junit.Assert.*;
import tetris.Next;

/**
 *
 * @author lehtimik
 */
public class NextTest {

    Next next;

    public NextTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        next = new Next();
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void nextLuonti() {

        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void nextLuonti2() {
        next.tulostaNext();
        next.uusiNappulaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin1() {
        Nelio nelio = new Nelio(0, 5);
        next.setNappula(nelio);
        next.tyhjennaNexti();
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin2() {
        Puikula puikula = new Puikula(0, 4);
        next.tyhjennaNexti();
        next.setNappula(puikula);
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin3() {
        Sininen sininen = new Sininen(0, 5);
        next.tyhjennaNexti();
        next.setNappula(sininen);
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin4() {
        Vihrea vihrea = new Vihrea(0, 4);
        next.tyhjennaNexti();
        next.setNappula(vihrea);
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin5() {
        SininenL sininenL = new SininenL(0, 7);
        next.setNappula(sininenL);
        next.tyhjennaNexti();
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin6() {
        vaaleanpunainenL vaaleanpunainenL = new vaaleanpunainenL(0, 4);
        next.setNappula(vaaleanpunainenL);
        next.tyhjennaNexti();
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }

    @Test
    public void asetaNappulanPaikkaNextiin7() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        next.setNappula(parasnappula);
        next.tyhjennaNexti();
        next.asetaNappulanPaikkaNextiin();
        next.tulostaNext();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }
}
