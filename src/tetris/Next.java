/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author HP_User
 */
public class Next {

    private int next[][];
    private Nappula nappula;

    public Next() {
        next = new int[6][6];
        for (int rivi = 0; rivi < next.length; rivi++) {
            for (int sarake = 0; sarake < next[0].length; sarake++) {

                next[rivi][sarake] = 0;


            }
        }
    }
    
     public void tulostaMatriisi() {
        for (int rivi = 0; rivi < next.length; ++rivi) {
            for (int sarake = 0; sarake < next[rivi].length; ++sarake) {
                int alkionArvo = next[rivi][sarake];
                System.out.print(alkionArvo + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
     
       public void asetaNappulanPaikkaLaudallaYkkoseksi() {
        next[nappula.annaEkaRivi()][nappula.annaEkaSarake()] = 1;
        next[nappula.annaTokaRivi()][nappula.annaTokaSarake()] = 1;
        next[nappula.annaKolmasRivi()][nappula.annaKolmasSarake()] = 1;
        next[nappula.annaNeljasRivi()][nappula.annaNeljasSarake()] = 1;
    }

    public void uusiNappulaLaudalle(Nappula nappula) {
        this.nappula = nappula;
        
    }
}
