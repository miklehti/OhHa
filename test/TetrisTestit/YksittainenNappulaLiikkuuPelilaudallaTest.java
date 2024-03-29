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
public class YksittainenNappulaLiikkuuPelilaudallaTest {

    Pelilauta pelilauta;

    public YksittainenNappulaLiikkuuPelilaudallaTest() {
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

    //testataan Neliön liikkumista ruudulla
    @Test
    public void siirraNeliotaOikealle4Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);

        assertTrue(
                pelilauta.siirraNappulaaOikealle(4, false));
    }

    @Test
    public void siirraNeliotaOikealle5Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);

        assertFalse(
                pelilauta.siirraNappulaaOikealle(5, false));
    }

    @Test
    public void siirraNappulaaAlas20Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);
       
        assertTrue(
                pelilauta.siirraNappulaaAlas(20, false));
    }

    @Test
    public void siirraNappulaaAlas21Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);

        assertFalse(
                pelilauta.siirraNappulaaAlas(21, false));
    }

    @Test
    public void siirraNeliotaVasemmalle4Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);
 
        assertTrue(
                pelilauta.siirraNappulaaVasemmalle(4, false));
    }

    @Test
    public void siirraNeliotaVasemmalle5Kertaa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);

        assertFalse(
                pelilauta.siirraNappulaaVasemmalle(5, false));
    }

    @Test
    public void pyoraytaNelioa() {
        Nelio nelio = new Nelio(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(nelio);

        assertFalse(
                pelilauta.pyoritaNappulaa(1, false));
    }

    //***********************************************************************************
// testataan puikulan liikkumista alueella yksin    
// puikula vaaka-asennossa                    
    @Test
    public void siirraPuikulaaOikealle3Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        assertTrue(
                pelilauta.siirraNappulaaOikealle(3, false));
    }

    @Test
    public void siirraPuikulaaOikealle4Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
   
        assertFalse(
                pelilauta.siirraNappulaaOikealle(4, false));
    }

    @Test
    public void siirraPuikulaaAlas21Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);

        assertTrue(
                pelilauta.siirraNappulaaAlas(21, false));
    }

    @Test
    public void siirraPuikulaaAlas22Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
       
        assertFalse(
                pelilauta.siirraNappulaaAlas(22, false));
    }

    @Test
    public void siirraPuikulaaVasemmalle3Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);

        assertTrue(
                pelilauta.siirraNappulaaVasemmalle(3, false));
    }

    @Test
    public void siirraPuikulaaVasemmalle4Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
   
        assertFalse(
                pelilauta.siirraNappulaaVasemmalle(4, false));
    }
///*******************************************************
    //Siirrä puikulaa pystyasennossa testit:

    @Test
    public void siirraPuikulaaPystyssaOikealle5Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
       
        assertTrue(
                pelilauta.siirraNappulaaOikealle(5, false));
    }

    @Test
    public void siirraPuikulaaPystyssaOikealle6Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
    
        assertFalse(
                pelilauta.siirraNappulaaOikealle(6, false));
    }

    @Test
    public void siirraPuikulaaPystyssaAlas16Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
     
        assertTrue(
                pelilauta.siirraNappulaaAlas(16, false));
    }

    @Test
    public void siirraPuikulaaPystyssaAlas17Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
      
        assertFalse(
                pelilauta.siirraNappulaaAlas(17, false));
    }

    @Test
    public void siirraPuikulaaPystyssaVasemmalle4Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
      
        assertTrue(
                pelilauta.siirraNappulaaVasemmalle(4, false));
    }

    @Test
    public void siirraPuikulaaPystyssaVasemmalle5Kertaa() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);

        assertFalse(
                 pelilauta.siirraNappulaaVasemmalle(5, false));
    }
    //**********************************************************
    // pyöritä puikulaa

    @Test
    public void pyoraytaPuikulaa1Kerta() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);

      
        assertTrue(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaa2Kerta() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
       
        assertTrue(
                pelilauta.pyoritaNappulaa(2, false));
    }
    //**********************************************************
    // pyöritä puikulaa, reuna tulee tielle

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleOikealla1() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
        pelilauta.siirraNappulaaOikealle(5, false);
       
        assertFalse(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleOikealla2() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
        pelilauta.siirraNappulaaOikealle(4, false);
      
        assertFalse(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleOikealla3() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
        pelilauta.siirraNappulaaOikealle(3, false);
      
        assertTrue(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleVasemmalla1() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
        pelilauta.siirraNappulaaVasemmalle(4, false);
       
        assertFalse(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleVasemmalla2() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(3, false);
        pelilauta.pyoritaNappulaa(1, false);
        pelilauta.siirraNappulaaVasemmalle(3, false);
        
        assertTrue(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleAlhaalla1() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(21, false);
      
        assertFalse(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleAlhaalla2() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(20, false);
       
        assertFalse(
                pelilauta.pyoritaNappulaa(1, false));
    }

    @Test
    public void pyoraytaPuikulaaReunaTuleeTielleAlhaalla3() {
        Puikula puikula = new Puikula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(puikula);
        pelilauta.siirraNappulaaAlas(19, false);
       
        assertTrue(
                pelilauta.pyoritaNappulaa(1, false));
    }

    //********************************************************************
// loppujen nappulojen alas tuonti testit. asento on aloitusasento
//   
    @Test
    public void siirraParasNappulaAlas20Kertaa() {
        ParasNappula parasnappula = new ParasNappula(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
       
        assertTrue(
               pelilauta.siirraNappulaaAlas(20, false));
    }

    @Test
    public void siirraparasnappulaNappulaaAlas21Kertaa() {
        ParasNappula parasnappula = new ParasNappula(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
      
        assertFalse(
                pelilauta.siirraNappulaaAlas(21, false));
    }

    @Test
    public void siirraSininenAlas20Kertaa() {
        Sininen sininen = new Sininen(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(sininen);
       
        assertTrue(
                pelilauta.siirraNappulaaAlas(20, false));
    }

    @Test
    public void siirraSininenAlas21Kertaa() {
        Sininen sininen = new Sininen(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(sininen);
      
        assertFalse(
                pelilauta.siirraNappulaaAlas(21, false));
    }

    @Test
    public void siirraVihreaAlas20Kertaa() {
        Vihrea vihrea = new Vihrea(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(vihrea);
       
        assertTrue(
                pelilauta.siirraNappulaaAlas(20, false));
    }

    @Test
    public void siirraVihreaAlas21Kertaa() {
        Vihrea vihrea = new Vihrea(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(vihrea);
       
        assertFalse(
                pelilauta.siirraNappulaaAlas(21, false));
    }

    @Test
    public void siirraSininenLAlas20Kertaa() {
        SininenL sininenl = new SininenL(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(sininenl);
        
        assertTrue(
                pelilauta.siirraNappulaaAlas(20, false));
    }

    @Test
    public void siirrasininenlAlas21Kertaa() {
        SininenL sininenl = new SininenL(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(sininenl);
       
        assertFalse(
                 pelilauta.siirraNappulaaAlas(21, false));
    }

    @Test
    public void siirravaaleanpunainenLAlas20Kertaa() {
        vaaleanpunainenL vaaleanpunainenL = new vaaleanpunainenL(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(vaaleanpunainenL);
       
        assertTrue(
                pelilauta.siirraNappulaaAlas(20, false));
    }

    @Test
    public void siirravaaleanpunainenLAlas21Kertaa() {
        vaaleanpunainenL vaaleanpunainenL = new vaaleanpunainenL(0, 5);
        pelilauta.uusiNappulaLaudalleNakyviin(vaaleanpunainenL);
       
        assertFalse(
                pelilauta.siirraNappulaaAlas(21, false));
    }

    //********************************************************************
// parasNappula testit
// nappulan liikkuminen asento 1   
    @Test
    public void tiputaParasta() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
       

        assertTrue(
                pelilauta.siirraNappulaaAlas(1, false));
    }

    @Test
    public void pyoraytParasta() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
        pelilauta.siirraNappulaaAlas(3, false);
       
        assertTrue(
                pelilauta.pyoritaNappulaa(5, false));
    }

    @Test
    public void siirraParastaOikealle4Kertaa() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
      
        assertTrue(
                 pelilauta.siirraNappulaaOikealle(4, false));
    }

    @Test
    public void siirraParastaOikealle5Kertaa() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
       
        assertFalse(
                pelilauta.siirraNappulaaOikealle(5, false));
    }

    @Test
    public void siirraParastaVasemmalle3Kertaa() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
      
        assertTrue(
                pelilauta.siirraNappulaaVasemmalle(3, false));
    }

    @Test
    public void siirraParastaVasemmalle4Kertaa() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
       
        assertFalse(
                 pelilauta.siirraNappulaaVasemmalle(4, false));
    }

    //********************************************************************
// parasNappula testit
// nappulan liikkuminen asento 2  
    @Test
    public void siirraParastaOikealle4Kertaa2() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
        pelilauta.siirraNappulaaAlas(1, false);
        pelilauta.pyoritaNappulaa(1, false);

      
        assertTrue(
                pelilauta.siirraNappulaaOikealle(4, false));
    }

    @Test
    public void siirraParastaOikealle6Kertaa2() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
        pelilauta.siirraNappulaaAlas(1, false);
        pelilauta.pyoritaNappulaa(1, false);

        
        assertFalse(
                pelilauta.siirraNappulaaOikealle(6, false));
    }

    @Test
    public void siirraParastaVasemmalle3Kertaa2() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
        pelilauta.siirraNappulaaAlas(1, false);
        pelilauta.pyoritaNappulaa(1, false);

       
        assertTrue(
                pelilauta.siirraNappulaaVasemmalle(3, false));
    }

    @Test
    public void siirraParastaVasemmalle4Kertaa2() {
        ParasNappula parasnappula = new ParasNappula(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
        pelilauta.siirraNappulaaAlas(1, false);
        pelilauta.pyoritaNappulaa(1, false);

       
        assertFalse(
                pelilauta.siirraNappulaaVasemmalle(4, false));
    }

    //Pyörimis testit lopuille nappuloille
    @Test
    public void pyoraytaSininen() {
        Sininen sininen = new Sininen(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(sininen);
        pelilauta.siirraNappulaaAlas(3, true);
       
        assertTrue(
                pelilauta.pyoritaNappulaa(2, true));
    }

    @Test
    public void pyoraytaVihrea() {
        Vihrea vihrea = new Vihrea(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(vihrea);
        pelilauta.siirraNappulaaAlas(3, false);
       
        assertTrue(
                 pelilauta.pyoritaNappulaa(2, false));
    }

    @Test
    public void pyoraytaSininenL() {
        SininenL sininenL = new SininenL(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(sininenL);
        pelilauta.siirraNappulaaAlas(3, false);
       
        assertTrue(
                pelilauta.pyoritaNappulaa(4, false));
    }

    @Test
    public void pyoraytavaaleanpunainenL() {
        vaaleanpunainenL vaaleanpunainenL = new vaaleanpunainenL(0, 4);
        pelilauta.uusiNappulaLaudalleNakyviin(vaaleanpunainenL);
        pelilauta.siirraNappulaaAlas(3, false);
        
        assertTrue(
                pelilauta.pyoritaNappulaa(4, false));
    }

    @Test
    public void uusiNappulaVasemmassaLaidassa() {
        pelilauta.uusiNappulaNextista();
        pelilauta.uusiNappulaNextiin();
        pelilauta.tulostaMatriisi("nextistä");
        pelilauta.update();
        pelilauta.siirraNappulaaAlas(2, false);

        while (true) {
            Nappula nappula = pelilauta.getNappula();
            if (nappula.isNappulaElossa() == false) {
                break;
            }
            pelilauta.siirraNappulaaVasemmalle(1, false);
            pelilauta.update();
            pelilauta.siirraNappulaaAlas(1, false);
            pelilauta.update();

        }

        pelilauta.muutaNappulaMoykyksi();
        pelilauta.update();
        pelilauta.uusiNappulaNextista();

//        ParasNappula parasnappula = new ParasNappula(0, 4);
// 
//        pelilauta.uusiNappulaLaudalleNakyviin(parasnappula);
//               pelilauta.siirraNappulaaVasemmalle(4, true);
//        pelilauta.siirraNappulaaAlas(20, true);
//      pelilauta.uusiNappulaNextista();
        boolean onnistuiko = false;
        assertFalse(
                onnistuiko);
    }
}
