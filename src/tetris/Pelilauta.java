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

    private int pelilauta[][];
    private Nappula nappula;
    private Moykky moykky;
//    private Palanen palanen;

    public Pelilauta(int rivi, int sarake) {

        pelilauta = new int[rivi][sarake];
        for (rivi = 0; rivi < pelilauta.length; rivi++) {
            for (sarake = 0; sarake < pelilauta[0].length; sarake++) {

                pelilauta[rivi][sarake] = 0;

                if (rivi == pelilauta.length - 1) {
                    pelilauta[rivi][sarake] = 5;
                }
                if (sarake == pelilauta[0].length - 1) {
                    pelilauta[rivi][sarake] = 5;
                }
                if (sarake == 0) {
                    pelilauta[rivi][sarake] = 5;
                }

            }
        }

    }

    public void tulostaMatriisi() {
        for (int rivi = 0; rivi < pelilauta.length; ++rivi) {
            for (int sarake = 0; sarake < pelilauta[rivi].length; ++sarake) {
                int alkionArvo = pelilauta[rivi][sarake];
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
                int alkionArvo = pelilauta[rivi][sarake];
                summa = summa + alkionArvo;
            }

        }
        return summa;
    }

    public int pelilaudanRuudunArvo(int rivi, int sarake) {
        int arvo = pelilauta[rivi][sarake];
        return arvo;
    }

    public void asetaNappulanPaikkaLaudallaYkkoseksi() {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for(int i  = 0; i< palaset.size();i++){
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            pelilauta[rivinNumero][sarakeNumero] = 1;
        }
       
    }

    public void uusiNappulaLaudalle(Nappula nappula) {
        this.nappula = nappula;

    }

    public void uusiMoykkyLaudalle(Moykky moykky) {
        this.moykky = moykky;

    }

    public boolean muutaNappulaMoykyksi() {
        if (nappula.isNappulaElossa() == false) {
            moykky.lisaaPalanenMoykkyyn(nappula);
            return true;
        }
        return false;
    }

    public void asetaMoykynPalasetKolmosiksi() {
        ArrayList<Palanen> moykynPalaset = new ArrayList<Palanen>();
        moykynPalaset = moykky.getPalaset();
        for (int i = 0; i < moykynPalaset.size(); i++) {
            Palanen pala = moykynPalaset.get(i);
            int rivi = pala.getRivi();
            int sarake = pala.getSarake();
            pelilauta[rivi][sarake] = 3;
        }
    }

    public void poistaNappulaNakyvista() {
        for (int rivi = 0; rivi < pelilauta.length; ++rivi) {
            for (int sarake = 0; sarake < pelilauta[rivi].length; ++sarake) {
                if (pelilauta[rivi][sarake] == 1) {
                    pelilauta[rivi][sarake] = 0;
                }
            }
        }
    }

    //muuta että ArrayList
    public boolean voinkoLiikkuaAlas() {
         ArrayList<Palanen> palaset = nappula.getPalaset();
        for(int i  = 0; i< palaset.size();i++){
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            if (pelilauta[rivinNumero + 1][sarakeNumero] > 1) {
            return false;
        }
        }
   

        return true;
    }

    public boolean voinkoLiikkuaOikealle() {
        
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for(int i  = 0; i< palaset.size();i++){
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            if (pelilauta[rivinNumero][sarakeNumero+1] > 1) {
            return false;
        }
        }

        return true;
    }

    public boolean voinkoLiikkuaVasemmalle() {
        ArrayList<Palanen> palaset = nappula.getPalaset();
        for(int i  = 0; i< palaset.size();i++){
            Palanen palanen = palaset.get(i);
            int rivinNumero = palanen.getRivi();
            int sarakeNumero = palanen.getSarake();
            if (pelilauta[rivinNumero][sarakeNumero-1] > 1) {
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
        poistaNappulaNakyvista();
        nappula.liikuAlas();
        asetaNappulanPaikkaLaudallaYkkoseksi();
        return true;
    }

    public boolean siirraNappullaaOikealle() {
        if (nappula.isNappulaElossa() == false) {
            return false;
        }
        if (voinkoLiikkuaOikealle() == false) {
            return false;
        }
        poistaNappulaNakyvista();
        nappula.liikuOikealle();
        asetaNappulanPaikkaLaudallaYkkoseksi();
        return true;
    }

    public boolean siirraNappullaaVasemmalle() {
        if (nappula.isNappulaElossa() == false) {
            return false;
        }
        if (voinkoLiikkuaVasemmalle() == false) {
            return false;
        }
        poistaNappulaNakyvista();
        nappula.liikuVasemmalle();
        asetaNappulanPaikkaLaudallaYkkoseksi();
        return true;
    }

    public boolean onkoRysaytettavaa() {
        for (int rivi = 0; rivi < pelilauta.length; rivi++) {

            int summa = 0;
            for (int sarake = 0; sarake < pelilauta[0].length; sarake++) {
                summa = summa + pelilauta[rivi][sarake];

            }
            if (summa == 40) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> annaRysaytettavatRivit() {
        ArrayList<Integer> rysaytettavat = new ArrayList<Integer>();
        for (int rivi = 0; rivi < pelilauta.length; rivi++) {

            int summa = 0;
            for (int sarake = 0; sarake < pelilauta[0].length; sarake++) {
                summa = summa + pelilauta[rivi][sarake];

            }
            if (summa == 40) {
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
    
    

    //refaktoroi
    public ArrayList<Integer> annaTutkittavaAlue() {
        ArrayList<Integer> alue = new ArrayList<Integer>();
        Palanen keskipiste = nappula.getKeskipiste();
        int keskipisteRivi = keskipiste.getRivi();
        int keskipisteSarake = keskipiste.getSarake();
       
        alue.add(pelilauta[tokaRivi + 1][tokaSarake]);
        alue.add(pelilauta[tokaRivi][tokaSarake + 1]);
        alue.add(pelilauta[tokaRivi - 1][tokaSarake]);
        alue.add(pelilauta[tokaRivi][tokaSarake - 1]);
        alue.add(pelilauta[tokaRivi + 1][tokaSarake + 1]);
        alue.add(pelilauta[tokaRivi - 1][tokaSarake - 1]);
        alue.add(pelilauta[tokaRivi - 1][tokaSarake + 1]);
        alue.add(pelilauta[tokaRivi + 1][tokaSarake - 1]);
        alue.add(pelilauta[tokaRivi][tokaSarake + 2]);
        alue.add(pelilauta[tokaRivi + 2][tokaSarake]);
        return alue;
    }

    public boolean pyoritaNappulaa() {
        ArrayList<Integer> tutkittavaAlue = annaTutkittavaAlue();     
        boolean onnistuiko = nappula.pyorahda(tutkittavaAlue);
        return onnistuiko;
    }

    public boolean onkoPeliOhi() {
        for (int rivi = 0; rivi < 2; rivi++) {
            for (int sarake = 0; sarake < pelilauta[0].length; sarake++) {
                if (pelilauta[rivi][sarake] == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
