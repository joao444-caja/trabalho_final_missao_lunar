
package br.unochapeco.missoes.service;

import br.unochapeco.missoes.model.Astronauta;
import br.unochapeco.missoes.model.Missao;
import br.unochapeco.missoes.model.Nave;
import br.unochapeco.missoes.repository.MissaoRepository;

import java.util.List;
import java.util.Objects;

public class MissionService {
    private final MissaoRepository binRepo;
    private final MissaoRepository nitriteRepo;

    public MissionService(MissaoRepository binRepo, MissaoRepository nitriteRepo) {
        this.binRepo = binRepo;
        this.nitriteRepo = nitriteRepo;
    }

    public void salvarMissao(Missao m) throws Exception {
        // validações
        if (m.getCodigo() == null || m.getCodigo().isBlank()) throw new IllegalArgumentException("Código obrigatório");
        if (m.getNave() == null) throw new IllegalArgumentException("Nave obrigatória");
        if (m.getTripulantes().size() > m.getNave().getCapacidade())
            throw new IllegalArgumentException("Nave não comporta tantos tripulantes");
        // validar astronautas (idade)
        for (Astronauta a : m.getTripulantes()) {
            if (a.getIdade() < 21) throw new IllegalArgumentException("Astronauta " + a.getNome() + " tem menos de 21 anos");
        }
        // persistir nas duas formas
        binRepo.salvar(m);
        nitriteRepo.salvar(m);
    }

    public List<Missao> listar() throws Exception {
        return binRepo.listar();
    }

    public Missao buscar(String codigo) throws Exception {
        return binRepo.buscarPorCodigo(codigo);
    }

    public void registrarResultado(String codigo, String resultado) throws Exception {
        Missao m = buscar(codigo);
        if (m == null) throw new IllegalArgumentException("Missão não encontrada");
        m.setResultado(resultado);
        // salvar novamente
        binRepo.salvar(m);
        nitriteRepo.salvar(m);
    }

    public void fechar() throws Exception {
        binRepo.fechar();
        nitriteRepo.fechar();
    }
}
