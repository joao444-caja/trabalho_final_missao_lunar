
package br.unochapeco.missoes.repository;

import br.unochapeco.missoes.model.Missao;
import java.util.List;

public interface MissaoRepository {
    void salvar(Missao m) throws Exception;
    List<Missao> listar() throws Exception;
    Missao buscarPorCodigo(String codigo) throws Exception;
    void fechar() throws Exception;
}
