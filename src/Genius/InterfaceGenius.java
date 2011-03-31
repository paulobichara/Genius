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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Rectangle;

public class InterfaceGenius extends JFrame implements ActionListener{
  JTabbedPane jTabbedPaneMenu = new JTabbedPane();  //  @jve:decl-index=0:visual-constraint="10,67"
  JPanel jPanelCad = new JPanel();
  JPanel jPanelSel = new JPanel();
  JPanel jPanelJogar = new JPanel();
  JPanel jPanelRel = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField jTextFieldApelido = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField jTextFieldNome = new JTextField();
  JLabel jLabel3 = new JLabel();
  JButton jButtonCad = new JButton();
  JPanel jPanelAjuda = new JPanel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JComboBox jComboBoxJogs = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JButton jButtonSel = new JButton();
  JButton jButtonJogar = new JButton();
  TitledBorder titledBorder1;
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel10 = new JLabel();
  TitledBorder titledBorder2;  //  @jve:decl-index=0:
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JButton jButtonVerde = new JButton();
  JButton jButtonVermelho = new JButton();
  JButton jButtonAmarelo = new JButton();
  JButton jButtonAzul = new JButton();
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  TitledBorder titledBorder5;
  TitledBorder titledBorder6;
  TitledBorder titledBorder7;
  TitledBorder titledBorder8;
  TitledBorder titledBorder9;
  TitledBorder titledBorder10;
  TitledBorder titledBorder11;
  JButton jButtonComecar = new JButton();
  JLabel jLabelJogdaVez = new JLabel();
  JTextField jTextFieldScore = new JTextField();
  Campeonato c;  //  @jve:decl-index=0:
  JLabel jLabelFundo = new JLabel();
  JTextField jTextFieldJog1 = new JTextField();
  JTextField jTextFieldJog2 = new JTextField();
  JTextField jTextFieldJog3 = new JTextField();
  JTextField jTextFieldJog4 = new JTextField();
  JTextField jTextFieldJog5 = new JTextField();
  JTextField jTextFieldJog6 = new JTextField();
  JLabel jLabel13 = new JLabel();

  JButton jButtonPisqueVerde = new JButton();
  JButton jButtonPisqueAmarelo = new JButton();
  JButton jButtonPisqueAzul = new JButton();
  JLabel jLabel14 = new JLabel();
  JTextField jTextFieldMelhorTempo = new JTextField();
  JComboBox jComboBoxRel = new JComboBox();
  JButton jButtonVerRel = new JButton();
  JLabel jLabel15 = new JLabel();
  JTextField jTextFieldNomeRel = new JTextField();
  JLabel jLabel16 = new JLabel();
  JTextField jTextFieldTempoTotal = new JTextField();
  JLabel jLabel17 = new JLabel();
  JTextField jTextFieldScoreRel = new JTextField();
  JButton jButtonPisqueVermelho = new JButton();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JLabel jLabel111 = new JLabel();
  JLabel jLabel112 = new JLabel();
  JLabel jLabel113 = new JLabel();
  JLabel jLabel114 = new JLabel();
  JLabel jLabelNivel = new JLabel();
  JTextField jTextFieldNivel = new JTextField();
  JButton jButtonSair = new JButton();
  JButton jButtonNovoJogo = new JButton();

  public void actionPerformed(ActionEvent aeEvento){
    Object obSource = aeEvento.getSource();
    if (obSource == jButtonCad) {                            // BOTAO CADASTRAR
      if ( (jTextFieldNome.getText().length() == 0) ||
          (jTextFieldApelido.getText().length() == 0)) {
        JOptionPane.showMessageDialog(null,
            "Cadastro não realizado! Um ou mais campos em branco!", "AVISO",
            JOptionPane.INFORMATION_MESSAGE);
        jTextFieldNome.setText("");
        jTextFieldApelido.setText("");
      }
      else {
        c.cadastrarJogador(jTextFieldNome.getText(), jTextFieldApelido.getText());
        jComboBoxJogs.addItem(jTextFieldApelido.getText());
        JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        jTextFieldNome.setText("");
        jTextFieldApelido.setText("");
      }
    }
    else {
      if (obSource == jButtonSel) {                         // BOTAO SELECIONAR
        if (jComboBoxJogs.getSelectedItem() == null) {
          JOptionPane.showMessageDialog(null, "Nenhum jogador selecionado!",
                                        "AVISO",
                                        JOptionPane.INFORMATION_MESSAGE);
        } else {
          if (jTextFieldJog1.getText().length() == 0) {
            jTextFieldJog1.setText((String)jComboBoxJogs.getSelectedItem());
          } else {
            JOptionPane.showMessageDialog(null, "Por enquanto, so funciona com um jogador!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
          }
        }
      } else {
        if (obSource == jButtonJogar) {                          // BOTAO JOGAR
          if (jTextFieldJog1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador selecionado!",
                                          "AVISO",
                                          JOptionPane.INFORMATION_MESSAGE);
          } else {
            jButtonComecar.setEnabled(true);
            jLabelJogdaVez.setText(jTextFieldJog1.getText());
            jTabbedPaneMenu.setSelectedComponent(jPanelJogar);
            c.criarRodada(jTextFieldJog1.getText());
          }
        } else {
          if (obSource == jButtonComecar) {                     //BOTAO COMEÇAR
            String apelido = jLabelJogdaVez.getText();
            long atraso = 0;
            Piscar pisque;
            int[] seq;

            if (apelido.length() == 0) {
              JOptionPane.showMessageDialog(null, "Nenhum jogador selecionado!",
                                          "AVISO",
                                          JOptionPane.INFORMATION_MESSAGE);
            } else {
              c.iniciarCronometro(apelido);
              jButtonComecar.setEnabled(false);
              jLabelFundo.setEnabled(true);
              jButtonVerde.setEnabled(true);
              jButtonVermelho.setEnabled(true);
              jButtonAmarelo.setEnabled(true);
              jButtonAzul.setEnabled(true);
              jButtonPisqueVerde.setEnabled(true);
              jButtonPisqueVermelho.setEnabled(true);
              jButtonPisqueAmarelo.setEnabled(true);
              jButtonPisqueAzul.setEnabled(true);
              c.addElementoSequencia(apelido);
              seq = c.getSequencia(apelido);
              jTextFieldScore.setText(" " + String.valueOf(c.getScore(apelido)));
              jTextFieldNivel.setText(String.valueOf(c.getNivel(apelido)));
              atraso = atraso + c.getAtraso(apelido);
              if (seq[0] == 0) {
                pisque = new Piscar(jButtonPisqueVerde, jButtonVerde, this, atraso);
                pisque.start();
              } else {
                if (seq[0] == 1) {
                  pisque = new Piscar(jButtonPisqueVermelho, jButtonVermelho, this, atraso);
                  pisque.start();
                } else {
                  if (seq[0] == 2) {
                    pisque = new Piscar(jButtonPisqueAmarelo, jButtonAmarelo, this, atraso);
                    pisque.start();
                  } else {
                    if (seq[0] == 3) {
                      pisque = new Piscar(jButtonPisqueAzul, jButtonAzul, this, atraso);
                      pisque.start();
                    }
                  }
                }
              }
            }
          } else {
            if (obSource == jButtonVerde) {                      // BOTAO VERDE
              String apelido = jLabelJogdaVez.getText();
              Piscar pisque;
              boolean piscar;

              piscar = c.addJogada(apelido, 0);
              if (c.checaJogada(apelido) == true) {
                jTextFieldScore.setText(" " + String.valueOf(c.getScore(apelido)));
                if (piscar == true) {
                  long atraso = 0;
                  long atrasoNivel = c.getAtraso(apelido);
                  int sequencia[];
                  int i;

                  if (c.checaPassouNivel(apelido) == true) {
                    JOptionPane.showMessageDialog(null, apelido + " passou para o nível " + c.getNivel(apelido), "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldNivel.setText(String.valueOf(c.getNivel(apelido)));
                  }
                  if (c.getNivel(apelido) == 1) {
                      c.addElementoSequencia(apelido);
                  } else {
                    if (c.getNivel(apelido) == 2) {
                      c.addElementoSequencia(apelido);
                      c.addElementoSequencia(apelido);
                    } else {
                      if (c.getNivel(apelido) == 3) {
                        c.addElementoSequencia(apelido);
                        c.addElementoSequencia(apelido);
                        c.addElementoSequencia(apelido);
                        c.addElementoSequencia(apelido);
                      }
                    }
                  }

                  c.zeraSequenciaJogador(apelido);
                  sequencia = c.getSequencia(apelido);
                  for (i = 0; sequencia[i] != 4; i++) {
                    if (sequencia[i] == 0) {
                      atraso = atraso + atrasoNivel;
                      pisque = new Piscar(jButtonPisqueVerde, jButtonVerde, this, atraso);
                      pisque.start();
                    } else {
                      if (sequencia[i] == 1) {
                        atraso = atraso + atrasoNivel;
                        pisque = new Piscar(jButtonPisqueVermelho, jButtonVermelho, this, atraso);
                        pisque.start();
                      } else {
                        if (sequencia[i] == 2) {
                          atraso = atraso + atrasoNivel;
                          pisque = new Piscar(jButtonPisqueAmarelo, jButtonAmarelo, this, atraso);
                          pisque.start();
                        } else {
                          atraso = atraso + atrasoNivel;
                          pisque = new Piscar(jButtonPisqueAzul, jButtonAzul, this, atraso);
                          pisque.start();
                        }
                      }
                    }
                  }
                }
              } else {
                if (c.checaJogada(apelido) == false) {
                  JOptionPane.showMessageDialog(null, "Você errou!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                  jButtonVerde.setEnabled(false);
                  jButtonVermelho.setEnabled(false);
                  jButtonAmarelo.setEnabled(false);
                  jButtonAzul.setEnabled(false);
                  jButtonPisqueVerde.setEnabled(false);
                  jButtonPisqueVermelho.setEnabled(false);
                  jButtonPisqueAmarelo.setEnabled(false);
                  jButtonPisqueAzul.setEnabled(false);
                  c.pararCronometro(apelido);
                  jComboBoxRel.setEnabled(true);
                  jButtonSair.setEnabled(true);
                  jButtonVerRel.setEnabled(true);
                  jButtonNovoJogo.setEnabled(true);
                  jTextFieldMelhorTempo.setText(apelido);
                  jComboBoxRel.addItem(apelido);
                  jTabbedPaneMenu.setSelectedComponent(jPanelRel);
                }
              }
            } else {
              if (obSource == jButtonVermelho) {              // BOTAO VERMELHO
                String apelido = jLabelJogdaVez.getText();
                Piscar pisque;
                boolean piscar;

                piscar = c.addJogada(apelido, 1);
                if (c.checaJogada(apelido) == true) {
                  jTextFieldScore.setText(" " + String.valueOf(c.getScore(apelido)));
                  if (piscar == true) {
                    long atraso = 0;
                    long atrasoNivel = c.getAtraso(apelido);
                    int sequencia[];
                    int i;

                    if (c.checaPassouNivel(apelido) == true) {
                      JOptionPane.showMessageDialog(null, apelido + " passou para o nível " + c.getNivel(apelido), "AVISO", JOptionPane.INFORMATION_MESSAGE);
                      jTextFieldNivel.setText(String.valueOf(c.getNivel(apelido)));
                    }
                    if (c.getNivel(apelido) == 1) {
                        c.addElementoSequencia(apelido);
                    } else {
                      if (c.getNivel(apelido) == 2) {
                        c.addElementoSequencia(apelido);
                        c.addElementoSequencia(apelido);
                      } else {
                        if (c.getNivel(apelido) == 3) {
                          c.addElementoSequencia(apelido);
                          c.addElementoSequencia(apelido);
                          c.addElementoSequencia(apelido);
                          c.addElementoSequencia(apelido);
                        }
                      }
                    }
                    c.zeraSequenciaJogador(apelido);
                    sequencia = c.getSequencia(apelido);
                    for (i = 0; sequencia[i] != 4; i++) {
                      if (sequencia[i] == 0) {
                        atraso = atraso + atrasoNivel;
                        pisque = new Piscar(jButtonPisqueVerde, jButtonVerde, this, atraso);
                        pisque.start();
                      } else {
                        if (sequencia[i] == 1) {
                          atraso = atraso + atrasoNivel;
                          pisque = new Piscar(jButtonPisqueVermelho, jButtonVermelho, this, atraso);
                          pisque.start();
                        } else {
                          if (sequencia[i] == 2) {
                            atraso = atraso + atrasoNivel;
                            pisque = new Piscar(jButtonPisqueAmarelo, jButtonAmarelo, this, atraso);
                            pisque.start();
                          } else {
                            atraso = atraso + atrasoNivel;
                            pisque = new Piscar(jButtonPisqueAzul, jButtonAzul, this, atraso);
                            pisque.start();
                          }
                        }
                      }
                    }
                  }
                } else {
                  if (c.checaJogada(apelido) == false) {
                    JOptionPane.showMessageDialog(null, "Você errou!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    jButtonVerde.setEnabled(false);
                    jButtonVermelho.setEnabled(false);
                    jButtonAmarelo.setEnabled(false);
                    jButtonAzul.setEnabled(false);
                    jButtonPisqueVerde.setEnabled(false);
                    jButtonPisqueVermelho.setEnabled(false);
                    jButtonPisqueAmarelo.setEnabled(false);
                    jButtonPisqueAzul.setEnabled(false);
                    c.pararCronometro(apelido);
                    jComboBoxRel.setEnabled(true);
                    jButtonSair.setEnabled(true);
                    jButtonVerRel.setEnabled(true);
                    jButtonNovoJogo.setEnabled(true);
                    jTextFieldMelhorTempo.setText(apelido);
                    jComboBoxRel.addItem(apelido);
                    jTabbedPaneMenu.setSelectedComponent(jPanelRel);
                  }
                }
              } else {
                if (obSource == jButtonAmarelo) {              // BOTAO AMARELO
                  String apelido = jLabelJogdaVez.getText();
                  Piscar pisque;
                  boolean piscar;

                  piscar = c.addJogada(apelido, 2);
                  if (c.checaJogada(apelido) == true) {
                    jTextFieldScore.setText(" " + String.valueOf(c.getScore(apelido)));
                    if (piscar == true) {
                      long atraso = 0;
                      long atrasoNivel = c.getAtraso(apelido);
                      int sequencia[];
                      int i;

                      if (c.checaPassouNivel(apelido) == true) {
                        JOptionPane.showMessageDialog(null, apelido + " passou para o nível " + c.getNivel(apelido), "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        jTextFieldNivel.setText(String.valueOf(c.getNivel(apelido)));
                      }
                      if (c.getNivel(apelido) == 1) {
                        c.addElementoSequencia(apelido);
                      } else {
                        if (c.getNivel(apelido) == 2) {
                          c.addElementoSequencia(apelido);
                          c.addElementoSequencia(apelido);
                        } else {
                          if (c.getNivel(apelido) == 3) {
                            c.addElementoSequencia(apelido);
                            c.addElementoSequencia(apelido);
                            c.addElementoSequencia(apelido);
                            c.addElementoSequencia(apelido);
                          }
                        }
                      }
                      c.zeraSequenciaJogador(apelido);
                      sequencia = c.getSequencia(apelido);
                      for (i = 0; sequencia[i] != 4; i++) {
                        if (sequencia[i] == 0) {
                          atraso = atraso + atrasoNivel;
                          pisque = new Piscar(jButtonPisqueVerde, jButtonVerde, this, atraso);
                          pisque.start();
                        } else {
                          if (sequencia[i] == 1) {
                            atraso = atraso + atrasoNivel;
                            pisque = new Piscar(jButtonPisqueVermelho, jButtonVermelho, this, atraso);
                            pisque.start();
                          } else {
                            if (sequencia[i] == 2) {
                              atraso = atraso + atrasoNivel;
                              pisque = new Piscar(jButtonPisqueAmarelo, jButtonAmarelo, this, atraso);
                              pisque.start();
                            } else {
                              atraso = atraso + atrasoNivel;
                              pisque = new Piscar(jButtonPisqueAzul, jButtonAzul, this, atraso);
                              pisque.start();
                            }
                          }
                        }
                      }
                    }
                  } else {
                    if (c.checaJogada(apelido) == false) {
                      JOptionPane.showMessageDialog(null, "Você errou!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                      jButtonVerde.setEnabled(false);
                      jButtonVermelho.setEnabled(false);
                      jButtonAmarelo.setEnabled(false);
                      jButtonAzul.setEnabled(false);
                      jButtonPisqueVerde.setEnabled(false);
                      jButtonPisqueVermelho.setEnabled(false);
                      jButtonPisqueAmarelo.setEnabled(false);
                      jButtonPisqueAzul.setEnabled(false);
                      c.pararCronometro(apelido);
                      jComboBoxRel.setEnabled(true);
                      jButtonSair.setEnabled(true);
                      jButtonVerRel.setEnabled(true);
                      jButtonNovoJogo.setEnabled(true);
                      jTextFieldMelhorTempo.setText(apelido);
                      jComboBoxRel.addItem(apelido);
                      jTabbedPaneMenu.setSelectedComponent(jPanelRel);
                    }
                  }
                } else {
                  if (obSource == jButtonAzul) {                  // BOTAO AZUL
                    Piscar pisque;
                    String apelido = jLabelJogdaVez.getText();
                    boolean piscar;

                    piscar = c.addJogada(apelido, 3);
                    if (c.checaJogada(apelido) == true) {
                      jTextFieldScore.setText(" " + String.valueOf(c.getScore(apelido)));
                      if (piscar == true) {
                        long atraso = 0;
                        long atrasoNivel = c.getAtraso(apelido);
                        int sequencia[];
                        int i;

                        if (c.checaPassouNivel(apelido) == true) {
                          JOptionPane.showMessageDialog(null, apelido + " passou para o nível " + c.getNivel(apelido), "AVISO", JOptionPane.INFORMATION_MESSAGE);
                          jTextFieldNivel.setText(String.valueOf(c.getNivel(apelido)));
                        }
                        if (c.getNivel(apelido) == 1) {
                          c.addElementoSequencia(apelido);
                        } else {
                          if (c.getNivel(apelido) == 2) {
                            c.addElementoSequencia(apelido);
                            c.addElementoSequencia(apelido);
                          } else {
                            if (c.getNivel(apelido) == 3) {
                              c.addElementoSequencia(apelido);
                              c.addElementoSequencia(apelido);
                              c.addElementoSequencia(apelido);
                              c.addElementoSequencia(apelido);
                            }
                          }
                        }

                        c.zeraSequenciaJogador(apelido);
                        sequencia = c.getSequencia(apelido);
                        for (i = 0; sequencia[i] != 4; i++) {
                          if (sequencia[i] == 0) {
                            atraso = atraso + atrasoNivel;
                            pisque = new Piscar(jButtonPisqueVerde, jButtonVerde, this, atraso);
                            pisque.start();
                          } else {
                            if (sequencia[i] == 1) {
                              atraso = atraso + atrasoNivel;
                              pisque = new Piscar(jButtonPisqueVermelho, jButtonVermelho, this, atraso);
                              pisque.start();
                            } else {
                              if (sequencia[i] == 2) {
                                atraso = atraso + atrasoNivel;
                                pisque = new Piscar(jButtonPisqueAmarelo, jButtonAmarelo, this, atraso);
                                pisque.start();
                              } else {
                                atraso = atraso + atrasoNivel;
                                pisque = new Piscar(jButtonPisqueAzul, jButtonAzul, this, atraso);
                                pisque.start();
                              }
                            }
                          }
                        }
                      }
                  } else {
                      if (c.checaJogada(apelido) == false) {
                        JOptionPane.showMessageDialog(null, "Você errou!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        jButtonVerde.setEnabled(false);
                        jButtonVermelho.setEnabled(false);
                        jButtonAmarelo.setEnabled(false);
                        jButtonAzul.setEnabled(false);
                        jButtonPisqueVerde.setEnabled(false);
                        jButtonPisqueVermelho.setEnabled(false);
                        jButtonPisqueAmarelo.setEnabled(false);
                        jButtonPisqueAzul.setEnabled(false);
                        c.pararCronometro(apelido);
                        jComboBoxRel.setEnabled(true);
                        jButtonSair.setEnabled(true);
                        jButtonVerRel.setEnabled(true);
                        jButtonNovoJogo.setEnabled(true);
                        jComboBoxRel.addItem(apelido);
                        jTextFieldMelhorTempo.setText(apelido);
                        jTabbedPaneMenu.setSelectedComponent(jPanelRel);
                      }
                    }
                  } else {
                    if (obSource == jButtonVerRel) {     // BOTAO VER RELATORIO
                      float segundos;
                      float minutos;
                      String apelido = (String)jComboBoxRel.getSelectedItem();
                      if (apelido.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum Jogador Selecionado!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                      } else {
                        jTextFieldScoreRel.setText(String.valueOf(c.getScore(apelido)));
                        jTextFieldNomeRel.setText(c.getNome(apelido));
                        minutos = (c.getTempo(apelido) / 1000) / 60;
                        segundos = (c.getTempo(apelido) / 1000) - (minutos * 60);
                        jTextFieldTempoTotal.setText(String.valueOf(minutos) + " min e " + String.valueOf(segundos) + " seg");
                      }
                    } else {
                      if (obSource == jButtonNovoJogo) {
                        c.encerrarCampeonato();
                        jTextFieldJog1.setText("");
                        jTextFieldJog2.setText("");
                        jTextFieldJog3.setText("");
                        jTextFieldJog4.setText("");
                        jTextFieldJog5.setText("");
                        jTextFieldJog6.setText("");
                        jTextFieldScore.setText("");
                        jTextFieldScoreRel.setText("");
                        jTextFieldNivel.setText("");
                        jLabelJogdaVez.setText("");
                        jTextFieldMelhorTempo.setText("");
                        jTextFieldNomeRel.setText("");
                        jTextFieldTempoTotal.setText("");
                        jComboBoxRel.removeAll();
                        jTabbedPaneMenu.setSelectedComponent(jPanelSel);
                      } else {
                        if (obSource == jButtonSair) {
                          c.encerrarCampeonato();
                          System.exit(0);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }


  public InterfaceGenius() {
    try  {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    jButtonAmarelo.addActionListener(this);
    jButtonAzul.addActionListener(this);
    jButtonCad.addActionListener(this);
    jButtonComecar.addActionListener(this);
    jButtonJogar.addActionListener(this);
    jButtonSel.addActionListener(this);
    jButtonVerde.addActionListener(this);
    jButtonVermelho.addActionListener(this);
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    titledBorder3 = new TitledBorder("");
    titledBorder4 = new TitledBorder("");
    titledBorder5 = new TitledBorder("");
    titledBorder6 = new TitledBorder("");
    titledBorder7 = new TitledBorder("");
    titledBorder8 = new TitledBorder("");
    titledBorder9 = new TitledBorder("");
    titledBorder10 = new TitledBorder("");
    titledBorder11 = new TitledBorder("");
    this.getContentPane().setLayout(null);
    this.setFont(new java.awt.Font("Dialog", 0, 12));
    this.setTitle(":::::  Genius  :::::");
    jTabbedPaneMenu.setBounds(new Rectangle(0, 2, 471, 405));
    jPanelRel.setEnabled(false);
    jPanelRel.setFont(new java.awt.Font("Dialog", 1, 14));
    jPanelRel.setBorder(titledBorder11);
    jPanelRel.setDebugGraphicsOptions(0);
    jPanelRel.setLayout(null);
    jPanelJogar.setBorder(titledBorder4);
    jPanelJogar.setDebugGraphicsOptions(0);
    jPanelJogar.setLayout(null);
    jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel1.setText("Nome: ");
    jLabel1.setBounds(new Rectangle(66, 97, 50, 30));
    jPanelCad.setLayout(null);
    jTextFieldApelido.setBounds(new Rectangle(148, 148, 86, 25));
    jLabel2.setBounds(new Rectangle(67, 144, 69, 30));
    jLabel2.setBounds(new Rectangle(28, 126, 63, 30));
    jLabel2.setText("Apelido: ");
    jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldNome.setBounds(new Rectangle(147, 103, 277, 25));
    jTextFieldNome.setBounds(new Rectangle(96, 127, 176, 25));
    jTextFieldNome.setBounds(new Rectangle(88, 40, 277, 25));
    jTextFieldNome.setAlignmentY((float) 0.5);
    jTextFieldNome.setBounds(new Rectangle(84, 96, 277, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel3.setBorder(null);
    jLabel3.setText("Cadastramento de Jogadores");
    jLabel3.setBounds(new Rectangle(123, 27, 209, 29));
    jButtonCad.setFont(new java.awt.Font("Dialog", 1, 12));
    jButtonCad.setText("Cadastrar");
    jButtonCad.setBounds(new Rectangle(175, 229, 103, 42));
    jPanelCad.setEnabled(true);
    jPanelCad.setBorder(titledBorder8);
    jPanelSel.setLayout(null);
    jPanelAjuda.setLayout(null);
    jLabel4.setBackground(Color.gray);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel4.setBorder(null);
    jLabel4.setText(" Conheça as Regras e Descubra Como Jogar ");
    jLabel4.setBounds(new Rectangle(62, 20, 323, 29));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel5.setText("Seleção do(s) Jogador(es) da Partida");
    jLabel5.setBounds(new Rectangle(99, 10, 262, 25));
    jComboBoxJogs.setToolTipText("");
    jComboBoxJogs.setActionCommand("comboBoxChanged");
    jComboBoxJogs.setSelectedItem(jTabbedPaneMenu);
    jComboBoxJogs.setBounds(new Rectangle(133, 71, 114, 21));
    jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel6.setText("Jogadores:");
    jLabel6.setBounds(new Rectangle(53, 71, 71, 18));
    jButtonSel.setBounds(new Rectangle(282, 67, 112, 31));
    jButtonSel.setFont(new java.awt.Font("Dialog", 1, 12));
    jButtonSel.setText("Selecionar");
    jButtonJogar.setBounds(new Rectangle(179, 301, 102, 42));
    jButtonJogar.setEnabled(true);
    jButtonJogar.setFont(new java.awt.Font("Dialog", 1, 12));
    jButtonJogar.setText("Jogar");
    jLabel7.setText("1 - O jogador deve se cadastrar");
    jLabel7.setBounds(new Rectangle(29, 74, 393, 18));
    jLabel8.setText("2 - Cada partida deve ter ao menos um jogador");
    jLabel8.setBounds(new Rectangle(29, 124, 392, 18));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel10.setDebugGraphicsOptions(0);
    jLabel10.setText("Genius");
    jLabel10.setBounds(new Rectangle(197, 6, 52, 32));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel11.setDebugGraphicsOptions(0);
    jLabel11.setText("Relatório Final Da Partida");
    jLabel11.setBounds(new Rectangle(134, 17, 199, 31));
    jLabel12.setText("4 - O jogador deve seguir a sequência formada pelo Genius");
    jLabel12.setBounds(new Rectangle(30, 218, 394, 21));
    jLabel9.setMinimumSize(new Dimension(256, 16));
    jLabel9.setText("5 - No final da partida será exibido um relatório");
    jLabel9.setBounds(new Rectangle(32, 268, 390, 19));
    jButtonVerde.setIcon(new ImageIcon("Imagens/botaoverde.gif"));
    jButtonVerde.setMargin(new Insets(0, 0, 0, 0));
    jButtonVerde.setPressedIcon(new ImageIcon("Imagens/pisqueverde.gif"));
    jButtonVerde.setBackground(Color.black);
    jButtonVerde.setBounds(new Rectangle(113, 57, 102, 104));
    jButtonVerde.setEnabled(false);
    jButtonVerde.setBorder(null);
    jButtonVerde.setBorderPainted(false);
    jButtonVermelho.setIcon(new ImageIcon("Imagens/botaovermelho.gif"));
    jButtonVermelho.setMargin(new Insets(0, 0, 0, 0));
    jButtonVermelho.setPressedIcon(new ImageIcon("Imagens/pisquevermelho.gif"));
    jButtonVermelho.setBackground(Color.black);
    jButtonVermelho.setBounds(new Rectangle(235, 58, 105, 103));
    jButtonVermelho.setEnabled(false);
    jButtonVermelho.setBorder(null);
    jButtonVermelho.setBorderPainted(false);
    jButtonAmarelo.setIcon(new ImageIcon("Imagens/botaoamarelo.gif"));
    jButtonAmarelo.setMargin(new Insets(0, 0, 0, 0));
    jButtonAmarelo.setPressedIcon(new ImageIcon("Imagens/pisqueamarelo.gif"));
    jButtonAmarelo.setBackground(Color.black);
    jButtonAmarelo.setBounds(new Rectangle(113, 173, 102, 108));
    jButtonAmarelo.setEnabled(false);
    jButtonAmarelo.setBorder(null);
    jButtonAmarelo.setBorderPainted(false);
    jButtonAzul.setIcon(new ImageIcon("Imagens/botaoazul.gif"));
    jButtonAzul.setMargin(new Insets(0, 0, 0, 0));
    jButtonAzul.setPressedIcon(new ImageIcon("Imagens/pisqueazul.gif"));
    jButtonAzul.setBackground(Color.black);
    jButtonAzul.setBounds(new Rectangle(234, 171, 104, 107));
    jButtonAzul.setEnabled(false);
    jButtonAzul.setBorder(null);
    jButtonAzul.setBorderPainted(false);
    jPanelSel.setBorder(titledBorder6);
    jPanelSel.setDoubleBuffered(true);
    jPanelAjuda.setBorder(titledBorder10);
    jButtonComecar.setBackground(Color.green);
    jButtonComecar.setBounds(new Rectangle(219, 160, 11, 14));
    jButtonComecar.setText("");
    jLabelJogdaVez.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabelJogdaVez.setBorder(titledBorder1);
    jLabelJogdaVez.setText("");
    jLabelJogdaVez.setBounds(new Rectangle(77, 311, 95, 27));
    jTextFieldScore.setBackground(SystemColor.inactiveCaption);
    jTextFieldScore.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldScore.setForeground(Color.yellow);
    jTextFieldScore.setDisabledTextColor(Color.yellow);
    jTextFieldScore.setText("");
    jTextFieldScore.setBounds(new Rectangle(179, 308, 61, 32));
    jTextFieldScore.setEnabled(false);
    jLabelFundo.setIcon(new ImageIcon("Imagens/fundogenius.gif"));
    jLabelFundo.setBounds(new Rectangle(114, 57, 227, 223));
    jLabelFundo.setEnabled(false);
    jTextFieldJog1.setBackground(SystemColor.inactiveCaption);
    jTextFieldJog1.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldJog1.setForeground(Color.yellow);
    jTextFieldJog1.setDisabledTextColor(Color.yellow);
    jTextFieldJog1.setSelectedTextColor(Color.white);
    jTextFieldJog1.setText("");
    jTextFieldJog1.setEnabled(false);
    jTextFieldJog1.setBounds(new Rectangle(78, 167, 126, 23));
    jTextFieldJog2.setBounds(new Rectangle(78, 196, 126, 23));
    jTextFieldJog2.setBackground(SystemColor.inactiveCaption);
    jTextFieldJog2.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldJog2.setForeground(Color.yellow);
    jTextFieldJog2.setEnabled(false);
    jTextFieldJog2.setDisabledTextColor(Color.yellow);
    jTextFieldJog2.setText("");
    jTextFieldJog3.setBounds(new Rectangle(78, 225, 126, 23));
    jTextFieldJog3.setBackground(SystemColor.inactiveCaption);
    jTextFieldJog3.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldJog3.setForeground(Color.yellow);
    jTextFieldJog3.setDisabledTextColor(Color.yellow);
    jTextFieldJog3.setText("");
    jTextFieldJog3.setEnabled(false);
    jTextFieldJog4.setBounds(new Rectangle(258, 166, 126, 23));
    jTextFieldJog4.setBackground(SystemColor.inactiveCaption);
    jTextFieldJog4.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldJog4.setForeground(Color.yellow);
    jTextFieldJog4.setDisabledTextColor(Color.yellow);
    jTextFieldJog4.setText("");
    jTextFieldJog4.setEnabled(false);
    jTextFieldJog5.setBounds(new Rectangle(258, 195, 126, 23));
    jTextFieldJog5.setBackground(SystemColor.inactiveCaption);
    jTextFieldJog5.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldJog5.setForeground(Color.yellow);
    jTextFieldJog5.setDisabledTextColor(Color.yellow);
    jTextFieldJog5.setText("");
    jTextFieldJog5.setEnabled(false);
    jTextFieldJog6.setBackground(SystemColor.inactiveCaption);
    jTextFieldJog6.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldJog6.setForeground(Color.yellow);
    jTextFieldJog6.setDisabledTextColor(Color.yellow);
    jTextFieldJog6.setText("");
    jTextFieldJog6.setBounds(new Rectangle(258, 224, 126, 24));
    jTextFieldJog6.setEnabled(false);
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel13.setText("Jogadores Selecionados");
    jLabel13.setBounds(new Rectangle(147, 127, 160, 22));
    jButtonPisqueVerde.setBounds(new Rectangle(81, 43, 102, 104));
    jButtonPisqueVerde.setBackground(Color.black);
    jButtonPisqueVerde.setIcon(new ImageIcon("Imagens/pisqueverde.gif"));
    jButtonPisqueVerde.setVisible(false);
    jButtonPisqueVerde.addActionListener(this);
    jButtonPisqueVerde.setEnabled(false);
    jButtonPisqueVerde.setBorder(null);
    jButtonPisqueVerde.setMargin(new Insets(0,0,0,0));
    jButtonPisqueAmarelo.setBounds(new Rectangle(82, 157, 102, 108));
    jButtonPisqueAmarelo.setBackground(Color.black);
    jButtonPisqueAmarelo.setIcon(new ImageIcon("Imagens/pisqueamarelo.gif"));
    jButtonPisqueAmarelo.setVisible(false);
    jButtonPisqueAmarelo.addActionListener(this);
    jButtonPisqueAmarelo.setEnabled(false);
    jButtonPisqueAmarelo.setBorder(null);
    jButtonPisqueAmarelo.setMargin(new Insets(0,0,0,0));
    jButtonPisqueAzul.setBounds(new Rectangle(203, 157, 104, 107));
    jButtonPisqueAzul.setBackground(Color.black);
    jButtonPisqueAzul.setIcon(new ImageIcon("Imagens/pisqueazul.gif"));
    jButtonPisqueAzul.setVisible(false);
    jButtonPisqueAzul.addActionListener(this);
    jButtonPisqueAzul.setEnabled(false);
    jButtonPisqueAzul.setBorder(null);
    jButtonPisqueAzul.setMargin(new Insets(0,0,0,0));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel14.setText("Melhor Tempo:");
    jLabel14.setBounds(new Rectangle(92, 63, 112, 24));
    jTextFieldMelhorTempo.setBackground(SystemColor.inactiveCaption);
    jTextFieldMelhorTempo.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldMelhorTempo.setForeground(Color.yellow);
    jTextFieldMelhorTempo.setDisabledTextColor(Color.yellow);
    jTextFieldMelhorTempo.setText("");
    jTextFieldMelhorTempo.setColumns(0);
    jTextFieldMelhorTempo.setBounds(new Rectangle(223, 63, 127, 24));
    jTextFieldMelhorTempo.setEnabled(false);
    jComboBoxRel.setBounds(new Rectangle(56, 115, 114, 21));
    jComboBoxRel.setSelectedItem(jTabbedPaneMenu);
    jComboBoxRel.setActionCommand("comboBoxChanged");
    jComboBoxRel.setToolTipText("");
    jComboBoxRel.setEnabled(false);
    jButtonVerRel.setText("Ver Relatório");
    jButtonVerRel.setFont(new java.awt.Font("Dialog", 1, 12));
    jButtonVerRel.setBounds(new Rectangle(207, 111, 196, 27));
    jButtonVerRel.setEnabled(false);
    jButtonVerRel.addActionListener(this);
    jLabel15.setBounds(new Rectangle(47, 178, 63, 24));
    jLabel15.setText("Jogador:");
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextFieldNomeRel.setBounds(new Rectangle(142, 177, 260, 27));
    jTextFieldNomeRel.setColumns(0);
    jTextFieldNomeRel.setText("");
    jTextFieldNomeRel.setDisabledTextColor(Color.yellow);
    jTextFieldNomeRel.setForeground(Color.yellow);
    jTextFieldNomeRel.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldNomeRel.setBackground(SystemColor.inactiveCaption);
    jTextFieldNomeRel.setEnabled(false);
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel16.setText("Tempo Total:");
    jLabel16.setBounds(new Rectangle(45, 226, 90, 24));
    jTextFieldTempoTotal.setBackground(SystemColor.inactiveCaption);
    jTextFieldTempoTotal.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldTempoTotal.setForeground(Color.yellow);
    jTextFieldTempoTotal.setDisabledTextColor(Color.yellow);
    jTextFieldTempoTotal.setText("");
    jTextFieldTempoTotal.setColumns(0);
    jTextFieldTempoTotal.setBounds(new Rectangle(142, 225, 260, 27));
    jTextFieldTempoTotal.setEnabled(false);
    jLabel17.setBounds(new Rectangle(47, 273, 48, 24));
    jLabel17.setText("Score:");
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextFieldScoreRel.setBackground(SystemColor.inactiveCaption);
    jTextFieldScoreRel.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldScoreRel.setForeground(Color.yellow);
    jTextFieldScoreRel.setDisabledTextColor(Color.yellow);
    jTextFieldScoreRel.setText("");
    jTextFieldScoreRel.setColumns(0);
    jTextFieldScoreRel.setBounds(new Rectangle(142, 272, 60, 27));
    jTextFieldScoreRel.setEnabled(false);
    jButtonPisqueVermelho.addActionListener(this);
    jButtonPisqueVermelho.setVisible(false);
    jButtonPisqueVermelho.setIcon(new ImageIcon("Imagens/pisquevermelho.gif"));
    jButtonPisqueVermelho.setBackground(Color.black);
    jButtonPisqueVermelho.setBounds(new Rectangle(204, 44, 105, 104));
    jButtonPisqueVermelho.setBorder(null);
    jButtonPisqueVermelho.setMargin(new Insets(0,0,0,0));
    jLabel18.setBounds(new Rectangle(29, 171, 404, 18));
    jLabel18.setText("3 - Para iniciar, clique sobre o botao verde no centro do genius");
    jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel19.setText("1 -");
    jLabel19.setBounds(new Rectangle(41, 168, 29, 20));
    jLabel110.setBounds(new Rectangle(42, 196, 28, 20));
    jLabel110.setText("2 -");
    jLabel110.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel111.setBounds(new Rectangle(42, 226, 28, 20));
    jLabel111.setText("3 -");
    jLabel111.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel112.setBounds(new Rectangle(225, 167, 25, 20));
    jLabel112.setText("4 -");
    jLabel112.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel113.setBounds(new Rectangle(226, 196, 24, 20));
    jLabel113.setText("5 -");
    jLabel113.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabel114.setBounds(new Rectangle(225, 225, 26, 20));
    jLabel114.setText("6 -");
    jLabel114.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabelNivel.setBounds(new Rectangle(296, 309, 48, 27));
    jLabelNivel.setText("Nível: ");
    jLabelNivel.setFont(new java.awt.Font("SansSerif", 1, 12));
    jLabelNivel.setBorder(null);
    jTextFieldNivel.setEnabled(false);
    jTextFieldNivel.setBounds(new Rectangle(351, 307, 33, 31));
    jTextFieldNivel.setText("");
    jTextFieldNivel.setDisabledTextColor(Color.yellow);
    jTextFieldNivel.setForeground(Color.yellow);
    jTextFieldNivel.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextFieldNivel.setBackground(SystemColor.inactiveCaption);
    jButtonSair.setEnabled(false);
    jButtonSair.addActionListener(this);
    jButtonSair.setBounds(new Rectangle(256, 317, 147, 27));
    jButtonSair.setFont(new java.awt.Font("Dialog", 1, 12));
    jButtonSair.setText("Sair do Programa");
    jButtonNovoJogo.setText("Iniciar Novo Jogo");
    jButtonNovoJogo.setFont(new java.awt.Font("Dialog", 1, 12));
    jButtonNovoJogo.setBounds(new Rectangle(51, 317, 148, 27));
    jButtonNovoJogo.addActionListener(this);
    jButtonNovoJogo.setEnabled(false);
    this.getContentPane().add(jTabbedPaneMenu, null);
    jTabbedPaneMenu.add(jPanelAjuda,  "Ajuda");
    jTabbedPaneMenu.add(jPanelCad,  "Cadastro");
    jPanelCad.add(jLabel3, null);
    jPanelCad.add(jTextFieldApelido, null);
    jPanelCad.add(jTextFieldNome, null);
    jPanelCad.add(jLabel1, null);
    jPanelCad.add(jLabel2, null);
    jPanelCad.add(jButtonCad, null);
    jTabbedPaneMenu.add(jPanelSel,   "Seleção");
    jPanelSel.add(jLabel5, null);
    jTabbedPaneMenu.add(jPanelJogar,  "Jogar");
    jPanelJogar.add(jLabel10, null);
    jTabbedPaneMenu.add(jPanelRel,  "Relatório Final");
    jPanelAjuda.add(jLabel4, null);
    jPanelAjuda.add(jLabel9, null);
    jPanelAjuda.add(jLabel7, null);
    jPanelAjuda.add(jLabel8, null);
    jPanelAjuda.add(jLabel18, null);
    jPanelAjuda.add(jLabel12, null);
    jPanelSel.add(jButtonSel, null);
    jPanelSel.add(jComboBoxJogs, null);
    jPanelSel.add(jLabel6, null);
    jPanelSel.add(jButtonJogar, null);
    jPanelJogar.add(jButtonComecar, null);
    jPanelJogar.add(jButtonPisqueVerde, null);
    jPanelJogar.add(jButtonVerde, null);
    jPanelJogar.add(jButtonPisqueAmarelo, null);
    jPanelJogar.add(jButtonPisqueAzul, null);
    jPanelJogar.add(jButtonAzul, null);
    jPanelJogar.add(jButtonAmarelo, null);
    jPanelJogar.add(jButtonPisqueVermelho, null);
    jPanelJogar.add(jButtonVermelho, null);
    jPanelJogar.add(jLabelFundo, null);
    jPanelJogar.add(jLabelJogdaVez, null);
    jPanelJogar.add(jTextFieldScore, null);
    jPanelSel.add(jLabel13, null);
    jPanelSel.add(jTextFieldJog2, null);
    jPanelSel.add(jTextFieldJog1, null);
    jPanelSel.add(jTextFieldJog3, null);
    jPanelSel.add(jTextFieldJog4, null);
    jPanelSel.add(jTextFieldJog5, null);
    jPanelSel.add(jTextFieldJog6, null);
    jPanelSel.add(jLabel111, null);
    jPanelSel.add(jLabel110, null);
    jPanelSel.add(jLabel113, null);
    jPanelSel.add(jLabel114, null);
    jPanelSel.add(jLabel19, null);
    jPanelSel.add(jLabel112, null);
    jPanelRel.add(jLabel11, null);
    jPanelRel.add(jLabel14, null);
    jPanelRel.add(jTextFieldMelhorTempo, null);
    jPanelRel.add(jComboBoxRel, null);
    jPanelRel.add(jButtonVerRel, null);
    jPanelRel.add(jLabel15, null);
    jPanelRel.add(jTextFieldNomeRel, null);
    jPanelRel.add(jLabel16, null);
    jPanelRel.add(jTextFieldTempoTotal, null);
    jPanelRel.add(jTextFieldScoreRel, null);
    jPanelRel.add(jLabel17, null);
    jPanelJogar.add(jTextFieldNivel, null);
    jPanelJogar.add(jLabelNivel, null);
    jPanelRel.add(jButtonNovoJogo, null);
    jPanelRel.add(jButtonSair, null);
    jLabel2.setBounds(new Rectangle(18, 38, 50, 30));
    jLabel2.setBounds(new Rectangle(17, 150, 50, 30));
    c = new Campeonato();
    jButtonVerRel.setEnabled(false);
  }


  public static void main(String[] args) {
      InterfaceGenius objetoFrame = new InterfaceGenius();
      objetoFrame.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });
       objetoFrame.pack();
       objetoFrame.setBounds(200,100,482, 455);
       objetoFrame.setVisible(true);

  }

}
