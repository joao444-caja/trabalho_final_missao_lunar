package br.unochapeco.missoes.model;
import java.io.Serializable;
public class Astronauta implements Serializable {
  private String nome,especialidade; private int idade; private double horasVoo;
  public Astronauta(String n,int i,String e,double h){nome=n;idade=i;especialidade=e;horasVoo=h;}
  public String getNome(){return nome;} public int getIdade(){return idade;}
  public boolean isElegivel(){return idade>=21;}
}
