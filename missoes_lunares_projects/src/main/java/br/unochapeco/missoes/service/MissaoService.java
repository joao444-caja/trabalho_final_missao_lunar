package br.unochapeco.missoes.service;
import java.util.*; import br.unochapeco.missoes.model.*; import br.unochapeco.missoes.repository.*;
public class MissaoService {
  private SerializacaoRepository repo;
  public MissaoService(SerializacaoRepository r){repo=r;}
  public void criar(Missao m){
    if(m.getAstronautas().size()>m.getNave().getCapacidade())throw new RuntimeException("Capacidade excedida");
    for(Astronauta a:m.getAstronautas()) if(!a.isElegivel()) throw new RuntimeException("Idade inválida");
    repo.salvar(m);
  }
  public List<Missao> listar(){return repo.carregar();}
}
