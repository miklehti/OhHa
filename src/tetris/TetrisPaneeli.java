/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author lehtimik
 */
class TetrisPaneeli extends JPanel implements KeyListener{

    Pelilauta pelilauta;
    int height;
    int width;

    public TetrisPaneeli() {
        height = 15;
        width = 15;
         addKeyListener(this);
    }

    public void setPelilauta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    public void paintComponent(Graphics kuva) {

        setBackground(Color.black);
        
//        System.out.println(pelilauta.getRivit()); 
//          System.out.println(pelilauta.getSarakkeet());      

        for (int i = 2; i < pelilauta.getRivit(); i++) {
            for (int j = 0; j < pelilauta.getSarakkeet(); j++) {
//                  for (int i = 2; i <4; i++) {
//            for (int j = 0; j < 2; j++) {


                if (pelilauta.annaPelilaudanAlkio(i, j) instanceof ReunaPalanen) {
                    kuva.setColor(Color.gray);
                    kuva.fillRect(100+((j+1)*width), (50+((i-1)*height)), height, width);
                }
                if (pelilauta.annaPelilaudanAlkio(i, j) ==null) {
                    kuva.setColor(Color.yellow);
                    kuva.fillRect(100+((j+1)*width), (50+((i-1)*height)), height, width);
                }
                if (pelilauta.annaPelilaudanAlkio(i, j) instanceof TetrisPalanen) {
                    kuva.setColor(Color.red);
                    kuva.fillRect(100+((j+1)*width), (50+((i-1)*height)), height, width);
                }
            }
        }
    }
 public void keyPressed(KeyEvent tapahtuma) {
        toteutaToiminto(tapahtuma);
    }

    public void keyReleased(KeyEvent tapahtuma) {
    }

    public void keyTyped(KeyEvent tapahtuma) {
    }
    
      public boolean isFocusTraversable() {
    return true;
  }

    public void toteutaToiminto(KeyEvent tapahtuma) {
        int keyCode = tapahtuma.getKeyCode();
        if (keyCode == KeyEvent.VK_RIGHT) {
            pelilauta.siirraNappulaaOikealle(1, false);
            repaint();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            pelilauta.siirraNappulaaVasemmalle(1, false);
           repaint();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            pelilauta.siirraNappulaaAlas(1, false);
            repaint();        
         } else if (keyCode == KeyEvent.VK_UP) {
            pelilauta.pyoritaNappulaa(1, false);
            repaint();
        }
    }
    }

