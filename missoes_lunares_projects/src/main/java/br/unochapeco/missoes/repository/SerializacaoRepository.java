package br.unochapeco.missoes.repository;
import java.io.*; import java.util.*; import br.unochapeco.missoes.model.Missao;
public class SerializacaoRepository {
  private File arquivo;
  public SerializacaoRepository(String p){arquivo=new File(p);}
  @SuppressWarnings("unchecked")
  public List<Missao> carregar(){try{
    if(!arquivo.exists())return new ArrayList<>();
    return (List<Missao>)new ObjectInputStream(new FileInputStream(arquivo)).readObject();
  }catch(Exception e){return new ArrayList<>();}}
  public void salvar(Missao m){
    List<Missao> l=carregar();
    l.removeIf(x->x.getCodigo().equals(m.getCodigo()));
    l.add(m);
    try{new ObjectOutputStream(new FileOutputStream(arquivo)).writeObject(l);}catch(Exception e){}
  }
}
