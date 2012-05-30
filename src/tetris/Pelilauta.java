/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

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
     *
     *
     *
     *
     */
    public void tulostaMatriisi() {
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
     *
     *
     *
     *
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

//    public int pelilaudanRuudunArvo(int rivi, int sarake) {
//        int arvo = pelilauta[rivi][sarake];
//        return arvo;
//    }
    /**
     * asettaa nappulan laudalle
     *
     *
     *
     *
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

    public void uusiNappulaLaudalle(Nappula nappula) {
        this.nappula = nappula;
//        ArrayList<Palanen> palaset = nappula.getPalaset();


    }

    /**
     * asettaa uuden nappulan nextiin
     *
     *
     *
     *
     */
    public void uusiNappulaNextista(Nappula nappula) {
        Nappula seuraava = next.getNappula();
        this.nappula = seuraava;

    }

    public void uusiNappulaNextiin() {
        next.uusiNappulaNextiin();
    }

    public void uusiNappulaKasaLaudalle(NappulaKasa moykky) {
        this.moykky = moykky;

    }

    /**
     * muuttaa nappulan napppulakasaan
     *
     *
     *
     *
     */
    public boolean muutaNappulaMoykyksi() {
        if (nappula.isNappulaElossa() == false) {
            moykky.lisaaPalanenMoykkyyn(nappula);
            return true;
        }
        return false;
    }
//
//    public void asetaMoykynPalasetKolmosiksi() {
//        ArrayList<Palanen> moykynPalaset = new ArrayList<Palanen>();
//        moykynPalaset = moykky.getPalaset();
//        for (int i = 0; i < moykynPalaset.size(); i++) {
//            Palanen pala = moykynPalaset.get(i);
//            int rivi = pala.getRivi();
//            int sarake = pala.getSarake();
//            pelilauta[rivi][sarake] = 3;
//        }
//    }

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
     * tutkii voiko nappula liikkua alas, että ei ole reuna tai nappulakasa
     * tiellä
     *
     *
     *
     *
     */
    public boolean voinkoLiikkuaAlas() {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            Palanen tutkittavaPalanen = pelilauta[rivinNumero + 1][sarakeNumero];
            if (tutkittavaPalanen instanceof ReunaPalanen) {
                return false;
            }
        }


        return true;
    }

    /**
     * tutkii voiko nappula liikkua oikealle, että ei ole reuna tai nappulakasa
     * tiellä
     *
     *
     *
     *
     */
    public boolean voinkoLiikkuaOikealle() {

        ArrayList<Palanen> palaset = nappula.getPalaset();

        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            Palanen tutkittavaPalanen = pelilauta[rivinNumero][sarakeNumero + 1];
            if (tutkittavaPalanen instanceof ReunaPalanen) {
                return false;
            }
        }
        return true;
    }

    /**
     * tutkii voiko nappula liikkua vasemmalle, että ei ole reuna tai
     * nappulakasa tiellä
     *
     *
     *
     *
     */
    public boolean voinkoLiikkuaVasemmalle() {
        ArrayList<Palanen> palaset = nappula.getPalaset();

        for (int i = 0; i < palaset.size(); i++) {
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            Palanen tutkittavaPalanen = pelilauta[rivinNumero][sarakeNumero - 1];
            if (tutkittavaPalanen instanceof ReunaPalanen) {
                return false;
            }
        }
        return true;
    }
    
        /**
     * tiputtaa nappulaa yhden verran alas, kutsuu nappulan omaa siirry alas metodia.
     *
     *
     *
     *
     */

    public boolean tiputaNappulaaAlas() {
        if (nappula.isNappulaElossa() == false) {
            return false;
        }
        if (voinkoLiikkuaAlas() == false) {
            nappula.setOnkoNappulaElossa(false);
            return false;
        }
        //  poistaNappulaNakyvista();
        nappula.liikuAlas();
        //   asetaNappulanPaikkaLaudallaYkkoseksi();
        return true;
    }
    
            /**
     * siirtää nappullaa oikealle, kutsuu nappulan omaa siirry oikealle metodia.
     *
     *
     *
     *
     */

    public boolean siirraNappullaaOikealle() {
        if (nappula.isNappulaElossa() == false) {
            return false;
        }
        if (voinkoLiikkuaOikealle() == false) {
            return false;
        }
        //    poistaNappulaNakyvista();
        nappula.liikuOikealle();
        //    asetaNappulanPaikkaLaudallaYkkoseksi();
        return true;
    }

            /**
     * siirtää nappullaa oikealle, kutsuu nappulan omaa siirry vasemalle metodia.
     *
     *
     *
     *
     */
    public boolean siirraNappullaaVasemmalle() {
        if (nappula.isNappulaElossa() == false) {
            return false;
        }
        if (voinkoLiikkuaVasemmalle() == false) {
            return false;
        }
        //   poistaNappulaNakyvista();
        nappula.liikuVasemmalle();
        //   asetaNappulanPaikkaLaudallaYkkoseksi();
        return true;
    }
               /**
     * tutkii onko rivillä yhtään nullia, jos on niin riviä ei voi rysäyttää, jos on niin true.
     *
     *
     *
     *@return onko rysäytettävää
     */

    public boolean onkoRysaytettavaa() {
        boolean onkoRysaytettavaa = false;
        for (int rivi = 0; rivi < pelilauta.length - 1; rivi++) {


            for (int sarake = 1; sarake < pelilauta[0].length - 1; sarake++) {
                if (pelilauta[rivi][sarake] == null) {
                    break;
                }
                onkoRysaytettavaa = true;
            }

        }
        return onkoRysaytettavaa;
    }

                   /**
     * jos on rysäytettävää niin otetaan niiden rivit ylös
     *
     *
     *
     *@return rysäytettävien rivien numero
     */
    
    public ArrayList<Integer> annaRysaytettavatRivit() {
        ArrayList<Integer> rysaytettavat = new ArrayList<Integer>();
        for (int rivi = 0; rivi < pelilauta.length; rivi++) {


            for (int sarake = 0; sarake < pelilauta[0].length; sarake++) {
                if (pelilauta[rivi][sarake] == null) {
                    break;
                }
                rysaytettavat.add(rivi);

            }

        }
        return rysaytettavat;
    }

                    /**
     * mitkä rivit rysäytetään, eli niiden yläpuolella olevaa nappulakasan palasien riviä lisätään yhdellä per rivi jota rysäytetään.
     *
     *
     *
     *@param rysäytettävien rivien numerot
     */
    
    public void rysayta(ArrayList<Integer> rysaytettavat) {
        for (int i = 0; i < rysaytettavat.size(); i++) {

            moykky.tiputaMoykkya(i);
        }
    }
    
                      /**
     * pyöräytystä varten pitää antaa pelilaudalta tietoja että sopiiko nappula pyörimään. 
     * Tutkittavan alueen koko riippuu nappulan säteestä,
     * esim. jos säde 1 => annetaan 3x3 alue jossa keskipisteenä on nappulan keskipiste
     * (eli siis minkä palasen suhteen nappula pyörii ympäri) tai jos säde 2 niin 5x alue jne.
     *
     *
     *
     *@param palasten otos
     */

    public Palanen[][] annaTutkittavaAlue() {

        if (nappula.getSade() == 0) {
            return null;
        }
        Palanen[][] tutkittavaAlue = new Palanen[2 * nappula.getSade() + 1][2 * nappula.getSade() + 1];
        Palanen keskipiste = nappula.getKeskipiste();
        int rivi = keskipiste.getRivi() - nappula.getSade();
        int sarake = keskipiste.getSarake() - nappula.getSade();
        for (int i = 0; i < 2 * nappula.getSade() + 1; i++) {
            for (int j = 0; j < 2 * nappula.getSade() + 1; j++) {
                if (rivi < 0 || sarake < 0 || sarake == 0) {
                    Palanen reunapalanen = new ReunaPalanen(rivi, sarake);
                    tutkittavaAlue[rivi][sarake] = reunapalanen;
                } else if (rivi == pelilauta.length - 1 || sarake == pelilauta[0].length - 1) {
                    Palanen reunapalanen = new ReunaPalanen(rivi, sarake);
                    tutkittavaAlue[rivi][sarake] = reunapalanen;
                } else {
                    tutkittavaAlue[rivi][sarake] = null;
                }

            }
        }
        return tutkittavaAlue;
    }
    
                         /**
     * pyöritä nappulaa, kutsutaan nappulan omaa pyöri metodia.
     *
     *
     *
     *@return onnistuiko
     */

    public boolean pyoritaNappulaa() {
        Palanen[][] tutkittavaAlue = annaTutkittavaAlue();
        boolean onnistuiko = nappula.pyorahda(tutkittavaAlue);
        return onnistuiko;
    }

                          /**
     * nappula osunut reunaan tai nappulakasaan, muutetaan kuolleeksi 
     * kutsumalla nappulan omaa boolean metodia.
     *
     *
     *
     *
     */
    public void muutaNappulaKuolleeksi() {
        nappula.setOnkoNappulaElossa(false);
    }
    
                              /**
     * jos nappula muuttuu kuolleksi ja joku nappulan palanen on game-over alueella. 
     * Normaalissa tetriksessä se on kaksi ekaa riviä pelilaudalta, 
     * mutta tätä voi muuttaa haluttaessa.
     *
     *
     *@return onko peli ohi
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
}
