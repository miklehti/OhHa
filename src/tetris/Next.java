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

    private Palanen next[][];
    private Nappula nappula;


    public Next() {
    
        next = new Palanen[6][6];
        for (int rivi = 0; rivi < next.length; rivi++) {
            for (int sarake = 0; sarake < next[0].length; sarake++) {

                next[rivi][sarake] = null;


            }
        }
    }
    
    public void tulostaMatriisi() {
        for (int rivi = 0; rivi < next.length; ++rivi) {
            for (int sarake = 0; sarake < next[rivi].length; ++sarake) {
                int alkionArvo = 0;
                Palanen palanen = next[rivi][sarake];
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


    public void uusiNappulaLaudalle(Nappula nappula) {
        this.nappula = nappula;
        
    }
}
