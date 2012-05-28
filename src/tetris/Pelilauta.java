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

    private Palanen pelilauta[][];
    private Nappula nappula;
    private NappulaKasa moykky;
    private Next next;
    private int GameOverAlueenKokoRiveina = 2; //piilossa oleva alue jonne nappulat luodaan, jos nappula muuttuu möykyksi tuolla alueella peli on ohi
    private int pisteMaara;
    private int rivienMaara;
    private int vaikeusTaso;
//    private Palanen palanen;

    public Pelilauta(int rivi, int sarake) {
         moykky = new  NappulaKasa();
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
     public void uusiNappulaNextista(Nappula nappula) {
        Nappula seuraava = next.getNappula();
       this.nappula = seuraava;      

    }
     
     public void uusiNappulaNextiin(){
         next.uusiNappulaNextiin();
     }

    public void uusiNappulaKasaLaudalle(NappulaKasa moykky) {
        this.moykky = moykky;

    }

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
    //muuta että ArrayList
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

    public boolean onkoRysaytettavaa() {
        boolean onkoRysaytettavaa = false;
        for (int rivi = 0; rivi < pelilauta.length-1; rivi++) {


            for (int sarake = 1; sarake < pelilauta[0].length-1; sarake++) {
                if (pelilauta[rivi][sarake] == null) {
                    break;
                }
                onkoRysaytettavaa = true;
            }

        }
        return onkoRysaytettavaa;
    }

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

    public void rysayta(ArrayList<Integer> rysaytettavat) {
        for (int i = 0; i < rysaytettavat.size(); i++) {

            moykky.tiputaMoykkya(i);
        }
    }

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
                } else{
                    tutkittavaAlue[rivi][sarake] = null;
                }

            }
        }
        return tutkittavaAlue;
    }

    public boolean pyoritaNappulaa() {
        Palanen[][] tutkittavaAlue = annaTutkittavaAlue();
        boolean onnistuiko = nappula.pyorahda(tutkittavaAlue);
        return onnistuiko;
    }
    public void muutaNappulaKuolleeksi(){
    nappula.setOnkoNappulaElossa(false);
}

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
