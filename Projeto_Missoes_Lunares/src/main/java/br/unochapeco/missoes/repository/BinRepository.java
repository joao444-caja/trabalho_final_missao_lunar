
package br.unochapeco.missoes.repository;

import br.unochapeco.missoes.model.Missao;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinRepository implements MissaoRepository {
    private final File arquivo;

    public BinRepository(String caminho) {
        this.arquivo = new File(caminho);
        arquivo.getParentFile().mkdirs();
    }

    @Override
    public synchronized void salvar(Missao m) throws Exception {
        List<Missao> todas = listar();
        // substituir se já existir
        todas.removeIf(x -> x.getCodigo().equals(m.getCodigo()));
        todas.add(m);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(todas);
        }
    }

    @Override
    public synchronized List<Missao> listar() throws Exception {
        if (!arquivo.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object o = ois.readObject();
            return (List<Missao>) o;
        } catch (EOFException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Missao buscarPorCodigo(String codigo) throws Exception {
        return listar().stream().filter(m -> m.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    @Override
    public void fechar() throws Exception {}
}
