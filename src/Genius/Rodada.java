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

import java.io.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
import java.sql.*;

class Rodada {

  private Jogador jog;
  private long tempo;
  private int score;
  private int contJogada;
  private Random elemento;
  private int sequenciaJogador[];
  private int sequencia[];
  private int nivel;
  private long atraso;
  private boolean passouNivel = false;
  private boolean encerrarPartida;

  public Rodada(Jogador j) {
    int i = 0;

    jog = j;
    nivel = 1;
    atraso = 1500;
    elemento = new Random();
    sequencia = new int[60];
    sequenciaJogador = new int[60];
    do {
      sequencia[i] = 4;
      i++;
    } while (i < 60);
    i = 0;
    do {
      sequenciaJogador[i] = 4;
      i++;
    } while (i < 60);

    score = 0;
    encerrarPartida = false;
  }

  public void addElementoSequencia() {
    int i = -1;

    do {
      i++;
    } while (sequencia[i] != 4);
    sequencia[i] = elemento.nextInt(4);
    if (i == 18) {
      nivel = 2;
      passouNivel = true;
      atraso = 1100;
    }
    if (i == 38) {
      nivel = 3;
      passouNivel = true;
      atraso = 700;
    }
  }

  public boolean checaJogada() {
    int i = -1;
    boolean acertou = true;

    do {
      i++;
      if (sequencia[i] != sequenciaJogador[i]) {
        acertou = false;
      }
    } while (sequenciaJogador[i+1] != 4);
    if (acertou == true) {
      score = score + 1;
    } else {
      encerrarPartida = true;
    }
    return acertou;
  }

  public void zeraSequenciaJogador() {
    int i = 0;
    do {
      sequenciaJogador[i] = 4;
      i++;
    } while (i < 60);
  }

  public boolean addJogada (int n) {
    int i = -1;
    boolean piscar;

    do {
      i++;
    } while (sequenciaJogador[i] != 4);
    sequenciaJogador[i] = n;
    if (sequencia[i+1] == 4) {
      piscar = true;
    } else {
      piscar = false;
    }
    return piscar;
  }

  public Jogador getJogador() {
    return jog;
  }

  public void iniciarCronometro() {
    tempo = System.currentTimeMillis();
  }

  public void pararCronometro() {
    tempo = System.currentTimeMillis() - tempo;
  }

  public boolean checaPassouNivel() {
    if (passouNivel == true) {
      passouNivel = false;
      return true;
    } else {
      return false;
    }
  }

  public long getTempo() {
    return tempo;
  }

  public String getNome() {
    return jog.getNome();
  }

  public int getScore() {
    return score;
  }

  public int[] getSequencia() {
    return sequencia;
  }

  public int getNivel() {
    return nivel;
  }

  public long getAtraso() {
    return atraso;
  }

  public boolean getEncerrarPartida() {
    return encerrarPartida;
  }
}
