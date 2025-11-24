package br.unochapeco.missoes.model;
import java.io.*; import java.time.*; import java.util.*;
public class Missao implements Serializable {
  private String codigo,nome,destino,objetivo,resultado;
  private LocalDate dataLancamento,dataRetorno;
  private Nave nave;
  private List<Astronauta> astronautas=new ArrayList<>();
  public Missao(String c,String n,LocalDate dl,LocalDate dr,String d,String o,Nave na,List<Astronauta> a){
    codigo=c;nome=n;dataLancamento=dl;dataRetorno=dr;destino=d;objetivo=o;nave=na;if(a!=null)astronautas=a;}
  public String getCodigo(){return codigo;} public LocalDate getDataLancamento(){return dataLancamento;}
  public LocalDate getDataRetorno(){return dataRetorno;} public Nave getNave(){return nave;}
  public List<Astronauta> getAstronautas(){return astronautas;}
  public long getDuracaoDias(){return Duration.between(dataLancamento.atStartOfDay(),dataRetorno.atStartOfDay()).toDays();}
  public void setResultado(String r){resultado=r;}
  public String toString(){return "Missao "+codigo+" - "+nome;}
}
