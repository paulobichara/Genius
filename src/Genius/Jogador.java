package Genius;

import java.io.*;
import java.awt.*;
import java.util.*;

class Jogador {

  private String nome;
  private String apelido;

  public Jogador(String n, String a) {
    nome = n;
    apelido = a;
  }

  public String getNome() {
    return nome;
  }

  public String getApelido() {
    return apelido;
  }
}