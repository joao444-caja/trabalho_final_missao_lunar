package br.unochapeco.missoes.repository;

import br.unochapeco.missoes.model.Missao;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.util.ArrayList;
import java.util.List;

public class NitriteRepository implements MissaoRepository {

    private final Nitrite db;
    private final ObjectRepository<Missao> repo;

    public NitriteRepository(String caminhoDb) {
        db = Nitrite.builder()
                .filePath(caminhoDb)
                .openOrCreate();

        repo = db.getRepository(Missao.class);
    }

    @Override
    public void salvar(Missao missao) throws Exception {
        // Remove missões com mesmo código antes de inserir novamente
        repo.remove(ObjectFilters.eq("codigo", missao.getCodigo()));
        repo.insert(missao);
    }

    @Override
    public List<Missao> listar() throws Exception {
        List<Missao> lista = new ArrayList<>();
        for (Missao m : repo.find()) {
            lista.add(m);
        }
        return lista;
    }

    @Override
    public Missao buscarPorCodigo(String codigo) throws Exception {
        return repo.find(ObjectFilters.eq("codigo", codigo))
                   .firstOrDefault();
    }

    @Override
    public void fechar() throws Exception {
        db.close();
    }
}
