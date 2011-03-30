package Genius;

import javax.swing.*;

class Piscar extends Thread {
  JButton bt=null;
  JButton bt2=null;
  JFrame frame=null;
  long atraso;

  public Piscar(JButton j,JButton y,JFrame x, long a) {
    atraso = a;
    bt=j;
    bt2=y;
    frame=x;
  }


  public void run(){
    try { this.sleep(atraso);}catch (Exception ex) { }
    bt.setVisible(true);
    bt2.setVisible(false);
    frame.repaint();

    try { this.sleep(350);}catch (Exception ex) { }
    bt.setVisible(false);
    bt2.setVisible(true);
    frame.repaint();
  }
}