package br.unochapeco.missoes.model;
public class NaveTripulada extends Nave {
  public NaveTripulada(String id,String m,int c){super(id,m,c);}
  public boolean isTripulada(){return true;}
}
