/*
   Copyright 2011 Paulo Augusto Dacach Bichara

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

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