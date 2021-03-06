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

import java.util.ArrayList;

class Campeonato {
  ArrayList rodadas;
  ArrayList jogadores;

  public Campeonato() {
    rodadas = new ArrayList();
    jogadores = new ArrayList();
  }

  public void cadastrarJogador(String nome, String apelido) {
    Jogador j;

    j = new Jogador(nome, apelido);
    jogadores.add(j);
  }

  public void criarRodada(String apelido) {
    Jogador j;
    Rodada r;
    int i = 0;

    do {
      j = (Jogador)jogadores.get(i);
      i++;
    } while (j.getApelido().equals(apelido) == false);
    r = new Rodada(j);
    rodadas.add(r);
  }

  public void addElementoSequencia(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    r.addElementoSequencia();
  }

  public void zeraSequenciaJogador(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    r.zeraSequenciaJogador();
  }

  public boolean addJogada(String apelido, int n) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.addJogada(n);
  }

  public boolean checaJogada(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.checaJogada();
  }

  public void pararCronometro(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    r.pararCronometro();
  }


  public void iniciarCronometro(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    r.iniciarCronometro();
  }

  public long getTempo(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.getTempo();
  }

  public int getScore(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.getScore();
  }

  public int[] getSequencia(String apelido) {
      Rodada r;
      Jogador j;
      int i = 0;

      do {
        r = (Rodada)rodadas.get(i);
        j = (Jogador)r.getJogador();
        i++;
      } while (j.getApelido().equals(apelido) == false);
      return r.getSequencia();
  }

  public long getAtraso(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.getAtraso();
  }

  public boolean checaPassouNivel(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.checaPassouNivel();
  }

  public int getNivel(String apelido) {
    Rodada r;
    Jogador j;
    int i = 0;

    do {
      r = (Rodada)rodadas.get(i);
      j = (Jogador)r.getJogador();
      i++;
    } while (j.getApelido().equals(apelido) == false);
    return r.getNivel();
  }

  public String getNome(String apelido) {
      Rodada r;
      Jogador j;
      int i = 0;

      do {
        r = (Rodada)rodadas.get(i);
        j = (Jogador)r.getJogador();
        i++;
      } while (j.getApelido().equals(apelido) == false);
      return r.getNome();
  }

  public void encerrarCampeonato() {
    int i = 0;

    do {
      rodadas.remove(i);
      i++;
    } while (i < rodadas.size());
  }

}

