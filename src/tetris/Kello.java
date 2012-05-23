/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author miklehti
 */
public class Kello {
    
    private long startTime;

    public Kello() {
        startTime=0;
    }

    public void nollaaKello() {
       startTime = System.currentTimeMillis();

    }
    public long paljonkoOnKulunut(){
       
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
