package br.unochapeco.missoes.model;
public class NaveCargueira extends Nave {
  public NaveCargueira(String id,String m,int c){super(id,m,c);}
  public boolean isTripulada(){return false;}
}
