package br.unochapeco.missoes.model;
import java.io.Serializable;
public abstract class Nave implements Serializable {
  protected String id,modelo; protected int capacidade;
  public Nave(String id,String m,int c){this.id=id;modelo=m;capacidade=c;}
  public int getCapacidade(){return capacidade;}
  public abstract boolean isTripulada();
  public String getModelo(){return modelo;}
}
