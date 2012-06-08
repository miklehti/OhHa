/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LayOut;

/**
 *
 * @author lehtimik
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Graphics;
import java.awt.Color;
import tetris.Next;
import javax.swing.JPanel;
import tetris.Pelilauta;

public class Graphics extends JFrame {

    private TetrisPaneeli tetrispaneeli;
//    private NextPaneeli nextpaneeli;
    private JTextField tulos;
    private JTextField level;

    public Graphics() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(1000, 1000);
            
                
        this.setTitle("Tetris");


    

//        JPanel pp2 = new JPanel(new BorderLayout());
        tetrispaneeli = new TetrisPaneeli();
//       nextpaneeli = new NextPaneeli();
//      pp2.setSize((new Dimension(1000, 1000)));
//      pp2.add(tetrispaneeli,BorderLayout.NORTH);
//      pp2.add(nextpaneeli,BorderLayout.SOUTH );

        this.add("Center", tetrispaneeli);

        this.setVisible(true);
    }

    public void paivitaTetrisPaneeli(Pelilauta pelilauta, Next next) {

        tetrispaneeli.setPelilauta(pelilauta);
        tetrispaneeli.setNext(next);
        tetrispaneeli.repaint();
    }

//    public void paivitaNextPaneeli(Next next) {
//
//        nextpaneeli.setNext(next);
//        nextpaneeli.repaint();
//    }
}
