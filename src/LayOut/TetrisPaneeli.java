/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LayOut;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Next;
import tetris.Palanen;
import tetris.Pelilauta;

/**
 *
 * @author lehtimik
 */
class TetrisPaneeli extends JPanel implements KeyListener{

    Pelilauta pelilauta;
    int height;
    int width;
      private Next next;

    public TetrisPaneeli() {
        height = 15;
        width = 15;
         addKeyListener(this);
        // this.setSize(400, 400);
    }

    public void setPelilauta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }
            public void setNext(Next next) {
        this.next = next;
    }
    
    public void piirraTetrisLauta(Graphics kuva){
        
        for (int i = 2; i < pelilauta.getRivit(); i++) {
            for (int j = 0; j < pelilauta.getSarakkeet(); j++) {



                if (pelilauta.annaPelilaudanAlkio(i, j) instanceof Palanen) {
                    Palanen palanen = pelilauta.annaPelilaudanAlkio(i, j);
                    kuva.setColor(palanen.getVari());
                    kuva.fillRect(100+((j+1)*width), (50+((i-1)*height)), height, width);
                }
                if (pelilauta.annaPelilaudanAlkio(i, j) ==null) {
                    kuva.setColor(Color.DARK_GRAY);
                    kuva.fillRect(100+((j+1)*width), (50+((i-1)*height)), height, width);
                }

            }
        }
    }
    
    public void piirraTetrisNexti(Graphics kuva){
        setBackground(Color.black);
         kuva.drawString("Next:", 20, 80);
           for (int i = 0; i < next.getNextRivit(); i++) {
            for (int j = 0; j < next.getNextSarakkeet(); j++) {

                if (next.annaNextPalanen(i, j) instanceof Palanen) {
                    Palanen palanen = next.annaNextPalanen(i, j);
                    kuva.setColor(palanen.getVari());
                     kuva.fillRect(5+((j+1)*width), (100+((i-1)*height)), height, width);
                }
                if (next.annaNextPalanen(i, j) ==null) {
                    kuva.setColor(Color.DARK_GRAY);
                     kuva.fillRect(5+((j+1)*width), (100+((i-1)*height)), height, width);
                }

            }
        }
    }
    
     public void piirraTulostiedot(Graphics kuva){
         kuva.clearRect(0, 0, 100, 50);
          kuva.drawString("Pisteet: " + pelilauta.getPisteMaara(), 10, 10);
          kuva.drawString("Vaikeustaso: " + pelilauta.getVaikeusTaso(), 10, 20);
       kuva.drawString("Rivejä: " + pelilauta.getRivienMaara(), 10, 30);
     }

    public void paintComponent(Graphics kuva) {

        setBackground(Color.black);
           piirraTetrisLauta(kuva);
            piirraTetrisNexti(kuva);
            piirraTulostiedot(kuva);

        
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
            pelilauta.setPisteMaara(pelilauta.getPisteMaara()+1);
         } else if (keyCode == KeyEvent.VK_UP) {
            pelilauta.pyoritaNappulaa(1, false);
            repaint();
        }
    }
    }

