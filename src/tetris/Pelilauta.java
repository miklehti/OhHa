/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import nappulat.Nelio;

/**
 *
 * @author HP_User
 */
public class Pelilauta {

    /**
     * tetris pelin pelilauta, kuvaa aina pelin senhetkisen tilanteen
     */
    private Palanen pelilauta[][];
    /**
     * pelilaudalla on kullakin hetkellä max yksi tetrrisnappula jota pelaaja
     * ohjaa (alas, vasemmalle, oikealle, pyöritä)
     */
    private Nappula nappula;
    /**
     * kaikki mitä aiemmista nappuloista on jäljellä, ei voi enää ohjata
     */
    private NappulaKasa moykky;
    /**
     * mikä nappula on seuraavaksi tulossa?
     */
    private Next next;
    /**
     * pelaajalle piilossa oleva alue pelilaudalla jonne nappulat luodaan, jos
     * nappula muuttuu möykyksi tuolla alueella peli on ohi
     */
    private int GameOverAlueenKokoRiveina = 2; //piilossa oleva alue jonne nappulat luodaan, jos nappula muuttuu möykyksi tuolla alueella peli on ohi
    private int pisteMaara;
    /**
     * aina kun rivien määrä saavuttaa pyöreän kymmenluvun, vaikeustaso nousee
     * yhdellä
     */
    private int rivienMaara;
    /**
     * 1-9
     */
    private int vaikeusTaso;
//    private Palanen palanen;
    private int rivit;
//    private Palanen palanen;
    private int sarakkeet;
//    private Palanen palanen;

    /**
     * luo annetuilla parametreilla Nappula taulukon joka toimii pelilautana
     *
     *
     * @param rivi pelilaudan rivien määrä
     * @param sarake pelilaudan sarakkeiden määrä
     *
     */
    public Pelilauta(int rivi, int sarake) {
        moykky = new NappulaKasa();
        pelilauta = new Palanen[rivi][sarake];
        next = new Next();
        rivit = pelilauta.length;
        sarakkeet = pelilauta[0].length;
        vaikeusTaso = 1;
        for (rivi = 0; rivi < pelilauta.length; rivi++) {
            for (sarake = 0; sarake < pelilauta[0].length; sarake++) {

                pelilauta[rivi][sarake] = null;

                if (rivi == pelilauta.length - 1) {
                    Palanen reunapala = new ReunaPalanen(rivi, sarake);
                    pelilauta[rivi][sarake] = reunapala;
                }
                if (sarake == pelilauta[0].length - 1) {
                    Palanen reunapala = new ReunaPalanen(rivi, sarake);
                    pelilauta[rivi][sarake] = reunapala;
                }
                if (sarake == 0) {
                    Palanen reunapala = new ReunaPalanen(rivi, sarake);
                    pelilauta[rivi][sarake] = reunapala;
                }

            }
        }

    }

    public Palanen annaPelilaudanAlkio(int rivi, int sarake) {
        return pelilauta[rivi][sarake];
    }

    /**
     * käytetään apuna testauksessa, tulostaa merkein matriisin
     */
    public void tulostaMatriisi(String otsikko) {
        System.out.println(otsikko);
        for (int rivi = 0; rivi < pelilauta.length; ++rivi) {
            for (int sarake = 0; sarake < pelilauta[rivi].length; ++sarake) {
                int alkionArvo = 0;
                Palanen palanen = pelilauta[rivi][sarake];
                if (palanen == null) {
                    alkionArvo = 0;
                } else if (palanen instanceof ReunaPalanen) {
                    alkionArvo = 5;
                } else if (palanen instanceof TetrisPalanen) {
                    alkionArvo = 1;
                }
                System.out.print(alkionArvo + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    /**
     * käytetään apuna testauksessa
     */
    public int pelilaudanSumma() {
        int summa = 0;
        for (int rivi = 0; rivi < pelilauta.length; ++rivi) {
            for (int sarake = 0; sarake < pelilauta[rivi].length; ++sarake) {
                int alkionArvo = 0;
                Palanen palanen = pelilauta[rivi][sarake];
                if (palanen == null) {
                    alkionArvo = 0;
                } else if (palanen instanceof ReunaPalanen) {
                    alkionArvo = 5;
                } else if (palanen instanceof TetrisPalanen) {
                    alkionArvo = 1;
                }
                summa = summa + alkionArvo;
            }

        }
        return summa;
    }

    /**
     * asettaa nappulan laudalle
     */
    public void asetaNappulanPaikkaLaudalla() {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            pelilauta[rivinNumero][sarakeNumero] = palanen;
        }
    }

    /**
     * asettaa nappulan laudalle
     */
    public void uusiNappulaLaudalle(Nappula nappula) {
        this.nappula = nappula;



    }

    /**
     * hakee uuden nappulan nextista
     */
    public void uusiNappulaNextista() {
        Nappula seuraava = next.getNappula();
        this.nappula = seuraava;
        uusiNappulaLaudalleNakyviin(nappula);
    }

    public void uusiNappulaNextiin() {
        next.uusiNappulaNextiin();
    }

    public void uusiNappulaKasaLaudalle(NappulaKasa moykky) {
        this.moykky = moykky;

    }

    /**
     * asettaa nappulakansanpaikan laudalla
     */
    public void asetaNappulaKasanPaikkaLaudalla() {
        int i=0;
        int rivinNumero=0;
        int sarakeNumero=0;
        ArrayList<Palanen> palaset = new ArrayList<Palanen>();
        try {
            palaset = moykky.getPalaset();
            for (i = 0; i < palaset.size(); i++) {

                Palanen palanen = palaset.get(i);

                rivinNumero = palanen.getRivi();

                sarakeNumero = palanen.getSarake();

                pelilauta[rivinNumero][sarakeNumero] = palanen;
            }
        } catch (NullPointerException e) {
        }
    }

    /**
     * poista möykky näkyvistä laudalta
     */
    public void poistaMoykkyNakyvista() {
        ArrayList<Palanen> palaset = moykky.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            pelilauta[rivinNumero][sarakeNumero] = palanen;
        }
    }

    /**
     * testausfunktio
     */
    public void uusiNappulaLaudalleNakyviin(Nappula nappula) {
        uusiNappulaLaudalle(nappula);
        asetaNappulanPaikkaLaudalla();
        asetaNappulaKasanPaikkaLaudalla();
    }

    /**
     * päivittää pelilaudan tilanteen
     */
    public void update() {
        poistaNappulaNakyvista();
        asetaNappulanPaikkaLaudalla();
        asetaNappulaKasanPaikkaLaudalla();

    }

    /**
     * muuttaa nappulan napppulakasaan
     */
    public boolean muutaNappulaMoykyksi() {
        if (nappula.isNappulaElossa() == false) {
            moykky.lisaaPalanenMoykkyyn(nappula);

            return true;
        }
        return false;
    }

    /**
     * poistaa nappulan näkyvistä
     */
    public void poistaNappulaNakyvista() {
        for (int rivi = 0; rivi < pelilauta.length; ++rivi) {
            for (int sarake = 0; sarake < pelilauta[rivi].length; ++sarake) {
                if (pelilauta[rivi][sarake] instanceof TetrisPalanen) {
                    pelilauta[rivi][sarake] = null;
                }
            }
        }
    }

    /**
     * tutkii voiko nappula liikkua alas, oikealle, vasemmalle että ei ole reuna
     * tai nappulakasa tiellä
     */
    public boolean voinkoLiikkua(String suunta) {
        int rivi = 0;
        int sarake = 0;
        if (suunta.equals("alas")) {
            rivi = -1;
            sarake = 0;
        }
        if (suunta.equals("vasemmalle")) {
            rivi = 0;
            sarake = 1;
        }
        if (suunta.equals("oikealle")) {
            rivi = 0;
            sarake = -1;
        }
        return tutkiVoinkoLiikkua(rivi, sarake);
    }

    /**
     * tutkii onko möykky nappulan tiellä
     */
    public boolean tutkiOnkoMoykkyTiella(int rivi, int sarake) {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            ArrayList<Palanen> moykynPalaset = moykky.getPalaset();
            if (onkoMoykynPalanenJonkunPalasenTiella(moykynPalaset, rivi, sarake, rivinNumero, sarakeNumero)==true) {
                return false;
            }
        }
        return true;
    }

   



    private boolean onkoMoykynPalanenJonkunPalasenTiella(ArrayList<Palanen> moykynPalaset, int rivi, int sarake, int rivinNumero, int sarakeNumero) {
        for (int j = 0; j < moykynPalaset.size(); j++) {
            Palanen moykynPalanen = moykynPalaset.get(j);
            int moykynRivinNumero = moykynPalanen.getRivi() + rivi;
            int moykynSarakeNumero = moykynPalanen.getSarake() + sarake;
            if (moykynRivinNumero == rivinNumero && sarakeNumero == moykynSarakeNumero) {
                return true;
            }
        }
        return false;
    }

    /**
     * tutkii onko reuna nappulan tiellä kun liikutaan alas
     */
    public boolean tutkiOnkoReunaTiella(int rivi, int sarake) {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            Palanen tutkittavaPalanen = pelilauta[rivinNumero - rivi][sarakeNumero - sarake];
            if (tutkittavaPalanen instanceof ReunaPalanen) {
                return false;
            }
        }
        return true;
    }

    /**
     * tutkii voiko nappula liikkua alas, oikealle, vasemmalle että ei ole reuna
     * tai nappulakasa tiellä
     */
    public boolean tutkiVoinkoLiikkua(int rivi, int sarake) {
        if (tutkiOnkoMoykkyTiella(rivi, sarake) == false) {
            return false;
        }
        if (tutkiOnkoReunaTiella(rivi, sarake) == false) {
            return false;
        }

        return true;
    }

    /**
     * tiputtaa nappulaa yhden verran alas, oikeall tai vasemmale,kutsuu
     * nappulan omaa siirry alas metodia.
     */
    public boolean siirraNappulaa(String suunta) {
        if (nappula.isNappulaElossa() == false) {
            return false;
        }
        if (voinkoLiikkua(suunta) == false) {
            if (suunta.equals("alas")) {
                nappula.setOnkoNappulaElossa(false);
            }
            return false;
        }
        nappula.liiku(suunta);

        return true;
    }

    /**
     * tutkii onko rivillä yhtään nullia, jos on niin riviä ei voi rysäyttää,
     * jos on niin true.
     *
     * @return onko rysäytettävää
     */
    public boolean onkoRysaytettavaa() {
        boolean onkoRysaytettavaa = false;
        for (int rivi = 0; rivi < pelilauta.length - 1; rivi++) {
            for (int sarake = 1; sarake < pelilauta[0].length - 1; sarake++) {
                if (pelilauta[rivi][sarake] == null) {
                    break;
                }
                if (sarake == pelilauta[0].length - 2) {
                    onkoRysaytettavaa = true;
                }

            }

        }
        return onkoRysaytettavaa;
    }

    /**
     * jos on rysäytettävää niin otetaan niiden rivit ylös
     *
     *
     *
     * @return rysäytettävien rivien numero
     */
    public ArrayList<Integer> annaRysaytettavatRivit() {
        ArrayList<Integer> rysaytettavat = new ArrayList<Integer>();
        for (int rivi = 0; rivi < pelilauta.length - 1; rivi++) {


            for (int sarake = 0; sarake < pelilauta[0].length; sarake++) {
                if (pelilauta[rivi][sarake] == null) {
                    break;
                }
                if (sarake == pelilauta[0].length - 2) {
                    rysaytettavat.add(rivi);
                }



            }

        }
        return rysaytettavat;
    }

     private boolean ollaankoYliPelilaudaAlueen(int rivi, int i, int sarake, int j) {
        return rivi + i >= pelilauta.length - 1 || sarake + j >= pelilauta[0].length - 1;
    }
     
    /**
     * mitkä rivit rysäytetään, eli niiden yläpuolella olevaa nappulakasan
     * palasien riviä lisätään yhdellä per rivi jota rysäytetään.
     *
     *
     *
     * @param rysäytettävien rivien numerot
     */
    public void rysayta(ArrayList<Integer> rysaytettavat) {
        for (int i = 0; i < rysaytettavat.size(); i++) {
            rivienMaara = rivienMaara + 1;
            pisteMaara = pisteMaara + 100;
            moykky.tiputaMoykkya(rysaytettavat.get(i));
        }
    }
    
        private Palanen annaVastaavaPalanen(int rivi, int i, int sarake, int j, Palanen[][] tutkittavaAlue) {
        if (rivi + i < 0 || sarake + j <= 0) {
            Palanen reunapalanen = new ReunaPalanen(rivi, sarake);
           return reunapalanen;
        } else if (ollaankoYliPelilaudaAlueen(rivi, i, sarake, j)==true) {
            Palanen reunapalanen = new ReunaPalanen(rivi, sarake);
             return reunapalanen;
        } else {
            return pelilauta[rivi + i][sarake + j];
        }
    }

    /**
     * pyöräytystä varten pitää antaa pelilaudalta tietoja että sopiiko nappula
     * pyörimään. Tutkittavan alueen koko riippuu nappulan säteestä, esim. jos
     * säde 1 => annetaan 3x3 alue jossa keskipisteenä on nappulan keskipiste
     * (eli siis minkä palasen suhteen nappula pyörii ympäri) tai jos säde 2
     * niin 5x alue jne.
     *
     * @param palasten otos
     */
    
    public Palanen[][] annaTutkittavaAlue(int tutkittavanAluuenKoko) {

        if (nappula.getSade() == 0) {
            return null;
        }      
        int alueenKoko = 2 * nappula.getSade() + 1;
        Palanen[][] tutkittavaAlue = new Palanen[tutkittavanAluuenKoko][tutkittavanAluuenKoko];
        Palanen keskipiste = nappula.getKeskipiste();
        int rivi = keskipiste.getRivi() - nappula.getSade();
        int sarake = keskipiste.getSarake() - nappula.getSade();
        for (int i = 0; i < alueenKoko; i++) {
            for (int j = 0; j < alueenKoko; j++) {
                tutkittavaAlue[i][j]=annaVastaavaPalanen(rivi, i, sarake, j, tutkittavaAlue);

            }
        }
        return tutkittavaAlue;
    }

    /**
     * nappula osunut reunaan tai nappulakasaan, muutetaan kuolleeksi kutsumalla
     * nappulan omaa boolean metodia.
     */
    public void muutaNappulaKuolleeksi() {
        nappula.setOnkoNappulaElossa(false);
    }

    /**
     * jos nappula muuttuu kuolleksi ja joku nappulan palanen on game-over
     * alueella. Normaalissa tetriksessä se on kaksi ekaa riviä pelilaudalta,
     * mutta tätä voi muuttaa haluttaessa.
     *
     *
     * @return onko peli ohi
     *
     */
    public boolean onkoPeliOhi() {
        for (int rivi = 0; rivi < GameOverAlueenKokoRiveina; rivi++) {
            for (int sarake = 0; sarake < pelilauta[0].length; sarake++) {
                Palanen tutkittavaPalanen = pelilauta[rivi][sarake];
                if (tutkittavaPalanen instanceof TetrisPalanen) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setPisteMaara(int pisteMaara) {
        this.pisteMaara = pisteMaara;
    }

    public int getPisteMaara() {
        return pisteMaara;
    }

    public int getRivienMaara() {
        return rivienMaara;
    }

    public int getVaikeusTaso() {
        return vaikeusTaso;
    }

    public void setRivienMaara(int rivienMaara) {
        this.rivienMaara = rivienMaara;
    }

    public void setVaikeusTaso(int vaikeusTaso) {
        this.vaikeusTaso = vaikeusTaso;
    }

    /**
     * montako kertaa siirretään nappulaa, tulostetaanko välitulos? Lopullisessa
     * pelissä aina false
     *
     *
     * @param montakoKertaa montako kertaa toteutetaan
     * @param tulostetaanko true niin välitulokset
     */
    public boolean siirraNappulaaOikealle(int montakoKertaa, boolean tulostetaanko) {
        boolean onnistuiko = true;

        for (int i = 0; i < montakoKertaa; i++) {
            if (tulostetaanko == true) {
                tulostaMatriisi("siirraNappulaaOikealle");
            }
            poistaNappulaNakyvista();
            onnistuiko = siirraNappulaa("oikealle");
            update();
            asetaNappulanPaikkaLaudalla();

        }
        if (tulostetaanko == true) {
            tulostaMatriisi("Lopputuolus:siirraNappulaaOikealle");
        }
        return onnistuiko;
    }

    /**
     * montako kertaa siirretään nappulaa, tulostetaanko välitulos? Lopullisessa
     * pelissä aina false
     *
     *
     * @param montakoKertaa montako kertaa toteutetaan
     * @param tulostetaanko true niin välitulokset
     */
    public boolean siirraNappulaaVasemmalle(int montakoKertaa, boolean tulostetaanko) {
        boolean onnistuiko = true;

        for (int i = 0; i < montakoKertaa; i++) {
            if (tulostetaanko == true) {
                tulostaMatriisi("siirraNappulaaVasemmalle");
            }
            poistaNappulaNakyvista();
            onnistuiko = siirraNappulaa("vasemmalle");
            update();
            asetaNappulanPaikkaLaudalla();

        }
        if (tulostetaanko == true) {
            tulostaMatriisi("Lopputulos:siirraNappulaaVasemmalle");
        }
        return onnistuiko;
    }

    /**
     * montako kertaa siirretään nappulaa, tulostetaanko välitulos? Lopullisessa
     * pelissä aina false
     *
     * @param montakoKertaa montako kertaa toteutetaan
     * @param tulostetaanko true niin välitulokset
     */
    public boolean siirraNappulaaAlas(int montakoKertaa, boolean tulostetaanko) {
        boolean onnistuiko = true;

        for (int i = 0; i < montakoKertaa; i++) {
            if (tulostetaanko == true) {
                tulostaMatriisi("siirraNappulaaAlas");
            }
            poistaNappulaNakyvista();
            onnistuiko = siirraNappulaa("alas");
            asetaNappulanPaikkaLaudalla();
            update();
            uusiNappulaLaudalleNakyviin(nappula);
        }
        if (tulostetaanko == true) {
            tulostaMatriisi("Lopputulos:siirraNappulaaAlas");
        }
        return onnistuiko;
    }

    /**
     * montako kertaa siirretään nappulaa, tulostetaanko välitulos? Lopullisessa
     * pelissä aina false
     *
     *
     * @param montakoKertaa montako kertaa toteutetaan
     * @param tulostetaanko true niin välitulokset
     */
    public boolean pyoritaNappulaa(int montakoKertaa, boolean tulostetaanko) {
        boolean onnistuiko = true;

        for (int i = 0; i < montakoKertaa; i++) {
            if (tulostetaanko == true) {
                tulostaMatriisi("pyoritaNappulaa");
            }
            // poistaNappulaNakyvista();
            onnistuiko = pyoritaNappulaa();
            update();
            //asetaNappulanPaikkaLaudalla();
            uusiNappulaLaudalleNakyviin(nappula);
        }
        if (tulostetaanko == true) {
            tulostaMatriisi("Lopputulos:pyoritaNappulaa");
        }
        return onnistuiko;
    }

    /**
     * pyöritä nappulaa, kutsutaan nappulan omaa pyöri metodia.
     *
     * @return onnistuiko
     */
    public boolean pyoritaNappulaa() {
        Palanen[][] tutkittavaAlue = annaTutkittavaAlue(2 * nappula.getSade() + 1);
        boolean onnistuiko = nappula.pyorahda(tutkittavaAlue);
        return onnistuiko;
    }

    public int getSarakkeet() {
        return sarakkeet;
    }

    public int getRivit() {
        return rivit;
    }

    public Nappula getNappula() {
        return nappula;
    }

    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }

    public Next getNext() {
        return next;
    }
}
