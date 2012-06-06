/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author lehtimik
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Graphics;
import java.awt.Color;

public class Graphics extends JFrame  {

    private TetrisPaneeli tetrispaneeli = new TetrisPaneeli();
    private JTextField tulos;
    private JTextField level;
    

    public Graphics() {


        // luodaan käyttöliittymäelementit, oliot:



        // valitaan asemointi:


//        tulos = new JTextField("tulos");
//        tulos.setEditable(false);  // muuttamattomaksi!
//        level = new JTextField("level");
//        level.setEditable(false);  // muuttamattomaksi!
//
//        JPanel pp2 = new JPanel(new GridLayout(2, 1));
//        pp2.add(tulos);
//        pp2.add(level);
//
//        JPanel p12 = new JPanel(new BorderLayout());
//        p12.add("Center", tetrispaneeli);
//
//
       


        setLayout(new BorderLayout());
        add("Center", tetrispaneeli);
////        add("North", tulos);
////        add("West", level);
        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
      
    }

    public void paivitaTetrisPaneeli(Pelilauta pelilauta) {
       
        tetrispaneeli.setPelilauta(pelilauta);
        tetrispaneeli.repaint();
    }

   
}
