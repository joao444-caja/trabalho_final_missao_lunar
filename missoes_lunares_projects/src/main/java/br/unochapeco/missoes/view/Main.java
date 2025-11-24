package br.unochapeco.missoes.view;
import java.util.*; import java.time.*; 
import br.unochapeco.missoes.model.*; import br.unochapeco.missoes.repository.*; import br.unochapeco.missoes.service.*;
public class Main {
  public static void main(String[] args){
    var repo=new SerializacaoRepository("missoes.bin");
    var service=new MissaoService(repo);
    Scanner sc=new Scanner(System.in);
    System.out.println("Cadastro rápido de missão:");
    Missao m=new Missao("M1","Teste",LocalDate.now(),LocalDate.now().plusDays(5),
    "Lua","Pesquisa",new NaveTripulada("N1","Apollo",3),
    List.of(new Astronauta("Alice",25,"Piloto",120)));
    service.criar(m);
    System.out.println(service.listar());
  }
}
